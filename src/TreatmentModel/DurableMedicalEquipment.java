package TreatmentModel;

import java.util.ArrayList;

/**
 * The DurableMedicalEquipment model represents the available types that can be prescribed to patients.
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class DurableMedicalEquipment {
    
    private String equipID;
    private String equipName;
    private String equipForm;
    private int equipQuantity;
    private String equipIdentification;
    private String equipInstructions;
    private String brand;
    private String overview;
    private String warnings;
    
    /**
     * @param equpID
     * @param equipNm
     * @param equipFrm
     * @param equipQty
     * @param equipIdent
     * @param equipInstruct
     * @param brnd
     * @param overVw
     * @param warn
     */
    public DurableMedicalEquipment (String equpID, String equipNm, String equipFrm, int equipQty,
            String equipIdent, String equipInstruct,String brnd, String overVw, String warn) {
        
        equipID = equpID;
        equipName = equipNm;
        equipForm = equipFrm; 
        equipQuantity = equipQty;
        equipIdentification = equipIdent;
        equipInstructions = equipInstruct;
        brand = brnd;
        overview = overVw;
        warnings = warn;
    }

     /**
     * Returns the name of the equipment identification number.
     * @return
     */
    public String getEquipmentID() {
        return equipID;
    }

    /**
     * Sets the name of the equipment identification number
     * @param equipID
     */
    public void setEquipID(String equipID) {
        this.equipID = equipID;
    }
    
    /**
     * Returns the name of the equipment.
     * @return
     */
    public String getEquipmentName() {
        return equipName;
    }

    /**
     * Sets the name of the equipment
     * @param equipName
     */
    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    /**
     * Returns the form that the equipment comes in.
     * @return
     */
    public String getEquipForm() {
        return equipForm;
    }

    /**
     * Sets the form that the equipment comes in.
     * @param equipForm
     */
    public void setEquipForm(String equipForm) {
        this.equipForm = equipForm;
    }

    /**
     * Returns the quantity being prescribed to the patient.
     * @return
     */
    public int getEquipQty() {
        return equipQuantity;
    }

    /**
     * Sets the quantity being prescribed to the patient.
     * @param equipQty
     */
    public void setEquipQty(int equipQty) {
        this.equipQuantity = equipQty;
    }
    
    /**
     * Returns the identification of the equipment.
     * @return
     */
    public String getEquipIdentification() {
        return equipIdentification;
    }

    /**
     * Sets the identification of the equipment.
     * @param equipIdentification
     */
    public void setEquipIdentification(String equipIdentification) {
        this.equipIdentification = equipIdentification;
    }

    /**
     * Returns the equipment instructions for use.
     * @return
     */
    public String getEquipInstructions() {
        return equipInstructions;
    }

    /**
     * Sets the equipment instructions for use.
     * @param equipInstructions
     */
    public void setEquipInstructions(String equipInstructions) {
        this.equipInstructions = equipInstructions;
    }

    /**
     * Returns the brand of the equipment.
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand of the equipment.
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Returns the overview of the equipment.
     * @return
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Sets the overview of the equipment.
     * @param overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * Returns the equipment warnings.
     * @return
     */
    public String getWarnings() {
        return warnings;
    }

    /**
     * Sets the equipment warnings.
     * @param warnings
     */
    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    /**
     * Returns the details for the prescribed item of durable medical equipment
     * @param equpID
     * @return 
     */
    public static ArrayList<DurableMedicalEquipment> getDMEDetails(String equpID){
        
        ArrayList<DurableMedicalEquipment> dmeDetails;
        dmeDetails = new ArrayList<>();
        System.out.println("Durable Medical Equipment Details: \nID, name, form, identification, quantity,"
                + "\ninstructions, brand,overview, warnings");
        return dmeDetails;
    } 
}