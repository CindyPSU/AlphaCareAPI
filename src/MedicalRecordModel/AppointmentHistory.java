
package MedicalRecordModel;

import UserModel.*;
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
public class AppointmentHistory extends DatabaseObjectModel {
    
    private Patient patient;
    private LocalDate appointmentDate;
    private Time appointmentTime;
    private String physicianName;
    private String appointmentCode;
    private String appCodeDescription;
    private AppointmentStatus status;
    private Practice practice;
    
    public AppointmentHistory()
    {
    }
    
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
    public AppointmentHistory(Patient linkPatient, int appID, LocalDate appDate, Time appTime, 
            String docName, String appCode, String appCodeDesc, AppointmentStatus status, Practice practice) {
        patient = linkPatient;
        ID = appID;
        appointmentDate = appDate;
        appointmentTime = appTime;
        physicianName = docName;
        appointmentCode = appCode;
        appCodeDescription = appCodeDesc;
        this.status = status;
        this.practice = practice;
    }
    
    /**
     * Returns the patient's appointment date.
     * @return A patient appointment date.
     */
    public LocalDate getAppointmentDate(){
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
     * @param appointmentDate the appointmentDate to set
     */
    public void setAppointmentDate(LocalDate appointmentDate) {
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
    
    /**
     * @return the status
     */
    public AppointmentStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    /**
     * @return the practice
     */
    public Practice getPractice() {
        return practice;
    }
    
    public String getPracticeString(){
        String app_practice = "";
        if(practice != null)
        {
          app_practice = practice.toString();
        }
        return app_practice;
    }

    /**
     * @param practice the practice to set
     */
    public void setPractice(Practice practice) {
        this.practice = practice;
    }
    
    /**
     * Returns the patient's complete appointment history that matches the patientID provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return An ArrayList of AppointmentHistory objects.
     */
    public static ArrayList<AppointmentHistory> getAppointments(String patientID){
        ArrayList<AppointmentHistory> appointments = new ArrayList<AppointmentHistory>();
        System.out.println("Appointment History will come from the DB.");
        return appointments;
    }
    
    /**
     * Checks to see if the model has all the required data filled out
     * @return boolean True if the model does have all the required data filled out, false if anything is missing 
     */
    @Override
    public boolean hasAllData()
    {
      if((this.appCodeDescription == null) || (this.appCodeDescription.isEmpty())) { return false; }
      if((this.appointmentCode == null) || (this.appointmentCode.isEmpty())) { return false; }
      if(this.appointmentDate == null) { return false; }
      if(this.appointmentTime == null) { return false; }
      if(this.patient == null) { return false; }
      if((this.physicianName == null) || (this.physicianName.isEmpty())) { return false; }
      if(this.practice == null) { return false; }
      if(this.status == null) { return false; }
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
      h.put("appointmentDate", getAppointmentDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
      h.put("appointmentTime", getAppointmentTime().toString());
      h.put("physicianName", getPhysicianName());
      h.put("practiceName", getPracticeString());
      h.put("appointmentCode", getAppointmentCode());
      h.put("appCodeDescription", getAppCodeDescription());
      h.put("appointmentStatus", getStatus().getValue());
      return h;
    }
}
