
 import java.text.DecimalFormat;
 
 public class Ball {
 
    private static final double BALL_RADIUS          = 4.45;       // radius in inches as given by the problem
    private static final double BALL_RADIUS_IN_FEET  = BALL_RADIUS ;// 12.0;     // converted to feet
    private static final double BALL_WEIGHT          = 1.0;        // weight in pounds as given
    private static final double FRICTION_COEFFICIENT = 0.01;       // friction
    private static final double MPH_TO_FT_PER_SEC    = 1.467;      // MPH converted to feet per second
  
    
    private Position centerLocation = new Position( 0.0, 0.0 );   
    private double   direction      = 0.0;                        // the direction of movement
    private double   speed          = 0.0;                        // speed the ball travels

 /**
    * Constructor to make a new Ball, no parameters
    *  @param p         Position object of the cartesian coordinates for this ball
    *  @param direction double-precision value of the direction the ball moves
    *  @param speed     double-precision value for the initial speed of the ball in MPH
    */
    public Ball( Position p, double d, double s ) {
         centerLocation = p;
         direction      = d;
         speed          = s * MPH_TO_FT_PER_SEC;        
    }
 
   /**
    *  method to fetch the current speed of the ball
    */
    public double getCurrentSpeed() {
       return speed;
    }
 
   /**
    *  method to fetch the current position of the ball
    */
    public Position getCurrentPosition() {
       return centerLocation;
    }

    /**
    *  method to update the speed of the ball for one second of time
    */
    public double updateSpeedForOneSecond() {
       if( 0.0 < speed ) {
          speed *= 0.99;
       }
       return speed;
    }
   /**
    *  method to update the ball's position after one tick of time
    *  NOTE: the Math.sin() method expects RADIANS, not DEGREES so we must convert
    */
    public Position updatePositionForOneTick( double timeSlice ) {
       Position p = centerLocation;
       double deltaX = 0.0;                        
       double deltaY = 0.0;
       double s = getCurrentSpeed();             
       double alpha = 0.0;
       double beta  = 0.0;
       double[] pos = centerLocation.getPosition();
       if( direction <= 90.0 ) {
          alpha = direction;
          beta  = 180.0 - (alpha + 90.0);
          deltaX  = (s * timeSlice) * Math.sin( ((alpha * Math.PI) / 180.0) );
          deltaY  = (s * timeSlice) * Math.sin( ((beta * Math.PI) / 180.0)  );
          centerLocation = new Position( pos[0] + deltaX, pos[1] + deltaY );
       } else if( direction <= 180.0 ) {
          alpha = 180.0 - direction;
          beta  = 180.0 - (alpha + 90.0);
          deltaX  = (s * timeSlice) * Math.sin( ((alpha * Math.PI) / 180.0) );
          deltaY  = (s * timeSlice) * Math.sin( ((beta * Math.PI) / 180.0)  );
          centerLocation = new Position( pos[0] + deltaX, pos[1] + deltaY );
       } else if( direction <= 270.0 ) {
          alpha = direction - 180.0;
          beta  = 180.0 - (alpha + 90.0);
          deltaX  = (s * timeSlice) * Math.sin( ((alpha * Math.PI) / 180.0) );
          deltaY  = (s * timeSlice) * Math.sin( ((beta * Math.PI) / 180.0)  );
          centerLocation = new Position( pos[0] + deltaX, pos[1] + deltaY );
       } else {
          alpha = 360.0 - direction;
          beta  = 180.0 - (alpha + 90.0);
          deltaX  = (s * timeSlice) * Math.sin( ((alpha * Math.PI) / 180.0) );
          deltaY  = (s * timeSlice) * Math.sin( ((beta * Math.PI) / 180.0)  );
          centerLocation = new Position( pos[0] + deltaX, pos[1] + deltaY );
       }
       return centerLocation;
    }

   /**
    * our venerable "toString()" representation
    *  @return  String-y version of what this Position is
    */
    public String toString() {
       DecimalFormat df = new DecimalFormat( "#0.0" );
       String output = "position <" + df.format( centerLocation.getPosition()[0] ) + "," +
                                      df.format( centerLocation.getPosition()[1] ) + ">";
       if( output.indexOf( ">" ) <= 21 ) {
          output += "\t";
       }
       if( 1.0 > (speed * 12.0) ) {
          output += "\t<at rest>";
       } else {
          output += "\t<velocity <" + df.format( direction ) + " @ " + df.format( speed ) + ">";
       }
       return output;
    }
 
 
   /**
    * a main method for testing -- pretty simple
    *  @param args[] String array of command line arguments
    */
    public static void main( String args[] ) {
       System.out.println( "\n   Testing the Ball class................" );
       Position p1 = new Position(  10.0,  13.0 );
       Position p2 = new Position(   4.0,   7.0 );
       Position p3 = new Position(  -1.5, -12.5 );
       Position p4 = new Position( -10.0, -23.0 );
       Position[] posRA = new Position[4];
       posRA[0] = p1;
       posRA[1] = p2;
       posRA[2] = p3;
       posRA[3] = p4;
       Ball b1 = new Ball( p1, 0.0, 0.0 );
       Ball b2 = new Ball( p2, 0.0, 0.0 );
       Ball b3 = new Ball( p3, 0.0, 0.0 );
       Ball b4 = new Ball( p4, 0.0, 0.0 );
       System.out.println( "Ball b1: " + b1.toString() );
       System.out.println( "Ball b2: " + b2.toString() );
       System.out.println( "Ball b3: " + b3.toString() );
       System.out.println( "Ball b4: " + b4.toString() );
       Ball[] ballRA = new Ball[4];
       for( int i = 0; i < ballRA.length; i++ ) {
          ballRA[i] = new Ball( posRA[i], (10.0 + (5.0 * i)), (5.0 + (3.0 * i)) );
       }
       for( int i = 0; i < ballRA.length; i++ ) {
          System.out.println( "Ball " + i + " is: " + ballRA[i].toString() );
       }
    }
 }
