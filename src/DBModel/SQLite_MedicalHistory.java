
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
public class SQLite_MedicalHistory extends SQLite_Table {

    /**
     * Sets up the Medical History table in the database if it does not already
     * exist.
     * @param conn 
     */
    public static void initializeTable(){
        String sql = "CREATE TABLE IF NOT EXISTS MedicalHistory (\n"
                +"ID integer PRIMARY KEY AUTOINCREMENT, \n"
                +"patientID text, \n"
                +"procedureDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"procedureName text, \n" 
                +"procedureAge integer, \n"
                +"allergyName text, \n"
                +"allergyDescription text);";
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

            String sqlSearch = "SELECT * FROM MedicalHistory WHERE patientID='" + profile.getIdentifier() + "'";
            ResultSet rs = stmt.executeQuery(sqlSearch);

            while(rs.next())
            {
                MedicalHistory entry = new MedicalHistory();
                entry.setID(rs.getInt("ID"));
                entry.setAllergyDescription(rs.getString("allergyDescription"));
                entry.setAllergyName(rs.getString("allergyName"));
                entry.setPatient(profile);
                entry.setProcedureAge(rs.getInt("procedureAge"));
                entry.setProcedureDate(LocalDate.parse(rs.getString("procedureDate"), DateTimeFormatter.ISO_DATE));
                entry.setProcedureName(rs.getString("procedureName"));
                profile.medicalData.add(entry);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    
}
