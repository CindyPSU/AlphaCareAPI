/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

import UserModel.Patient;
import java.util.*;

/**
 *
 * @author chrismorris
 */
public class PatientListModel {
    
    private List<Patient> patients;
    
    /**
     * @return the patients
     */
    public List<Patient> getPatients() {
        return patients;
    }
    
    void loadPatients() {
        patients = new PatientStoreStub().load();
        
        System.out.println("Patient List Model loaded patients. Would typically "
                + "load from a persistence layer.");
    }
}
