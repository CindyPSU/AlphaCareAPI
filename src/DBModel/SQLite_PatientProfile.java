package DBModel;

import MedicalRecordModel.*;
import UserModel.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and
 * Christopher Morris The initialization is adapted from SQLite documentation.
 */
public class SQLite_PatientProfile {

    /**
     * Sets up the Patient Profile table in the database if it does not already
     * exist.
     */
    public static void initializeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS PatientProfile (\n"
                + "patientID text PRIMARY KEY, \n"
                + "patientFirstName text, \n"
                + "patientLastName text, \n"
                + "patientMiddleInitial text, \n"
                + "patientPreferredName text, \n"
                + "patientDOB text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                + "patientPhoneNumber text, \n"
                + "patientAddress text, \n"
                + "patientEmailAddress text);";
        try (Statement stmt = SQLite.getConnection().createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Starting data
        if (SQLite.initializeStartingData) {
            // ArrayList<Patient> startingPatients = new ArrayList<>();
            save(new Patient("111223333", "John", "Smith", "", "Johnny", LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE), "1235551234", "123 Main Street", "john.smith@gmail.com"));
            save(new Patient("111223334", "Mary", "Smith", "J", "MJ", LocalDate.parse("1970-02-01", DateTimeFormatter.ISO_DATE), "1235551234", "123 Main Street", "mary.smith@gmail.com"));
            save(new Patient("111223335", "Martin", "McFly", "", "Marty", LocalDate.parse("1980-02-02", DateTimeFormatter.ISO_DATE), "1235551235", "456 Time Street", "martin.mcfly@gmail.com"));
        }
    }

    /**
     * Saves the patient's profile to the database.
     *
     * @param profile
     */
    public static void save(Patient profile) {

        // code for inserting patient profile into the database
        try (Statement stmt = SQLite.getConnection().createStatement()) {

            String sqlSearch = "SELECT * FROM PatientProfile WHERE patientID='" + profile.getIdentifier() + "'";
            ResultSet rs = stmt.executeQuery(sqlSearch);

            String sqlUpdateOrInsert = null;
            boolean updated = false;
            while (rs.next()) {
                updated = true;
                sqlUpdateOrInsert = "UPDATE PatientProfile SET "
                        + "patientFirstName='" + profile.getFirstName() + "', "
                        + "patientLastName='" + profile.getLastName() + "',"
                        + "patientMiddleInitial='" + profile.getMiddleInitial() + "', "
                        + "patientPreferredName='" + profile.getPreferredName() + "', "
                        + "patientDOB='" + profile.getBirthdate().format(DateTimeFormatter.ISO_LOCAL_DATE) + "',"
                        + "patientPhoneNumber='" + profile.getPhoneNumber() + "', "
                        + "patientAddress='" + profile.getAddress() + "', "
                        + "patientEmailAddress='" + profile.getEmail() + "'"
                        + " WHERE patientID='" + profile.getIdentifier() + "'";
            }

            if (!updated) {
                sqlUpdateOrInsert = "INSERT INTO PatientProfile (patientID, patientFirstName, patientLastName, patientMiddleInitial, "
                        + "patientPreferredName, patientDOB, patientPhoneNumber, patientAddress, patientEmailAddress) VALUES ("
                        + "'" + profile.getIdentifier() + "', "
                        + "'" + profile.getFirstName() + "', "
                        + "'" + profile.getLastName() + "', "
                        + "'" + profile.getMiddleInitial() + "', "
                        + "'" + profile.getPreferredName() + "', "
                        + "'" + profile.getBirthdate().format(DateTimeFormatter.ISO_LOCAL_DATE) + "', "
                        + "'" + profile.getPhoneNumber() + "', "
                        + "'" + profile.getAddress() + "', "
                        + "'" + profile.getEmail() + "'"
                        + ")";
            }

            // create a new table
            stmt.execute(sqlUpdateOrInsert);
            // select last_insert_rowid();
            // This is the technique that I will use to manage the data in the other subtables
            // Reference SQLite List Item #2
            // Replicate lines 87 thru 89 for the rest of the subtables
            for (AppointmentHistory ahEntry : profile.appointments) {
                SQLite_AppointmentHistory.save("AppointmentHistory", ahEntry);
            }
            for (ImmunizationHistory imHistory : profile.immunizations) {
                SQLite_ImmunizationHistory.save("ImmunizationHistory", imHistory);
            }
            for (MedicalHistory history : profile.medicalData) {
                SQLite_MedicalHistory.save("MedicalHistory", history);
            }
            for (PrescriptionHistory rxHistory : profile.prescriptions) {
                SQLite_PrescriptionHistory.save("PrescriptionHistory", rxHistory);
            }
            for (TestLabResults history : profile.labResults) {
                SQLite_TestLabResults.save("TestLabResults", history);
            }
            for (VitalSigns history : profile.vitalSignsData) {
                SQLite_VitalSigns.save("VitalSigns", history);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Load patient info from the database into the medical record
     *
     * @return
     */
    public static List<Patient> loadPatients() {
        return loadPatients("");
    }

    /**
     * Load patient info from the database into the medical record
     *
     * @return
     */
    public static List<Patient> loadPatients(String whereClause) {

        ArrayList<Patient> results = new ArrayList<>();

        // code for inserting patient profile into the database
        try (Statement stmt = SQLite.getConnection().createStatement()) {

            String sqlSearch = "SELECT * FROM PatientProfile";
            if (!whereClause.isEmpty()) {
                sqlSearch += " WHERE " + whereClause;
            }
            ResultSet rs = stmt.executeQuery(sqlSearch);

            while (rs.next()) {
                Patient p = getModel(rs);
                results.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return results;
    }

    private static Patient getModel(ResultSet rs) {
        try {
            Patient p = new Patient();
            p.setIdentifier(rs.getString("patientID"));
            p.setFirstName(rs.getString("patientFirstName"));
            p.setLastName(rs.getString("patientLastName"));
            p.setMiddleInitial(rs.getString("patientMiddleInitial"));
            p.setPreferredName(rs.getString("patientPreferredName"));
            p.setAddress(rs.getString("patientAddress"));
            p.setPhoneNumber(rs.getString("patientPhoneNumber"));
            p.setEmail(rs.getString("patientEmailAddress"));
            p.setBirthdate(LocalDate.parse(rs.getString("patientDOB")));

            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Patient getModelByID(String patientID) {
        List<Patient> patients = loadPatients("patientID='" + patientID + "'");
        if (patients.size() == 1) {
            return patients.get(0);
        } else {
            return null;
        }
    }

    public static void populatePatientData(Patient profile) {
        SQLite_AppointmentHistory.loadPatientData(profile);
        SQLite_ImmunizationHistory.loadPatientData(profile);
        SQLite_MedicalHistory.loadPatientData(profile);
        SQLite_PrescriptionHistory.loadPatientData(profile);
        SQLite_TestLabResults.loadPatientData(profile);
        SQLite_VitalSigns.loadPatientData(profile);
    }

}
