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
public class StringUtilities {
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }
    
    public static boolean isNullOrEmptyOrNullString(String string) {
        return isNullOrEmpty(string) || string.equals("null");
    }
}
