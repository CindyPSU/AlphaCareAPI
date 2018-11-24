
package MedicalRecordModel.Appt;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class ApptOptions {
    private String apptName;

    /**
     * @return the apptName
     */
    public String getApptName() {
        return apptName;
    }

    /**
     * @param apptName the apptName to set
     */
    public void setApptName(String apptName) {
        this.apptName = apptName;
    }
    
    @Override
    public String toString(){
        return apptName;
    }
}
