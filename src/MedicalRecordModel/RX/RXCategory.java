/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel.RX;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class RXCategory {
    String ID;
    private ObservableList<RXOptions> rxOptions = FXCollections.observableArrayList();
    
    public RXCategory(String rxID){
        ID = rxID;
    }
    
    
    public void addOption(String optionName){
        RXOptions rxOption = new RXOptions();
        rxOption.setRxName(optionName);
        getRxOptions().add(rxOption);
    }
    
    public RXOptions findOption(String name)
    {
        for(RXOptions option: rxOptions)
        {
            if(option.getRxName().equals(name))
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
     * @return the rxOptions
     */
    public ObservableList<RXOptions> getRxOptions() {
        return rxOptions;
    }

    /**
     * @param rxOptions the rxOptions to set
     */
    public void setRxOptions(ObservableList<RXOptions> rxOptions) {
        this.rxOptions = rxOptions;
    }
}
