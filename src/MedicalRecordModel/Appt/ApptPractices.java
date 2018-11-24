
package MedicalRecordModel.Appt;

import MedicalRecordModel.PracticeStoreStub;
import UserModel.Practice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class ApptPractices {
    private ObservableList<Practice> apptPractices = FXCollections.observableArrayList();
    
    public ApptPractices(){
        
        PracticeStoreStub pss = new PracticeStoreStub();
        apptPractices.addAll(pss.load());
    }
    
    public Practice find(String name)
    {
        for(Practice practice: apptPractices)
        {
            if(practice.getName().equals(name))
            {
                return practice;
            }
        }
        return null;
    }

    /**
     * @return the apptPractices
     */
    public ObservableList<Practice> getOptions() {
        return apptPractices;
    }
}
