/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investmentportfolio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ari
 */
public class InvestmentPortfolio3 {
    
    public static Keywords map = new Keywords();
    public static ArrayList<Investment> investList = new ArrayList<Investment>();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InvestmentReader reader = null;
        
        if (args.length != 0 && args[0] != null)
        {
            System.out.println("Finding file.....");
            File f = new File(args[0]);
            if (new File(args[0]).exists())
            {
                reader = new InvestmentReader(args[0]);
                investList = reader.parseFile(); 
                //map.loadKeywords(investList);
                /*if (keyWords == null)
                {
                    keyWords = new HashMap<String, ArrayList<Integer>>();
                }*/
                System.out.println("Loading file.....");
            }
            
            else {
                try {
                    
                    f.createNewFile();
                    reader = new InvestmentReader(args[0]);
                    System.out.println("Creating file....");
                } catch (IOException ex) {
                    Logger.getLogger(InvestmentPortfolio3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        else {
            System.out.println("No File Given! Try again with a file!");
            System.exit(0);
        }
        map.loadKeywords(investList);
        Gui g = new Gui(investList, map, reader); 
        g.setVisible(true);
       
        // TODO code application logic here
    }
    
}
