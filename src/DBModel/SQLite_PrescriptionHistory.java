
package DBModel;

import MedicalRecordModel.*;
import UserModel.Patient;
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
public class SQLite_PrescriptionHistory extends SQLite_Table {

    /**
     * Sets up the Prescription History table in the database if it does not already
     * exist.
     */
    public static void initializeTable(){
        String sql = "CREATE TABLE IF NOT EXISTS PrescriptionHistory (\n"
                +"ID integer PRIMARY KEY AUTOINCREMENT, \n"
                +"patientID text, \n"
                +"rXorderDate text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"rXorderTime text, \n" // Date format YYYY-MM-DD HH:MM:SS.SSS
                +"physicianName text, \n"
                +"rXID text, \n"
                +"rXName text, \n"
                +"refillCount integer);";
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

            String sqlSearch = "SELECT * FROM PrescriptionHistory WHERE patientID='" + profile.getIdentifier() + "'";
            ResultSet rs = stmt.executeQuery(sqlSearch);

            while(rs.next())
            {
                PrescriptionHistory entry = new PrescriptionHistory();
                entry.setID(rs.getInt("ID"));
                entry.setPatient(profile);
                entry.setPhysicianName(rs.getString("physicianName"));
                entry.setRefillCount(rs.getInt("refillCount"));
                entry.setrXID(rs.getString("rXID"));
                entry.setrXName(rs.getString("rXName"));
                entry.setrXorderDate(LocalDate.parse(rs.getString("rXorderDate"), DateTimeFormatter.ISO_DATE));
                entry.setrXorderTime(Time.valueOf(rs.getString("rXorderTime")));
               
                profile.prescriptions.add(entry);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    
    
    /*
    private static void save(PrescriptionHistory rxHistory){
        // code for inserting patient profile into the database
        try (
            Statement stmt = SQLite.getConnection().createStatement()) {
            if(rxHistory.getDatabaseID() == 0){
                // insert new record into RX History table
                String sqlInsert = "INSERT INTO PrescriptionHistory (patientID, rXorderDate, rXorderTime, physicianName, "
                    + "rXID, rXName, refillCount) VALUES ("
                    + "'" + rxHistory.getPatientID().getIdentifier() + "', "
                    + "'" + rxHistory.getRXOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE) + "', "
                    + "'" + rxHistory.getRXOrderTime() + "', "
                    + "'" + rxHistory.getPhysicianName() + "', "
                    + "'" + rxHistory.getRXID() + "', "
                    + "'" + rxHistory.getRXName() + "', "
                    + "" + rxHistory.getRefillCount() + ""
                    + ")";
                stmt.execute(sqlInsert);
                
                rxHistory.setDatabaseID(SQLite.getLastInsertID());
            }
            else {
                // update RX History table record where ID = rxHistory.getDatabaseID()
            }
            String sqlUpdate = "UPDATE PrescriptionHistory SET "
                    + "patientID='" + rxHistory.getPatientID().getIdentifier() + "', "
                    + "rXorderDate='" + rxHistory.getRXOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE) + "',"
                    + "rXorderTime='" + rxHistory.getRXOrderTime()+ "', "
                    + "physicianName='" + rxHistory.getPhysicianName()+ "', "
                    + "rXID='" + rxHistory.getRXID()+"',"
                    + "rXName='" + rxHistory.getRXName() + "', "
                    + "refillCount=" + rxHistory.getRefillCount() + ""
                + " WHERE ID='" + rxHistory.getDatabaseID() + "'";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     */
    
}
