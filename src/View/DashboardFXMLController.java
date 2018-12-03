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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
    private Map<String, Integer> risks;
    
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
    private BarChart epidemicChart;
    @FXML
    private NumberAxis epidemicChartYAxis;
    @FXML
    private CategoryAxis epidemicChartXAxis;
    
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
                Patient patient = ((AppointmentHistory)newValue).getPatient();
                showDetail(patient);
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
        atRiskTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                showDetail((Patient)newValue);
            }
        });
        
        epidemicChart.setLegendVisible(false);
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
            controller.setDashboardController(this);
            if(profile != null)
            {
                profile.refreshData();
                controller.setProfile(profile);
            }
            
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
        tableView.getItems().setAll(appointments);
        refreshAtRiskPatients();
    }
    
    public void refreshRisks() {
        risks = new HashMap();
        for (Patient atRiskPatient : atRiskPatients) {
            for (String risk : atRiskPatient.getRisks()) {
                Integer numberOfRisks = risks.get(risk) == null ? 1 : risks.get(risk) + 1;
                risks.put(risk, numberOfRisks);
            }
        }
        XYChart.Series riskSeries = new XYChart.Series();
        for (Map.Entry<String, Integer> entry : risks.entrySet()) {
            XYChart.Data<String, Integer> chartData = new XYChart.Data(entry.getKey(), entry.getValue());
            chartData.nodeProperty().addListener(new ChangeListener<Node>() {
                @Override
                public void changed(ObservableValue<? extends Node> observable, Node oldValue, Node newValue) {
                    if (newValue == null) {
                        return;
                    }
                    if (chartData.getYValue().intValue() > 2) {
                        newValue.setStyle("-fx-bar-fill: red;");
                    } else if (chartData.getYValue().intValue() > 1) {
                        newValue.setStyle("-fx-bar-fill: yellow;");
                    } else {
                        newValue.setStyle("-fx-bar-fill: green;");
                    }
                }
            });
            riskSeries.getData().add(chartData);
        }
        epidemicChart.getData().setAll(riskSeries);
    }
    
    public void refreshAtRiskPatients() {
        atRiskPatients = patientStore.load()
                .stream()
                .filter(patient -> !patient.getRisks().isEmpty()).collect(Collectors.toList());
        atRiskTableView.getItems().setAll(atRiskPatients);
        refreshRisks();
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
