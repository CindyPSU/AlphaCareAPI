
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
public class SQLite {
    private static String fileName = "alphacare.db";
    private static Connection _conn;
    public static boolean initializeStartingData = false;
    
    public static Connection getConnection()
    {
        if(_conn == null){
            String url = "jdbc:sqlite:" + fileName;
            try  {
                
                // If we're creating a new DB file, set a flag to indicate we should populate starting/testing data
                if(new File(fileName).exists() == false)
                {
                  initializeStartingData = true;
                }
                
                // Connect/initialize the DB
                _conn = DriverManager.getConnection(url);

                // Initialize tables                
                if (_conn != null) {
                   SQLite_PatientProfile.initializeTable();
                   SQLite_AppointmentHistory.initializeTable();
                   SQLite_ImmunizationHistory.initializeTable();
                   SQLite_MedicalHistory.initializeTable();
                   SQLite_PrescriptionHistory.initializeTable();
                   SQLite_TestLabResults.initializeTable();
                   SQLite_VitalSigns.initializeTable();
                }
                
                // Only run the initialization once
                initializeStartingData = false;

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return _conn;
    }
    
    /**
     * Gets the last insert ID
     * @param profile 
     */
    public static int getLastInsertID(){
        try (Statement stmt = getConnection().createStatement()) {
            String sqlSearch = "select last_insert_rowid();";
            ResultSet rs = stmt.executeQuery(sqlSearch);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    
    /**
     * Converts a Hashtable of field-to-value entries into an INSERT query
     * @param tableName the name of the table
     * @param h the Hashtable with the fields/values
     */
    public static String getInsertSQL(String tableName, Hashtable h)
    {
        String sql = "INSERT INTO " + tableName + " (STRFIELDS) VALUES (STRVALUES)";
        
        String sqlFields = "";
        String sqlValues = "";
        
        Enumeration keys = h.keys(); 
        while (keys.hasMoreElements()) { 
            String field = (String)keys.nextElement(); 
            Object value = h.get(field);
            
            // Create a comma-separated list of fields
            sqlFields = sqlFields + (sqlFields.length() == 0 ? "" : ", ") + field;
            
            // Create a comma-separated list of values
            if(value instanceof String)
            {
                sqlValues = sqlValues + (sqlValues.length() == 0 ? "'" : ", '") + value + "'";
            }
            else
            {
                sqlValues = sqlValues + (sqlValues.length() == 0 ? "" : ", ") + value;
            }
        }
        
        sql = sql.replace("STRFIELDS", sqlFields).replace("STRVALUES", sqlValues);
        return sql;
    }

    /**
     * Converts a Hashtable of field-to-value entries into an UPDATE query
     * @param tableName the name of the table
     * @param h the Hashtable with the fields/values
     * @param where the string that comes after the WHERE clause
     */
    public static String getUpdateSQL(String tableName, Hashtable h, String where)
    {
        String sql = "UPDATE " + tableName + " SET ";
        
        boolean firstField = true;
        Enumeration keys = h.keys(); 
        while (keys.hasMoreElements()) { 
            String field = (String)keys.nextElement(); 
            Object value = h.get(field);
            
            // Create a comma-separated list of fields
            sql = sql + (firstField ? "" : ", ") + field + " = ";
            
            // Create a comma-separated list of values
            if(value instanceof String)
            {
                sql = sql + "'" + value + "'";
            }
            else
            {
                sql = sql + value;
            }
            firstField = false;
        }
        
        sql = sql + " WHERE " + where;
        return sql;
    }
     
    
}
