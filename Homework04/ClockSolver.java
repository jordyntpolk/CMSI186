/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
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

public class ClockSolver {
    /**
     *  Class field definintions go here
     */
    private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
    private final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
    private static double EPSILON_VALUE = 0.05;      // small value for double-precision comparisons
    private static double targetAngle = 0;
    private static double timeSlice = 0;
    
    /**
     *  Constructor
     *  This just calls the superclass constructor, which is "Object"
     */
    public ClockSolver(String args[]) {
        super();
    }
    
    /**
     *  Method to handle all the input arguments from the command line
     *   this sets up the variables for the simulation
     */
    public void handleInitialArguments( String args[] ) {
        // args[0] specifies the angle for which you are looking
        //  your simulation will find all the angles in the 12-hour day at which those angles occur
        // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
        // you may want to consider using args[2] for an "angle window"
        
        if( 0 == args.length ) {
            System.out.println( "   Sorry you must enter at least one argument\n" +
                               "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                               "   Please try again..........." );
            System.exit( 1 );
        }else if (3 <= args.length) {
            System.out.println("Sorry, only a maximum of 2 arguments allowed");
            System.exit( 1 );
        }
    }
    
    /**
     *  The main program starts here
     *  remember the constraints from the project description
     *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
     *  @param  args  String array of the arguments from the command line
     *                args[0] is the angle for which we are looking
     *                args[1] is the time slice; this is optional and defaults to 60 seconds
     *                args[2] is the epsilon value (angle window)
     */
    public static void main( String args[] ) {
        System.out.println( "\n\n      Hello world! Welcome to the ClockSolver program!!\n\n" ) ;
        ClockSolver cse = new ClockSolver(args);
        Clock clock = new Clock();
        double[] timeValues = new double[3];
        cse.handleInitialArguments( args );
        while( clock.getTotalSeconds() < 43200 ) {
            clock.tick();
            if(Math.abs((clock.getHandAngle()-targetAngle)) <= EPSILON_VALUE) {
                clock.toString();
            }
        }
        System.exit( 0 );
    }
}
