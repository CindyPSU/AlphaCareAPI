
package DBModel;

import MedicalRecordModel.*;
import UserModel.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 * The initialization is adapted from SQLite documentation.
 */
public class SQLite_TestLabResults extends SQLite_Table {

    /**
     * Sets up the Test Lab Results table in the database if it does not already
     * exist.
     * @param conn 
     */
    public static void initializeTable(){
        String sql = "CREATE TABLE IF NOT EXISTS TestLabResults (\n"
                +"ID integer PRIMARY KEY AUTOINCREMENT, \n"
                +"patientID text, \n"
                +"testOrderDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"testOrderTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"physicianName text, \n"
                +"testID text, \n"
                +"testName text, \n"
                +"testResult text);";
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

            String sqlSearch = "SELECT * FROM TestLabResults WHERE patientID='" + profile.getIdentifier() + "'";
            ResultSet rs = stmt.executeQuery(sqlSearch);

            while(rs.next())
            {
                TestLabResults entry = new TestLabResults();
                entry.setID(rs.getInt("ID"));
                entry.setPatient(profile);
                entry.setPhysicianName(rs.getString("physicianName"));
                entry.setTestResult(rs.getString("testResult"));
                entry.setTestID(rs.getString("testID"));
                entry.setTestName(rs.getString("testName"));
                entry.setTestOrderDate(LocalDate.parse(rs.getString("testOrderDate"), DateTimeFormatter.ISO_DATE));
                entry.setTestOrderTime(Time.valueOf(rs.getString("testOrderTime")));
               
                profile.labResults.add(entry);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
