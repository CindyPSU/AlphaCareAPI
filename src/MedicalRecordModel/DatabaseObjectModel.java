
package MedicalRecordModel;

import java.util.Hashtable;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class DatabaseObjectModel {
    
    public int ID;
    
    /**
     * Returns the database ID.
     * @return A databaset ID.
     */
    public int getID(){
        return ID;
    }
        
    /**
     * @param ID the database ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * Checks to see if the model has all the required data filled out
     * @return boolean True if the model does have all the required data filled out, false if anything is missing 
     */
    public boolean hasAllData()
    {
      return false;
    }
    
    /**
     * Maps values from the model to the fields in the database
     * @return A Hashtable of fields and mapped values
     */
    public Hashtable getMappedData()
    {
      Hashtable h = new Hashtable();
      return h;
    }
}
