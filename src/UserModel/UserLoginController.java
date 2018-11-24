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
 * @param <T> The expected User Subtype.
 */
public class UserLoginController<T extends User> {
   
    public UserLoginController() {
        
    }
    
    /**
     * Returns a User based on the credentials input. Calls the instance of 
     * UserLoginControllerDelegate when finished attempting login.
     * @param credentials The credentials used to verify and return a User instance
     * @param type The expected type. This is used to cast to the generic type. 
     * @return A User instance if the credentials are valid.
     * @throws UserModel.InvalidCredentialsException
     */
    public T login(UserLoginCredentials credentials, Class<T> type) throws InvalidCredentialsException {
        User user = stubbedUserForCredentials(credentials);
        if (user == null) {
            throw new InvalidCredentialsException(InvalidCredentialsException.ERROR_CODE_INVALID_USERNAME_OR_PASSWORD);
        }
        if (!type.isInstance(user)) {
            throw new InvalidCredentialsException(InvalidCredentialsException.ERROR_CODE_INVALID_TYPE);
        }
        return type.cast(user);
    }
    
    private User stubbedUserForCredentials(UserLoginCredentials credentials) {
        Map<UserLoginCredentials, User> map = new HashMap<>();
        map.put(new UserLoginCredentials("MedicalAdministrator", "IST412FTW"), 
                new MedicalAdministrator());
        map.put(new UserLoginCredentials("Nurse", "IST412FTW"), 
                new Nurse());
        map.put(new UserLoginCredentials("Patient", "IST412FTW"), 
                new Patient("initPatientID"));
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
