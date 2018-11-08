/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

import UserModel.Patient;
import java.util.List;

/**
 *
 * @author chrismorris
 */
public interface PatientStore {
    public List<Patient> loadPatients();
    public void updatePatient(Patient profile);
}
