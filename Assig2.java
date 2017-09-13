/**
 * 
 * Joseph Cortez
 * Lyndsay Hackett
 * Mokhlis Awad
 * Ahdia Fuller
 *
 * Assig2 Class: Simulates a slot machine
 *
 */

import java.util.*;
import java.lang.Math;

// Main class for Assignment 2
public class Assig2
{
   public static Scanner keyboard = new Scanner(System.in);
   
   /* This prompts the user for input and returns the bet amount as a functional
    * return.  It should validate the amount before it returns and insist on a 
    * legal bet (0 < bet < 100) until it gets one from the user.  It must return
    * the legal value to the client and not take any other action besides 
    * getting the legal amount.
    */
   public static int getBet()
   {
      int bet;
      // Place bet loop
      do
      {
      System.out.println("How much would you like to bet (1 - 100) or 0 to"
            + " quit?");
      bet = keyboard.nextInt();
      }
      while( bet < 0 || bet > 100);
      return bet;
   }
   
   // This method instantiates and returns a TripleString object to the client.
   public static TripleString pull()
   {
      TripleString pulled = new TripleString();
      String firstString = randString();
      String secondString = randString();
      String thirdString = randString();
      pulled.setString1(firstString);
      pulled.setString2(secondString);
      pulled.setString3(thirdString);
      return pulled;
      
   }
   
   /* This method produces and returns a single random string based on the
    * required probabilities.
    */
   private static String randString()
   {
      String pullString = "";
      int randomNumber = (int) (Math.random() * 1000);
      if (randomNumber > 1 && randomNumber <= 125)
      {
         pullString = "7";
      }
      else if (randomNumber > 125 && randomNumber <= 250)
      {
         pullString = "(space)";
      }
      else if (randomNumber > 250 && randomNumber <= 500)
      {
         pullString = "cherries";
      }
      else if (randomNumber > 500 && randomNumber <= 1000)
      {
         pullString = "BAR";
      }
      else
      {
         System.out.println("Fatal ERROR");
      }
      return pullString;
      
   }
   
   /*  Takes the pullString as a parameter, and inspects it to determine what 
    *  its pay multiplier should be
    */
   public static int getPayMultiplier(TripleString thePull)
   {
      int multiplier;
      String c = "cherries";
      String b = "BAR";
      if (thePull.getString1().equals(c) && !(thePull.getString2().equals(c)))
      {
         multiplier = 5;
      }
      else if (thePull.getString1().equals(c) && thePull.getString2().equals(c))
      {
         multiplier = 15;
      }
      else if (thePull.getString1().equals(c) && thePull.getString2().equals(c) 
            && thePull.getString3().equals(c))
      {
         multiplier = 30;
      }
      else if (thePull.getString1().equals(b) && 
            thePull.getString2().equals(b) && 
            thePull.getString3().equals(b))
      {
         multiplier = 50;
      }
      else if (thePull.getString1().equals("7") && 
            thePull.getString2().equals("7") && 
            thePull.getString3().equals("7"))
      {
         multiplier = 100;
      }
      else multiplier = 0;
      //System.out.println(multiplier);   test for multiplier
      return multiplier;
      
   }
   
   /* This method takes the winnings (a dollar amount) and thePull as parameters
    * and displays the three strings inside thePull along with "  sorry - you 
    * lost " or "congrats, you won $X".
    */
   public static void display(TripleString thePull, int winnings)
   {
      if(winnings > 0)
      {
         System.out.println("whirrrrrr .... and your pull is ...");
         System.out.println(thePull.toString());
         System.out.printf("Congratulations! You win $%,d\n", winnings);
         System.out.println();
      }
      else
      {
         System.out.println("whirrrrrr .... and your pull is ...");
         System.out.println(thePull.toString());
         System.out.println("Sorry, you lose!");
         System.out.println();
      }
   }

   // Main method
   public static void main(String[] args)
   {
      int bet = 0;
      int m;                        // Multiplier
      int pullWinnings;
      TripleString pullString;
      String outputResult = "";
      // Main loop
      do
      {
         bet = getBet();
         pullString = pull();
         m = getPayMultiplier(pullString);
         pullWinnings = m * bet;
         if (bet != 0)
         {
            display(pullString, pullWinnings);
            pullString.saveWinnings(pullWinnings);
         }   
      }
      while (bet != 0);
      
      //End of game
      if (bet == 0) 
      {
         System.out.println("Thanks for playing at the Casino!");
         outputResult = pullString.displayWinnings();
         System.out.println("Your individual winnings were:");
         System.out.println(outputResult);
         StringTokenizer winningsToken = new StringTokenizer(outputResult);
         int totalWinnings = 0;
         
         // Convert Winning Strings to ints
         while(winningsToken.hasMoreTokens()) 
         {
            totalWinnings = totalWinnings + 
                  Integer.parseInt(winningsToken.nextToken());
         }
         System.out.printf("Your total winnings were: $%,d\n", totalWinnings);
      }
   System.exit(0);  
   }

}

class TripleString
{
   public static final int MAX_LEN = 20;
   public static final int MAX_PULLS = 40;
   private static int[] pullWinnings = new int [MAX_PULLS];
   
   private static int numPulls = 0;
      
   private String string1, string2, string3;
   
   // This method is the default constructor, initalizes our private strings.
   public TripleString()
   {
      string1 = "";
      string2 = "";
      string3 = "";
      
   }
   
   // Determines legality of string
   public boolean validString(String str)
   {
      if ((str.length() > 0) && (str.length() < MAX_LEN)) 
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   // Modifier for setting private string values
   public boolean setString1(String str)
   {
      if (validString(str) == true)
      {
         string1 = str;
         return true;
      }      
      else
      {
         return false;
      }
   }
   
   // method to get string 1
   public String getString1() {
      return string1;
   }
   
   // Modifier for setting private string values
   public boolean setString2(String str)
   {
      if (validString(str) == true)
      {
         string2 = str;
         return true;
      }      
      else
      {
         return false;
      }
   }
   
   // method to get string 2
   public String getString2() {
      return string2;
   }
   
   // Modifier for setting private string values
   public boolean setString3(String str)
   {
      if (validString(str) == true)
      {
         string3 = str;
         return true;
      }  
      else
      {
         return false;
      }
   }
   
   // method to get string 3
   public String getString3() 
   {
      return string3;
   }
   
   // This method combines the private strings into a single string.
   public String toString()
   {
      String combinedString = string1 + " " + string2 + " " + string3;
      return combinedString;
   }
   
   // method to save winnings
   public boolean saveWinnings(int winnings) 
   { 
      if (numPulls < pullWinnings.length)
      {
         pullWinnings[numPulls] = winnings;
         numPulls++;
         return true;
      } 
      else 
      {
         System.out.println("You've exceeded the maximum number of pulls!");
         return false;
      }
   }
  
   // This method displays the total winnings of the user from the array
   public String displayWinnings() 
   {
      String result = "";
      for (int i = 0; i < numPulls; i++)
      {
         if (pullWinnings[i] != -1)
         {
            result = result + " ";
            String item = "";
            item = Integer.toString(pullWinnings[i]);
            result = result + item;
         }
         
      }
      return result; 
   }

}
