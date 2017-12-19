/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investmentportfolio3;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Ari Perez
 */
public class Keywords {
    
    private HashMap<String, ArrayList<Integer>> map;
    
    /**
     * Keywords Constructor
     */
    public Keywords (){
        
        this.map = new HashMap<String, ArrayList<Integer>>();
        
    }
    
    /**
     * Returns hash map to user
     * @return this.map objects hash map holding investment keywords 
     */
    public HashMap<String, ArrayList<Integer>> getKeyWords(){
        return (this.map);
    }
    
    /**
     * Finds investments with matching keywords from user
     * @param words
     * @return temp arrayList of integers storing investment indexes
     */
    public ArrayList<Integer> getIndexes(String[] words) 
    {
        ArrayList<Integer> temp = new ArrayList<Integer>(); 
        temp = null;
        for (String toFind : words)
        {
            //System.out.println(toFind);
            //System.out.println("New Line?");
            if (this.map.containsKey(toFind.toLowerCase()))
            {
                if (temp == null)
                {
                    //System.out.println("Hello!");
                    temp = this.map.get(toFind);
                }
                else {
                //System.out.println("How many times?");
                    temp.retainAll(this.map.get(toFind));
                }
                //return(this.map.get(word));
            }
           
            
            else {
                return null; 
            }
        }
        //System.out.println(Arrays.asList(temp));
        return temp;
        
    }
    
    /**
     * Load keywords into instance hash map (this.map)
     * @param tw
     */
    public void loadKeywords(ArrayList<Investment> tw) //HashMap<String, ArrayList<Integer>>
    {
        if (tw != null)
        {
           
            //HashMap<String, ArrayList<Integer>> keywords= new HashMap<String, ArrayList<Integer>>();
            for (int i = 0; i < tw.size(); i++)
            {
                String[] t = tw.get(i).getName().split(" ");
                for (int j = 0; j< t.length; j++)
                {
                    if (!this.map.containsKey(t[j].toLowerCase()))
                    {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(i);
                        this.map.put(t[j].toLowerCase(), temp);
                    } else {
                        //Add index to HashMap
                        this.map.get(t[j].toLowerCase()).add(i);

                    }
                }
            }
        }
        //System.out.println(Arrays.asList(this.map));
        //return keywords; 
    }
     
    /**
     * Insert keywords into objects hash map
     * @param name
     * @param index
     */
    public void insertKeywords(String name, int index)  //HashMap<String, ArrayList<Integer>>
    {
        String[] kw = name.split(" ");
        //System.out.println(kw);
        for (int j = 0; j< kw.length; j++)
        {
            if (!this.map.containsKey(kw[j].toLowerCase()))
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(index);
                this.map.put(kw[j], temp);
            } else {
                //Add index to HashMap
                this.map.get(kw[j].toLowerCase()).add(index);
                     
                }
            }

        //return hm; 
         
    }
    
    /**
     * Delete contents of hash map
     */
    public void resetMap()
    {
        this.map = new HashMap<String, ArrayList<Integer>>();
    }
    
}
