
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Jordyn Polk
 *  Date written  :  2018-03-13
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock{
    /**
     *  Class field definitions go here
     */

    private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
    private static final double INVALID_ARGUMENT_VALUE = -1.0;
    private static final double MAXIMUM_DEGREE_VALUE = 360.0;
    private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
    private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
    private static double timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
    private static double minuteHandAngle = 0;
    private static double hourHandAngle = 0;
    double totalSeconds = 0;

    /**
     *  Constructor
     */
    public Clock() {
        totalSeconds = 0;
    }

    /**
     *
     *  Method to calculate the next tick from the time increment
     *  @return double-precision value of the current clock tick
     *  @throws IllegalArgumentException
     */
    public double tick() {
        totalSeconds += timeSlice;
        return totalSeconds;
    }


    /**
     *  Method to validate the angle argument
     *  @param   argValue  String from the main program's args[0] input
     *  @return  double-precision value of the argument
     *  @throws  IllegalArgumentException
     */
    public double validateAngleArg( String argValue ) {
        double angleValue = Double.parseDouble( argValue );
        if ( angleValue > 360.0 || angleValue < 0 ) {
            throw new IllegalArgumentException();
        }
        return angleValue;
    }

    /**
     *  Method to validate the optional time slice argument
     *  @param  argValue  String from the main program's args[1] input
     *  @return double-precision value of the argument or -1.0 if invalid
     *  note: if the main program determines there IS no optional argument supplied,
     *         I have elected to have it substitute the string "60.0" and call this
     *         method anyhow.  That makes the main program code more uniform, but
     *         this is a DESIGN DECISION, not a requirement!
     *  note: remember that the time slice, if it is small will cause the simulation
     *         to take a VERY LONG TIME to complete!
     */
    public double validateTimeSliceArg( String argValue ) {
        double timeSliceValue = Double.parseDouble( argValue );
        if ( timeSliceValue > 1800 || timeSliceValue < 0 ) {
            return INVALID_ARGUMENT_VALUE;
        }
        return timeSliceValue;
    }

    /**
     *  Method to calculate and return the current position of the hour hand
     *  @return double-precision value of the hour hand location
     */
    public double getHourHandAngle() {
        hourHandAngle = ( totalSeconds * HOUR_HAND_DEGREES_PER_SECOND ) % 360;
        return hourHandAngle;
    }

    /**
     *  Method to calculate and return the current position of the minute hand
     *  @return double-precision value of the minute hand location
     */
    public double getMinuteHandAngle() {
        minuteHandAngle = ( totalSeconds * MINUTE_HAND_DEGREES_PER_SECOND ) % 360;
        return minuteHandAngle;
    }

    /**
     *  Method to calculate and return the angle between the hands
     *  @return double-precision value of the angle between the two hands
     */
    public double getHandAngle() {
        getHourHandAngle();
        getMinuteHandAngle();
        return Math.abs( minuteHandAngle - hourHandAngle );
    }

    /**
     *  Method to fetch the total number of seconds
     *   we can use this to tell when 12 hours have elapsed
     *  @return double-precision value the total seconds private variable
     */
    public double getTotalSeconds() {
        return totalSeconds;
    }

    /**
     *  Method to return a String representation of this clock
     *  @return String value of the current clock
     *  Note: method for calculating Hours:Minutes:Seconds from Stackoverflow
     */
    public String toString() {
        int hours = (int) totalSeconds / 3600;
        int minutes = (int) (totalSeconds / 60) % 60;
        int seconds = (int) totalSeconds % 60;
        return hours + ":" + minutes + ":" + seconds;
    }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );

       System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  100 degrees', expecting double value   100" );
      try { System.out.println( (100 == clock.validateAngleArg( "0.0" )) ? " - got 100" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

       System.out.println( "    Testing getMinuteHand Angle()....");
       System.out.print( "      sending '  35 degrees', expecting double value   35" );
       try { System.out.println( (35 == clock.validateAngleArg( "0.0" )) ? " - got 35" : " - no joy" ); }
       catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   }
}
