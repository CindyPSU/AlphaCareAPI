/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

/**
 * The delegate that communicates the results of login attempts made on an 
 * instance of UserLoginController.
 * @author chrismorris
 */
public interface UserLoginControllerDelegate {
    
    /**
     * The method called when the user transaction was successful
     * @param user User that resulted from the login transaction.
     */
    void credentialsDidLoginUser(User user);
    
    /**
     * Called when the login transaction fails to retrieve a user.
     */
    void credentialsFailedToLogin();
}
