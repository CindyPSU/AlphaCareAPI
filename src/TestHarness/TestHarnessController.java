/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHarness;

import UserModel.*;

/**
 *
 * @author chrismorris
 */
public class TestHarnessController {
    void testUserLoginWithMultipleAttemptsCredentials() {
        System.out.println("Beginning user scenario to login to their account "
                + "with an expected return type of Nurse.");
        
        final UserLoginController<Nurse> controller = new UserLoginController();
        final String failedTestMessageForUnexpectedSuccessfulLogin = "TEST FAILED. "
                + "Logged in successfully when expecting to receive an error.";
        
        // Invalid username, Invalid password, Maching generic type
        UserLoginCredentials credentials = new UserLoginCredentials("Nurs", "IST412FT");
        try {
            controller.login(credentials, Nurse.class);
            System.out.println(failedTestMessageForUnexpectedSuccessfulLogin);
            return;
        } catch (InvalidCredentialsException e) {
            System.out.println("Message: " + e + " Code: " + e.getErrorCode());
        }
        
        // Valid username, Invalid password, Maching generic type
        credentials = new UserLoginCredentials("Nurse", "IST412FT");
        try {
            controller.login(credentials, Nurse.class);
            System.out.println(failedTestMessageForUnexpectedSuccessfulLogin);
            return;
        } catch (InvalidCredentialsException e) {
            System.out.println("Message: " + e + " Code: " + e.getErrorCode());
        }
        
        // Invalid username, Valid password, Maching generic type
        credentials = new UserLoginCredentials("Nurs", "IST412FTW");
        try {
            controller.login(credentials, Nurse.class);
            System.out.println(failedTestMessageForUnexpectedSuccessfulLogin);
            return;
        } catch (InvalidCredentialsException e) {
            System.out.println("Message: " + e + " Code: " + e.getErrorCode());
        }
        
        // Valid username, Valid password, Mismatching generic type
        credentials = new UserLoginCredentials("Patient", "IST412FTW");
        try {
            controller.login(credentials, Nurse.class);
            System.out.println(failedTestMessageForUnexpectedSuccessfulLogin);
            return;
        } catch (InvalidCredentialsException e) {
            System.out.println("Message: " + e + " Code: " + e.getErrorCode());
        }
        
        // Valid username, Valid password, Matching generic type
        credentials = new UserLoginCredentials("Nurse", "IST412FTW");
        try {
            Nurse nurse = controller.login(credentials, Nurse.class);
            System.out.println("Successfully logged in with a Nurse's account.");
        } catch (InvalidCredentialsException e) {
            System.out.println("TEST FAILED. Threw exception when expecting to "
                    + "login successfully:\n" + e + "Code: " + e.getErrorCode());
            return;
        }
        
        System.out.println("TEST PASSED.");
        System.out.println();
    }
    
    // Melper methods to login with a desired type
    
    /**
     * 
     * Helper method for the test controller to login a Nurse easily without
     * the boiler plate. Only use this or other helper methods when you expect
     * the credentials to be valid and the User subtype (Nurse in this case) 
     * to match with those credentials.
     * 
     * Example: Nurse nurse = loginNurseUsing(credentials);
     * 
     * @param credentials The user credentials for a Nurse.
     * @return A Nurse instance or null
     */
    private Nurse loginNurseUsing(UserLoginCredentials credentials) {
        return new LoginHelper<Nurse>().loginWithCredentials(
                credentials, 
                Nurse.class
        );
    }
    
    private Patient loginPatientUsing(UserLoginCredentials credentials) {
        return new LoginHelper<Patient>().loginWithCredentials(
                credentials, 
                Patient.class
        );
    }
    
    private Physician loginPhysicianUsing(UserLoginCredentials credentials) {
        return new LoginHelper<Physician>().loginWithCredentials(
                credentials, 
                Physician.class
        );
    }
    
    private SystemAdministrator loginSystemAdministratorUsing(UserLoginCredentials credentials) {
        return new LoginHelper<SystemAdministrator>().loginWithCredentials(
                credentials, 
                SystemAdministrator.class
        );
    }
    
    private MedicalAdministrator loginMedicalAdministratorUsing(UserLoginCredentials credentials) {
        return new LoginHelper<MedicalAdministrator>().loginWithCredentials(
                credentials, 
                MedicalAdministrator.class
        );
    }
    
    private class LoginHelper<T extends User> {
        T loginWithCredentials(UserLoginCredentials credentials, Class<T> type) {
            final UserLoginController<T> controller = new UserLoginController();
            try {
                return controller.login(credentials, type);
            } catch (InvalidCredentialsException e) {
                return null;
            }
        }
    }
}
