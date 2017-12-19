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
public class Stock extends Investment{
    private static final double com = 9.99;
    private double comission = 9.99; 
    
    /*private String symbol; 
    private String name; 
    private int quantity; 
    private double price; 
    private double bookVal; */
    
    
    //Constructor Class 

    /**
     * Stock constructor
     * @param symbol symbol of stock
     * @param name name of stock
     * @param quantity number of stocks to buy 
     * @param price price of stocks
     * @throws investmentportfolio3.InvalidInputException
     */
    public Stock (String symbol, String name, int quantity, double price) throws InvalidInputException
    {
        super(symbol, name, quantity, price);
        //This is the value the book was bought for
        this.bookVal = this.getQuantity() * this.getPrice()+ this.com; 
        System.out.println(this.bookVal);
    }
    
    /**
     *
     * @param symbol
     * @param name
     * @param quantity
     * @param price
     * @param bookVal
     * @throws InvalidInputException
     */
    public Stock(String symbol, String name, int quantity, double price, double bookVal) throws InvalidInputException
    {
        super(symbol, name, quantity, price, bookVal);
    }

    
    /**
     * Update the total book value when buying stocks
     * @param quantity is the quantity of stocks to buy 
     * @param price of stocks
     */
    public void updateBookValue(int quantity, double price)
    {
        //Might be problematic?
        this.bookVal += quantity * price + this.com;
        this.comission += this.com;
        
        
    }

    
    /**
    *Sell some or all stocks and return amount of money made from sale
    *@param toSell (number of items to sell)
    *@return double moneyMade (how much money was made by sale)
    */
    
    public double sellStock(int toSell)
    {
        double moneyMade;
        
        if (toSell > this.getQuantity())
        {
            return -1; 
        }
        
        else
        {
            int numAfter = this.getQuantity() - toSell; 
            moneyMade = toSell * this.getPrice()- this.comission;
            
            //Update value
            this.bookVal = this.bookVal * (numAfter/this.getQuantity());
            
            //Update quantity
            this.changeQuantity(numAfter); 
        }
        
        return moneyMade; 
    }
    
    /**Calculate book value change
    *@return DOUBLE (amount gained)    
    */
    public double getGain()
    {
        return ((this.getPrice() * this.getQuantity() - this.comission) - this.bookVal);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stock other = (Stock) obj;
        if (this.getQuantity() != other.getQuantity()) {
            return false;
        }
        if (Double.doubleToLongBits(this.getPrice()) != Double.doubleToLongBits(other.getPrice())) {
            return false;
        }
        if (Double.doubleToLongBits(this.bookVal) != Double.doubleToLongBits(other.bookVal)) {
            return false;
        }
        if (!Objects.equals(this.getSymbol(), other.getSymbol())) {
            return false;
        }
        if (!Objects.equals(this.getName(), other.getName())) {
            return false;
        }
        return true;
    }
    
    /*@Override
    public String toString()
    {
        
        return (super.toString()); 
    }*/
    

    
}
