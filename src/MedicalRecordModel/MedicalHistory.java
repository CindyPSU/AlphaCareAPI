
package MedicalRecordModel;

import UserModel.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class MedicalHistory extends DatabaseObjectModel {
    private Patient patient;
    private LocalDate procedureDate;
    private String procedureName;
    private int procedureAge = -1;
    private String allergyName;
    private String allergyDescription;
    
    public MedicalHistory()
    {
    }

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
    public MedicalHistory(Patient linkPatientID, int medHID, LocalDate pDate, String pName, int pAge,
            String allName, String allDesc){
        patient = linkPatientID;
        ID = medHID;
        procedureDate = pDate;
        procedureName = pName;
        procedureAge = pAge;
        allergyName = allName;
        allergyDescription = allDesc;
    }
    
    /**
     * Returns the procedure date.
     * @return An procedure date.
     */
    public LocalDate getProcedureDate(){
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
    
    public String getProcedureAgeString(){
        String p_age;
        p_age = Integer.toString(procedureAge);
        return p_age;
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
     * @return the patientID
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatient(Patient patientID) {
        this.patient = patientID;
    }

    /**
     * @param procedureDate the procedureDate to set
     */
    public void setProcedureDate(LocalDate procedureDate) {
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

    /**
     * Checks to see if the model has all the required data filled out
     * @return boolean True if the model does have all the required data filled out, false if anything is missing 
     */
    @Override
    public boolean hasAllData()
    {
        if(this.patient == null) { return false; }

        if((this.allergyDescription == null) || (this.allergyDescription.isEmpty())) { return false; }
        if((this.allergyName == null) || (this.allergyName.isEmpty())) { return false; }
        if(this.procedureAge == -1) { return false; }
        if(this.procedureDate == null) { return false; }
        if((this.procedureName  == null) || (this.procedureName.isEmpty())) { return false; }
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
      h.put("allergyDescription", getAllergyDescription());
      h.put("allergyName", getAllergyName());
      h.put("procedureDate", getProcedureDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
      h.put("procedureAge", getProcedureAge());
      h.put("procedureName", getProcedureName());
      return h;
    }

}
