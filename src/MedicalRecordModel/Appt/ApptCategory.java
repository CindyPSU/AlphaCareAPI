/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel.Appt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class ApptCategory {
    String ID;
    private ObservableList<ApptOptions> apptOptions = FXCollections.observableArrayList();
    
    public ApptCategory(String apptID){
        ID = apptID;
    }
    
    
    public void addOption(String optionName){
        ApptOptions apptOption = new ApptOptions();
        apptOption.setApptName(optionName);
        getApptOptions().add(apptOption);
    }
    
    public ApptOptions findOption(String name)
    {
        for(ApptOptions option: apptOptions)
        {
            if(option.getApptName().equals(name))
            {
                return option;
            }
        }
        return null;
    }
        
    @Override
    public String toString(){
        return ID;
    }

    /**
     * @return the apptOptions
     */
    public ObservableList<ApptOptions> getApptOptions() {
        return apptOptions;
    }

    /**
     * @param apptOptions the apptOptions to set
     */
    public void setApptOptions(ObservableList<ApptOptions> apptOptions) {
        this.apptOptions = apptOptions;
    }  
}
