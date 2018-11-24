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
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chrismorris
 */
public class PatientListXMLController implements Initializable {
    
    @FXML private TableView tableView;
    @FXML private TableColumn<Patient, String> tableViewColumn;
    @FXML private TextField searchBar;
    
    private List<Patient> patients;
    private EntityStore<Patient> patientLoader;
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
    public EntityStore<Patient> getPatientLoader() {
        return patientLoader;
    }

    /**
     * @param patientLoader the patientLoader to set
     */
    public void setPatientLoader(EntityStore<Patient> patientLoader) {
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
                    Stage stage = (Stage)tableView.getScene().getWindow();
                    getDelegate().patientListXMLControllerDidSelectPatient(profile, stage);
                }
            }
        });
        
        searchBar.textProperty().addListener((obs, oldText, newText) -> {
            if (newText.length() < 2) {
                if (oldText.length() > 1) {
                    tableView.getItems().setAll(patients);
                }
                return;
            }
            List<Patient> filtered = patients.stream().filter(profile -> 
                    profile.getFullName().contains(newText)
            ).collect(Collectors.toList());
            tableView.getItems().setAll(filtered);
        });
    }
    
    public void load() {
        patients = getPatientLoader().load();
        tableView.getItems().setAll(getPatients());
    }
}
