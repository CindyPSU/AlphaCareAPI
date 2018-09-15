
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
        return 12345678;
    }
    /**
     * Returns the patient name in a preferred format.
     * @return A formatted patient name.
     */
    public String getPatientName(){
        return "Patient Last Name: "+patientLastName+", Patient First Name: "+patientFirstName+", Patient Middle Initial: "+patientMiddleInitial;  
    }
    
    /**
     * Returns the patient social security in a preferred format.
     * @return A formatted patient social security number.
     */
    public String getPatientSSN(){
        return "Patient SSN: "+patientSSN;
    }
    
    /**
     * Returns the patient date of birth in a preferred format.
     * @return A formatted patient date of birth.
     */
    public String getPatientDOB(){
        return "Patient Date of Birth (DOB): "+patientDOB;
    }
    
    /**
     * Returns the patient phone number in a preferred format.
     * @return A formatted patient phone number.
     */
    public String getPatientPhoneNumber(){
        return "Phone: "+patientPhoneNumber;
    }
    
    /**
     * Returns the patient home address in a preferred format.
     * @return A formatted patient home address.
     */
    public String getPatientAddress(){
        return "Address: "+patientAddress;
    }
    
    /**
     * Returns the patient email address in a preferred format.
     * @return A formatted patient email address.
     */
    public String getPatientEmailAddress(){
        return "Email: "+patientEmailAddress;
    }
}
