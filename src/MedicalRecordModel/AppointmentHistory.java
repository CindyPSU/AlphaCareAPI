
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class AppointmentHistory {
    private PatientProfile patientID;
    private int appointmentID;
    private Date appointmentDate;
    private Time appointmentTime;
    private String physicianName;
    private String appointmentCode;
    private String appCodeDescription;
    
    /**
     * 
     * @param linkPatientID
     * @param appID
     * @param appDate
     * @param appTime
     * @param docName
     * @param appCode
     * @param appCodeDesc 
     * 
     * This is the constructor for the AppointmentHistory Class.
     */
    public AppointmentHistory(PatientProfile linkPatientID, int appID, Date appDate, Time appTime, 
            String docName, String appCode, String appCodeDesc){
        patientID = linkPatientID;
        appointmentID = appID;
        appointmentDate = appDate;
        appointmentTime = appTime;
        physicianName = docName;
        appointmentCode = appCode;
        appCodeDescription = appCodeDesc;
    }
    
    /**
     * Returns the appointment ID.
     * @return An appointment ID.
     */
    public int getAppointmentID(){
        return appointmentID;
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
     * @param appointmentID the appointmentID to set
     */
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    /**
     * @param appointmentDate the appointmentDate to set
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * @param appointmentTime the appointmentTime to set
     */
    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * @param physicianName the physicianName to set
     */
    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    /**
     * @param appointmentCode the appointmentCode to set
     */
    public void setAppointmentCode(String appointmentCode) {
        this.appointmentCode = appointmentCode;
    }

    /**
     * @param appCodeDescription the appCodeDescription to set
     */
    public void setAppCodeDescription(String appCodeDescription) {
        this.appCodeDescription = appCodeDescription;
    }
}
