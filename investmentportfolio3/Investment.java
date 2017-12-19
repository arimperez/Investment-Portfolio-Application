/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investmentportfolio3;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Ari Perez
 */
public abstract class Investment {
    
    private String symbol; 
    private String name; 
    private int quantity; 
    private double price; 

    /**
     * Book value of type protected so that child classes can access this variable
     */
    protected double bookVal; 
    
    /**
     *
     * @param symbol
     * @param name
     * @param quantity
     * @param price
     * @param bookVal
     * @throws investmentportfolio3.InvalidInputException
     */
    public Investment(String symbol, String name, int quantity, double price, double bookVal) throws InvalidInputException
    {
        if (symbol == null) {
            throw new InvalidInputException("Symbol is null");
            //this.symbol = "";    
        }
        else {
            this.symbol = symbol; 
        }
        
        if (name == null) {
            throw new InvalidInputException("Name is null");
            //this.name = ""; 
        }
        else {
            this.name = name; 
        }
        
        if (quantity < 0) {
            throw new InvalidInputException("Quantity is 0");
            //quantity = 0; 
        }
        else {
            this.quantity = quantity; 
        }
        if (price < 0)
        {
            throw new InvalidInputException("Price is negative value");
            //this.price = 0; 
        }
        else { 
            this.price = price; 
        }
        
        this.bookVal = bookVal; 
        
    }
    
    /**
     *
     * @param symbol
     * @param name
     * @param quantity
     * @param price
     */
    public Investment (String symbol, String name, int quantity, double price)
    {
        if (symbol == null) {
            this.symbol = "";    
        }
        else {
            this.symbol = symbol; 
        }
        
        if (name == null) {
            this.name = ""; 
        }
        else {
            this.name = name; 
        }
        
        if (quantity < 0) {
            quantity = 0; 
        }
        else {
            this.quantity = quantity; 
        }
        if (price < 0)
        {
            this.price = 0; 
        }
        else { 
            this.price = price; 
        }
        //This is the value the book was bought for
        //this.bookVal = this.quantity * this.price; 
    }
    
    //This will be overloaded to account for stock/mutualfund fees

    /**
     *
     * @return gain
     */
    public abstract double getGain();
    /*{
        return (this.price *this.quantity);
    }*/

    /**
     * Change price of investment
     * @param newPrice
     */
    public void changePrice(double newPrice)
    {
        this.price = newPrice; 
    }
    
    /**
     * Change quantity instance variable
     * @param newQuantity
     */
    public void changeQuantity(int newQuantity)
    {
        this.quantity = newQuantity;
        
    }
    
    /**
     * Add to quantity instance variable
     * @param toAdd
     */
    public void addQuantity(int toAdd)
    {
        this.quantity += toAdd;
        
    }
    
   /**
    *Returns stock symbol to user
    *@return STRING (stock symbol)
    */
    public String getSymbol()
    {
        return (this.symbol);    
    }
    
   /**
    *Returns stock name of object
    *@return STRING (stock name)
    */
    public String getName()
    {
        return (this.name);
    }
    

    /**
     * return quantity of investment
     * @return this.quantity number of mutual funds 
     */

    public int getQuantity()
    {
        return (this.quantity);
    }
    

    /**
     * gets mutual fund price
     * @return price of mutual fund
     */

    
    public double getPrice()
    {
        return (this.price);
    }
    

    /** 
     * Gets book value for user
     * @return
     */

    
    public double getBookVal()
    {
        return (this.bookVal);
    }
    
    /**
     *
     * @param newPrice
     */
    public void updatePrice(double newPrice)
    {
        this.price = newPrice; 
        
    }
    
    /**
     *
     * @param toCompare
     * @return
     */
    public boolean compareSymbol(String toCompare)
    {
        return toCompare.equals(this.symbol); 
    }
    
    /**
     *
     * @param words
     * @return
     */
    public boolean compareWords(String[] words)
    {
        
        String temp = this.name.toLowerCase(); 
        
        for (int i = 0; i < words.length; i++){
            System.out.println(temp + ":" + words[i].toLowerCase());
            if (!temp.contains(words[i].toLowerCase()))
            {
                return false;   
            }
        }
        
        return true;
    }
    
    /**
     *
     * @param lower
     * @param upper
     * @return
     */
    public boolean comparePrice(double lower, double upper) {
        //System.out.println(Double.toString(lower) + "  " + Double.toString(upper));
        if (lower <= this.price && this.price <= upper)
        {
            //System.out.println("YAY!");
            return true;
        }
        
        return false; 
        
    }
    
    @Override
    public String toString()
    {
        
       return("Symbol: " + this.symbol + "  |Name: " + this.name + " |Quantity: " + this.quantity + " |Price: $" + this.price + " |Book Value: $" + this.bookVal);
        
    }
    
        
    /**
     *
     * @param symbol
     * @param toUse
     * @return
     */
    public static ArrayList<Investment> search(String symbol, ArrayList<Investment> toUse)
    {
        
        //ArrayList<Investment> toCheck; 
        ArrayList<Investment> store = new ArrayList<Investment>(); 
        
        for (Investment toCheck : toUse) {
            //System.out.println("LOOP!");
            if (toCheck.compareSymbol(symbol))
            {
                //System.out.println("Adding.....");
                store.add(toCheck);
            
            }
            
        }
       
        
        return store; 
    }
    
