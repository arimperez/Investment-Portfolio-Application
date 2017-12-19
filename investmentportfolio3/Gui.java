/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investmentportfolio3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;

/**
 *
 * @author ari
 */
public class Gui extends JFrame {//implements ActionListener{

    /**
     * Width of window
     */
    public static final int WIDTH = 500; 

    /**
     * Height of window
     */
    public static final int HEIGHT = 400; 
    
    private Keywords map; 
    private ArrayList<Investment> investList; 
    private InvestmentReader reader;
    
    private JPanel input;
    private JPanel buttons; 
    private JPanel output;
    private JPanel top;
    private JLabel welcome;
    
    private int upIndex;
    private int upSize;
    private JTextField upsymField;
    private JTextField upnameField; 
    
    private class CheckOnExit implements WindowListener 
    {
        public void windowOpened(WindowEvent we) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            //Save to file
            reader.writeFile(investList);
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
        
    }
    
    private class GainListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            try {     
                getContentPane().remove(welcome);
                getContentPane().remove(input);
                getContentPane().remove(output);
                getContentPane().remove(buttons);
                getContentPane().remove(top);
             
            }
            
            catch (Exception ex)
            {
            }
            top = new JPanel();
            top.setLayout(new GridLayout(0,2));//));, 10,16));

            input = new JPanel();
            input.setSize(5,24);

            buttons = new JPanel(); 
            top.add(input);
            top.add(buttons);
            output = new JPanel();
            
            add(top, BorderLayout.CENTER);
            add(output, BorderLayout.SOUTH);
            //About
            JLabel cmd = new JLabel("Get Investment Gain");
            input.add(cmd);
            input.add(new JLabel("<html><br></html>"));
                
            //Symbol Input
            JLabel symLabel = new JLabel("Total Gain: "); 
            JTextField symField = new JTextField(20);
            symField.setAlignmentX(Component.LEFT_ALIGNMENT);
            symField.setMaximumSize(symField.getPreferredSize());
            symField.setEditable(false);
            symLabel.setLabelFor(symField);
            input.add(symLabel);
            input.add(symField);
            
            //***OUTPUT TEXT***//
            JTextArea userMessage = new JTextArea(10, 20);
            
            double totalGain = 0; 
            for (Investment temp: investList)
            {
                userMessage.append(temp.getName() + ": $" + temp.getGain() + "\n");
                totalGain += temp.getGain();
                
            }
            
            symField.setText("$" + String.valueOf(totalGain));
            //top.add(input);

            input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
            input.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
            
