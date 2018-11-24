
package DBModel;

import MedicalRecordModel.*;
import UserModel.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 * The initialization is adapted from SQLite documentation.
 */
public class SQLite_ImmunizationHistory extends SQLite_Table {

    /**
     * Sets up the Immunization History table in the database if it does not already exist.
     */
    public static void initializeTable(){
        String sql = "CREATE TABLE IF NOT EXISTS ImmunizationHistory (\n"
                +"ID integer PRIMARY KEY AUTOINCREMENT, \n"
                +"patientID text, \n"
                +"immunizeDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"immunizeTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"givenByName text, \n"
                +"givenByTitle text, \n"
                +"immunizeID text, \n"
                +"immunizeName text);";
        try (
            Statement stmt = SQLite.getConnection().createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadPatientData(Patient profile)
    {
        try (Statement stmt = SQLite.getConnection().createStatement()) {

            String sqlSearch = "SELECT * FROM ImmunizationHistory WHERE patientID='" + profile.getIdentifier() + "'";
            ResultSet rs = stmt.executeQuery(sqlSearch);

            while(rs.next())
            {
                ImmunizationHistory entry = new ImmunizationHistory();
                entry.setID(rs.getInt("ID"));
                entry.setGivenByName(rs.getString("givenByName"));
                entry.setGivenByTitle(rs.getString("givenByTitle"));
                entry.setImmunizeDate(LocalDate.parse(rs.getString("immunizeDate"), DateTimeFormatter.ISO_DATE));
                entry.setImmunizeTime(Time.valueOf(rs.getString("immunizeTime")));
                entry.setImmunizeName(rs.getString("immunizeName"));
                entry.setImmunizationID(rs.getString("immunizeID"));
                entry.setPatient(profile);
                profile.immunizations.add(entry);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
