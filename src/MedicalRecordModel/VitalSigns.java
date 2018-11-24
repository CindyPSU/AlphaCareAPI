
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
public class VitalSigns extends DatabaseObjectModel {
    private Patient patient;
    private LocalDate vitalSignsDate;
    private Time vitalSignsTime;
    private String checkedBy;
    private String heartRate;
    private String bloodPressure;
    private String oxygenSat;
    private String breathsPerMinute;
    
    /**
     * 
     * @param linkPatient
     * @param vsID
     * @param vsDate
     * @param vsTime
     * @param hRate
     * @param bPressure
     * @param oSat
     * @param bpm 
     * 
     * This is the constructor for the VitalSigns Class.
     */
    public VitalSigns(Patient linkPatient, int vsID, LocalDate vsDate, Time vsTime, 
            String hRate, String bPressure, String oSat, String bpm){
        patient = linkPatient;
        ID = vsID;
        vitalSignsDate = vsDate;
        vitalSignsTime = vsTime;
        heartRate = hRate;
        bloodPressure = bPressure;
        oxygenSat = oSat;
        breathsPerMinute = bpm;
    }
    
    public VitalSigns()
    {
        
    }
    
    /**
     * Returns the patient's vital signs check date.
     * @return A patient vital signs date.
     */
    public LocalDate getVitalSignsDate(){
        return vitalSignsDate;
    } 
    
    /**
     * Returns the patient's vital signs check time.
     * @return A patient vital signs time.
     */
    public Time getVitalSignsTime(){
        return vitalSignsTime;
    }
    
    /**
     * Returns the patient's heart rate.
     * @return A patient heart rate.
     */
    public String getHeartRate(){
        return heartRate;
    }
    
    /**
     * Returns the patient's blood pressure.
     * @return A patient blood pressure.
     */
    public String getBloodPressure(){
        return bloodPressure;
    }
    
    /**
     * Returns the patient's O2 sat.
     * @return A patient 02 sat.
     */
    public String getOxygenSat(){
        return oxygenSat;
    }
    
    /**
     * Returns the patient's breaths per minute.
     * @return A patient breaths per minute.
     */
    public String getBreathsPerMinute(){
        return breathsPerMinute;
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
     * @param vitalSignsDate the vitalSignsDate to set
     */
    public void setVitalSignsDate(LocalDate vitalSignsDate) {
        this.vitalSignsDate = vitalSignsDate;
    }

    /**
     * @param vitalSignsTime the vitalSignsTime to set
     */
    public void setVitalSignsTime(Time vitalSignsTime) {
        this.vitalSignsTime = vitalSignsTime;
    }

    /**
     * @param heartRate the heartRate to set
     */
    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * @param bloodPressure the bloodPressure to set
     */
    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    /**
     * @param oxygenSat the oxygenSat to set
     */
    public void setOxygenSat(String oxygenSat) {
        this.oxygenSat = oxygenSat;
    }

    /**
     * @param breathsPerMinute the breathsPerMinute to set
     */
    public void setBreathsPerMinute(String breathsPerMinute) {
        this.breathsPerMinute = breathsPerMinute;
    }
    
    /**
     * Returns the patient's complete vital signs history that matches the patientID provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return An ArrayList of vital signs objects.
     */
    public static ArrayList<VitalSigns> getVitalSignsData(String patientID){
        ArrayList<VitalSigns> vitalSignsData = new ArrayList<VitalSigns>();
        System.out.println("Vital Signs Data History will come from the DB.");
        return vitalSignsData;
    }

    /**
     * @return the checkedBy
     */
    public String getCheckedBy() {
        return checkedBy;
    }

    /**
     * @param checkedBy the checkedBy to set
     */
    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
    }

    /**
     * Checks to see if the model has all the required data filled out
     * @return boolean True if the model does have all the required data filled out, false if anything is missing 
     */
    @Override
    public boolean hasAllData()
    {
        if(this.patient == null) { return false; }
        if(this.vitalSignsDate == null) { return false; }
        if(this.vitalSignsTime == null) { return false; }

        if((this.checkedBy == null) || (this.checkedBy.isEmpty())) { return false; }
        if((this.heartRate == null) || (this.heartRate.isEmpty())) { return false; }
        if((this.bloodPressure == null) || (this.bloodPressure.isEmpty())) { return false; }
        if((this.oxygenSat == null) || (this.oxygenSat.isEmpty())) { return false; }
        if((this.breathsPerMinute == null) || (this.breathsPerMinute.isEmpty())) { return false; }

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
      h.put("vitalSignsDate", getVitalSignsDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
      h.put("vitalSignsTime", getVitalSignsTime().toString());
      h.put("checkedBy", getCheckedBy());
      h.put("heartRate", getHeartRate());
      h.put("bloodPressure", getBloodPressure());
      h.put("oxygenSat", getOxygenSat());
      h.put("breathsPerMinute", getBreathsPerMinute());
      return h;
    }
    
}
