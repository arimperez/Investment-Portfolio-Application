Investment Portfolio Application
By, Ari Perez

The Problem:
We are trying to allow a user to keep track of their stocks and mutual funds
through an easy to use command line interface

****User Guide****
To Run, compile java code and execute***
A command line argument must be given - which is the name of the file to store investments

IF A .TXT FILE IS NOT GIVEN THE PROGRAM WILL EXIT

****How to use****
You have these options for commands: Buy, sell, update, search, get gain and quit

You can buy and sell stocks and mutual funds by entering the names, symbols quantities and prices for the investments you wish to perform an action on

There are multiple search params:
1. Symbol
2. Price range
3. Key words

You must use at least one of these to search
IF NO ARGUMENTS ARE GIVEN ALL INVESTMENTS WILL BE SHOWN

Update will allow you to change the prices of your investments when they change

When you close the program your data will be saved to the text file which the program was given

****TESTING AND TEST PLAN****

To test this program, enter a range of vales for stocks and mutual funds.
This means enter their symbols, names, prices and quantities.

Ensure that when testing to test with boundary cases to check if the program will crash

Also ensure to test if the program breaks if you enter the wrong type of value on input

As well, enter a large number of stocks and mutual funds to see if the program slows as more are added

For example, a test that should be performed is saying no to all questions when searching

As well, the graphical user interface should be tested for bugs by entering a large amount of data, and throughly testing each part of the GUI's functionality.

####TESTING SEARCH###########
These cases need to be performed: 
-User provides only a symbol
-User provides only a price range
-User provides only keywords

For keywords we should test what happens when: 
-Elements have one word, but not all of the words
-Elements have all the words
-There is no element with all the key words required
-All elements have the keywords 

#####TESTING BUY/SELL##########
Buying Cases: 
-Investment already exists
-Investment does not already exist
*Check to see if user is entering in negative numbers

Selling Cases: 
-If all selling cases are inputed
-If some are inputed
-If only one is inputed
-If no requirments are inputed

****Improvements****
With extra time, I would check boundary cases to ensure my program is air tight

As well, I would make the user interface more user friendly and easy to use. 

Error Messages would be better if they appeared in a popup, so I would add that if I had the time
