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
public class MutualFund extends Investment{
    
    private final int fee = 45; 
    
    /*private String symbol; 
    private String name; 
    private int quantity; 
    private double price; 
    private double bookVal; */
    
    
    //Constructor Class 

    /**
     * MutualFund constructor
     * @param symbol symbol of mutual fund
     * @param name name of mutual fund
     * @param quantity number of mutual funds to buy 
     * @param price price of mutual fund
     */
    public MutualFund (String symbol, String name, int quantity, double price) throws InvalidInputException
    {

        super(symbol, name, quantity, price);
        //This is the value the book was bought for
        super.bookVal = quantity * price; 
    }
    
    public MutualFund(String symbol, String name, int quantity, double price, double bookVal) throws InvalidInputException
    {
        super(symbol, name, quantity, price, bookVal);
    }
    

    /**
     * @param quantity number of mutual funds
     * @param price price of one mutual fund
     */
    public void updateBookValue(int quantity, double price)
    {
        this.bookVal += quantity * price;
        
        
    }
    
    /**
     * Sell some or all stocks and return amount of money made from sale
     * @param toSell
     * @return
     */
    public double sellFund(int toSell)
    {
        double moneyMade;
        
        if (toSell > this.getQuantity())
        {
            return -1; 
        }
        
        else
        {
            int numAfter = this.getQuantity() - toSell; 
            moneyMade = toSell * this.getPrice()-99;
            
            //Update value
            this.bookVal = this.bookVal * (numAfter/this.getQuantity());
            
            //Update quantity
            this.changeQuantity(numAfter); 
        }
        
        return moneyMade; 
    }
    
    /**Calculate book value change
    *
    *@return DOUBLE (amount gained)    
    */
    public double getGain()
    {
        return ((this.getPrice() * this.getQuantity() - this.fee) - this.bookVal);
    }
   
    
    /**
     * update mutual fund price
     * @param newPrice
     */
    public void updatePrice(double newPrice)
    {
        this.changePrice(newPrice); //= newPrice; 
        
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
        final MutualFund other = (MutualFund) obj;
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
    
    //Might consider changing this?
    /*@Override
    public String toString()
    {
        
        return (super.toString() + " : $"+ this.fee);
        
        
    }*/
   
    
}
