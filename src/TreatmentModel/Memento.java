/**
 *
 * @author kmartin 
 */

package TreatmentModel;

public class Memento {
    // The note stored in the memento
    private String note;
    
    //Saving a new note to the memento
    public Memento(String noteSave) { 
        note = noteSave; 
    }

    //Returning the value stored in the note 
    public String getSavedNote() { 
        return note; 
    }
}
