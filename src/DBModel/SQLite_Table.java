
package DBModel;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 * The initialization is adapted from SQLite documentation.
 */
public abstract class SQLite_Table {
    
   
    /**
     * Saves the model data to the database.
     * @param entry
     */
    public static void save(String tableName, MedicalRecordModel.DatabaseObjectModel entry){

        // Don't do anything if we don't have all the data
        if(!entry.hasAllData())
        {
            System.out.println(entry.toString() + " :: Not saving because it doesn't have all the data"); 
            return;
        }
        
        try (Statement stmt = SQLite.getConnection().createStatement()) {

            String sqlUpdateOrInsert;
            if(entry.getID() > 0)
            {
                System.out.println(entry.toString() + " :: Generating update SQL"); 
                sqlUpdateOrInsert = SQLite.getUpdateSQL(tableName, entry.getMappedData(), "ID='" + entry.getID() + "'");
            }
            else
            {
                System.out.println(entry.toString() + " :: Generating insert SQL"); 
                sqlUpdateOrInsert = SQLite.getInsertSQL(tableName, entry.getMappedData());
            }
            
            // create a new table
            stmt.execute(sqlUpdateOrInsert);
            if(entry.getID() > 0)
            {
              // Update
            }
            else
            {
              // Insert - update ID
              entry.setID(SQLite.getLastInsertID());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
