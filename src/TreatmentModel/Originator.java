/**
 *
 * @author kmartin 
 */

package TreatmentModel;

public class Originator {
        
    private String note;
	
    //Setting the value of the new note
    public void set(String newNote) { 
        System.out.println("(Originator) New note: " + newNote);
	this.note = newNote; 
    }

    //Creating a new memento with a new note
    public Memento storeInMemento() { 
        System.out.println("(Originator) Saving to Memento");
        return new Memento(note); 
    }
	   
    //Getting the note currently stored in the memento
    public String restoreFromMemento(Memento memento) {
        note = memento.getSavedNote(); 
        System.out.println("(Originator) Previous note: " + note);
        return note;
    }
}
