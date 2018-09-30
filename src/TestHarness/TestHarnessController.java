/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHarness;

import UserModel.*;
import MedicalRecordModel.*;
import TreatmentModel.*;
import Utilities.ErrorController;
import java.text.*;


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
            System.err.println(failedTestMessageForUnexpectedSuccessfulLogin);
            return;
        } catch (InvalidCredentialsException e) {
            showErrorWith(e);
        }
        
        // Valid username, Invalid password, Maching generic type
        credentials = new UserLoginCredentials("Nurse", "IST412FT");
        try {
            controller.login(credentials, Nurse.class);
            System.err.println(failedTestMessageForUnexpectedSuccessfulLogin);
            return;
        } catch (InvalidCredentialsException e) {
            showErrorWith(e);
        }
        
        // Invalid username, Valid password, Maching generic type
        credentials = new UserLoginCredentials("Nurs", "IST412FTW");
        try {
            controller.login(credentials, Nurse.class);
            System.err.println(failedTestMessageForUnexpectedSuccessfulLogin);
            return;
        } catch (InvalidCredentialsException e) {
            showErrorWith(e);
        }
        
        // Valid username, Valid password, Mismatching generic type
        credentials = new UserLoginCredentials("Patient", "IST412FTW");
        try {
            controller.login(credentials, Nurse.class);
            System.err.println(failedTestMessageForUnexpectedSuccessfulLogin);
            return;
        } catch (InvalidCredentialsException e) {
            showErrorWith(e);
        }
        
        // Valid username, Valid password, Matching generic type
        credentials = new UserLoginCredentials("Nurse", "IST412FTW");
        try {
            Nurse nurse = controller.login(credentials, Nurse.class);
            System.out.println("Successfully logged in with a Nurse's account.");
        } catch (InvalidCredentialsException e) {
            System.err.println("TEST FAILED. Threw exception when expecting to "
                    + "login successfully:\n" + e + "Code: " + e.getErrorCode());
            return;
        }
                
        System.out.println("TEST PASSED.");
        System.out.println();
    }
    
    void testNurseLogsInToUpdateMedicalRecord() {
        System.out.println();
        System.out.println("Beginning User Scenario where Nurse logs in and "
                + "updates a patient's existing record.");
        
        // login as Nurse
        // This internally uses UserLoginController to login. This is a 
        // convenience method so not every test has to add try-catch syntax
        // for logging in.
        Nurse nurse = loginNurse();
        
        // show home screen controller
        HomeController homeController = new HomeController();
        homeController.showWith(nurse);
        
        // Select patient list to show list controller
        PatientListController listController = homeController.showPatientList();
        
        // Select patient from list to show detail controller
        PatientDetailController detailController = listController.selectPatient();
        
        // update record in detail controller and close patient detail controller
        detailController.updateRecord();
        
        System.out.println("Ending User Scenario.");
        System.out.println();
    }
    
    // Helper methods
    
    private void showErrorWith(Exception exception) {
        ErrorController errorController = new ErrorController(
                exception.getLocalizedMessage(), 
                "Error"
        );
        errorController.show();
    }
    
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
    private Nurse loginNurse() {
        return new LoginHelper<Nurse>().loginWithCredentials(
                new UserLoginCredentials("Nurse", "IST412FTW"), 
                Nurse.class
        );
    }
    
    private Physician loginPhysician() {
        return new LoginHelper<Physician>().loginWithCredentials(
                new UserLoginCredentials("Physician", "IST412MD"), 
                Physician.class
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
    
    private MedicalAdministrator loginMedicalAdministratorUsing() {
        return new LoginHelper<MedicalAdministrator>().loginWithCredentials(
                new UserLoginCredentials("MedicalAdministrator", "IST412FTW"),
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
    
    // @author Cindy Hilgeman    
    /**
     * Returns a patient profile once created - just the patient last name for simple testing purposes.
     * @return A patient profile object.
     */
    public PatientProfile createPatientProfile(){
        
        try
        {
            SimpleDateFormat df = new SimpleDateFormat();
            PatientProfile patientOne = new PatientProfile("123456789", "Marty", "McFly", "CK", "Marty", df, "5556778", "9303 Roslyndale Ave, Pacoima, CA 91331", "bttf@gmail.com");
            System.out.println(patientOne.getPatientLastName());
            patientOne.appointments = AppointmentHistory.getAppointments(patientOne.getPatientID());
            patientOne.immunizations = ImmunizationHistory.getImmunizations(patientOne.getPatientID());
            patientOne.medicalData = MedicalHistory.getMedicalData(patientOne.getPatientID());
            patientOne.prescriptions = PrescriptionHistory.getPrescriptions(patientOne.getPatientID());
            patientOne.labResults = TestLabResults.getLabResults(patientOne.getPatientID());
            patientOne.vitalSignsData = VitalSigns.getVitalSignsData(patientOne.getPatientID());
            if(patientOne != null){
                System.out.println("PatientProfile object successfully created.");
            }
            PatientProfile.patientProfiles.add(patientOne);
            return patientOne;
            

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    
        return null;
    }
    
    /**
     * Returns a complete patient medical record. 
     * @param patientID
     * @return 
     */
    public PatientProfile getCompletePatientMedicalRecord (String patientID){
       return PatientProfile.getCompleteMedicalRecord(patientID);
    }
    
    /**
     * Login as Medical Administrator
     * This internally uses UserLoginController to login. 
     */
    void testMedicalAdminLogsInToCreateMedicalRecord() {
        System.out.println();
        System.out.println("Beginning User Scenario where Medical Admin logs in and "
                + "creates a patient medical record.");
        
        // login as Medical Admin
        MedicalAdministrator medAdmin = loginMedicalAdministratorUsing();
        
        // show home screen controller
        HomeController homeController = new HomeController();
        homeController.showWith(medAdmin);
        
        // Select patient list to show list controller
        //PatientListController listController = homeController.showPatientList();
        
        // Select patient from list to show detail controller
        //PatientDetailController detailController = listController.selectPatient();
        
        // update record in detail controller and close patient detail controller
        //detailController.updateRecord();
        
        System.out.println("Ends login scenario and moves to next test to check for existing patient record"
                + " before creating a new one.");
        System.out.println();
    }
    
    // Test One: Test for expected failure
    // Returns a null to convey failure
    public void testAccessMissingRecord(){
        if(getCompletePatientMedicalRecord("123456789") == null){
            System.out.println("Test Successful: Patient Record Does Not Exist Yet. New patient record can be created.");
        }
        else {
            System.out.println("Test Failed: Patient Record Does Exist.");
        }
    }
    
    // Test Two: Test for expected success.
    // Returns patient record components and message to confirm success.
    public void testAccessExistingRecord(){
        // Creates new patient record.
        createPatientProfile();
        if(getCompletePatientMedicalRecord("123456789") != null){
            System.out.println("Test Successful: Patient Record Created and Exists.");
        }
        else {
            System.out.println("Test Failed: Patient Record Does Not Exist.");
        }
        System.out.println("Ending User Scenario.");
    }
    
    void testPhysicianLogsInToPatientRecordAndAddsPrescription() {
        System.out.println();
        System.out.println("Beginning User Scenario where Physician logs in to "
                + "create a prescription for a patient.");
        
        // login as Physician
        Physician Physician = loginPhysician();
        
        // show home screen controller
        HomeController homeController = new HomeController();
        homeController.showWith(Physician);
        
        // Select patient list to show list controller
        PatientListController listController = homeController.showPatientList();
        
        // Select patient from list to show detail controller
        PatientDetailController detailController = listController.selectPatient();
        
        //todo create prescription
        
        // update record in detail controller and close patient detail controller
        //detailController.updateRecord();
        

        System.out.println();
    }  
}
