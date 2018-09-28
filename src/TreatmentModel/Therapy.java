package TreatmentModel;

import java.util.ArrayList;
import java.util.Date;

/**
 * The Therapy model represents all components needed for a doctor to prescribe therapy to patient. 
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class Therapy {
    
    private String therapyID;
    private String therapyService;
    private int thduration;
    private Date thPeriodStart;
    private Date thPeriodEnd;
    private Date thOrdered;
    private String thInstructions;
    private Boolean thReferral;
    private Boolean thOutOfNetwork;
    private Boolean thEligibility;
    private Boolean thRefillable;

    /**
     * @param thID
     * @param thServ
     * @param thDur
     * @param thStart
     * @param thEnd
     * @param thOrd
     * @param thInstr
     * @param thRef whether the therapy is a referral
     * @param thOon whether the therapy is out of network
     * @param thElig whether the patient is eligible for therapy
     * @param thRefill whether the therapy order can be refilled
     */
    public Therapy(String thID, String thServ, int thDur, Date thStart, Date thEnd, Date thOrd, 
        String thInstr, Boolean thRef, Boolean thOon, Boolean thElig, Boolean thRefill){
       
        therapyID = thID;
        therapyService = thServ;
        thduration = thDur;
        thPeriodStart = thStart;
        thPeriodEnd = thEnd;
        thOrdered = thOrd;
        thInstructions = thInstr;
        thReferral = thRef;
        thOutOfNetwork = thOon;
        thEligibility = thElig;
        thRefillable = thRefill;
    }

    /**
     * Returns the therapy identification number
     * @return the therapyID
     */
    public String getTherapyID() {
        return therapyID;
    }

    /**
     * Sets the therapy identification number
     * @param therapyID 
     */
    public void setTherapyID(String therapyID) {
        this.therapyID = therapyID;
    }
    
    /**
     * Returns the type of therapy being ordered, such as physical or psychotherapy.
     * @return the therapyService
     */
    public String getTherapyService() {
        return therapyService;
    }

    /**
     * Sets the type of therapy being ordered.
     * @param therapyService the therapyService to set
     */
    public void setTherapyService(String therapyService) {
        this.therapyService = therapyService;
    }

    /**
     * Returns the duration of the therapy being ordered.
     * @return the thDuration
     */
    public int getThduration() {
        return thduration;
    }

    /**
     * Sets the duration of the therapy being ordered.
     * @param thduration the thDuration to set
     */
    public void setThduration(int thduration) {
        this.thduration = thduration;
    }

    /**
     * Returns the start of the therapy availability
     * @return the thPeriodStart
     */
    public Date getThPeriodStart() {
        return thPeriodStart;
    }

    /**
     * Sets the start of the therapy availability
     * @param thPeriodStart the thPeriodStart to set
     */
    public void setThPeriodStart(Date thPeriodStart) {
        this.thPeriodStart = thPeriodStart;
    }

    /**
     * Returns the end of the therapy availability
     * @return the thPeriodEnd
     */
    public Date getThPeriodEnd() {
        return thPeriodEnd;
    }

    /**
     * Sets the end of the therapy availability
     * @param thPeriodEnd the thPeriodEnd to set
     */
    public void setThPeriodEnd(Date thPeriodEnd) {
        this.thPeriodEnd = thPeriodEnd;
    }

    /**
     * Returns the date the doctor ordered the therapy
     * @return the thOrdered
     */
    public Date getThOrdered() {
        return thOrdered;
    }

    /**
     * Sets the date the doctor ordered the therapy
     * @param thOrdered the thOrdered to set
     */
    public void setThOrdered(Date thOrdered) {
        this.thOrdered = thOrdered;
    }

    /**
     * Returns the therapy instructions
     * @return the thInstructions
     */
    public String getThInstructions() {
        return thInstructions;
    }

    /** 
     * Sets the therapy instructions
     * @param thInstructions the thInstructions to set
     */
    public void setThInstructions(String thInstructions) {
        this.thInstructions = thInstructions;
    }

    /**
     * Returns true if the therapy is a referral to another physician or practice
     * @return the thReferral
     */
    public Boolean getThReferral() {
        return thReferral;
    }

    /**
     * Sets true if the therapy is a referral
     * @param thReferral the thReferral to set
     */
    public void setThReferral(Boolean thReferral) {
        this.thReferral = thReferral;
    }

    /**
     * Returns true if the therapy order is out of network
     * @return the thOutOfNetwork
     */
    public Boolean getThOutOfNetwork() {
        return thOutOfNetwork;
    }

    /**
     * Sets true if the therapy order is out of network
     * @param thOutOfNetwork the thOutOfNetwork to set
     */
    public void setThOutOfNetwork(Boolean thOutOfNetwork) {
        this.thOutOfNetwork = thOutOfNetwork;
    }

    /**
     * Returns true if the patient is eligible for therapy
     * @return the thEligibility
     */
    public Boolean getThEligibility() {
        return thEligibility;
    }

    /**
     * Sets true if the patient is eligible for therapy
     * @param thEligibility the thEligibility to set
     */
    public void setThEligibility(Boolean thEligibility) {
        this.thEligibility = thEligibility;
    }

    /**
     * Returns true if the therapy order is refillable
     * @return the thRefillable
     */
    public Boolean getThRefillable() {
        return thRefillable;
    }

    /**
     * Sets true if the therapy order is refillable
     * @param thRefillable the thRefillable to set
     */
    public void setThRefillable(Boolean thRefillable) {
        this.thRefillable = thRefillable;
    }
    
    /**
     * Returns the details for the therapy being prescribed
     * @param thID
     * @return 
     */
    public static ArrayList<Therapy> getTherapyDetails(String thID){
        
        ArrayList<Therapy> therapyDetails;
        therapyDetails = new ArrayList<>();
        System.out.println("Therapy Details: \nID, service, duration, start, end, order,"
                + "\ninstructions, referral, out of network, eligibility, refills");
        return therapyDetails;
    } 
    
}
