
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
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/**
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 * The initialization is adapted from SQLite documentation.
 */
public class SQLite_VitalSigns extends SQLite_Table {

    /**
     * Sets up the Vital Signs table in the database if it does not already
     * exist.
     * @param conn 
     */
    public static void initializeTable(){
        String sql = "CREATE TABLE IF NOT EXISTS VitalSigns (\n"
                +"ID integer PRIMARY KEY AUTOINCREMENT, \n"
                +"patientID text, \n"
                +"vitalSignsDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"vitalSignsTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"checkedBy text, \n"
                +"heartRate text, \n"
                +"bloodPressure text, \n"
                +"oxygenSat text, \n"
                +"breathsPerMinute text);";
        try (
            Statement stmt = SQLite.getConnection().createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void loadPatientData(Patient profile)
    {
        try (Statement stmt = SQLite.getConnection().createStatement()) {

            String sqlSearch = "SELECT * FROM VitalSigns WHERE patientID='" + profile.getIdentifier() + "'";
            ResultSet rs = stmt.executeQuery(sqlSearch);

            while(rs.next())
            {
                VitalSigns entry = new VitalSigns();
                entry.setID(rs.getInt("ID"));
                entry.setPatient(profile);
                entry.setVitalSignsDate(LocalDate.parse(rs.getString("vitalSignsDate"), DateTimeFormatter.ISO_DATE));
                entry.setVitalSignsTime(Time.valueOf(rs.getString("vitalSignsTime")));
                entry.setCheckedBy(rs.getString("checkedBy"));
                entry.setBreathsPerMinute(rs.getString("breathsPerMinute"));
                entry.setOxygenSat(rs.getString("oxygenSat"));
                entry.setBloodPressure(rs.getString("bloodPressure"));
                entry.setHeartRate(rs.getString("heartRate"));
                
               
                profile.vitalSignsData.add(entry);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
