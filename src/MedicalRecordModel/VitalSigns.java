
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class VitalSigns {
    private PatientProfile patientID;
    private int vitalSignsID;
    private Date vitalSignsDate;
    private Time vitalSignsTime;
    private String heartRate;
    private String bloodPressure;
    private String oxygenSat;
    private String breathsPerMinute;
    
    /**
     * 
     * @param linkPatientID
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
    public VitalSigns(PatientProfile linkPatientID, int vsID, Date vsDate, Time vsTime, 
            String hRate, String bPressure, String oSat, String bpm){
        patientID = linkPatientID;
        vitalSignsID = vsID;
        vitalSignsDate = vsDate;
        vitalSignsTime = vsTime;
        heartRate = hRate;
        bloodPressure = bPressure;
        oxygenSat = oSat;
        breathsPerMinute = bpm;
    }
    
    /**
     * Return vital signs ID.
     * @return A vital signs ID.
     */
    public int getVitalSignsID(){
        return vitalSignsID;
    }
    /**
     * Returns the patient's vital signs check date.
     * @return A patient vital signs date.
     */
    public Date getVitalSignsDate(){
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
     * @param vitalSignsID the vitalSignsID to set
     */
    public void setVitalSignsID(int vitalSignsID) {
        this.vitalSignsID = vitalSignsID;
    }

    /**
     * @param vitalSignsDate the vitalSignsDate to set
     */
    public void setVitalSignsDate(Date vitalSignsDate) {
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
}
