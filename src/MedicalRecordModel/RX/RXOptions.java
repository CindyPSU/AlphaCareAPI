/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel.RX;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class RXOptions {
    private String rxName;

    /**
     * @return the rxName
     */
    public String getRxName() {
        return rxName;
    }

    /**
     * @param rxName the rxName to set
     */
    public void setRxName(String rxName) {
        this.rxName = rxName;
    }
    
    @Override
    public String toString(){
        return rxName;
    }
}
