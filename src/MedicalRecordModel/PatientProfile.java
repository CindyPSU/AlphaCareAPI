
package MedicalRecordModel;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class PatientProfile {
    private String patientID;
    private String patientFirstName;
    private String patientLastName;
    private String patientMiddleInitial;
    private String patientPreferredName;
    private SimpleDateFormat patientDOB;
    private String patientPhoneNumber;
    private String patientAddress;
    private String patientEmailAddress;
    public static ArrayList<PatientProfile> patientProfiles = new ArrayList<PatientProfile>();
    public ArrayList<AppointmentHistory> appointments;
    public ArrayList<ImmunizationHistory> immunizations;
    public ArrayList<MedicalHistory> medicalData;
    public ArrayList<PrescriptionHistory> prescriptions;
    public ArrayList<TestLabResults> labResults;
    public ArrayList<VitalSigns> vitalSignsData;
    /**
     * 
     * @param initPatientID 
     * Basic entry constructor.
     */
    public PatientProfile(String initPatientID){
        patientID = initPatientID;
    }
    /**
     * 
     * @param initPatientID
     * @param pFirstName
     * @param pLastName
     * @param pMiddleInitial
     * @param pPreferredName
     * @param pDOB
     * @param pPhoneNumber
     * @param pAddress
     * @param pEmail 
     * 
     * This is the constructor for the PatientProfile Class.
     */
    public PatientProfile(String initPatientID, String pFirstName, String pLastName, String pMiddleInitial, 
            String pPreferredName, SimpleDateFormat pDOB, String pPhoneNumber, String pAddress, String pEmail){
        patientID = initPatientID;
        patientFirstName = pFirstName;
        patientLastName = pLastName;
        patientMiddleInitial = pMiddleInitial;
        patientPreferredName = pPreferredName;
        patientDOB = pDOB;
        patientPhoneNumber = pPhoneNumber;
        patientAddress = pAddress;
        patientEmailAddress = pEmail;
    }
    
    /**
     * Returns the Patient ID that will be linked to the patient profile.
     * @return A long representing the patient ID.
     */
    public String setPatientID(){
        return getPatientID();
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
     * Returns the patient date of birth.
     * @return A patient date of birth.
     */
    public SimpleDateFormat getPatientDOB(){
        return patientDOB;
    }
    
    /**
     * Returns the patient phone number.
     * @return A patient phone number.
     */
    public String getPatientPhoneNumber(){
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
    
    /**
     * Returns the patient complete medical record when the patient ID is provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return A patient complete medical record.
     */
    public static PatientProfile getCompleteMedicalRecord(String patientID){
        for(PatientProfile pp : patientProfiles) {
            if(pp.patientID.equals(patientID)){
                return pp;
            }
        }
        return null;
    }

    /**
     * @return the patientID
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     * @return the patientPreferredName
     */
    public String getPatientPreferredName() {
        return patientPreferredName;
    }
    
    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    /**
     * @param patientFirstName the patientFirstName to set
     */
    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    /**
     * @param patientLastName the patientLastName to set
     */
    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    /**
     * @param patientMiddleInitial the patientMiddleInitial to set
     */
    public void setPatientMiddleInitial(String patientMiddleInitial) {
        this.patientMiddleInitial = patientMiddleInitial;
    }

    /**
     * @param patientPreferredName the patientPreferredName to set
     */
    public void setPatientPreferredName(String patientPreferredName) {
        this.patientPreferredName = patientPreferredName;
    }

    /**
     * @param patientDOB the patientDOB to set
     */
    public void setPatientDOB(SimpleDateFormat patientDOB) {
        this.patientDOB = patientDOB;
    }

    /**
     * @param patientPhoneNumber the patientPhoneNumber to set
     */
    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    /**
     * @param patientAddress the patientAddress to set
     */
    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    /**
     * @param patientEmailAddress the patientEmailAddress to set
     */
    public void setPatientEmailAddress(String patientEmailAddress) {
        this.patientEmailAddress = patientEmailAddress;
    }
}
