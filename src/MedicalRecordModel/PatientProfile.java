
package MedicalRecordModel;

import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class PatientProfile {
    String patientFirstName;
    String patientLastName;
    String patientMiddleInitial;
    String patientPreferredName;
    int patientSSN;
    Date patientDOB;
    int patientPhoneNumber;
    String patientAddress;
    String patientEmailAddress;
    
    public PatientProfile(String pFirstName, String pLastName, String pMiddleInitial, 
            String pPreferredName, int pSSN, Date pDOB, int pPhoneNumber, String pAddress, String pEmail){
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
    
    public String getPatientName(){
        return "";  
    }
    
    public String getPatientSSN(){
        return "";
    }
    
    public String getPatientDOB(){
        return "";
    }
    
    public String getPatientPhoneNumber(){
        return "";
    }
    
    public String getPatientAddress(){
        return "";
    }
    
    public String getPatientEmailAddress(){
        return "";
    }
}
