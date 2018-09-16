
package MedicalRecordModel;

import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class MedicalHistory {
    PatientProfile patientID;
    int medicalHistoryID;
    Date procedureDate;
    String procedureName;
    int procedureAge;
    String allergyName;
    String allergyDescription;
    String currentMedicalCondition;
    String pastMedicalCondition;
    
    /**
     * 
     * @param linkPatientID
     * @param medHID
     * @param pDate
     * @param pName
     * @param pAge
     * @param allName
     * @param allDesc
     * @param currentMed
     * @param pastMed 
     * 
     * This is the constructor for the MedicalHistory Class.
     */
    public MedicalHistory(PatientProfile linkPatientID, int medHID, Date pDate, String pName, int pAge,
            String allName, String allDesc, String currentMed, String pastMed){
        patientID = linkPatientID;
        medicalHistoryID = medHID;
        procedureDate = pDate;
        procedureName = pName;
        procedureAge = pAge;
        allergyName = allName;
        allergyDescription = allDesc;
        currentMedicalCondition = currentMed;
        pastMedicalCondition = pastMed;
    }
    
    /**
     * Returns med history ID.
     * @return med history ID.
     */
    public int getMedicalHistoryID(){
        return medicalHistoryID;
    }
    /**
     * Returns the procedure date.
     * @return An procedure date.
     */
    public Date getProcedureDate(){
        return procedureDate;
    }
    
    /**
     * Returns the procedure name.
     * @return An procedure name.
     */
    public String getProcedureName(){
        return procedureName;
    }
    
    /**
     * Returns the age at which the patient's medical procedure was completed
     * @return An age of the patient.
     */
    public int getProcedureAge(){
        return procedureAge;
    }
    
    /**
     * Returns the name of the patient's allergy.
     * @return An allergy name.
     */
    public String getAllergyName(){
        return allergyName;
    }
    
    /**
     * Returns the description of the patient's allergy.
     * @return An allergy description.
     */
    public String getAllergyDescription(){
        return allergyDescription;
    }
        
    /**
     * Returns the patient's current medical condition information.
     * @return A current medical condition.
     */
    public String getCurrentMedicalCondition(){
        return currentMedicalCondition;
    }
     
    /**
     * Returns the patient's past medical condition information.
     * @return A past medical condition.
     */
    public String getPastMedicalCondition(){
        return pastMedicalCondition;
    }  
}
