
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class AppointmentHistory {
    PatientProfile patientID;
    Date appointmentDate;
    Time appointmentTime;
    String physicianName;
    String appointmentCode;
    String appCodeDescription;
    
    /**
     * 
     * @param linkPatientID
     * @param appDate
     * @param appTime
     * @param docName
     * @param appCode
     * @param appCodeDesc 
     * 
     * This is the constructor for the AppointmentHistory Class.
     */
    public AppointmentHistory(PatientProfile linkPatientID, Date appDate, Time appTime, 
            String docName, String appCode, String appCodeDesc){
        patientID = linkPatientID;
        appointmentDate = appDate;
        appointmentTime = appTime;
        physicianName = docName;
        appointmentCode = appCode;
        appCodeDescription = appCodeDesc;
    }
    
    /**
     * Returns the patient's appointment date.
     * @return A patient appointment date.
     */
    public Date getAppointmentDate(){
        return appointmentDate;
    } 
    
    /**
     * Returns the patient's appointment time.
     * @return A patient appointment time.
     */
    public Time getAppointmentTime(){
        return appointmentTime;
    }
    
    /**
     * Returns the physician's name for the appointment.
     * @return A physician's name.
     */
    public String getPhysicianName(){
        return physicianName;
    }
    
    /**
     * Returns the tracking code for the appointment type.
     * @return An appointment code.
     */
    public String getAppointmentCode(){
        return appointmentCode;
    }
    
    /**
     * Returns the appointment description that is tied to the appointment code.
     * @return An appointment description.
     */
    public String getAppCodeDescription(){
        return appCodeDescription;
    }     
}
