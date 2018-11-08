
package MedicalRecordModel;

import UserModel.Patient;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class ImmunizationHistory {
    private Patient patientID;
    private Date immunizeDate;
    private Time immunizeTime;
    private String givenByName;
    private String givenByTitle;
    private int immunizeID;
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
    public ImmunizationHistory(Patient linkPatientID, Date iDate, Time iTime, String givenName,
            String givenTitle, int iID, String iName){
        patientID = linkPatientID;
        immunizeDate = iDate;
        immunizeTime = iTime;
        givenByName = givenName;
        givenByTitle = givenTitle;
        immunizeID = iID;
        immunizeName = iName;
    }
    
    /**
     * Returns the immunization date.
     * @return An immunization date.
     */
    public Date getImmunizationDate(){
        return getImmunizeDate();
    }
    
    /**
     * Returns the immunization time.
     * @return An immunization time.
     */
    public Date getImmunizationTime(){
        return getImmunizeTime();
    }
    
    /**
     * Returns the name of the medical personnel who administered the immunization.
     * @return A name of the medical personnel.
     */
    public String getGivenByName(){
        return givenByName;
    }
    
    /**
     * Returns the title of the medical personnel who administered the immunization.
     * @return A title of the medical personnel.
     */
    public String getGivenByTitle(){
        return givenByTitle;
    }
    
    /**
     * Returns the immunization ID.
     * @return An immunization ID.
     */
    public int getImmunizationID(){
        return getImmunizeID();
    }
    
    /**
     * Returns the immunization name that is linked to the ID.
     * @return An immunization name.
     */
    public String getImmunizationName(){
        return getImmunizeName();
    }      

    /**
     * @return the patientID
     */
    public Patient getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    /**
     * @return the immunizeDate
     */
    public Date getImmunizeDate() {
        return immunizeDate;
    }

    /**
     * @param immunizeDate the immunizeDate to set
     */
    public void setImmunizeDate(Date immunizeDate) {
        this.immunizeDate = immunizeDate;
    }

    /**
     * @return the immunizeTime
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
     * @param givenByName the givenByName to set
     */
    public void setGivenByName(String givenByName) {
        this.givenByName = givenByName;
    }

    /**
     * @param givenByTitle the givenByTitle to set
     */
    public void setGivenByTitle(String givenByTitle) {
        this.givenByTitle = givenByTitle;
    }

    /**
     * @return the immunizeID
     */
    public int getImmunizeID() {
        return immunizeID;
    }

    /**
     * @param immunizeID the immunizeID to set
     */
    public void setImmunizeID(int immunizeID) {
        this.immunizeID = immunizeID;
    }

    /**
     * @return the immunizeName
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
     * Returns the patient's complete immunization history that matches the patientID provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return An ArrayList of ImmunizationHistory objects.
     */
    public static ArrayList<ImmunizationHistory> getImmunizations(String patientID){
        ArrayList<ImmunizationHistory> immunizations = new ArrayList<ImmunizationHistory>();
        System.out.println("Immunization History will come from the DB.");
        return immunizations;
    }
}
