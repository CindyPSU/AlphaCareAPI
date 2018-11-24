
package MedicalRecordModel.Appt;

import UserModel.AppointmentStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class ApptStatuses {
    private ObservableList<AppointmentStatus> options = FXCollections.observableArrayList();
    
    public ApptStatuses(){
        options.addAll(AppointmentStatus.values());
    }
    
    /**
     * @return the apptCategory
     */
    public ObservableList<AppointmentStatus> getOptions() {
        return options;
    }
    
    public AppointmentStatus find(String name)
    {
        for(AppointmentStatus option: options)
        {
            if(option.getValue().equals(name))
            {
                return option;
            }
        }
        return null;
    }
}
