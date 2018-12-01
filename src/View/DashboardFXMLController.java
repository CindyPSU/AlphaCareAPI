/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.*;
import UserModel.Patient;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class DashboardFXMLController implements Initializable, PatientDetailFXMLControllerDelegate, PatientListXMLControllerDelegate {
    
    private List<AppointmentHistory> appointments;
    private List<Patient> atRiskPatients;
    private EntityStore<AppointmentHistory> store;
    private EntityStore<Patient> patientStore;
    
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<AppointmentHistory, String> tableViewColumnDate;
    @FXML
    private TableColumn<AppointmentHistory, String> tableViewColumnTime;
    @FXML
    private TableColumn<AppointmentHistory, String> tableViewColumnOffice;
    @FXML
    private TableColumn<AppointmentHistory, String> tableViewColumnStatus;
    
    @FXML
    private TableView atRiskTableView;
    @FXML
    private TableColumn<Patient, String> tableViewColumnFullName;
    @FXML
    private TableColumn<Patient, String> tableViewColumnRisk;
    
    /**
     * @return the appointments
     */
    public List<AppointmentHistory> getAppointments() {
        return appointments;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableViewColumnDate.setCellValueFactory((p)-> { return new SimpleStringProperty(p.getValue().getAppointmentDate().toString()); });
        tableViewColumnTime.setCellValueFactory((p)-> { return new SimpleStringProperty(p.getValue().getAppointmentTime().toString()); });
        tableViewColumnOffice.setCellValueFactory((p)-> { return new SimpleStringProperty(p.getValue().getPractice().getName()); });
        tableViewColumnStatus.setCellValueFactory((p)-> { return new SimpleStringProperty(p.getValue().getStatus().getValue()); });
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                // TODO: Open an appointment
            }
        });
        
        tableViewColumnFullName.setCellValueFactory((p) -> { return new SimpleStringProperty(p.getValue().getFullName()); });
        tableViewColumnRisk.setCellValueFactory((p) -> { 
            String risks = p
                    .getValue()
                    .getRisks()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            return new SimpleStringProperty(risks); 
        });
        
        load();
    } 
    
    public void displayPatientSearchView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientListXML.fxml"));
            Parent root = loader.load();
            PatientListXMLController controller = loader.<PatientListXMLController>getController();
            controller.setPatientLoader(new PatientStoreStub());
            controller.setDelegate(this);
            controller.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException error) {
            System.out.println(error);
        }
    }
    
    public void displayCreateNewPatientView() {
        showDetail(new Patient());
    }
    
    public void displayAppointmentCalendar(){
        
    }
    
    public void displayInternalMessageView(){
        
    }
    
    public void displayLoginView(){
        
    }
    
    private void showDetail(Patient profile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CompleteMedicalRecordFXML.fxml"));
            Parent root = loader.load();
            CompleteMedicalRecordFXMLController controller = loader.<CompleteMedicalRecordFXMLController>getController();
            if(profile != null)
            {
                profile.refreshData();
                controller.setProfile(profile);
            }
            controller.setDashboardController(this);
            
            Stage stage = new Stage();
            controller.setStage(stage);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException error) {
            System.out.println(error);
        }
    }
    
    // PatientDetailFXMLControllerDelegate

    @Override
    public void patientDetailFXMLControllerDidSavePatientProfile(PatientDetailFXMLController controller, Stage stage, Patient profile) {
        PatientStoreStub.savedPatients.add(profile);
        stage.close();
        displayPatientSearchView();
    }
    
    public void load() {
        store = new AppointmentStoreStub();
        // For real patients, just have to swap out PatientStoreStub for another
        // class or method that returns a List<Patient> object instance.
        patientStore = new PatientStoreStub();
        appointments = store.load();
        atRiskPatients = patientStore
                .load()
                .stream()
                .filter(patient -> !patient.getRisks().isEmpty()).collect(Collectors.toList());
        tableView.getItems().setAll(appointments);
        atRiskTableView.getItems().setAll(atRiskPatients);
    }

    public void refreshAppointments() {
        appointments = store.load();
        tableView.getItems().setAll(appointments);
    }

    @Override
    public void patientListXMLControllerDidSelectPatient(Patient profile, Stage stage) {
        stage.close();
        showDetail(profile);
    }
}
