
package DBModel;

import MedicalRecordModel.PatientProfile;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 * The initialization is adapted from SQLite documentation.
 */
public class SQLite {
    private static String fileName = "alphacare.db";
    private static Connection conn;
    
    /**
     * Looks up a patient profile record based on the ID.
     * @param patientID 
     */
    public static void getPatientProfile(String patientID){
        
    }
    
    /**
     * Saves the patient's profile to the database.
     * @param profile 
     */
    public static void savePatientProfile(PatientProfile profile){
        initializeDatabase();
        // code for inserting patient profile into the database
        /*try (
            String sql = "INSERT INTO PatientProfile"
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
    }
    
    /**
     * Keeps the connection to the database open.
     * @return 
     */
    private static Connection initializeDatabase(){
        if(conn != null){
            return conn;
        }

        // Check to see if the file exists
        //File f = new File(fileName);
        //if(f.exists() && !f.isDirectory()) { 
            // Define the connection string
            String url = "jdbc:sqlite:" + fileName;
            // Try to connect to the database
            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                   //DatabaseMetaData meta = conn.getMetaData();
                   initializePatientProfileTable(conn); 
                   initializeAppointmentHistoryTable(conn);
                   initializeImmunizationHistoryTable(conn);
                   initializeMedicalHistoryTable(conn);
                   initializePrescriptionHistoryTable(conn);
                   initializeTestLabResultsTable(conn);
                   initializeVitalSignsTable(conn);
                   SQLite.conn = conn;
                   return conn;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        //}
        return null;
    }
    
    /**
     * Sets up the Patient Profile table in the database if it does not already
     * exist.
     * @param conn 
     */
    private static void initializePatientProfileTable(Connection conn){
        String sql = "CREATE TABLE IF NOT EXISTS PatientProfile (\n"
                +"patientID text PRIMARY KEY, \n"
                +"patientFirstName text, \n"
                +"patientLastName text, \n"
                +"patientMiddleInitial text, \n"
                +"patientPreferredName text, \n"
                +"patientDOB text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"patientPhoneNumber integer, \n"
                +"patientAddress text, \n"
                +"patientEmailAddress text);";
        try (
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Sets up the Appointment History table in the database if it does not already
     * exist.
     * @param conn 
     */
    private static void initializeAppointmentHistoryTable(Connection conn){
        String sql = "CREATE TABLE IF NOT EXISTS AppointmentHistory (\n"
                +"patientID text, \n"
                +"appointmentDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"appointmentTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"physicianName text, \n"
                +"appointmentCode text, \n"
                +"appCodeDescription text);";
        try (
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Sets up the Immunization History table in the database if it does not already
     * exist.
     * @param conn 
     */
    private static void initializeImmunizationHistoryTable(Connection conn){
        String sql = "CREATE TABLE IF NOT EXISTS ImmunizationHistory (\n"
                +"patientID text, \n"
                +"immunizeDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"immunizeTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"givenByName text, \n"
                +"givenByTitle text, \n"
                +"immunizeID text, \n"
                +"immunizeName text);";
        try (
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Sets up the Medical History table in the database if it does not already
     * exist.
     * @param conn 
     */
    private static void initializeMedicalHistoryTable(Connection conn){
        String sql = "CREATE TABLE IF NOT EXISTS MedicalHistory (\n"
                +"patientID text, \n"
                +"procedureDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"procedureName text, \n" 
                +"procedureAge integer, \n"
                +"allergyName text, \n"
                +"allergyDescription text, \n"
                +"currentMedicalCondition text, \n"
                +"pastMedicalCondition text);";
        try (
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Sets up the Prescription History table in the database if it does not already
     * exist.
     * @param conn 
     */
    private static void initializePrescriptionHistoryTable(Connection conn){
        String sql = "CREATE TABLE IF NOT EXISTS PrescriptionHistory (\n"
                +"patientID text, \n"
                +"rXorderDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"rXorderTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"physicianName text, \n"
                +"rXID text, \n"
                +"rXName text, \n"
                +"refillCount integer);";
        try (
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Sets up the Test Lab Results table in the database if it does not already
     * exist.
     * @param conn 
     */
    private static void initializeTestLabResultsTable(Connection conn){
        String sql = "CREATE TABLE IF NOT EXISTS TestLabResults (\n"
                +"patientID text, \n"
                +"testOrderDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"testOrderTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"physicianName text, \n"
                +"testID text, \n"
                +"testName text, \n"
                +"testResult text);";
        try (
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets up the Vital Signs table in the database if it does not already
     * exist.
     * @param conn 
     */
    private static void initializeVitalSignsTable(Connection conn){
        String sql = "CREATE TABLE IF NOT EXISTS TestLabResults (\n"
                +"patientID text, \n"
                +"vitalSignsDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"vitalSignsTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"heartRate text, \n"
                +"bloodPressure text, \n"
                +"oxygenSat text, \n"
                +"breathsPerMinute text);";
        try (
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
