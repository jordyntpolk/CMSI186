
 import java.text.DecimalFormat;
 
 public class Pole {
 
    private Position polePosition = null;     // the position location of the pole
 
   /**
    * Constructor
    *  @param p Position object of this pole
    */
    public Pole( Position p ) {
         polePosition = p;
    }
 
   /**
    *  method to fetch the position of the pole
    */
    public Position getCurrentPosition() {
       return polePosition;
    }
 
   /**
    * method to return a "string-y" version of this pole's location
    *  @return a string with this pole's cartesian coordinate location
    */
    public String toString() {
       return "[" + polePosition.getPosition()[0] + "," + polePosition.getPosition()[1] + "]";
    }
 
   /**
    * a main method for testing -- pretty simple
    *  @param args[] String array of command line arguments
    */
    public static void main( String args[] ) {
       System.out.println( "\n   Testing the Pole class....." );
       Position p1 = new Position( 6.5, 9.5 );
       Pole pole = new Pole( p1 );
       System.out.println( "    Pole is located at: " + pole.toString() );
       p1 = new Position( 5.0, 7.0 );
       pole = new Pole( p1 );
       System.out.println( "    Pole moved, is now located at: " + pole.toString() );
    }
 
 }
