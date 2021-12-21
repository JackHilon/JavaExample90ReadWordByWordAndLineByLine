
package javaexample90readwordbywordandlinebyline;

import java.util.*;


public class JavaExample90ReadWordByWordAndLineByLine {

    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        in.useLocale(Locale.US);
        
        // delimiter between words (space)
        String delimiter0 = in.delimiter()+"";
        
        // delimiter between lines
        String delimiterLine = System.getProperty("line.separator");
        /*
        I may be wrong but I guess when a Scanner is taking input from System.in, 
        it is waiting for enter/return to be pressed to know that the user 
        has finished input. Otherwise how would System.in know when a line is 
        available to be read. So in the case when you set the delimiter to be 
        the default line separator for the host OS, unfortunately there will 
        be no new line separator because System.in does not return the newline 
        character. So it is continually waiting to split the input on the line 
        separator delimiter that will never occur. This situation would be better 
        suited when input comes by means of a text file.

        Btw the program may run fine with the line in question commented out. 
        However if you were to enter a dorm name containing multiple words 
        delimited by a space you will most likely run into a run time exception. 
        Which appears to me the program will not run as intended with or without 
        the line commented out.
        
         source: https://community.oracle.com/tech/developers/discussion/1252155/usedelimiter-system-getproperty-line-separator
        */
        
        
        
        // read word-by-word
        System.out.print("Enter a word and an integer: ");
        String s1= in.next();
        int n1 = in.nextInt();
        
        System.out.println("Your word and integer....");
        System.out.println(s1);
        System.out.println(n1);
        
        System.out.println();
        System.out.println();
        
        // read line-by-line ((*) execution is not good! Infinite loop!)
        // (*) in.useDelimiter(System.getProperty("line.separator"));
        // (*) in.useDelimiter(delimiterLine);
        // (Solution1) in.useDelimiter(System.getProperty("line.separator")+ "|\n");
        // (Solution2)
        in.useDelimiter("\r\n|[\r\n\u2028\u2029\u0085]");
        /*
        This expression matches the \r\n combination used by Windows, or 
        any single \n (Unix/Linux), \r (Mac), \u2029 (unicode line separator), 
        /u2029 (unicode paragraph separator), or \u0085 (next-line symbol).
        */
        System.out.println("Enter two lines....");
        String s2 = in.next();
        String s3 = in.next();
        System.out.println("Your two lines....");
        System.out.println(s2);
        System.out.println(s3);
        
        System.out.println();
        System.out.println();
        
        // read word-by-word
        in.useDelimiter(delimiter0);
        System.out.print("Enter a double and a word: ");
        double n2 = in.nextDouble();
        String s4= in.next();
        
        System.out.println("Your double and word....");
        System.out.println(n2);
        System.out.println(s4);
        
        in.close();
        
    }
    
}
