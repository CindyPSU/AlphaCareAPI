
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class VitalSigns {
    PatientProfile patientID;
    int vitalSignsID;
    Date vitalSignsDate;
    Time vitalSignsTime;
    String heartRate;
    String bloodPressure;
    String oxygenSat;
    String breathsPerMinute;
    
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
}
