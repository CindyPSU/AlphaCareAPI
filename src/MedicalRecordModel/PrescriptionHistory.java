
package MedicalRecordModel;

import UserModel.Patient;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class PrescriptionHistory extends DatabaseObjectModel {
    private Patient patient;
    private LocalDate rXorderDate;
    private Time rXorderTime;
    private String physicianName;
    private String rXID;
    private String rXName;
    private int refillCount = -1;
    
    /**
     * 
     * @param linkPatient
     * @param rxDate
     * @param rxTime
     * @param docName
     * @param rxID
     * @param rxName 
     * @param rxCount
     * 
     * This is the constructor for the PrescriptionHistory Class.
     */
    public PrescriptionHistory(Patient linkPatient, LocalDate rxDate, Time rxTime, String docName,
            String rxID, String rxName, int rxCount){
        patient = linkPatient;
        rXorderDate = rxDate;
        rXorderTime = rxTime;
        physicianName = docName;
        rXID = rxID;
        rXName = rxName;
        refillCount = rxCount;
    }

    public PrescriptionHistory()
    {
    }
    
    /**
     * Returns the RX order submission date.
     * @return A RX order date.
     */
    public LocalDate getRXOrderDate(){
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
    public String getRXID(){
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
    
    public String getRefillCountString(){
        String p_refill;
        p_refill = Integer.toString(refillCount);
        return p_refill;
    }
    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the rXorderDate
     */
    public LocalDate getrXorderDate() {
        return rXorderDate;
    }

    /**
     * @param rXorderDate the rXorderDate to set
     */
    public void setrXorderDate(LocalDate rXorderDate) {
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
    public String getrXID() {
        return rXID;
    }

    /**
     * @param rXID the rXID to set
     */
    public void setrXID(String rXID) {
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
    
    /**
     * Returns the patient's complete prescription history that matches the patientID provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return An ArrayList of PrescriptionHistory objects.
     */
    public static ArrayList<PrescriptionHistory> getPrescriptions(String patientID){
        ArrayList<PrescriptionHistory> prescriptions = new ArrayList<PrescriptionHistory>();
        System.out.println("Prescription History will come from the DB.");
        return prescriptions;
    }

    /**
     * Checks to see if the model has all the required data filled out
     * @return boolean True if the model does have all the required data filled out, false if anything is missing 
     */
    @Override
    public boolean hasAllData()
    {
        if(this.patient == null) { return false; }
        if(this.rXorderDate == null) { return false; }
        if(this.rXorderTime == null) { return false; }
        if((this.physicianName == null) || (this.physicianName.isEmpty())) { return false; }
        //if((this.rXID  == null) || (this.rXID.isEmpty())) { return false; }
        if((this.rXName == null) || (this.rXName.isEmpty())) { return false; }
        if(this.refillCount  == -1) { return false; }
        return true;
    }
    
    /**
     * Maps values from the model to the fields in the database
     * @return A Hashtable of fields and mapped values
     */
    @Override
    public Hashtable getMappedData()
    {
      Hashtable h = new Hashtable();
      h.put("patientID", getPatient().getIdentifier());
      h.put("rXorderDate", getRXOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
      h.put("rXorderTime", getRXOrderTime().toString());
      h.put("physicianName", getPhysicianName());
      h.put("rXID", getRXID());
      h.put("rXName", getRXName());
      h.put("refillCount", getRefillCount());
      return h;
    }
   
}
