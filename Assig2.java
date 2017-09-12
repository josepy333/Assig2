/**
 * 
 * Joseph Cortez
 * Assig2 Class: Simulates a slot machine
 *
 */

import java.util.*;
import java.lang.Math;

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
      do
      {
      System.out.println("How much would you like to bet (1 - 100) or 0 to"
            + " quit?");
      bet = keyboard.nextInt();
      }
      while(bet < 1 || bet > 100);
      return bet;
   }
   
   // This method instantiates and returns a TripleString object to the client.
   public static TripleString pull()
   {
      
   }
   
   /* This method produces and returns a single random string based on the
    * required probabilities.
    */
   private static String randString()
   {
      
   }
   
   /*  Takes the pullString as a parameter, and inspects it to determine what 
    *  its pay multiplier should be
    */
   public static int getPayMultiplier(TripleString thePull)
   {
      
   }
   
   /* This method takes the winnings (a dollar amount) and thePull as parameters
    * and displays the three strings inside thePull along with "  sorry - you 
    * lost " or "congrats, you won $X".
    */
   public static void display(TripleString thePull, int winnings)
   {
      
   }

   // Main method
   public static void main(String[] args)
   {
      
   }

}

class TripleString
{
   public static final int MAX_LEN = 20;

   private String string1, string2, string3;

   // This method is the default constructor, which initalizes our private strings.
   public TripleString()
   {
      string1 = "";
      string2 = "";
      string3 = "";
   }
   
   // Determines legality of string
   public boolean validString(String str)
   {
      if (str != NULL && str.length() < MAX_LEN) {
         return true;
      }
      else {
         return false;
      }
   }
   
   // Modifiers for setting private string values
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
   public String getString3() {
      return string3;
   }
   // This method combines the private strings into a single string.
   public String toString()
   {
      String combinedString = string1 + " " + string2 + " " + string3;
      return combinedString;
   }
   // method to save winnings
   public boolean saveWinnings(int winnings) {
      if (numPulls + 1 < pullWinnings.length) {
         pullWinnings[numPulls++] = winnings;
         return true;
      } else {
         return false;
      }
   }

   // This method displays the winnings of the user
   public String displayWinnings() {
    
   }
}
