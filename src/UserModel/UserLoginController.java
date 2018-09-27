/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import java.util.HashMap;
import java.util.Map;

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
        User user = stubbedUserForCredentials(credentials);
        if (user == null) {
            delegate.credentialsFailedToLogin();
            return;
        }
        delegate.credentialsDidLoginUser(user);
    }
    
    private User stubbedUserForCredentials(UserLoginCredentials credentials) {
        Map<UserLoginCredentials, User> map = new HashMap<>();
        map.put(new UserLoginCredentials("MedicalAdministrator", "IST412FTW"), 
                new MedicalAdministrator());
        map.put(new UserLoginCredentials("Nurse", "IST412FTW"), 
                new Nurse());
        map.put(new UserLoginCredentials("Patient", "IST412FTW"), 
                new Patient());
        map.put(new UserLoginCredentials("Physician", "IST412FTW"), 
                new Physician());
        map.put(new UserLoginCredentials("SystemAdministrator", "IST412FTW"), 
                new SystemAdministrator());
        
        for (Map.Entry<UserLoginCredentials, User> entry : map.entrySet()) {
            UserLoginCredentials key = entry.getKey();
            User user = entry.getValue();
            
            if (credentials.equals(key)) {
                return user;
            }
        }
        
        return null;
    }
}
