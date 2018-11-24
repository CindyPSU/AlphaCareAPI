
package MedicalRecordModel.TestLab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class TestCategories {
    private ObservableList<TestCategory> testCategory = FXCollections.observableArrayList();
    
    public TestCategories(){
        TestCategory HEMA = new TestCategory("HEMA");
        HEMA.addOption("ANEMIA");
        HEMA.addOption("THYROID");
        HEMA.addOption("HCG");
        HEMA.addOption("CBC");
        testCategory.add(HEMA);
        
        TestCategory RAD = new TestCategory("RAD");
        RAD.addOption("X-Ray");
        RAD.addOption("CATSCAN");
        RAD.addOption("MRI");
        testCategory.add(RAD);
        
        TestCategory CARDIAC = new TestCategory("CARDIAC");
        CARDIAC.addOption("ECG");
        CARDIAC.addOption("Stress Test");
        CARDIAC.addOption("TEE");
        CARDIAC.addOption("Tilt");
        CARDIAC.addOption("Angio");
        testCategory.add(CARDIAC);
    }
    
    public TestCategory find(String name)
    {
        for(TestCategory category: getTestCategory())
        {
            if(category.ID.equals(name))
            {
                return category;
            }
        }
        return null;
    }

    /**
     * @return the testCategory
     */
    public ObservableList<TestCategory> getTestCategory() {
        return testCategory;
    }

    /**
     * @param testCategory the testCategory to set
     */
    public void setTestCategory(ObservableList<TestCategory> testCategory) {
        this.testCategory = testCategory;
    }
}
