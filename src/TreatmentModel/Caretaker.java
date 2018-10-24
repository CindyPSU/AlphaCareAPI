/**
 *
 * @author kmartin 
 */

package TreatmentModel;

import java.util.ArrayList;

public class Caretaker {      
    //Contains all the saved mementos
    ArrayList<Memento> savedNotes = new ArrayList<>();

    //Adds memento to the ArrayList
    public void addMemento(Memento m) { 
        savedNotes.add(m); 
    }

    //Gets the memento requested from the ArrayList
    public Memento getMemento(int index) { 
        return savedNotes.get(index); 
    }
        
}
