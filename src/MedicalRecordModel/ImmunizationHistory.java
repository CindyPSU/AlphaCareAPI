
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
}
