
package MedicalRecordModel;

import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class MedicalHistory {
    PatientProfile patientID;
    Date procedureDate;
    String procedureName;
    int procedureAge;
    String allergyName;
    String allergyDescription;
    String currentMedicalCondition;
    String pastMedicalCondition;
    
    public MedicalHistory(PatientProfile linkPatientID, Date pDate, String pName, int pAge,
            String allName, String allDesc, String currentMed, String pastMed){
        patientID = linkPatientID;
        procedureDate = pDate;
        procedureName = pName;
        procedureAge = pAge;
        allergyName = allName;
        allergyDescription = allDesc;
        currentMedicalCondition = currentMed;
        pastMedicalCondition = pastMed;
    }
}
