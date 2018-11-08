
package MedicalRecordModel;

import UserModel.Patient;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class MedicalHistory {
    private Patient patientID;
    private int medicalHistoryID;
    private Date procedureDate;
    private String procedureName;
    private int procedureAge;
    private String allergyName;
    private String allergyDescription;
    private String currentMedicalCondition;
    private String pastMedicalCondition;
    
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
    public MedicalHistory(Patient linkPatientID, int medHID, Date pDate, String pName, int pAge,
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
     * @param medicalHistoryID the medicalHistoryID to set
     */
    public void setMedicalHistoryID(int medicalHistoryID) {
        this.medicalHistoryID = medicalHistoryID;
    }

    /**
     * @param procedureDate the procedureDate to set
     */
    public void setProcedureDate(Date procedureDate) {
        this.procedureDate = procedureDate;
    }

    /**
     * @param procedureName the procedureName to set
     */
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    /**
     * @param procedureAge the procedureAge to set
     */
    public void setProcedureAge(int procedureAge) {
        this.procedureAge = procedureAge;
    }

    /**
     * @param allergyName the allergyName to set
     */
    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    /**
     * @param allergyDescription the allergyDescription to set
     */
    public void setAllergyDescription(String allergyDescription) {
        this.allergyDescription = allergyDescription;
    }

    /**
     * @param currentMedicalCondition the currentMedicalCondition to set
     */
    public void setCurrentMedicalCondition(String currentMedicalCondition) {
        this.currentMedicalCondition = currentMedicalCondition;
    }

    /**
     * @param pastMedicalCondition the pastMedicalCondition to set
     */
    public void setPastMedicalCondition(String pastMedicalCondition) {
        this.pastMedicalCondition = pastMedicalCondition;
    }
    
    /**
     * Returns the patient's complete medical history that matches the patientID provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return An ArrayList of MedicalHistory objects.
     */
    public static ArrayList<MedicalHistory> getMedicalData(String patientID){
        ArrayList<MedicalHistory> medicalData = new ArrayList<MedicalHistory>();
        System.out.println("Medical History will come from the DB.");
        return medicalData;
    }
}
