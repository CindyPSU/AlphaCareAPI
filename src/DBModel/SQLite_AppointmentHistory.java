package DBModel;

import MedicalRecordModel.*;
import UserModel.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and
 * Christopher Morris The initialization is adapted from SQLite documentation.
 */
public class SQLite_AppointmentHistory extends SQLite_Table {

    private static MedicalRecordModel.Appt.ApptPractices practices = new MedicalRecordModel.Appt.ApptPractices();
    private static MedicalRecordModel.Appt.ApptStatuses statuses = new MedicalRecordModel.Appt.ApptStatuses();

    /**
     * Sets up the Appointment History table in the database if it does not
     * already exist.
     */
    public static void initializeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS AppointmentHistory (\n"
                + "ID integer PRIMARY KEY AUTOINCREMENT, \n"
                + "patientID text, \n"
                + "appointmentDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                + "appointmentTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                + "physicianName text, \n"
                + "practiceName text, \n"
                + "appointmentStatus text, \n"
                + "appointmentCode text, \n"
                + "appCodeDescription text);";
        try (
                Statement stmt = SQLite.getConnection().createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadPatientData(Patient profile) {

        // code for inserting patient profile into the database
        try (Statement stmt = SQLite.getConnection().createStatement()) {

            String sqlSearch = "SELECT * FROM AppointmentHistory WHERE patientID='" + profile.getIdentifier() + "'";
            ResultSet rs = stmt.executeQuery(sqlSearch);

            while (rs.next()) {
                AppointmentHistory entry = getModel(rs, profile);
                profile.appointments.add(entry);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<AppointmentHistory> loadAllAppointments() {
        ArrayList<AppointmentHistory> results = new ArrayList<>();

        // code for inserting patient profile into the database
        try (Statement stmt = SQLite.getConnection().createStatement()) {

            String sqlSearch = "SELECT * FROM AppointmentHistory";
            ResultSet rs = stmt.executeQuery(sqlSearch);

            while (rs.next()) {
                AppointmentHistory entry = getModel(rs, null);
                results.add(entry);
            }
            return results;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static AppointmentHistory getModel(ResultSet rs, Patient profile) {
        try {
            AppointmentHistory entry = new AppointmentHistory();
            entry.setID(rs.getInt("ID"));
            entry.setAppCodeDescription(rs.getString("appCodeDescription"));
            entry.setAppointmentCode(rs.getString("appointmentCode"));
            entry.setAppointmentDate(LocalDate.parse(rs.getString("appointmentDate"), DateTimeFormatter.ISO_DATE));
            entry.setAppointmentTime(Time.valueOf(rs.getString("appointmentTime")));
            if (profile == null) {
                profile = SQLite_PatientProfile.getModelByID(rs.getString("patientID"));
            }
            entry.setPatient(profile);
            entry.setPhysicianName(rs.getString("physicianName"));
            entry.setPractice(practices.find(rs.getString("practiceName")));
            entry.setStatus(statuses.find(rs.getString("appointmentStatus")));
            return entry;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
