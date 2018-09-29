/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import MedicalRecordModel.*;

/**
 *
 * @author chrismorris
 */
public class HomeController {
    public HomeController() {
        
    }
    
    public void showWith(User user) {
        System.out.println("Showing HomeController on screen with user type: " + user.getClassName());
    }
    
    public PatientListController showPatientList() {
        PatientListController controller = new PatientListController();
        controller.show();
        return controller;
    }
}
