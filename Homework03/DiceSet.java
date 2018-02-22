/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Jordyn Polk
 *  Date          :  2018-02-22
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet{

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;
   private int sides = MINIMUM_SIDES;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public Die( int count, int sides ) {
       this.count = count;
       this.side = sides;
       if(count < 1 || 
       sides < MINIMUM_SIDES )
           throw new IllegalArgumentException();
       this.ds = new Die[ count ];
       return ds;
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
       int sum = 0;
       for (Die i : ds){
           sum += i.getValue();
       }
       return sum;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
       for (Die i : ds){
           i.roll();
       }
       return ds;
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
       int arrayLength = ds.length();
       int dieToRoll = Math.random() * arrayLength;
       return dc[dieToRoll].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
       if (dieIndex >= 0 && dieIndex < this.die.length()){
           return ds[dieIndex];
       } else {
           throw new IllegalArgumentException("Invalid number of sides!");
       }
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
       for (int i = 0; i < ds.length(); i++){
   }
      result = "";
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
       for (int i = 0; i < ds.length(); i++){
   }
       result = "";
       return result;
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
       if (dc == this.DiceSet){
           return true;
       } else {
           return false;
       }
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
       DiceSet Player1 = new DiceSet(4,2);
       DiceSet Player2 = new DiceSet (3,1);
       DiceSet Player3 = new DiceSet (9,1);
       
       Player1.roll();
       Player2.roll();
       Player3.roll();
       
  
       System.out.println("Player 1 test: ");
       System.out.println("Player 1: " + Player1);
       System.out.println("sum: " + Player1.sum());
       steve.rollIndividual(0);
       System.out.println("roll individual (0): " + Player1);
   
       System.out.println("Player 2 test: ");
       System.out.println("Player 2: " + Player2);
       System.out.println("sum: " + Player2.sum());
       steve.rollIndividual(2);
       System.out.println("roll individual (2): " + steve);
       
       System.out.println("Player 3 test: ");
       System.out.println("Player3: " + Player3);
       System.out.println("sum: " + Player3.sum());
       steve.rollIndividual(1);
       System.out.println("roll individual (1): " + steve);
   }
}