    /**
     * search array lists for given investment
     * @param keywords
     * @param wordMap
     * @param toUse
     * @return
     */
    public static ArrayList<Investment> search(String[] keywords, Keywords wordMap, ArrayList<Investment> toUse)
    {
        ArrayList<Investment> store = new ArrayList<Investment>(); 
        ArrayList<Integer> indexes = wordMap.getIndexes(keywords);
        
        if (indexes != null)
        {
            for (Integer i: indexes)
            {
                store.add(toUse.get(i));
            }
        }
        /*for (Investment toCheck : toUse) {
            if (toCheck.compareWords(keywords))
            {
                store.add(toCheck);
            
            }
            
        }*/
        return store; 
    }
    
    /**
     * search array lists for given investment
     * @param low lowest bound to check
     * @param high highest bound to check
     * @param toUse arrayList of stocks
     * @return store (array list of values found)
     */
    public static ArrayList<Investment> search(double low, double high, ArrayList<Investment> toUse)
    {
        ArrayList<Investment> store = new ArrayList<Investment>();  
        
        for (Investment toCheck : toUse) {
            if (toCheck.comparePrice(low, high))
            {
                store.add(toCheck);
            
            }
            
        }
        return store; 
    }
    
    /**
     * search array lists for given investment
     * @param symbol symbol of stock
     * @param keywords keywords to compare to name
     * @param wordMap Keyword object storing Keyword hash map
     * @param toUse array list of stocks
     * @return
     */
    public static ArrayList<Investment> search(String symbol, String[] keywords, Keywords wordMap,ArrayList<Investment> toUse)
    {
        ArrayList<Investment> store = new ArrayList<Investment>(); 
        
        ArrayList<Integer> indexes = wordMap.getIndexes(keywords);
        //System.out.println("Test!");
        for (Integer i: indexes)
        {
            if (toUse.get(i).compareSymbol(symbol))
            {
                //System.out.println("TEST");
                store.add(toUse.get(i));
            }
        }
        
        /*for (Investment toCheck : toUse) {
            if (toCheck.compareSymbol(symbol) && toCheck.compareWords(keywords))
            {
                store.add(toCheck);
            
            }
            
        }*/
        return store; 
        
    }
    
    /**
     * search array lists for given investment
     * @param symbol symbol of stock
     * @param low lowest bound
     * @param high highest bound
     * @param toUse array list of stocks
     * @return store
     */
    public static ArrayList<Investment> search(String symbol, double low, double high, ArrayList<Investment> toUse)
    {
        ArrayList<Investment> store = new ArrayList<Investment>();  
        
        for (Investment toCheck : toUse) {
            if (toCheck.compareSymbol(symbol) && toCheck.comparePrice(low, high))
            {
                store.add(toCheck);
            
            }
            
        }
        return store; 
        
    }
    
    /**
     * search array lists for given investment
     * @param low lowest bound to compare
     * @param high highest bound to compare
     * @param keywords keywords to compare
     * @param wordMap Keyword object storing Keyword hash map
     * @param toUse array list of stocks
     * @return store (array list of founds elements 
     */
    public static ArrayList<Investment> search(double low, double high, String[] keywords, Keywords wordMap, ArrayList<Investment> toUse)
    {
        
        ArrayList<Investment> store = new ArrayList<Investment>();  
        
        ArrayList<Integer> indexes = wordMap.getIndexes(keywords);
        
        for (Integer i: indexes)
        {
            if (toUse.get(i).comparePrice(low, high))
            {
                store.add(toUse.get(i));
            }
        }
        return store; 
        
    }

    /**
     * search array lists for given investment
     * @param symbol symbol of stock 
     * @param low lowest bound to check
     * @param high highest bound to check
     * @param keywords keywords to check
     * @param wordMap Keyword object storing Keyword hash map
     * @param toUse array list of stocks
     * @return store (array list)
     */
    public static ArrayList<Investment> search(String symbol,double low, double high, String[] keywords, Keywords wordMap, ArrayList<Investment> toUse)
    {
        
        ArrayList<Investment> store = new ArrayList<Investment>(); 
        
        ArrayList<Integer> indexes = wordMap.getIndexes(keywords);
        
        for (Integer i: indexes)
        {
            
            Investment toCheck = toUse.get(i);
            if (toCheck.comparePrice(low, high) && toCheck.compareSymbol(symbol))
            {
                store.add(toUse.get(i));
            }
        }
        return store; 
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.symbol);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + this.quantity;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.bookVal) ^ (Double.doubleToLongBits(this.bookVal) >>> 32));
        return hash;
    }

    //Generated by netbeans
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Investment other = (Investment) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bookVal) != Double.doubleToLongBits(other.bookVal)) {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
   
}
