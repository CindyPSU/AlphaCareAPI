package TreatmentModel;

import java.util.ArrayList;
import java.util.Date;

/**
 * The Referral model represents all components needed for a doctor to make a referral to patient. 
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class Referral {
    
    private String referralID;
    private Date referralPeriodStart;
    private Date referralPeriodEnd;
    private Date referralMade;
    private Boolean priorApproval;
    private String service;
    private Boolean outOfNetwork;
    private Boolean eligibility;
 
    /**
     * @psrsm refID
     * @param refStart
     * @param refEnd
     * @param refMd
     * @param prApp whether prior approval is needed
     * @param serv
     * @param oon whether the referred doctor or specialist is out of the network
     * @param elig whether the patient is eligible for the referral
     */
    public Referral(String refID, Date refStart, Date refEnd, Date refMd, Boolean prApp, String serv, 
            Boolean oon, Boolean elig) {
        referralID = refID;
        referralPeriodStart = refStart;
        referralPeriodEnd = refEnd;
        referralMade = refMd;
        priorApproval = prApp;
        service = serv;
        outOfNetwork = oon;
        eligibility = elig;
    }

     /**
     * Returns the referral identification number
     * @return
     */
    public String getReferralID() {
        return referralID;
    }

    /**
     * Sets the referral identification number
     * @param referralID
     */
    public void setReferralPeriodStart(String referralID) {
        this.referralID = referralID;
    }
    
    /**
     * Returns the date when the referral is valid.
     * @return
     */
    public Date getReferralPeriodStart() {
        return referralPeriodStart;
    }

    /**
     * Sets the date when the referral is valid.
     * @param referralPeriodStart
     */
    public void setReferralPeriodStart(Date referralPeriodStart) {
        this.referralPeriodStart = referralPeriodStart;
    }

    /**
     * Returns the date when the validity of the referral ends.
     * @return
     */
    public Date getReferralPeriodEnd() {
        return referralPeriodEnd;
    }

    /**
     * Sets the date when the validity of the referral ends.
     * @param referralPeriodEnd
     */
    public void setReferralPeriodEnd(Date referralPeriodEnd) {
        this.referralPeriodEnd = referralPeriodEnd;
    }

    /**
     * Returns the date the referral was made by the doctor.
     * @return
     */
    public Date getReferralMade() {
        return referralMade;
    }

    /**
     * Sets the date when the referral was made by the doctor.
     * @param referralMade
     */
    public void setReferralMade(Date referralMade) {
        this.referralMade = referralMade;
    }

    /**
     * Returns true if prior approval is needed for the referral.
     * @return
     */
    public Boolean getPriorApproval() {
        return priorApproval;
    }

    /**
     * Sets true if prior approval is needed for the referral.
     * @param priorApproval
     */
    public void setPriorApproval(Boolean priorApproval) {
        this.priorApproval = priorApproval;
    }

    /**
     * Returns the type of service that the referral will provide.
     * @return
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the type of service that the referral will provide.
     * @param service
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * Returns true if the referral is out of the network.
     * @return
     */
    public Boolean getOutOfNetwork() {
        return outOfNetwork;
    }

    /**
     * Sets true if the referral is out of the network.
     * @param outOfNetwork
     */
    public void setOutOfNetwork(Boolean outOfNetwork) {
        this.outOfNetwork = outOfNetwork;
    }

    /**
     * Returns true if patient is eligible for referral.
     * @return
     */
    public Boolean getEligibility() {
        return eligibility;
    }

    /**
     * Sets true if patient is eligible for referral.
     * @param eligibility
     */
    public void setEligibility(Boolean eligibility) {
        this.eligibility = eligibility;
    }
    
    /**
     * Returns the referral details
     * @param refID
     * @return 
     */
    public static ArrayList<Referral> getReferralDetails(String refID){
        
        ArrayList<Referral> referralDetails;
        referralDetails = new ArrayList<>();
        System.out.println("Referral Details: \nID, start, end, doc, approval,"
                + "\nservice, out of network, eligibility");
        return referralDetails;
    }

}