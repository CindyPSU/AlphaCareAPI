/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

/**
 *
 * @author chrismorris
 */
public interface PatientDetailControllerDelegate {
    public void patientDetailControllerDidUpdateRecord(PatientDetailController controller, PatientProfile updatedProfile);
}
