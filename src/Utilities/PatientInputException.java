/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author chrismorris
 */
public class PatientInputException extends Exception {
    
    public static final String ERROR_CODE_INVALID_FIRST_NAME = "com.alphacare.PatientDetailControllerException.INVALID_FIRST_NAME";
    public static final String ERROR_CODE_INVALID_LAST_NAME = "com.alphacare.PatientDetailControllerException.INVALID_LAST_NAME";
    public static final String ERROR_CODE_INVALID_MIDDLE_INITIAL = "com.alphacare.PatientDetailControllerException.INVALID_MIDDLE_INITIAL";
    public static final String ERROR_CODE_INVALID_PREFERRED_NAME = "com.alphacare.PatientDetailControllerException.INVALID_PREFERRED_NAME";
    public static final String ERROR_CODE_INVALID_BIRTHDATE = "com.alphacare.PatientDetailControllerException.INVALID_BIRTHDATE";
    public static final String ERROR_CODE_INVALID_PHONE_NUMBER = "com.alphacare.PatientDetailControllerException.INVALID_PHONE_NUMBER";
    public static final String ERROR_CODE_INVALID_ADDRESS = "com.alphacare.PatientDetailControllerException.INVALID_ADDRESS";
    public static final String ERROR_CODE_INVALID_EMAIL_ADDRESS = "com.alphacare.PatientDetailControllerException.INVALID_EMAIL_ADDRESS";
    
    private final String errorCode;
    
    public PatientInputException(String errorCode) {
        super("Error validating form input.");
        this.errorCode = errorCode;
    }
    
    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        switch (getErrorCode()) {
            case ERROR_CODE_INVALID_FIRST_NAME:
                return "Invalid First Name";
            case ERROR_CODE_INVALID_LAST_NAME:
                return "Invalid Last Name";
            case ERROR_CODE_INVALID_MIDDLE_INITIAL:
                return "Invalid Middle Initial";
            case ERROR_CODE_INVALID_PREFERRED_NAME:
                return "Invalid Preferred Name";
            case ERROR_CODE_INVALID_BIRTHDATE:
                return "Invalid birthdate";
            case ERROR_CODE_INVALID_PHONE_NUMBER:
                return "Invalid phone number";
            case ERROR_CODE_INVALID_ADDRESS:
                return "Invalid address";
            case ERROR_CODE_INVALID_EMAIL_ADDRESS:
                return "Invalid email";
        }
        return super.toString();
    }
    
    
}
