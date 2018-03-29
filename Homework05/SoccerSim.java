import java.text.DecimalFormat;
 
 public class SoccerSim {
 
    private static final double DEFAULT_FIELD_WIDTH   = 500.0;
    private static final double DEFAULT_FIELD_HEIGHT  = 500.0;
    private static final int    DEFAULT_BALL_COUNT    = 3;
    private static final double DEFAULT_POLEX_POS    = 300.0;
    private static final double DEFAULT_POLEY_POS    = 500.0;
    private static final double DEFAULT_ORIENTATION   = 0.0;
    private static final double DEFAULT_TIME_SLICE    = 1.0;
    private static final int    NUMBER_OF_BALL_PARAMS = 3;
    private static final String USAGE_MESSAGE         = "\n  Usage:" +
          "\n    java SoccerSim <field-X> <field-Y> <ball-parameters> ... <ball-parameters> "
 
    private boolean  initialReport = true;
    private boolean  updateSpeed   = false;
    private double   sliceCount    = 0.0;
    private double   timeSlice     = DEFAULT_TIME_SLICE;
    private double[] time          = { 0.0, 0.0, 0.0 };
    private Clock    c             = null;
    private Field    f             = null;
    private Position pole          = null;
 
    public SoccerSim() {
       c = new Clock();
       pole = new Position( DEFAULT_POLEX_POS, DEFAULT_POLEY_POS );
       f = new Field( DEFAULT_FIELD_WIDTH, DEFAULT_FIELD_HEIGHT, 0.0, pole, 2 );
    }
 
   /**
    *  Method to validate the input arguments
    *  @param arguments String array of the arguments supplied to the program
    */
    public void validateArgs( String arguments[] ) {
 
      // no arguments specified, so put out a usage message
       if( 0 == arguments.length ) {
          System.out.println( USAGE_MESSAGE );
          System.exit( 0 );
 
      // validation: first two are field x and y size of the field in feet
      //             if remaining count is odd, assume last is timeslice in seconds and remove
      //             if remaining count is not multiple of four, error
      //             note that if there are only 3 arguments, random ball info is assumed
       } else {
          int argCount = arguments.length - 2;  // take off the field X and Y
          if( 1 == (argCount % 2) ) {           // check for user-specified time slice argument
             try {
                timeSlice = Double.parseDouble( arguments[arguments.length - 1] );
             }
             catch( NumberFormatException nfe ) {
                System.out.println( "\n    Sorry, time slice must be a number.  Try again!" );
                System.exit( 1 );
                }
            }
        }
    }

 
   /**
    *  method to report the status of the simulation for every clock tick
    *  @param  c  Clock object which keeps track of time
    *  NOTE: this method calls the clock.tick() method to get one second to elapse
    */
    public void report( Clock c ) {
       String output = "";
       if( initialReport ) {
          initialReport = false;
          output += "\nFIELD SIZE IS " + f.getFieldX() + " by " + f.getFieldY();
          output += "\nINITIAL REPORT at 00:00:00.0000";
          for( int i = 0; i < f.getBallCount(); i++ ) {
             output += "\nBall " + i + ":\t" + f.getBall( i ).toString();
          }
       } else {
          c.tick( time[0], time[1], time[2], timeSlice );
          output += "\nPROGRESS REPORT at " + c.toString();
          for( int i = 0; i < f.getBallCount(); i++ ) {
             output += "\nBall " + i + ":\t" + f.getBall( i ).toString();
          }
       }
       System.out.println( output );
    }
 
   /**
    *  main method of the simulation
    *  @param  args  String array of the command line arguments
    */
    public static void main( String args[] ) {
       System.out.println( "\n  Hello, world, from the SoccerSim program!" );
       SoccerSim ss = new SoccerSim();
       System.out.println( ss.f.toString() );
       try {
          ss.validateArgs( args );
       }
       catch( Exception e ) {}
       ss.report( ss.c );
       while( true ) {
          ss.updateSpeed = ss.f.simUpdate( ss.timeSlice, ss.updateSpeed );
          ss.report( ss.c );
          if( ss.f.collisionCheck() ) {
             System.out.println( "\nCollision occurred, stopping sim....." );
             break;
          }
          if( (ss.sliceCount += ss.timeSlice) > 1.0 ) {
             ss.updateSpeed = true;
             ss.sliceCount = 0.0;
          }
       }
    }
 }
