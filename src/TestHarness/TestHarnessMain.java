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
        
        controller.testMedicalAdminLogsInToCreateMedicalRecord();
        
        controller.testAccessMissingRecord();
        
        controller.testAccessExistingRecord();
        
        controller.testNurseLogsInToUpdateMedicalRecord();
    }
    
}
