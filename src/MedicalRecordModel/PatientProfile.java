
package MedicalRecordModel;

import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */

public class PatientProfile {
    long patientID;
    String patientFirstName;
    String patientLastName;
    String patientMiddleInitial;
    String patientPreferredName;
    int patientSSN;
    Date patientDOB;
    int patientPhoneNumber;
    String patientAddress;
    String patientEmailAddress;
    
    /**
     * 
     * @param initPatientID
     * @param pFirstName
     * @param pLastName
     * @param pMiddleInitial
     * @param pPreferredName
     * @param pSSN
     * @param pDOB
     * @param pPhoneNumber
     * @param pAddress
     * @param pEmail 
     * 
     * This is the constructor for the PatientProfile Class.
     */
    public PatientProfile(long initPatientID, String pFirstName, String pLastName, String pMiddleInitial, 
            String pPreferredName, int pSSN, Date pDOB, int pPhoneNumber, String pAddress, String pEmail){
        patientID = initPatientID;
        patientFirstName = pFirstName;
        patientLastName = pLastName;
        patientMiddleInitial = pMiddleInitial;
        patientPreferredName = pPreferredName;
        patientSSN = pSSN;
        patientDOB = pDOB;
        patientPhoneNumber = pPhoneNumber;
        patientAddress = pAddress;
        patientEmailAddress = pEmail;
    }
    /**
     * Returns the Patient ID that will be linked to the patient profile.
     * @return A long representing the patient ID.
     */
    public long setPatientID(){
        return patientID;
    }
    /**
     * Returns the patient's last name.
     * @return A patient last name.
     */
    public String getPatientLastName(){
        return patientLastName;  
    }
    
    /**
     * Returns the patient's first name.
     * @return A patient first name.
     */
    public String getPatientFirstName(){
        return patientFirstName;  
    }
    
    /**
     * Returns the patient's middle initial.
     * @return A patient middle initial.
     */
    public String getPatientMiddleInitial(){
        return patientMiddleInitial;  
    }
    
    /**
     * Returns the patient social security number.
     * @return A patient social security number.
     */
    public int getPatientSSN(){
        return patientSSN;
    }
    
    /**
     * Returns the patient date of birth.
     * @return A patient date of birth.
     */
    public Date getPatientDOB(){
        return patientDOB;
    }
    
    /**
     * Returns the patient phone number.
     * @return A patient phone number.
     */
    public int getPatientPhoneNumber(){
        return patientPhoneNumber;
    }
    
    /**
     * Returns the patient home address.
     * @return A patient home address.
     */
    public String getPatientAddress(){
        return patientAddress;
    }
    
    /**
     * Returns the patient email address.
     * @return A patient email address.
     */
    public String getPatientEmailAddress(){
        return patientEmailAddress;
    }
}
