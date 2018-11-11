package TreatmentModel;

import java.util.ArrayList;

/**
 *
 * @author kmartin
 */
public class TreatmentController {
    
    DrugList dl = new DrugList();
    InteractionsView iView = new InteractionsView();
    
    public TreatmentController(){

        iView.setVisible(true);
        ArrayList drugs = dl.getList();   
        System.out.println("\nTesting list of available medications");                
    }
    
    public void printList(){
        dl.printDrugList();
    }

}
