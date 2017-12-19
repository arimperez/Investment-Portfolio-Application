/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investmentportfolio3;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.StringTokenizer;

/**
 * This class reads and writes user investments to given file
 * @author Ari Perez
 */
public class InvestmentReader {
    
    private String file; 
    
    /**
     * InvestmentReader Constructor
     * @param file
     */
    public InvestmentReader(String file)
    {
        this.file = file; 
        
    }
    
    /**
     * Parse investments from file
     * @return fromFile ArrayList of investments from file
     */
    public ArrayList<Investment> parseFile(){
        int i = 0;
        ArrayList<Investment> fromFile = new ArrayList<Investment>();
        //FileInputStream fileIn = null;
        Scanner inputStream = null;
        
        try 
        {
            inputStream = new Scanner (new FileInputStream(this.file));
        }
        
        catch (Exception e) {
            System.out.println("No File Found");
        }
        
        while (inputStream.hasNext()) {
            String []temp = inputStream.nextLine().split("~");
            String []values = temp[1].split(";");
            //System.out.println(Arrays.asList(temp));
            Investment inv = null;
            if (temp[0].equals("stock"))
            {
                try {
                    inv = new Stock(values[0], values[1], Integer.parseInt(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]));
                } catch (InvalidInputException exc) {
                    System.out.println("Error Reading Stock");
                    //Logger.getLogger(InvestmentReader.class.getName()).log(Level.SEVERE, null, ex);
                }
                fromFile.add(inv);
            }
            
            else if (temp[0].equals("mutualfund"))
            {
                try {
                    inv = new MutualFund(values[0], values[1], Integer.parseInt(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]));
                } catch (InvalidInputException exc) {
                    System.out.println("Error Reading Mutual Fund");
                    //Logger.getLogger(InvestmentReader.class.getName()).log(Level.SEVERE, null, exc);
                }
                fromFile.add(inv);
            }
            
        }
        inputStream.close(); 
        return fromFile; 
    }
    
    /**
     * Writes to file, returns true if writing was done, false if program fails to write to file
     * @param tw
     * @return Boolean 
     */
    public Boolean writeFile(ArrayList<Investment> tw){
        FileOutputStream fileOut = null; 
        PrintWriter printer = null;
        
        try {
            fileOut = new FileOutputStream(this.file);
            printer = new PrintWriter(fileOut);
        } 
        
        catch (Exception e)
        {
            return false; 
        }
        for (Investment temp: tw)
        {
            String toSave = "";
            if (temp instanceof Stock)
            {
                toSave += "stock~";
            }
            else {
                toSave+="mutualfund~";
            }
                //String symbol, String name, int quantity, double price, double bookVal)
                //Create String to save into the file
                toSave += temp.getSymbol() + ";" + temp.getName() + ";" + temp.getQuantity() + ";" + 
                        temp.getPrice() + ";" + temp.getBookVal();
                
                printer.println(toSave);
            
        }
        printer.close(); 
        return true;
     }
     
  
}
