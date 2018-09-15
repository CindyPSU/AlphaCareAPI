/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

/**
 * Manages login transactions for a set of credentials.
 * 
 * @author chrismorris
 */
public class UserLoginController {
    
    private final UserLoginControllerDelegate delegate;

    public UserLoginController(UserLoginControllerDelegate delegate) {
        this.delegate = delegate;
    }
    
    /**
     * The delegate responsible for communicating the result of the login transaction.
     * @return UserLoginControllerDelegate
     */
    public UserLoginControllerDelegate getDelegate() {
        return delegate;
    }
    
    /**
     * Returns a User based on the credentials input. Calls the instance of 
     * UserLoginControllerDelegate when finished attempting login.
     * @param credentials The credentials used to verify and return a User instance
     */
    public void login(UserLoginCredentials credentials) {
        // Call delegate.credentialsFailedToLogin(); when fails
        // Call delegate.credentialsDidLoginUser(user); when successful
    }
}
