/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investmentportfolio3;

/**
 * Exception for Invalid Investment Input
 * @author ari
 */
public class InvalidInputException extends Exception {

    /**
     * Empty Constructor
     */
    public InvalidInputException()
    {
    }
    
    /**
     * Constructor with message 
     * @param message
     */
    public InvalidInputException(String message)
    {
        super(message);
    }
    
    /**
     * Constructor with message and Throwable cause 
     * @param message
     * @param cause
     */
    public InvalidInputException(String message, Throwable cause)
    {
        super(message, cause);
        
    }
    
    
}
