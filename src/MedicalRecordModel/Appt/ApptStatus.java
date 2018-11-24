
package MedicalRecordModel.Appt;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class ApptStatus {
    private String apptStatus;

    /**
     * @return the apptStatus
     */
    public String getApptStatus() {
        return apptStatus;
    }

    /**
     * @param apptStatus the apptStatus to set
     */
    public void setApptStatus(String apptStatus) {
        this.apptStatus = apptStatus;
    }
    
    @Override
    public String toString(){
        return apptStatus;
    }
}
