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
                "1 tsp every 8 hours", "Penicillin-like Antibiotics", "Trimox", false, 
                "None", "Nausea", "Overview", "Warning");
        Drug alb = new Drug("23456", "Albuterol Sulfate", 180, "Mcg", "Red inhaler",
                "2 puffs every 4 to 6 hours as needed", "Beta-2 agonist", "ProAir", true,
                "None", "Racing heart", "Overview", "Warning");
        
        drugList.add(amox);
        drugList.add(alb);
    }
    
    public ArrayList<Drug> getList(){
        return drugList;
    }
    
    public void printDrugList(){
        
        System.out.println("The DrugList has these drugs:");
        
        for(int i = 0; i < drugList.size(); i++){
            Drug currentDrug = (Drug)drugList.get(i);
            
        System.out.println(currentDrug);
        }
    }
}
