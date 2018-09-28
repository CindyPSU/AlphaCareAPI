
package MedicalRecordModel;

import java.util.ArrayList;
import java.util.Date;
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
    private Date patientDOB;
    private int patientPhoneNumber;
    private String patientAddress;
    private String patientEmailAddress;
    ArrayList<AppointmentHistory> appointments;
    ArrayList<ImmunizationHistory> immunizations;
    ArrayList<MedicalHistory> medicalData;
    ArrayList<PrescriptionHistory> prescriptions;
    ArrayList<TestLabResults> labResults;
    ArrayList<VitalSigns> vitalSignsData;
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
            String pPreferredName, Date pDOB, int pPhoneNumber, String pAddress, String pEmail){
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
    
    /**
     * Returns the patient complete medical record when the patient ID is provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return A patient complete medical record.
     */
    public static PatientProfile getCompleteMedicalRecord(String patientID){
        PatientProfile completePatientProfile = new PatientProfile(patientID);
        completePatientProfile.appointments = AppointmentHistory.getAppointments(patientID);
        completePatientProfile.immunizations = ImmunizationHistory.getImmunizations(patientID);
        completePatientProfile.medicalData = MedicalHistory.getMedicalData(patientID);
        completePatientProfile.prescriptions = PrescriptionHistory.getPrescriptions(patientID);
        completePatientProfile.labResults = TestLabResults.getLabResults(patientID);
        completePatientProfile.vitalSignsData = VitalSigns.getVitalSignsData(patientID);
        return completePatientProfile;
    }

    /**
     * @return the patientID
     */
    public String getPatientID() {
        return patientID;
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
     * @return the patientPreferredName
     */
    public String getPatientPreferredName() {
        return patientPreferredName;
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
    public void setPatientDOB(Date patientDOB) {
        this.patientDOB = patientDOB;
    }

    /**
     * @param patientPhoneNumber the patientPhoneNumber to set
     */
    public void setPatientPhoneNumber(int patientPhoneNumber) {
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
