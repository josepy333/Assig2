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
   /* This prompts the user for input and returns the bet amount as a functional
    * return.  It should validate the amount before it returns and insist on a 
    * legal bet (0 < bet < 100) until it gets one from the user.  It must return
    * the legal value to the client and not take any other action besides 
    * getting the legal amount.
    */
   public static int getBet()
   {
      
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
   
   // This method combines the private strings into a single string.
   public String toString()
   {
      String combinedString = string1 + " " + string2 + " " + string3;
      return combinedString;
   }
   
}
