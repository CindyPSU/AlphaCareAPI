
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class PrescriptionHistory {

    /**
     * @return the patientID
     */
    public PatientProfile getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(PatientProfile patientID) {
        this.patientID = patientID;
    }

    /**
     * @return the rXorderDate
     */
    public Date getrXorderDate() {
        return rXorderDate;
    }

    /**
     * @param rXorderDate the rXorderDate to set
     */
    public void setrXorderDate(Date rXorderDate) {
        this.rXorderDate = rXorderDate;
    }

    /**
     * @return the rXorderTime
     */
    public Time getrXorderTime() {
        return rXorderTime;
    }

    /**
     * @param rXorderTime the rXorderTime to set
     */
    public void setrXorderTime(Time rXorderTime) {
        this.rXorderTime = rXorderTime;
    }

    /**
     * @param physicianName the physicianName to set
     */
    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    /**
     * @return the rXID
     */
    public int getrXID() {
        return rXID;
    }

    /**
     * @param rXID the rXID to set
     */
    public void setrXID(int rXID) {
        this.rXID = rXID;
    }

    /**
     * @return the rXName
     */
    public String getrXName() {
        return rXName;
    }

    /**
     * @param rXName the rXName to set
     */
    public void setrXName(String rXName) {
        this.rXName = rXName;
    }

    /**
     * @param refillCount the refillCount to set
     */
    public void setRefillCount(int refillCount) {
        this.refillCount = refillCount;
    }
    private PatientProfile patientID;
    private Date rXorderDate;
    private Time rXorderTime;
    private String physicianName;
    private int rXID;
    private String rXName;
    private int refillCount;
    
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
        return getrXorderDate();
    }
    
    /**
     * Returns the RX order submission time.
     * @return A RX order time.
     */
    public Time getRXOrderTime(){
        return getrXorderTime();
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
        return getrXID();
    }
    
    /**
     * Returns the prescription Name tied to the RX ID.
     * @return A prescription name.
     */
    public String getRXName(){
        return getrXName();
    }  
    
    /**
     * Returns the number of refills remaining on a RX.
     * @return A refill count (how many are left on the RX)
     */
    public int getRefillCount(){
        return refillCount;
    }
}
