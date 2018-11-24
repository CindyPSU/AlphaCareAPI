
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
public class ImmunizationHistory extends DatabaseObjectModel {
    private Patient patient;
    private LocalDate immunizeDate;
    private Time immunizeTime;
    private String givenByName;
    private String givenByTitle;
    private String immunizeID;
    private String immunizeName;
 
    /**
     * 
     * @param linkPatientID
     * @param iDate
     * @param iTime
     * @param givenName
     * @param givenTitle
     * @param iID
     * @param iName 
     * 
     * This is the constructor for the ImmunizationHistory Class.
     */
    public ImmunizationHistory(Patient linkPatient, LocalDate iDate, Time iTime, String givenName,
            String givenTitle, int ID, String iID, String iName){
        patient = linkPatient;
        immunizeDate = iDate;
        immunizeTime = iTime;
        givenByName = givenName;
        givenByTitle = givenTitle;
        ID = ID;
        immunizeID = iID;
        immunizeName = iName;
    }

    public ImmunizationHistory()
    {
    }
    
    /**
     * Returns the name of the medical personnel who administered the immunization.
     * @return A name of the medical personnel.
     */
    public String getGivenByName(){
        return givenByName;
    }

    /**
     * @param givenByName the givenByName to set
     */
    public void setGivenByName(String givenByName) {
        this.givenByName = givenByName;
    }
    
    /**
     * Returns the title of the medical personnel who administered the immunization.
     * @return A title of the medical personnel.
     */
    public String getGivenByTitle(){
        return givenByTitle;
    }

    /**
     * @param givenByTitle the givenByTitle to set
     */
    public void setGivenByTitle(String givenByTitle) {
        this.givenByTitle = givenByTitle;
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
     * Returns the immunization date.
     * @return An immunization date.
     */
    public LocalDate getImmunizeDate() {
        return immunizeDate;
    }

    /**
     * @param immunizeDate the immunizeDate to set
     */
    public void setImmunizeDate(LocalDate immunizeDate) {
        this.immunizeDate = immunizeDate;
    }

    /**
     * Returns the immunization time.
     * @return An immunization time.
     */
    public Time getImmunizeTime() {
        return immunizeTime;
    }

    /**
     * @param immunizeTime the immunizeTime to set
     */
    public void setImmunizeTime(Time immunizeTime) {
        this.immunizeTime = immunizeTime;
    }
    
    /**
     * Returns the immunization name that is linked to the ID.
     * @return An immunization name.
     */
    public String getImmunizeName() {
        return immunizeName;
    }

    /**
     * @param immunizeName the immunizeName to set
     */
    public void setImmunizeName(String immunizeName) {
        this.immunizeName = immunizeName;
    }
    
    /**
     * Returns the immunization ID
     * @return An immunization ID.
     */
    public String getImmunizationID(){
        return immunizeID;
    }

    /**
     * @param immunizeID the immunizeIDto set
     */
    public void setImmunizationID(String immunizeID) {
        this.immunizeID = immunizeID;
    }



    
    /**
     * Returns the patient's complete immunization history that matches the patientID provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return An ArrayList of ImmunizationHistory objects.
     */
    public static ArrayList<ImmunizationHistory> getImmunizations(String patientID){
        ArrayList<ImmunizationHistory> immunizations = new ArrayList<>();
        System.out.println("Immunization History will come from the DB.");
        return immunizations;
    }
    
        /**
     * Checks to see if the model has all the required data filled out
     * @return boolean True if the model does have all the required data filled out, false if anything is missing 
     */
    @Override
    public boolean hasAllData()
    {
        if(this.patient == null) { return false; }
        if(this.immunizeDate == null) { return false; }
        if(this.immunizeTime == null) { return false; }

        if((this.givenByName == null) || (this.givenByName.isEmpty())) { return false; }
        if((this.givenByTitle == null) || (this.givenByTitle.isEmpty())) { return false; }
        if((this.immunizeName == null) || (this.immunizeName.isEmpty())) { return false; }
        if((this.immunizeID == null) || (this.immunizeID.isEmpty())) { return false; }
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
      h.put("immunizeDate", getImmunizeDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
      h.put("immunizeTime", getImmunizeTime().toString());
      h.put("immunizeID", getImmunizationID());
      h.put("immunizeName", getImmunizeName());
      h.put("givenByName", getGivenByName());
      h.put("givenByTitle", getGivenByTitle());
      return h;
    }

}
