
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangemMaker.java
 * Purpose    :  Program to determine the optimal amount of coin denominations necessary to for a given amount
 * @author    :  Professor Johnson
 * @author    :  Jordyn Polk
 * Date       :  2018-05-03
 * Description:  This program is an algorithm that generates the optimal amount of coins needed to make a
 *               a given value.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:   Reason for change or modification
 *  -----  ----------  ------------   ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson   Initial release; stolen blatently from Professor Don Murphy with his
 *                                    express permission and blessing; just added this comment block
 *  1.1.0  2018-05-03  Jordyn Polk    Wrote algorithm makeChangeWithDynamicProgramming, completed JavaDocs,
                                      tested the program with given test harness.
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import java.util.Arrays;
 
 /**
  *   Program to determine the optimal number of change with an input of a number of coins.
  */

 public class DynamicChangeMaker {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }

            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println("\n" + amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("--> "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount) + "\n");
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }

    /**
    *   A method to find the optimal solution of coinns to make a target amount.
    *   @param    denominations   array   containing each argument starting with args[0]
    *   @param    amount          int     the amount of cents
    *   @return                   array
    */

    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {

    // Check to see if the target amount is negative
   
    if(amount<0) {
      System.out.println("The amount you want is negative");
      return Tuple.IMPOSSIBLE;
    }
    
    // Check to see if the denominations contain a 0 or a negative number
    for (int i=0; i<denominations.length; i++) {
      if (denominations[i]==0) {
        System.out.println("You argument is 0");
        return Tuple.IMPOSSIBLE;
      } else if (denominations[i]<0) {
        System.out.println("Your argument is negative");
        return Tuple.IMPOSSIBLE;
      }
    }

    // Check to see if the denominations are duplicates    
    for(int i=0; i<denominations.length-1; i++) {
      for(int j=i+1; j<denominations.length; j++) {
        if ( denominations[i] == denominations[j] ) {
          System.out.println("Your denominations are duplicated");
          return Tuple.IMPOSSIBLE;
        }
      }
    }

      // Create a new tuple table    
      Tuple[][] table = new Tuple[ denominations.length ][ amount + 1 ];

      // Loops through each denomination
      for ( int i = 0; i < denominations.length; i++ ) {
        
        // Loops through amount of coin        
         for ( int j = 0; j <= amount; j++ ) {

            Tuple t = new Tuple( denominations.length );

            if ( j == 0 ) {
               table[i][j] = new Tuple( denominations.length );
            } else {

               if ( ( j / denominations[i] ) >= 1 ) {
                  t.setElement( i, 1 );
                  if ( table[ i ][ j - denominations[i] ].isImpossible() == false ) {
                     t = t.add( table[ i ][ j - denominations[i] ] );
                  } else {
                     t = Tuple.IMPOSSIBLE;
                  }

               } else if ( ( j / denominations[i] ) < 1 ) {
                  t = Tuple.IMPOSSIBLE;
               }

               if ( i != 0 ) {
                  if ( t.isImpossible() == false ) {
                     if ( table[ i - 1 ][ j ].isImpossible() ) {

                     } else {

                        if ( table[ i - 1 ][ j ].total() < t.total() ) {
                           t = table[ i - 1 ][ j ];
                        }
                     }
                  } else {

                     if ( table[ i - 1 ][ j ].isImpossible() == false ) {
                        t = table[ i - 1 ][ j ];
                     }
                  }
               }

               table[i][j] = t;
              }
            }
          }
          // Return the table
        return table[ denominations.length - 1 ][ amount ];
      }

    /**
     *  Method to print usage instructions for class
     *  Returned when inputted arguments do not match the requirements
     */
    private static void printUsage() {
        System.out.println("Usage: java DynamicChangemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    /**
     *  Method to pluralize "coin" if more than one coin is used
     *  @param count Number of coins total needed to make the amount desired
     *  @return String "s" if more than one coin is needed
     */
    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
