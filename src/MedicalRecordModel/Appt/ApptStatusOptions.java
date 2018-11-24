
package MedicalRecordModel.Appt;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class ApptStatusOptions {
    private ChoiceBox apptStatus = new ChoiceBox();
    
    public ApptStatusOptions(){
        apptStatus.setItems(FXCollections.observableArrayList("Scheduled", "Cancelled", "Completed"));
    }

    /**
     * @return the apptStatus
     */
    public ChoiceBox getApptStatus() {
        return apptStatus;
    }

    /**
     * @param apptStatus the apptStatus to set
     */
    public void setApptStatus(ChoiceBox apptStatus) {
        this.apptStatus = apptStatus;
    }
}

