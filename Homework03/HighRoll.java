/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  MainProgLoopDemo.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  Jordyn Polk
 *  Date          :  2018-02-22
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{

   public static void main( String args[] ) {
       System.out.println( "  Welcome to the MainProgLoopDemo!!\n" );
       System.out.println( " Press the '1' to roll all the dice." );
       System.out.println( " Press the '2' to roll a single die." );
       System.out.println( " Press the '3' to calculate the score for the set." );
       System.out.println( " Press the '4' to save this score as the high schore." );
       System.out.println( " Press the '5' to display the high score." );
       System.out.println( " Press the 'q' to quit the program." );
      
       DiceSet a = new DiceSet(6,6);
       int hScore = 0;
     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      
    BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         try {
              inputLine = input.readLine();
              if ( '1' == inputLine.charAt(0)){
                  a.DiceSetroll();
                  System.out.println("Values of dice after roll: " + a.toString());
              }
              if ( '2' == inputLine.charAt(0)){
                  System.out.println("Roll of one die: " + a.rollIndividual(0));
              }
              if ( '3' == inputLine.charAt(0)){
                  System.out.println("Score of first set: " + a.sum());
              }
             if ( '4' == inputLine.charAt(0)){
                 System.out.println("Save this as high score.");
                  hs = a.sum();
              }
              if ( '5' == inputLine.charAt(0)){
                  System.out.println("High score: " + hs);
              }
              if( 'q' == inputLine.charAt(0) ) {
                  break;
              }
             
         }
             catch( IOException ioe ) {
                 System.out.println( "Caught IOException" );
         }
      }
   }
}
