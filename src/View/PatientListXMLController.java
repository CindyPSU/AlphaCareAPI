/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import UserModel.Patient;
import MedicalRecordModel.*;
import java.net.URL;
import java.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.*;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author chrismorris
 */
public class PatientListXMLController implements Initializable {
    
    @FXML private TableView tableView;
    @FXML private TableColumn<Patient, String> tableViewColumn;
    
    private List<Patient> patients;
    private PatientStore patientLoader;
    private PatientListXMLControllerDelegate delegate;
    
    /**
     * @return the patients
     */
    public List<Patient> getPatients() {
        return patients;
    }
    
    /**
     * @return the patientLoader
     */
    public PatientStore getPatientLoader() {
        return patientLoader;
    }

    /**
     * @param patientLoader the patientLoader to set
     */
    public void setPatientLoader(PatientStore patientLoader) {
        this.patientLoader = patientLoader;
    }
    
    /**
     * @return the delegate
     */
    public PatientListXMLControllerDelegate getDelegate() {
        return delegate;
    }

    /**
     * @param delegate the delegate to set
     */
    public void setDelegate(PatientListXMLControllerDelegate delegate) {
        this.delegate = delegate;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableViewColumn.setCellValueFactory((p)-> { return new SimpleStringProperty(p.getValue().getFullName()); });
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    Patient profile = (Patient)tableView.getSelectionModel().getSelectedItem();
                    getDelegate().patientListXMLControllerDidSelectPatient(profile);
                }
            }
        });
    }
    
    public void load() {
        patients = getPatientLoader().loadPatients();
        tableView.getItems().setAll(getPatients());
    }
}
