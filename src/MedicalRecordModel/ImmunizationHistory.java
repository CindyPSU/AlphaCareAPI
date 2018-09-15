
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class ImmunizationHistory {
    PatientProfile patientID;
    Date immunizeDate;
    Time immunizeTime;
    String givenByName;
    String givenByTitle;
    int immunizeID;
    String immunizeName;
 
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
    public ImmunizationHistory(PatientProfile linkPatientID, Date iDate, Time iTime, String givenName,
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
        return immunizeDate;
    }
    
    /**
     * Returns the immunization time.
     * @return An immunization time.
     */
    public Date getImmunizationTime(){
        return immunizeTime;
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
        return immunizeID;
    }
    
    /**
     * Returns the immunization name that is linked to the ID.
     * @return An immunization name.
     */
    public String getImmunizationName(){
        return immunizeName;
    }      
}
