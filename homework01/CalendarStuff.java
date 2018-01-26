/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Jordyn Polk
 *  Date          :  1/25/18
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2017-12-25  B.J. Johnson  Updated for Spring 2018
 */
public class CalendarStuff {

  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   */
   private static final int SUNDAY    = 0;
   private static final int MONDAY    = SUNDAY    + 1;
   private static final int TUESDAY   = MONDAY    + 1;
   private static final int WEDNESDAY = TUESDAY   + 1;
   private static final int THURSDAY  = WEDNESDAY + 1;
   private static final int FRIDAY    = THURSDAY  + 1;
   private static final int SATURDAY  = FRIDAY    + 1;

  
  /**
   * A listing of the months of the year, assigning numbers
   */
   private static final int JANUARY    = 0;
   private static final int FEBRUARY   = JANUARY   + 1;
   private static final int MARCH      = FEBRUARY  + 1;
   private static final int APRIL      = MARCH     + 1;
   private static final int MAY        = APRIL     + 1;
   private static final int JUNE       = MAY       + 1;
   private static final int JULY       = JUNE      + 1;
   private static final int AUGUST     = JULY      + 1;
   private static final int SEPTEMBER  = AUGUST    + 1;
   private static final int OCTOBER    = SEPTEMBER + 1;
   private static final int NOVEMBER   = OCTOBER   + 1;
   private static final int DECEMBER   = NOVEMBER  + 1;

  
  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   *  NOTE: this is optional, but suggested
   */
   private static int[]    days        = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * The constructor for the class
   */
   public CalendarStuff() {
      System.out.println( "Constructor called..." );  // replace this with the actual code
   }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
    public static boolean isLeapYear( long year ){
         if (year % 4 == 0 && year % 100 != 0)
         {
             return true;
         }
        // A leap year
         else if (year % 400 == 0)
         {
             return true;
         }
        // A leap year
         else
         {
             return false;
         }
        // Not a leap year
     }
  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an index, and so must
   *         be decremented to make the appropriate index value
   */
   public static long daysInMonth( long month, long year ){
       if (month == 0  || month == 2  || month == 4  || month == 6  ||month == 7  ||month == 9  || month == 11){
           return 31;
       }
       // These are the months with 31 days
       else if (month == 3 || month == 5 || month == 8 || month == 10){
           return 30;
       }
       // These are the months with 31 days
       else if(month == 1){
           if(isLeapYear(year)){
               return 29;
           }
           // This is when February has 29 days
           else{
               return 28;
           }
           // This is when February has 28 days

       }
       else{
           throw new UnsupportedOperationException();
       }
       // This is for an invalid month
       
   }
    /**
     * A method to determine if two dates are exactly equal
     * @param    month1 long    containing month number, starting with "1" for "January"
     * @param    day1   long    containing day number
     * @param    year1  long    containing four-digit year
     * @param    month2 long    containing month number, starting with "1" for "January"
     * @param    day2   long    containing day number
     * @param    year2  long    containing four-digit year
     * @return          boolean which is true if the two dates are exactly the same
     */
    public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
        return true;  // replace this with the actual code
    }
    
    /**
     * A method to compare the ordering of two dates
     * @param    month1 long   containing month number, starting with "1" for "January"
     * @param    day1   long   containing day number
     * @param    year1  long   containing four-digit year
     * @param    month2 long   containing month number, starting with "1" for "January"
     * @param    day2   long   containing day number
     * @param    year2  long   containing four-digit year
     * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
     */
    public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
        return 0;  // replace this with the actual code
    }
    
  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
   public static boolean isValidDate( long month, long day, long year ){
       if (year <= 0){
           return false;
       }
       // A year must be greater than 0
       if (month < 1 || month > 12){
           return false;
       }
       // A month must be in between the numbers 1 and 12
       if (day < 0 || day <= daysInMonth(month,year)){
           return false;
       }
       // The day of th month must be greater than zero but must be less than or equal to the days in the month
       else{
           return true;
       }
       
   }
    /**
     * A method to return a string version of the month name
     * @param    month long   containing month number, starting with "1" for "January"
     * @return         String containing the string value of the month (no spaces)
     */

    public static String toMonthString( int month ) {
        switch( month - 1 ) {
            default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
        }
    }
    
    /**
     * A method to return a string version of the day of the week name
     * @param    day int    containing day number, starting with "1" for "Sunday"
     * @return       String containing the string value of the day (no spaces)
     */
    public static String toDayOfWeekString( int day ) {
        switch( day - 1 ) {
            default       : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
        }
    }
  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
       if (isValidDate(month1, day1, year1) && isValidDate(month2, day2, year2)){
           long num1 = Math.round(java.lang.Math.abs((year1-year2)*365.25));
           // The difference in years multiplied by the days in each year
           // Absolute value so it's always a positive number because it's time
           long num2 = java.lang.Math.abs(daysInMonth(month1, year1)*month1-daysInMonth(month2, year2)*month2);
           // The difference in months and the days of the month
           // Absolute value so it's always a positive number because it's time
           long num3 = java.lang.Math.abs(day1-day2);
           // The difference the days
           // Absolute value so it's always a positive number because it's time
           long num4 = num1+num2+num3;
           // All these numbers added together for the total
           return (num4);
       }
       else{
               throw new UnsupportedOperationException();
           }
       // There is an invalid date
   }
}
