/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

/**
 *
 * @author chrismorris
 */
public class InvalidCredentialsException extends Exception {
    
    public static final String ERROR_CODE_INVALID_USERNAME_OR_PASSWORD = "ERROR_CODE_INVALID_USERNAME_OR_PASSWORD";
    public static final String ERROR_CODE_INVALID_TYPE = "ERROR_CODE_INVALID_TYPE";
    
    private final String errorCode;
    
    public InvalidCredentialsException(String errorCode) {
        super("Username or password is invalid. Please try again.");
        this.errorCode = errorCode;
    }
    
    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }
}
