
package UserModel;

import MedicalRecordModel.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class Patient extends User {
    
    public static ArrayList<Patient> patientProfiles = new ArrayList<Patient>();
    
    private String identifier;
    private LocalDate birthdate;
    private String phoneNumber;
    private String address;
    private String email;
    
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
    public Patient(String initPatientID){
        identifier = initPatientID;
    }
    
    /**
     * Empty constructor
     */
    public Patient(){
        
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
    public Patient(String initPatientID, String pFirstName, String pLastName, String pMiddleInitial, 
            String pPreferredName, LocalDate pDOB, String pPhoneNumber, String pAddress, String pEmail){
        identifier = initPatientID;
        this.firstName = pFirstName;
        this.lastName = pLastName;
        this.middleInitial = pMiddleInitial;
        this.preferredName = pPreferredName;
        birthdate = pDOB;
        phoneNumber = pPhoneNumber;
        address = pAddress;
        email = pEmail;
    }
    
    /**
     * Returns the Patient ID that will be linked to the patient profile.
     * @return A long representing the patient ID.
     */
    public String setPatientID(){
        return getIdentifier();
    }
    
    /**
     * Returns the patient date of birth.
     * @return A patient date of birth.
     */
    public LocalDate getBirthdate(){
        return birthdate;
    }
    
    /**
     * Returns the patient phone number.
     * @return A patient phone number.
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    /**
     * Returns the patient home address.
     * @return A patient home address.
     */
    public String getAddress(){
        return address;
    }
    
    /**
     * Returns the patient email address.
     * @return A patient email address.
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Returns the patient complete medical record when the patient ID is provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return A patient complete medical record.
     */
    public static Patient getCompleteMedicalRecord(String patientID){
        for(Patient pp : patientProfiles) {
            if(pp.identifier.equals(patientID)){
                return pp;
            }
        }
        return null;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
