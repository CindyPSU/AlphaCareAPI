/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import UserModel.Address;
import UserModel.Patient;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author chrismorris
 */
public class PatientInputValidator {
    
    private final String firstName;
    private final String lastName;
    private final String middleInitial;
    private final String preferredName;
    private final LocalDate birthday;
    private final String phoneNumber;
    private final String line1;
    private final String line2;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String email;

    public PatientInputValidator(String firstName, String lastName, String middleInitial, String preferredName, LocalDate birthday, String phoneNumber, String line1, String line2, String city, String state, String zipCode, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.preferredName = preferredName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
    }
    
    public Patient validated() throws PatientInputException {
        String identifierValue = "my_random_id";
        
        validateFirstName();
        validateLastName();
        validateMiddleInitial();
        validatePreferredName();
        LocalDate birthdayValue = validatedBirthday();
        validatePhoneNumber();
        validateAddress();
        validateEmail();
        
        Address address = new Address();
        address.setLine1(line1);
        address.setLine2(line2);
        address.setCity(city);
        address.setState(state);
        address.setZipCode(zipCode);
        
        return new Patient(
                identifierValue, 
                firstName, 
                lastName,
                middleInitial, 
                preferredName, 
                birthdayValue, 
                phoneNumber, 
                address.toString(), 
                email
        );
    }
    
    private void validateFirstName() throws PatientInputException {
        if (StringUtilities.isNullOrEmpty(firstName)) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_FIRST_NAME);
        }
    }
    
    private void validateLastName() throws PatientInputException {
        if (StringUtilities.isNullOrEmpty(lastName)) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_LAST_NAME);
        }
    }
    
    private void validatePreferredName() throws PatientInputException {
        if (StringUtilities.isNullOrEmpty(preferredName)) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_PREFERRED_NAME);
        }
    }
    
    private LocalDate validatedBirthday() throws PatientInputException {
        if (birthday == null) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_BIRTHDATE);
        }
        
        if (birthday.compareTo(LocalDate.now()) >= 0) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_BIRTHDATE);
        }
        
        return LocalDate.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    private void validateMiddleInitial() throws PatientInputException {
        if (StringUtilities.isNullOrEmpty(middleInitial) || middleInitial.length() > 2) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_MIDDLE_INITIAL);
        }
    }
    
    private void validatePhoneNumber() throws PatientInputException {
        if (StringUtilities.isNullOrEmpty(phoneNumber)) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_PHONE_NUMBER);
        }
        
        if (phoneNumber.length() != 10) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_PHONE_NUMBER);
        }
    }
    
    private void validateAddress() throws PatientInputException {
        if (StringUtilities.isNullOrEmpty(line1) || 
            StringUtilities.isNullOrEmpty(line2) ||
            StringUtilities.isNullOrEmpty(city) || 
            StringUtilities.isNullOrEmpty(state)) {
                throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_ADDRESS);
        }
        
        if (state.length() != 2) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_ADDRESS);
        }
        
        if (zipCode.length() != 5) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_ADDRESS);
        }
    }
    
    private void validateEmail() throws PatientInputException {
        if (StringUtilities.isNullOrEmpty(email)) {
            throw new PatientInputException(PatientInputException.ERROR_CODE_INVALID_EMAIL_ADDRESS);
        }
    }
}
