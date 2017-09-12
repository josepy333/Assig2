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
      System.out.println(thePull.getString1());
      System.out.println(thePull.getString2());
      System.out.println(thePull.getString3());
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
      else multiplier = 1;
      System.out.println(multiplier);
      return multiplier;
      
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
      int bet = 0;
      int m;
      do
      {
         // Test
         bet = getBet();
         TripleString pullString = pull();
         //pullString = pull();
         System.out.println(pullString.toString());
         m = getPayMultiplier(pullString);
         System.out.println(m);
         
      }
      while (bet != 0);
      
      if (bet == 0) {
         System.out.println("Thanks for playing at the Casino!");
         System.out.println("Your individual winnings were:");
         String outputResult = TripleString.displayWinnings();
      }
      
   }

}

class TripleString
{
   public static final int MAX_LEN = 20;
   public static final int MAX_PULLS = 40;
   private static int[] pullWinnings = new int [MAX_PULLS];
   private static int numPulls;
      
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
      if ((str.length() > 0) && (str.length() < MAX_LEN)) 
      {
         return true;
      }
      else
      {
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
  
   // This method displays the total winnings of the user from the array
   public String displayWinnings() {
      String result = "";
      for (i = 0; i < pullWinnings.length; i++) {
         if (i > 0) {
            result = result + " ";
         }
         String item = pullWinnings[i];
         result = result + item;
      }
      return result; 
   }

}
