/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.TestLab.*;
import MedicalRecordModel.TestLabResults;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Princess_ktwo
 */
public class TestLabResultsFXMLController implements Initializable {

    // The AppointmentHistory object associated with the current row
    private TestLabResults testLabResult;
    private TestCategories testCategories = new TestCategories();
    
    @FXML
    private DatePicker tL_date;
    @FXML
    private TextField tL_time;
    @FXML
    private TextField tL_physician;
    @FXML
    private TextField test_result;
    @FXML
    private ChoiceBox<TestCategory> test_id;
    @FXML
    private ChoiceBox<TestOptions> test_name;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupChoiceBoxes();
    }
    
    private void setupChoiceBoxes(){
        ChangeListener<TestCategory> changeListener = new ChangeListener<TestCategory>() {

            @Override
            public void changed(ObservableValue<? extends TestCategory> observable, TestCategory oldValue, TestCategory newValue) {
                test_name.setItems(newValue.getTestOptions());
            }
        };
        // Selected Item Changed.
        test_id.setItems(testCategories.getTestCategory());
        test_id.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }

    public void load(TestLabResults testLabResult)
    {
        // Save to the property
        this.testLabResult = testLabResult;
        
        // Sets text fields
        tL_date.setValue(testLabResult.getTestOrderDate());

        Time apptTime = testLabResult.getTestOrderTime();
        if(apptTime != null)
        {
          tL_time.setText(apptTime.toString());
        }

        if(testLabResult.getPhysicianName() != null)
        {
            tL_physician.setText(testLabResult.getPhysicianName());
        }

        if(testLabResult.getTestResult() != null)
        {
            test_result.setText(testLabResult.getTestResult()); 
        }
        
        // Set the choicebox options
        TestCategory category = this.testCategories.find(testLabResult.getTestID());
        if(category != null)
        {
            // Appt Code
            test_id.setValue(category);
            TestOptions option = category.findOption(testLabResult.getTestName());
            if(option != null)
            {
                // Appt Description
                test_name.setValue(option);
            }
        }
    }
    
    public void save()
    {
      if(this.testLabResult == null)
      {
          // Don't save anything
          return;
      }
      
      testLabResult.setTestOrderDate(tL_date.getValue());
      String timeText = tL_time.getText();
      if((timeText != null) && !timeText.isEmpty())
      {
        testLabResult.setTestOrderTime(Time.valueOf(timeText));
      }
      if(tL_physician.getText() != null)
      {
        testLabResult.setPhysicianName(tL_physician.getText());
      }
      if(test_result.getText() != null)
      {
        testLabResult.setTestResult(test_result.getText());
      }
      if(test_id.getValue() != null)
      {
        testLabResult.setTestID(test_id.getValue().toString());
      }
      if(test_name.getValue() != null)
      {
        testLabResult.setTestName(test_name.getValue().toString());
      }
      
    }
    
}
