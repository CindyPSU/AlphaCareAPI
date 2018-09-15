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
public class UserLoginCredentials {

    private final String userName;
    private final String password;
    
    public UserLoginCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    /**
     * Returns the username for UserLoginCredentials
     * @return 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the password for UserLoginCredentials
     * @return 
     */
    public String getPassword() {
        return password;
    }
    
}
