/**
 *
 * @author kmartin
 */

package TreatmentModel;

import java.util.ArrayList;

public class DrugList {
    
    private ArrayList<Drug> drugList = new ArrayList<Drug>();
    
        public DrugList(){
        
        Drug amox = new Drug("12345", "Amoxicillin", 500, "Milligrams", "Pink liquid", 
                "1 tsp every 8 hours", "Penicillin-like Antibiotics", "Trimox", true, 
                "Warfarin", "Nausea", "Overview", "Warning", "GlaxoSmithKline");
        Drug alb = new Drug("23456", "Albuterol Sulfate", 180, "Mcg", "Red inhaler",
                "2 puffs every 4 to 6 hours as needed", "Beta-2 agonist", "ProAir", false,
                "None", "Racing heart", "Overview", "Warning", "Teva Respiratory, LLC");
        Drug coum = new Drug("34567", "Coumadin", 10, "Grams", "White tablet",
                "Take at the same time every day", "Anticoagulant", "Warfarin", true,
                "Amoxicillan", "Blood thinner", "Overview", "Warning", "Bristol-Meyer-Squibb");
    }
    
    public ArrayList<Drug> getList(){
        return getDrugList();
    }
    
    
    
    public void printDrugList(){
        
        System.out.println("These drugs may be prescribed to this patient:");
        
        for(int i = 0; i < getDrugList().size(); i++){
            Drug currentDrug = (Drug)getDrugList().get(i);
            
        System.out.println(currentDrug);
        }
    }   

    /**
     * @return the drugList
     */
    public ArrayList<Drug> getDrugList() {
        return drugList;
    }

    /**
     * @param drugList the drugList to set
     */
    public void setDrugList(ArrayList<Drug> drugList) {
        this.drugList = drugList;
    }
}
