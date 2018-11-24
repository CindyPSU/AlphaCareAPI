
package MedicalRecordModel.Appt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class ApptCategories {
    private ObservableList<ApptCategory> apptCategory = FXCollections.observableArrayList();
    
    public ApptCategories(){
        ApptCategory GEN = new ApptCategory("GEN");
        GEN.addOption("Annual");
        GEN.addOption("Checkup");
        apptCategory.add(GEN);
        
        ApptCategory MED = new ApptCategory("MED");
        MED.addOption("Minor");
        MED.addOption("Major");
        MED.addOption("Severe");
        apptCategory.add(MED);
        
        ApptCategory SPEC = new ApptCategory("SPEC");
        SPEC.addOption("OB/GYN");
        SPEC.addOption("ORTHO");
        SPEC.addOption("ENT");
        SPEC.addOption("HEMA");
        SPEC.addOption("NEURO");
        apptCategory.add(SPEC);
        
        ApptCategory SURG = new ApptCategory("SURG");
        SURG.addOption("Pre-Op");
        SURG.addOption("Follow Up");
        SURG.addOption("Rehab");
        SURG.addOption("Post-Op Eval");
        apptCategory.add(SURG);  
    }
    
    public ApptCategory find(String name)
    {
        for(ApptCategory category: getApptCategory())
        {
            if(category.ID.equals(name))
            {
                return category;
            }
        }
        return null;
    }

    /**
     * @return the apptCategory
     */
    public ObservableList<ApptCategory> getApptCategory() {
        return apptCategory;
    }

    /**
     * @param apptCategory the apptCategory to set
     */
    public void setApptCategory(ObservableList<ApptCategory> apptCategory) {
        this.apptCategory = apptCategory;
    }  
}
