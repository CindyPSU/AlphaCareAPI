
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class PrescriptionHistory {
    PatientProfile patientID;
    Date rXorderDate;
    Time rXorderTime;
    String physicianName;
    int rXID;
    String rXName;
    int refillCount;
    //int preferredPharmacyID;
    //String preferredPharmacyName;
    //String preferredPharmacyAddress;
    
    /**
     * 
     * @param linkPatientID
     * @param rxDate
     * @param rxTime
     * @param docName
     * @param rxID
     * @param rxName 
     * @param rxCount
     * 
     * This is the constructor for the PrescriptionHistory Class.
     */
    public PrescriptionHistory(PatientProfile linkPatientID, Date rxDate, Time rxTime, String docName,
            int rxID, String rxName, int rxCount){
        patientID = linkPatientID;
        rXorderDate = rxDate;
        rXorderTime = rxTime;
        physicianName = docName;
        rXID = rxID;
        rXName = rxName;
        refillCount = rxCount;
    }
    
    /**
     * Returns the RX order submission date.
     * @return A RX order date.
     */
    public Date getRXOrderDate(){
        return rXorderDate;
    }
    
    /**
     * Returns the RX order submission time.
     * @return A RX order time.
     */
    public Time getRXOrderTime(){
        return rXorderTime;
    }
    
    /**
     * Returns the RX ordering physician's name.
     * @return A physician's name.
     */
    public String getPhysicianName(){
        return physicianName;
    }
    
    /**
     * Returns the prescription ID for the RX.
     * @return A prescription ID.
     */
    public int getRXID(){
        return rXID;
    }
    
    /**
     * Returns the prescription Name tied to the RX ID.
     * @return A prescription name.
     */
    public String getRXName(){
        return rXName;
    }  
    
    /**
     * Returns the number of refills remaining on a RX.
     * @return A refill count (how many are left on the RX)
     */
    public int getRefillCount(){
        return refillCount;
    }
}
