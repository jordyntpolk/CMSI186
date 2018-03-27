
 import java.text.DecimalFormat;
 
 public class Field {
 
   /// fastest measured speed a soccer ball has ever been kicked
    private static final double MAX_VELOCITY = 100.00;
   /// distance between centers when two balls bump (in feet to maintain unit consistency)
    private static final double BALL_BUMP_DISTANCE_FT = (4.45 * 2) / 12.0;
   /// distance between center and pole when ball bumps pole (in feet to maintain unit consistency)
    private static final double POLE_BUMP_DISTANCE_FT =  4.45 / 12.0;
 
    private Position  origin      = new Position( 0.0, 0.0 );
    private double    xWidth      = 0.0;
    private double    yWidth      = 0.0;
    private double    orientation = 0.0;
    private Pole      pole        = null;
    private Ball[]    ballArray   = null;
 
   /**
    *  Constructor
    *   This one is pretty extensive, moreso than the other ones we've done
    *   That's because there is more initialization to be done with constructing a Field
    *   The simulation has lots of parameters that need to be handled
    *  @param width         double-precision value of the field's width in inches
    *  @param height        double-precision value of the field's height in inches
    *  @param oriented      double-precision value of the orientation from north, in degrees
    *  @param poleLocation  Position object containing coordinates on which the Pole will be placed
    *  @param ballCount     integer value of the number of Ball objects to be used in the simulation
    */
    public Field( double width, double height, double oriented, Position poleLocation, int ballCount ) {
 
       double   randomX = 0.0;       
       double   randomY = 0.0;       
       double   randomD = 0.0;       
       double   randomS = 0.0;       
       Position randomP = null;      
 
       xWidth      = width;                     
       yWidth      = height;                     
       orientation = oriented;                   
       pole        = new Pole( poleLocation );   
       ballArray   = new Ball[ballCount];        
 
       for( int i = 0; i < ballArray.length; i++ ) {
          randomX = (double)((Math.floor(Math.random() * (xWidth / 2.0))  + 1.0));
          randomY = (double)((Math.floor(Math.random() * (yWidth / 2.0))  + 1.0));
          randomD = (double)((Math.floor(Math.random() * 360.0)        + 1.0));
          randomS = (double)((Math.floor(Math.random() * MAX_VELOCITY) + 1.0));
          randomP = new Position( randomX, randomY );
          ballArray[i] = new Ball( randomP, randomD, randomS );
       }
    }
 
   /**
    *  method to get the field X size
    */
    public double getFieldX() {
       return xWidth;
    }
 
   /**
    *  method to get the field Y size
    */
    public double getFieldY() {
       return yWidth;
    }
 
   /**
    *  method to reset the field size
    *  @param  xValue  double-precision value for the new x size
    *  @param  yValue  double-precision value for the new y size
    */
    public void setNewFieldSize( double x, double y ) {
       xWidth = x;
       yWidth = y;
    }
 
   /**
    *  method to get the ball count
    *  @return size of the ballArray
    */
    public int getBallCount() {
       return ballArray.length;
    }
 
   /**
    *  method to return a single Ball object
    *  @param  index  integer of the index of the Ball to return
    *  @return Ball object indicated by index argument
    */
    public Ball getBall( int index ) {
       if( (index > ballArray.length) || (0 > index) ) {
          return ballArray[0];
       }
       return ballArray[index];
    }
 
   /**
    *  method to add a Ball object to the Field using X/Y location
    *  @param xLocation  double-precision value of the Ball's X value
    *  @param yLocation  double-precision value of the Ball's Y value
    *  @param direction  double-precision value of the Ball's direction of movement
    *  @param speed      double-precision value of the Ball's starting speed
    */
    public void addBall( double xLocation, double yLocation, double direction, double speed ) {
       Position p = new Position( xLocation, yLocation );
       Ball b = new Ball( p, direction, speed );
       Ball[] newBallArray = new Ball[ballArray.length + 1];
       for( int i = 0; i < ballArray.length; i++ ) {
          newBallArray[i] = ballArray[i];
       }
       newBallArray[newBallArray.length - 1] = b;
       ballArray = newBallArray;
    }
 
   /**
    *  method to add a Ball object to the Field using position location
    *  @param p          Position object of the Ball's location
    *  @param direction  double-precision value of the Ball's direction of movement
    *  @param speed      double-precision value of the Ball's starting speed
    */
    public void addBall( Position p, double direction, double speed ) {
       Ball b = new Ball( p, direction, speed );
       Ball[] newBallArray = new Ball[ballArray.length + 1];
       for( int i = 0; i < ballArray.length; i++ ) {
          newBallArray[i] = ballArray[i];
       }
       newBallArray[newBallArray.length - 1] = b;
       ballArray = newBallArray;
    }
 
   /**
    *  method to update all the Ball locations and speeds
    *  @param  timeSlice  double-precision value of the time slice argument
    *  Note: if the time slice is not one second, it changes when the speed is
    *        recalculated
    */
    public boolean simUpdate( double timeSlice, boolean updateSpeed ) {
       for( int i = 0; i < ballArray.length; i++ ) {
          ballArray[i].updatePositionForOneTick( timeSlice );
          if( updateSpeed ) {
             ballArray[i].updateSpeedForOneSecond();
             return false;
          }
       }
       return true;
    }
 
   /**
    *  method to check if any collisions have occurred
    */
    public boolean collisionCheck() {
       double   distance = 0.0;
       double   dX       = 0.0;
       double   dY       = 0.0;
       for( int i = 0; i < (ballArray.length - 1); i++ ) {
          for( int j = (i +1); j < ballArray.length; j++ ) {
             dX = Math.abs( ballArray[i].getCurrentPosition().getPosition()[0] -
                            ballArray[j].getCurrentPosition().getPosition()[0] );
             dY = Math.abs( ballArray[i].getCurrentPosition().getPosition()[1] -
                            ballArray[j].getCurrentPosition().getPosition()[1] );
             distance = Math.sqrt( (dX * dX) + (dY * dY) );
             if( distance <= BALL_BUMP_DISTANCE_FT ) {
                return true;
             }
          }
          dX = Math.abs( ballArray[i].getCurrentPosition().getPosition()[0] -
                         pole.getCurrentPosition().getPosition()[0] );
          dY = Math.abs( ballArray[i].getCurrentPosition().getPosition()[1] -
                         pole.getCurrentPosition().getPosition()[1] );
          distance = Math.sqrt( (dX * dX) + (dY * dY) );
          if( distance <= POLE_BUMP_DISTANCE_FT ) {
             return true;
          }
       }
       return false;
    }
 
   /**
    * our venerable "toString()" method with 'pretty' output
    * @return String version of the Field
    */
    public String toString() {
       String returnValue = " width: "         + xWidth           + "\n" +
                            " height: "        + yWidth           + "\n" +
                            " orientation: "   + orientation      + "\n" +
                            " pole location: " + pole.toString()  + "\n" +
                            " ball count: "    + ballArray.length + "\n";
       for( int i = 0; i < ballArray.length; i++ ) {
          returnValue += "  Ball " + i + " parameters: " + ballArray[i].toString() + "\n";
       }
       return returnValue;
    }
 
    public static void main( String args[] ) {
       System.out.println( "\n   Testing the Field class....." );
       Position pl = new Position( 30., 40.0 );
       Field field = new Field( 500.0, 500.0, 0.0, pl, 5 );
       System.out.println( "\n     new Field created....");
       System.out.println( "\n     parameters:\n" + field.toString() );
       Position p2 = new Position( 123.4, 234.5 );
       Ball b2 = new Ball( p2, 100.0, 25.0 );
       System.out.println( "\n     new Ball b2 created, parameters:\n" + b2.toString() );
       field.addBall( 234.5, 345.6, 79.0, 23.0 );
       System.out.println( "\n     parameters:\n" + field.toString() );
       System.out.println( "\n     values for ball[3]: " + field.getBall( 3 ).toString() );
       field.simUpdate( 1.0, true );
       System.out.println( "\n     values for ball[3]: " + field.getBall( 3 ).toString() );
    }
 
 }
