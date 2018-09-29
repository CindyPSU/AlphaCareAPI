/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author chrismorris
 */
public class ErrorController {
    
    private String message;
    private String title;
    
    public ErrorController(String message, String title) {
        this.title = title;
        this.message = message;
    }
    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void show() {
        System.out.println("Show error message in controller with:\nTitle: \"" 
                + getTitle() + "\"\nMessage: \"" + getMessage() + "\"\n");
    }
}
