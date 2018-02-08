/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  Jordyn POlk
 *  Date          :  2017-02-08
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Fill in methods to make the program actually work
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {

    static String evenAlphabet = "BDFHJLNPRTVXZbdfhjlnprtvxz";
    static String oddAlphabet  = "ACEGIKMOQSUWYacegikmoqsuwy";
  /**
   * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
   * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
   * it gets included.
   */
  
    public static boolean containsVowel( String str ) {
            if((str.contains ("A")) ||
               (str.contains ("E")) ||
               (str.contains ("I")) ||
               (str.contains ("O")) ||
               (str.contains ("U")) ||
               (str.contains ("Y")) ||
               (str.contains ("a")) ||
               (str.contains ("e")) ||
               (str.contains ("i")) ||
               (str.contains ("o")) ||
               (str.contains ("u")) ||
               (str.contains ("y"))){
                return true;
            }
            return false;
        }
        /**
   * Method to determine if a string is a palindrome.
   */
   public static boolean isPalindrome( String s ) {
                if (s.length() <= 1) {
                    return true;
                } else {
                    char first = s.charAt(0);
                    char last = s.charAt(s.length() - 1);
                    String middle = s.substring(1, s.length() - 1);
                    return first == last && isPalindrome(middle);
                    }
            }
               
  /**
   * Method to return the characters in a string that correspond to the numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even, corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
   */
    public static String evensOnly(String letter) {
                String evenLetter = "";
                for (int i = 0; i < letter.length(); i += 2) {
                    evenLetter = evenLetter + letter.charAt(i);
                }
                return evenLetter;
            }
  /**
   * Method to return the characters in a string that correspond to the numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd, corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
   */
    public static String oddsOnly(String letter) {
                String oddLetter = "";
                for (int i = 1; i < letter.length(); i += 2) {
                    oddLetter = oddLetter + letter.charAt(i);
                }
                return oddLetter;
            }
    /**
     * Method that gets rid of duplicate characters in the string.
     */
    public static String NoDupes( String letter ) {
                String evenLetter = "";
                for (int i=0; i < letter.length(); i++) {
                    if(!(evenLetter.contains(Character.toString(letter.charAt(i))))) {
                        evenLetter = evenLetter + (Character.toString(letter.charAt(i)));
                    }
                }
                return evenLetter;
            }
    /**
     * Method to return the even characters in a string that correspond to the numbers of the alphabet, but with no duplicate characters in the resulting string.
     */
    public static String evensOnlyNoDupes( String letter ) {
        return NoDupes(evensOnly(letter));
    }
    
  /**
   * Method to return the even characters in a string that correspond to the numbers of the alphabet, but with no duplicate characters in the resulting string.
   */
    public static String oddsOnlyNoDupes( String letter ) {
        return NoDupes(oddsOnly(letter));
    }


  /**
   * Method to return the reverse of a string passed as an argument.
   */
   public static String reverse(String input){
                char[] in = input.toCharArray();
                int begin=0;
                int end=in.length-1;
                char temp;
                while(end>begin){
                    temp = in[begin];
                    in[begin]=in[end];
                    in[end] = temp;
                    end--;
                    begin++;
                }
                return new String(in);
            }
  /**
   * Main method to test the methods in this class.
   */
   public static void main( String args[] ) {
      String blah = new String( "Blah blah blah" );
      String woof = new String( "BCDBCDBCDBCDBCD" );
      String jump = new String( "QWERTY qwerty" );
      String run = new String( "JRDYNplk" );
      String walk = new String( "Leftovers" );
      String pal1 = new String( "aaa" );
      String pal2 = new String( "madamimadam" );
      String pal3 = new String( "aeiou" );
      String pal4 = new String( "abd" );
      String pal5 = new String( "racecar" );
      /**
       Test to see if string contains vowel
       */
      System.out.println( containsVowel( blah ) );
      System.out.println( containsVowel( woof ) );
      System.out.println( containsVowel( jump ) );
      System.out.println( containsVowel( run ) );
      System.out.println( containsVowel( walk ) );
      
      /**
      Test to see if string is a palindrome
      */
      System.out.println( isPalindrome( pal1 ) );
      System.out.println( isPalindrome( pal2 ) );
      System.out.println( isPalindrome( pal3 ) );
      System.out.println( isPalindrome( pal4 ) );
      System.out.println( isPalindrome( pal5 ) );
      
       /**
        Test to see if string contains even letters
        */
      System.out.println( "evensOnly()        returns: " + evensOnly( "Time" ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "thank you" ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "Laughing" ) );
      
       /**
        Test to see if string contains even letters or duplicated letters
        */
      System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "Hhugss" ) );
      System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "Maam" ) );
      System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "Chromosome" ) );

       
       
       /**
        Test to see if string contains odd letters
        */
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "alphabet" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "letters" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "ENGLISH" ) );
     
       /**
        Test to see if string contains odd letters or duplicated letters
        */
      System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "Grammy" ) );
      System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "Telephone" ) );
      System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "Mercedes" ) );
       
       
       /**
        Makes string return in reverse
        */
      System.out.println( "reverse()          returns: " + reverse( "Jordyn Polk" ) );
      System.out.println( "reverse()          returns: " + reverse( "Elephant" ) );
      System.out.println( "reverse()          returns: " + reverse( "REHEARSALSZ" ) );
   }
}
