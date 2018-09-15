/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import java.util.Date;

/**
 * A Patient is the entity that represents a person who is registered with an
 * office and visits with a doctors or multiple doctors.
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class Patient extends User {
    
    private String patientID;
    private String socialSecurityNumber;
    private Date dateOfBirth;
    private String phoneNumber;
    private Address address;
    private String emailAddress;

    /**
     * Returns the patient's unique identifier
     * @return 
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     * Returns the patient's social security number for Patient
     * @return 
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Sets the social security number for Patient
     * @param socialSecurityNumber 
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Returns the DOB for Patient
     * @return 
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the DOB for Patient
     * @param dateOfBirth 
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the phone number for Patient
     * @return 
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number for Patient
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the address for Patient
     * @return 
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address for Patient
     * @param address 
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Returns the email address for Patient
     * @return 
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address for Patient
     * @param emailAddress 
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
}
