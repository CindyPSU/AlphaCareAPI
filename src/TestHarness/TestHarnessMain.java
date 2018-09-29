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
public class TestHarnessMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestHarnessController controller = new TestHarnessController();
        
        controller.testUserLoginWithMultipleAttemptsCredentials();
        
        // Test One: Test for expected failure
        // Returns a null to convey failure
        if(controller.getCompletePatientMedicalRecord("123456789") == null){
            System.out.println("Test Successful: Patient Record Does Not Exist Yet.");
        }
        else {
            System.out.println("Test Failed: Patient Record Does Exist.");
        }
        
        // Test Two: Test for expected success.
        controller.createPatientProfile();
        if(controller.getCompletePatientMedicalRecord("123456789") != null){
            System.out.println("Test Successful: Patient Record Exists.");
        }
        else {
            System.out.println("Test Failed: Patient Record Does Not Exist.");
        }
        
        controller.testNurseLogsInToUpdateMedicalRecord();
    }
    
}