            JScrollPane text = new JScrollPane(userMessage, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            userMessage.setEditable(false);
            output.add(text);
            
            revalidate();
            repaint();
            
        }
    }
    
    private class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            try {     
                getContentPane().remove(welcome);
                getContentPane().remove(input);
                getContentPane().remove(output);
                getContentPane().remove(buttons);
                getContentPane().remove(top);
             
            }
            
            catch (Exception ex)
            {
            }
            top = new JPanel();
            top.setLayout(new GridLayout(0,2));//));, 10,16));

            input = new JPanel();
            input.setSize(5,24);

            buttons = new JPanel(); 
            top.add(input);
            top.add(buttons);
            output = new JPanel();
            
            add(top, BorderLayout.CENTER);
            add(output, BorderLayout.SOUTH);
            //About
            JLabel cmd = new JLabel("Search Investments");
            input.add(cmd);
            input.add(new JLabel("<html><br></html>"));
                
            //Symbol Input
            JLabel symLabel = new JLabel("Symbol: "); 
            JTextField symField = new JTextField(20);
            symField.setAlignmentX(Component.LEFT_ALIGNMENT);
            symField.setMaximumSize(symField.getPreferredSize());
            symLabel.setLabelFor(symField);
            input.add(symLabel);
            input.add(symField);
            
            //Name input
            JLabel keynameLabel = new JLabel("Name Keywords "); 
            JTextField keynameField = new JTextField(20);
            keynameField.setAlignmentX(Component.LEFT_ALIGNMENT);
            keynameField.setMaximumSize(keynameField.getPreferredSize());
            keynameLabel.setLabelFor(keynameField);
            input.add(keynameLabel);
            input.add(keynameField);
            
            //Low Price input
            JLabel lowPriceLabel = new JLabel("Low Price: "); 
            JTextField lowPriceField = new JTextField(20);
            lowPriceField.setAlignmentX(Component.LEFT_ALIGNMENT);
            lowPriceField.setMaximumSize(lowPriceField.getPreferredSize());
            lowPriceLabel.setLabelFor(lowPriceField);
            input.add(lowPriceLabel);
            input.add(lowPriceField);
            
            //High Price input
            JLabel highPriceLabel = new JLabel("High Price: "); 
            JTextField highPriceField = new JTextField(20);
            highPriceField.setAlignmentX(Component.LEFT_ALIGNMENT);
            highPriceField.setMaximumSize(highPriceField.getPreferredSize());
            highPriceLabel.setLabelFor(highPriceField);
            input.add(highPriceLabel);
            input.add(highPriceField);
            
            //Buttons -----------------
            
            //***OUTPUT MESSAGE SET***//
            JTextArea userMessage = new JTextArea(10, 20);
            
            JButton reset = new JButton("Reset");
            reset.setAlignmentX(Component.CENTER_ALIGNMENT);
            reset.setAlignmentY(Component.CENTER_ALIGNMENT);
            reset.setMaximumSize(reset.getPreferredSize());
            reset.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b)
                {
                    resetElements();
                }
            });
            
            
            JButton search = new JButton("Search");
            search.setAlignmentX(Component.CENTER_ALIGNMENT);
            search.setVerticalAlignment(JLabel.CENTER);//setAlignmentY(Component.CENTER_ALIGNMENT);
            search.setMaximumSize(search.getPreferredSize());
            search.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b)
                {
                    Boolean toProcess = true;
                    Boolean set = false;
                    int count = 0; 
                    String sym = "";
                    String keyString = null;
                    String []keys = null;
                    double lower = -1;
                    double upper = 2147483647;
                    
                    try {
                        //getType = investType.getSelectedItem().toString();
                        //name = nameField.getText();
                        sym = symField.getText();
                        if (sym.length() != 0)
                        {
                            count+=1;
                        }
                    }
                    catch (Exception em) {
                        //resetElements();
                        //userMessage.append("Error! 1 Or More Field(s) Empty!\n");
                        //toProcess = false; 
                        
                    }
                    
                    try {
                        keyString = keynameField.getText();
                        if (keyString.length() != 0)
                        {
                            keys = keyString.split(" ");
                            for (int i = 0; i < keys.length; i++)
                            {
                                keys[i] = keys[i].toLowerCase();
                            }
                            //System.out.println(Arrays.toString(keys) + "\n");
                            //if (keys.length != 0)
                            //{
                            count+=4;
                            //}
                        }
                        
                    }
                    
                    catch (Exception em) {
                        
                    }
                    
                    try {
                        upper = Double.parseDouble(highPriceField.getText());
                        count +=2;
                        set = true;
                    }
                    
                    catch (Exception em) {
                        
                    }
                    
                    try {
                        lower = Double.parseDouble(lowPriceField.getText());
                        if (!set)
                        {
                            count+=2;
                        }
                        
                    }
                    
                    catch (Exception em)
                    {
                        
                    }
                    
                    if (investList.isEmpty())
                    {
                        toProcess = false; 
                        userMessage.append("No Investment Matches Found\n");
                    }
                    
                    if (toProcess)
                    {
                        resetElements();
                        //System.out.println(count + "\n");
                        ArrayList<Investment> searched = null;
                        switch(count)
                        {
                            case 1: 
                                searched = Investment.search(sym, investList);

                                break;

                            case 2: 
                                searched = Investment.search(lower, upper, investList);
                                //searchedFunds = MutualFund.search(lower, upper, mutualFundList);
                                break;

                            case 3:
                                searched = Investment.search(sym, lower, upper, investList);
                                //searchedFunds = MutualFund.search(sym, lower, upper, mutualFundList);
                                break;

                            case 4: 

                                searched = Investment.search(keys, map, investList);
                                //searchedFunds = MutualFund.search(sym, lower, upper, mutualFundList);
                                break;
                            //This is supposed to be 6, I was too lazy to switch 5 and 6 when I made a mistake
                            case 6:
                                searched = Investment.search(lower, upper, keys, map, investList); 
                                //searchedFunds = MutualFund.search(lower, upper, keys, mutualFundList);
                                break;

                            case 5:
                                //System.out.println("Gottem!");
                                searched = Investment.search(sym, keys, map, investList);
                                //searchedFunds = MutualFund.search(sym, keys, mutualFundList);
                                break;

                            case 7:
                                searched = Investment.search(sym, lower, upper, keys, map, investList);
                                //searchedFunds = MutualFund.search(sym, lower, upper, keys, mutualFundList);
                                break;

                            default: 
                                //If nothing is given, print all of them
                                searched = investList;
                                break;

                        }
                        
                        if (searched.isEmpty())
                        {
                            userMessage.append("No Investment Matches Found\n");
                        }
                        for (Investment temp : searched) {
                            userMessage.append(temp.toString() + "\n");
                        }
                    }
                    
                    
  
                }       
            });
            
            buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
            
            JLabel space = new JLabel("<html><br><br><br></html>");
            
            buttons.add(new JLabel("<html><br><br><br></html>"));
            
            buttons.add(reset);
            buttons.add(new JLabel("<html><br><br></html>"));
            buttons.add(search);
 
            
            
            //top.add(input);

            input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
            input.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
            
            JScrollPane text = new JScrollPane(userMessage, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            output.add(text);
            
            revalidate();
            repaint();
            
                
        }
            
    }
    
    private class UpdateListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            try {     
                getContentPane().remove(welcome);
                getContentPane().remove(input);
                getContentPane().remove(output);
                getContentPane().remove(buttons);
                getContentPane().remove(top);
             
            }
            
            catch (Exception ex)
            {
                
            }
            
            //int index = 0;
            upIndex = 0;
            String ifError = "";
            String symb = "";
            String name = "";
            if (investList.isEmpty())
            {
                ifError = "Error! You don't have investments!\n";
                
            }
            
            else {
                upSize = investList.size();
                symb = investList.get(upIndex).getSymbol();
                name = investList.get(upIndex).getName();
            }
       
            top = new JPanel();
            top.setLayout(new GridLayout(0,2));//));, 10,16));

            input = new JPanel();
            input.setSize(5,24);

            //input.add(welcome);


            buttons = new JPanel(); 
            top.add(input);
            top.add(buttons);
            output = new JPanel();

            add(top, BorderLayout.CENTER);
            add(output, BorderLayout.SOUTH);
            //About
            JLabel cmd = new JLabel("Updating Investment");
            input.add(cmd);
            input.add(new JLabel("<html><br></html>"));
            
           
            //Symbol Input
            JLabel symLabel = new JLabel("Symbol: "); 
            //JTextField 
            upsymField = new JTextField(20);
            upsymField.setAlignmentX(Component.LEFT_ALIGNMENT);
            upsymField.setMaximumSize(upsymField.getPreferredSize());
            upsymField.setEditable(false);
            upsymField.setText(symb);
            symLabel.setLabelFor(upsymField);
            input.add(symLabel);
            input.add(upsymField);
            
            //Name input
            JLabel nameLabel = new JLabel("Name: "); 
            //JTextField 
            upnameField = new JTextField(20);
            upnameField.setAlignmentX(Component.LEFT_ALIGNMENT);
            upnameField.setMaximumSize(upnameField.getPreferredSize());
            upnameField.setText(name);
            upnameField.setEditable(false);
            
            nameLabel.setLabelFor(upnameField);
            input.add(nameLabel);
            input.add(upnameField);
   
            //Price input
            JLabel priceLabel = new JLabel("Price: "); 
            JTextField priceField = new JTextField(20);
            priceField.setAlignmentX(Component.LEFT_ALIGNMENT);
            priceField.setMaximumSize(priceField.getPreferredSize());
            priceLabel.setLabelFor(priceField);
            input.add(priceLabel);
            input.add(priceField);
            
            //***OUTPUT TEXT ****//
            JTextArea userMessage = new JTextArea(ifError, 10, 20);
            
            //Buttons -----------------
            
            JButton prev = new JButton("Prev");
            prev.setAlignmentX(Component.CENTER_ALIGNMENT);
            prev.setAlignmentY(Component.CENTER_ALIGNMENT);
            prev.setMaximumSize(prev.getPreferredSize());
            prev.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b)
                {
                    if (upIndex - 1 > -1)
                    {
                        upIndex = upIndex - 1; 
                        upnameField.setText(investList.get(upIndex).getName());
                        upsymField.setText(investList.get(upIndex).getSymbol());
                        
                        revalidate();
                    }
                }
                
            });
            
            JButton next = new JButton("Next");
            next.setAlignmentX(Component.CENTER_ALIGNMENT);
            next.setVerticalAlignment(JLabel.CENTER);//setAlignmentY(Component.CENTER_ALIGNMENT);
            next.setMaximumSize(next.getPreferredSize());
            next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b)
                {
                    if (upIndex + 1 < upSize)
                    {
                        upIndex = upIndex + 1; 
                        upnameField.setText(investList.get(upIndex).getName());
                        upsymField.setText(investList.get(upIndex).getSymbol());
                        revalidate();
                    }
                }
                
            });
            
            JButton save = new JButton("Save");
            save.setAlignmentX(Component.CENTER_ALIGNMENT);
            save.setVerticalAlignment(JLabel.CENTER);//setAlignmentY(Component.CENTER_ALIGNMENT);
            save.setMaximumSize(save.getPreferredSize());
            save.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b)
                {
                    double price = 0; 
                    Boolean toProcess = true;
                    try {
                        price = Double.parseDouble(priceField.getText());
                    }
                    catch (Exception en) {
                        resetElements();
                        userMessage.append("Error! Price needs to be a double!\n");
                        toProcess = false; 
                        
                    }
                    if (toProcess)
                    {
                        investList.get(upIndex).changePrice(price);
                        userMessage.append(investList.get(upIndex).toString());
                    }
                }
                
            });
            
            
            buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
            
            JLabel space = new JLabel("<html><br><br><br></html>");
            
            buttons.add(new JLabel("<html><br><br><br></html>"));
            
            buttons.add(prev);
            buttons.add(new JLabel("<html><br><br></html>"));
            buttons.add(next);
            buttons.add(new JLabel("<html><br><br></html>"));
            buttons.add(save);
            
            
            //top.add(input);

            input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
            input.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            /*
            output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
            JTextArea userMessage = new JTextArea(10, 20);
            output.add(userMessage);
            */
            
            output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
            
            JScrollPane text = new JScrollPane(userMessage, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            output.add(text);
            
            revalidate();
            repaint();
            
        }
    }
    private class SellListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            //Remove Welcome Message
            
            try {     
                getContentPane().remove(welcome);
                getContentPane().remove(input);
                getContentPane().remove(output);
                getContentPane().remove(buttons);
                getContentPane().remove(top);
             
            }
            
            catch (Exception ex)
            {
                
            }
       
            top = new JPanel();
            top.setLayout(new GridLayout(0,2));//));, 10,16));

            input = new JPanel();
            input.setSize(5,24);

            //input.add(welcome);


            buttons = new JPanel(); 
            top.add(input);
            top.add(buttons);
            output = new JPanel();

            add(top, BorderLayout.CENTER);
            add(output, BorderLayout.SOUTH);
            //About
            JLabel cmd = new JLabel("Sell Investment");
            input.add(cmd);
            
           
            //Symbol Input
            JLabel symLabel = new JLabel("Symbol: "); 
            JTextField symField = new JTextField(20);
            symField.setAlignmentX(Component.LEFT_ALIGNMENT);
            symField.setMaximumSize(symField.getPreferredSize());
            symLabel.setLabelFor(symField);
            input.add(symLabel);
            input.add(symField);
            
            //Quantity input
            JLabel quantLabel = new JLabel("Quantity: "); 
            JTextField quantField = new JTextField(20);
            quantField.setAlignmentX(Component.LEFT_ALIGNMENT);
            quantField.setMaximumSize(quantField.getPreferredSize());
            quantLabel.setLabelFor(quantField);
            input.add(quantLabel);
            input.add(quantField);
            
            //Price input
            JLabel priceLabel = new JLabel("Price: "); 
            JTextField priceField = new JTextField(20);
            priceField.setAlignmentX(Component.LEFT_ALIGNMENT);
            priceField.setMaximumSize(priceField.getPreferredSize());
            priceLabel.setLabelFor(priceField);
            input.add(priceLabel);
            input.add(priceField);
            
            //Buttons -----------------
            
            JButton reset = new JButton("Reset");
            reset.setAlignmentX(Component.CENTER_ALIGNMENT);
            reset.setAlignmentY(Component.CENTER_ALIGNMENT);
            reset.setMaximumSize(reset.getPreferredSize());
            reset.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b)
                {
                    //Reset elements of input panel
                    resetElements();
                }
            });
            
            JButton sell = new JButton("Sell");
            
            //****OUTPUT TEXT****//
            JTextArea userMessage = new JTextArea(10, 20);
            
            sell.setAlignmentX(Component.CENTER_ALIGNMENT);
            sell.setVerticalAlignment(JLabel.CENTER);//setAlignmentY(Component.CENTER_ALIGNMENT);
            sell.setMaximumSize(reset.getPreferredSize());
            sell.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b)
                {
                    Investment n; 
                    //String getType = null; 
                    //String name = null;
                    Boolean toProcess = true;
                    String symbol = null;
                    
                    //Check if string fields are empty
                    try {
                        //getType = investType.getSelectedItem().toString();
                        //name = nameField.getText();
                        symbol = symField.getText();
                    }
                    catch (Exception em) {
                        resetElements();
                        userMessage.append("Error! 1 Or More Field(s) Empty!\n");
                        toProcess = false; 
                        
                    }
                    int quantity = 0;
                    double price = 0;
                    
                    //Check 
                    try {
                         quantity = Integer.parseInt(quantField.getText());
                    }
                    
                    catch (NumberFormatException en)
                    {
                        resetElements();
                        userMessage.append("Error! Quantity Needs to be a number!\n");
                        toProcess = false; 
                    }
                    
                    try {
                        price = Double.parseDouble(priceField.getText());
                    }
                    catch (Exception en) {
                        resetElements();
                        userMessage.append("Error! Price needs to be a double!\n");
                        toProcess = false; 
                        
                    }
                    int i = 0;
                    if (toProcess)
                    {
                        for (Investment tempStock : investList) {// stockList) {
                            if (tempStock.compareSymbol(symbol)) //&& name.equals(tempStock.getName()))
                            {
                                if (quantity > tempStock.getQuantity())
                                {
                                    userMessage.append("You don't have enough of selected investment\n");
                                    //System.out.println("You don't have enough of selected investment");
                                }
                                else {
                                    double made = 0; 
                                    if (tempStock instanceof Stock)
                                    {
                                        made = ((Stock)tempStock).sellStock(quantity);
                                    }

                                    else if (tempStock instanceof MutualFund)
                                    {
                                        made = ((MutualFund)tempStock).sellFund(quantity);
                                    }

                                    if (tempStock.getQuantity() == 0)
                                    {
                                        //System.out.println
                                        userMessage.append("You have sold all your investments of this type");
                                        //System.out.println
                                         userMessage.append("Deleting investment from list....");
                                        investList.remove(i);

                                        //Recreate hashmap because arrayList item has been removed
                                        map.resetMap();
                                        map.loadKeywords(investList);

                                    }

                                    //System.out.println
                                     userMessage.append("You made $" + Double.toString(made) + " by selling your investment");

                                }
                                //return;

                            }
                            i++;
                        }
                    }
                }

            });
            
            buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
            
            JLabel space = new JLabel("<html><br><br><br></html>");
            
            buttons.add(new JLabel("<html><br><br><br><br><br></html>"));
            
            buttons.add(reset);
            buttons.add(new JLabel("<html><br><br></html>"));
            buttons.add(sell);
            
            
            //top.add(input);

            input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
            input.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            /*output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
            JTextArea userMessage = new JTextArea(10, 20);
            output.add(userMessage);*/
            //JLabel msgLabel = new JLabel("Messages");
            //msgLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
            //msgLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            //msgLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            //msgLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
            
            JScrollPane text = new JScrollPane(userMessage, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            
            //msgLabel.setLabelFor(text);
            //output.add(msgLabel,BorderLayout.CENTER);
            output.add(text);
            
            revalidate();
            repaint();
            
        }
    }
    
    private class BuyListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String [] types = {"Stock", "Mutual Fund"};
            //top = new JPanel();
            //top.setLayout(new GridLayout(0,2));//));, 10,16)); 

            //add(top);
            //this.top = new JPanel();
            
            //Remove Welcome Message
            //getContentPane().remove(welcome);
            
            try {     
                getContentPane().remove(welcome);
                getContentPane().remove(input);
                getContentPane().remove(output);
                getContentPane().remove(buttons);
                getContentPane().remove(top);
             
            }
            
            catch (Exception ex)
            {
                
            }
            
            
            top = new JPanel();
            top.setLayout(new GridLayout(0,2));//));, 10,16));

            input = new JPanel();
            input.setSize(5,24);

            //input.add(welcome);


            buttons = new JPanel(); 
            top.add(input);
            top.add(buttons);
            output = new JPanel();

            add(top, BorderLayout.CENTER);
            add(output, BorderLayout.SOUTH);
            //About
            JLabel cmd = new JLabel("Buy Investment");
            input.add(cmd);
            
            //Type
            JLabel investLabel = new JLabel("Type: ");
            JComboBox investType = new JComboBox(types);
            investType.setAlignmentX(Component.LEFT_ALIGNMENT);
            investType.setMaximumSize(investType.getPreferredSize());
            investLabel.setLabelFor(investType);
            investType.setSelectedIndex(-1);
            input.add(investLabel);
            input.add(investType);
            
            //Name Input
            JLabel nameLabel = new JLabel("Name: "); 
            JTextField nameField = new JTextField(20);
            //nameField.setSize(new Dimension(20, 1));
            nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
            nameField.setMaximumSize(nameField.getPreferredSize() );
            nameLabel.setLabelFor(nameField);
            input.add(nameLabel);
            input.add(nameField);
          
            //Symbol Input
            JLabel symLabel = new JLabel("Symbol: "); 
            JTextField symField = new JTextField(20);
            symField.setAlignmentX(Component.LEFT_ALIGNMENT);
            symField.setMaximumSize(symField.getPreferredSize());
            symLabel.setLabelFor(symField);
            input.add(symLabel);
            input.add(symField);
            
            //Quantity input
            JLabel quantLabel = new JLabel("Quantity: "); 
            JTextField quantField = new JTextField(20);
            quantField.setAlignmentX(Component.LEFT_ALIGNMENT);
            quantField.setMaximumSize(quantField.getPreferredSize());
            quantLabel.setLabelFor(symField);
            input.add(quantLabel);
            input.add(quantField);
            
            //Price input
            JLabel priceLabel = new JLabel("Price: "); 
            JTextField priceField = new JTextField(20);
            priceField.setAlignmentX(Component.LEFT_ALIGNMENT);
            priceField.setMaximumSize(priceField.getPreferredSize());
            priceLabel.setLabelFor(priceField);
            input.add(priceLabel);
            input.add(priceField);
            
            
            top.add(input);

            input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
            input.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            /***Output Error Text***/
            JTextArea userMessage = new JTextArea(10, 20);
            JScrollPane text = new JScrollPane(userMessage, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            userMessage.setEditable(false);
            
            JButton reset = new JButton("Reset");
            reset.setAlignmentX(Component.CENTER_ALIGNMENT);
            reset.setAlignmentY(Component.CENTER_ALIGNMENT);
            reset.setMaximumSize(reset.getPreferredSize());
            reset.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b)
                {
                    //Reset elements of input panel
                    resetElements();
                }
            });
            
            JButton buy = new JButton("Buy");
            buy.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e)
                {
                    Boolean toProcess = true;
                    Investment n; 
                    String getType = null; 
                    String name = null;
                    String symbol = null;
                    
                    //Check if string fields are empty
                    try {
                        getType = investType.getSelectedItem().toString();
                        name = nameField.getText();
                        symbol = symField.getText();
                    }
                    catch (Exception em) {
                        resetElements();
                        userMessage.append("Error! 1 Or More Field(s) Empty!\n");
                        toProcess = false; 
                        
                    }
                    int quantity = 0;
                    double price = 0;
                    
                    //Check 
                    try {
                         quantity = Integer.parseInt(quantField.getText());
                    }
                    
                    catch (NumberFormatException en)
                    {
                        resetElements();
                        userMessage.append("Error! Quantity Needs to be a number!\n");
                        toProcess = false; 
                    }
                    
                    try {
                        price = Double.parseDouble(priceField.getText());
                    }
                    catch (Exception en) {
                        resetElements();
                        userMessage.append("Error! Price needs to be a double!\n");
                        toProcess = false; 
                        
                    }
                    /*
                    if (typeField.getText() == "Stock")
                    {
                        n = new Stock();
                        
                    }
                    */
                    
                    boolean found = false;
                    
                    //If all input does not give an error
                    if (toProcess == true)
                    {
                        for (Investment temp: investList)
                        {
                            //See if one part matches but not the other
                            if (temp.compareSymbol(symbol) != temp.getName().equals(name))
                            {
                                //System.out.println("Error. If you are trying to enter a stock you already have, you may have entered incorrect values");
                                userMessage.append("Error! If you are trying to enter a stock you already have, you may have entered incorrect values\n");
                                resetElements();
                                found = true; 
                            }
                            else if (temp.compareSymbol(symbol)) //&& temp.compareName(name))
                            {
                                temp.addQuantity(quantity);
                                if (temp instanceof Stock)
                                { 
                                    ((Stock)temp).updateBookValue(quantity, price);
                                    //found = true; 
                                }

                                else if(temp instanceof MutualFund) 
                                {
                                    ((MutualFund)temp).updateBookValue(quantity, price);
                                    //found = true; 
                                }

                                found = true;        
                            }   
                        }

                        if (!found) 
                        {
                            Investment t = null;
                            
                            if (getType.contains("S")) 
                            {
                                try 
                                {
                                    t = new Stock(symbol, name, quantity, price);
                                }
                                
                                catch(InvalidInputException ie){
                                    userMessage.append(ie.getMessage() + "\n");
                                    
                                }
                            }

                            else {
                                try {
                                    t = new MutualFund(symbol,name,quantity,price);
                                } catch (InvalidInputException ie) {
                                    userMessage.append(ie.getMessage() + "\n");
                                }
                            }

                            investList.add(t);
                            //Insert new stocks name into Keywords Map
                            map.insertKeywords(name, investList.size() -1);
                            System.out.println(Arrays.asList(investList));

                        }
                        
                        resetElements();
                    }
                }
            }
            
            );
            buy.setAlignmentX(Component.CENTER_ALIGNMENT);
            buy.setVerticalAlignment(JLabel.CENTER);//setAlignmentY(Component.CENTER_ALIGNMENT);
            buy.setMaximumSize(reset.getPreferredSize());
            
            buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
            
            JLabel space = new JLabel("<html><br><br><br></html>");
            
            buttons.add(new JLabel("<html><br><br><br><br><br></html>"));
            
            buttons.add(reset);
            buttons.add(new JLabel("<html><br><br></html>"));
            buttons.add(buy);
            
            //buttons.setBackground(Color.BLUE);
            top.add(buttons);


            
            /*output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
            //output.setSize(WIDTH,3);
            //JTextField userMessage = new JTextField(20);
            JTextArea userMessage = new JTextArea(10, 20);
            output.add(userMessage);*/
            
            output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
           
            output.add(text);
            
            //Refresh to work with changes
            revalidate();
            repaint();
            //add(top, BorderLayout.CENTER);
            //add(output, BorderLayout.SOUTH); 
        }
    }
    
    /**
     *
     * @param invest
     * @param map
     */
    public Gui(ArrayList<Investment> invest, Keywords map, InvestmentReader reader)
    {
        super("Investment Portfolio");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new CheckOnExit());
        //setLayout(new GridLayout(0,2, 5,6)); 
        if (invest == null)
        {
            this.investList = new ArrayList<>();
        }
        
        else {
            this.investList = invest; 
        }
        
        if (map == null)
        {
            this.map = new Keywords();
        }
        
        else 
        {
            this.map = map;
        }
        
        this.reader = reader; 
       

        JMenu menu = new JMenu("Commands");
        //Create Welcome Message
        
        welcome = new JLabel("<html>Welcome to Investment Portfolio! <br><br><br>"
                + "Choose a command in the commands menu.to buy or sell an investment, update prices for all investments,"
                + "get gain for the portfolio, search for relevant invgestments or quit the program</html>");
        
        add(welcome);
        
        /*Buy Menu Button*/
        JMenuItem buy = new JMenuItem("Buy");
        buy.addActionListener(new BuyListener());

        menu.add(buy);
        
        /*Sell Menu Button*/
        JMenuItem sell = new JMenuItem("Sell");
        sell.addActionListener(new SellListener());
        menu.add(sell);
        
        /*Search Menu Button*/
        JMenuItem search = new JMenuItem("Search");
        search.addActionListener(new SearchListener());/*ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Search Button Pressed");
            }
            
        });*/
        menu.add(search);
        
        /*Update Menu Button*/
        JMenuItem update = new JMenuItem("Update");
        update.addActionListener(new UpdateListener());
        menu.add(update);
        
        /*Get Gain Menu Button*/
        JMenuItem getGain = new JMenuItem("Get Gain");
        getGain.addActionListener(new GainListener());
        menu.add(getGain);
        
        /*QUIT MENU BUTTON*/
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev)
            {
                reader.writeFile(investList);
                System.exit(0);
            }
        });
        menu.add(quit);
        
        
        /*Add Bar to GUI*/
        JMenuBar bar = new JMenuBar(); 
        bar.add(menu);
        setJMenuBar(bar);
    }
    
    /**
     *
     */
    public void resetElements()
    {
        for(Component element : input.getComponents())
        {
            if(element instanceof JTextField)
            {
                JTextField ctrl = (JTextField) element;
                ctrl.setText("");
            }
            else if (element instanceof JComboBox)
            {
                JComboBox cbox = (JComboBox) element;
                cbox.setSelectedIndex(-1);
            }
        }
                for (Component element: output.getComponents())
        {
            
            

            if (element instanceof JScrollPane)
            {
                //System.out.println("Reset SCROLL!");
                JViewport viewport = ((JScrollPane)element).getViewport();
                Component[] components = viewport.getComponents();
                ((JTextArea)components[0]).setText("");
                //JTextField txt = (JTextField)element;
                //txt.setText("");
            }
            
            if (element instanceof JTextArea)
            {
                JTextArea txtArea = (JTextArea)element;
                txtArea.setText("");
            }
        }
        
    }
}
