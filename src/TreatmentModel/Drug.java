package TreatmentModel;

import java.util.ArrayList;

/**
 * The Drug model represents the available types that can be prescribed and whether or 
 * not they have interactions.
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class Drug {
    
    private String drugID;
    private String drugName;
    private int drugDosage;
    private String drugForm;
    private String drugIdentification;
    private String drugInstructions;
    private String drugClass;
    private String brand;
    private Boolean ifInteractions;
    private String interactions;
    private String sideEffects;
    private String overview;
    private String warnings;
    
    /**
     * @param drgID
     * @param drgNm
     * @param drgDsg
     * @param drgFrm
     * @param drgIdent
     * @param drgInstruct
     * @param drgCls
     * @param brnd
     * @param ifInteract whether the prescribed drug has any interactions
     * @param interact
     * @param sdEff
     * @param overVw
     * @param warn
     */
    public Drug (String drgID, String drgNm, int drgDsg, String drgFrm, String drgIdent, String drgInstruct,
        String drgCls, String brnd, Boolean ifInteract, String interact, String sdEff, 
        String overVw, String warn) {
        
        drugID = drgID;
        drugName = drgNm;
        drugDosage = drgDsg;
        drugForm = drgFrm; 
        drugIdentification = drgIdent;
        drugInstructions = drgInstruct;
        drugClass = drgCls;
        brand = brnd;
        ifInteractions = ifInteract;
        interactions = interact;
        sideEffects = sdEff;
        overview = overVw;
        warnings = warn;
    }

     /**
     * Returns the ID number of the drug.
     * @return
     */
    public String getDrugID() {
        return drugID;
    }

    /**
     * Sets the ID number of the drug.
     * @param drugID
     */
    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }
    
    /**
     * Returns the name of the drug.
     * @return
     */
    public String getDrugName() {
        return drugName;
    }

    /**
     * Sets the name of the drug.
     * @param drugName
     */
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    /**
     *
     * @return
     */
    public int getDrugDosage() {
        return drugDosage;
    }

    /**
     *
     * @param drugDosage
     */
    public void setDrugDosage(int drugDosage) {
        this.drugDosage = drugDosage;
    }

    /**
     *
     * @return
     */
    public String getDrugForm() {
        return drugForm;
    }

    /**
     *
     * @param drugForm
     */
    public void setDrugForm(String drugForm) {
        this.drugForm = drugForm;
    }

    /**
     *
     * @return
     */
    public String getDrugIdentification() {
        return drugIdentification;
    }

    /**
     *
     * @param drugIdentification
     */
    public void setDrugIdentification(String drugIdentification) {
        this.drugIdentification = drugIdentification;
    }

    /**
     *
     * @return
     */
    public String getDrugInstructions() {
        return drugInstructions;
    }

    /**
     *
     * @param drugInstructions
     */
    public void setDrugInstructions(String drugInstructions) {
        this.drugInstructions = drugInstructions;
    }

    /**
     *
     * @return
     */
    public String getDrugClass() {
        return drugClass;
    }

    /**
     *
     * @param drugClass
     */
    public void setDrugClass(String drugClass) {
        this.drugClass = drugClass;
    }

    /**
     *
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @return
     */
    public Boolean getIfInteractions() {
        return ifInteractions;
    }

    /**
     *
     * @param ifInteractions
     */
    public void setIfInteractions(Boolean ifInteractions) {
        this.ifInteractions = ifInteractions;
    }

    /**
     *
     * @return
     */
    public String getInteractions() {
        return interactions;
    }

    /**
     *
     * @param interactions
     */
    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    /**
     *
     * @return
     */
    public String getSideEffects() {
        return sideEffects;
    }

    /**
     *
     * @param sideEffects
     */
    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    /**
     *
     * @return
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     *
     * @return
     */
    public String getWarnings() {
        return warnings;
    }

    /**
     *
     * @param warnings
     */
    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    /**
     * Returns the details for the prescribed drug
     * @param drgID
     * @return 
     */
    public static ArrayList<Drug> getDrugDetails(String drgID){
        
        ArrayList<Drug> drugDetails;
        drugDetails = new ArrayList<>();
        System.out.println("Drug Details: \nID, name, dosage, identification, form, instructions, class, "
                + "\nbrand, interactions, side effects, overview, warnings");
        return drugDetails;
    }

}