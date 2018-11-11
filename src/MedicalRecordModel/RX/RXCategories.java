
package MedicalRecordModel.RX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class RXCategories {
    private ObservableList<RXCategory> rxCategory = FXCollections.observableArrayList();
    
    public RXCategories(){
        RXCategory ANT1 = new RXCategory("ANT1");
        ANT1.addOption("Penicillin");
        ANT1.addOption("Sulfa");
        rxCategory.add(ANT1);
        
        RXCategory ANT2 = new RXCategory("ANT2");
        ANT2.addOption("Macrobid");
        ANT2.addOption("Cipro");
        rxCategory.add(ANT2);
        
        RXCategory ANT3 = new RXCategory("ANT3");
        ANT3.addOption("Levaquin");
        rxCategory.add(ANT3);
        
        RXCategory NAR1 = new RXCategory("NAR1");
        NAR1.addOption("Codeine");
        rxCategory.add(NAR1);
        
        RXCategory NAR2 = new RXCategory("NAR2");
        NAR2.addOption("Morphine");
        NAR2.addOption("Demerol");
        rxCategory.add(NAR2);
        
        RXCategory NAR3 = new RXCategory("NAR3");
        NAR3.addOption("Oxycontin");
        rxCategory.add(NAR3);
        
        
    }
    
    public RXCategory find(String name)
    {
        for(RXCategory category: rxCategory)
        {
            if(category.ID.equals(name))
            {
                return category;
            }
        }
        return null;
    }

    /**
     * @return the rxCategory
     */
    public ObservableList<RXCategory> getRxCategory() {
        return rxCategory;
    }

    /**
     * @param rxCategory the rxCategory to set
     */
    public void setRxCategory(ObservableList<RXCategory> rxCategory) {
        this.rxCategory = rxCategory;
    }
}
