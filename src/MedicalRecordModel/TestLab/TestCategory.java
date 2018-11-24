
package MedicalRecordModel.TestLab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class TestCategory {
    String ID;
    private ObservableList<TestOptions> testOptions = FXCollections.observableArrayList();
    
    public TestCategory(String testID){
        ID = testID;
    }
    
    
    public void addOption(String optionName){
        TestOptions testOption = new TestOptions();
        testOption.setTestName(optionName);
        getTestOptions().add(testOption);
    }
    
    public TestOptions findOption(String name)
    {
        for(TestOptions option: getTestOptions())
        {
            if(option.getTestName().equals(name))
            {
                return option;
            }
        }
        return null;
    }
        
    @Override
    public String toString(){
        return ID;
    }

    /**
     * @return the testOptions
     */
    public ObservableList<TestOptions> getTestOptions() {
        return testOptions;
    }

    /**
     * @param testOptions the testOptions to set
     */
    public void setTestOptions(ObservableList<TestOptions> testOptions) {
        this.testOptions = testOptions;
    }
}
