import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Practice {

    public static void main(String[] args) {
        /*
        //char c = '\u112f4'; // outside BMP, so needs a char array of surrogate pairs
        int codePoint = 0x112f4;
        char[] c = new char[2];
        c = Character.toChars(codePoint); //get surrogate codepoint pair for the supplementary character using its codepoint
        //Then print the surrogate pair values as hex string
        System.out.println(Integer.toHexString(Character.codePointAt(c, 0, 1)));
        System.out.println(Integer.toHexString(Character.codePointAt(c, 1)));
        System.out.println("\ud804\udef4".length()); //2 The length is equal to the number of Unicode code units in the string.

        System.out.println(Integer.toHexString("\ud804\udef4".charAt(0))); //print as hex strings
        System.out.println(Integer.toHexString("\ud804\udef4".charAt(1))); //print as hex strings
        System.out.println("\ud804\udef4".charAt(0) == '\ud804');
        System.out.println("\ud804\udef4".charAt(1) == '\udef4');


        c = "\ud804\udef4".toCharArray(); //separate String into Codepoints
        System.out.println(Integer.toHexString(Character.codePointAt(c, 0, 1)));
        System.out.println(Integer.toHexString(Character.codePointAt(c , 1)));


        //System.out.println(c);
        System.out.println(Character.isLetter('\uD804'));
        System.out.println(Character.isLetter('\uDEF4'));
        //System.out.println(Character.isLetter('\u112F4')); //won't work for supplementary range code points, char is 16 bits
        //System.out.println(Character.isLetter('\uD804\uDEF4')); //won't work for pair, char is 16 bits
        System.out.println("Code point is: " + Integer.toHexString(Character.toCodePoint(c[0], c[1]))); //to get the codePoint back from surrogate pair
        System.out.println(new String(c)); // get String from surrogate pair
        System.out.println(new String(c, 0 , 2)); // get String from surrogate pair

        c = "\u15e2".toCharArray();
        //c = "\u112f4".toCharArray(); // can't do this. Since the char is outside BMP,needs to be represented as a surrogate pair
        System.out.println(c.length);
        System.out.println(Integer.toHexString(Character.codePointAt(c, 0, 1)));
        //How to start from codePoint and get a String
        //In Java Strings are sequence of chars
        //Each char in Java is 16 bit, so if the code point is outside BMP you need a surrogate pair to
        //represent that char.
        //For codePoint = 0x112f4, you will represent String like this:
        //"\ud804\udef4"
        // and not like this "\u112f4"
        // and char will be represented as a char array of length two.

        codePoint = 0x0AA0;
        codePoint = 0x112f4;

        if(Character.charCount(codePoint) >= 1) { //need surrogate pair if > 1
            c = Character.toChars(codePoint); //codepoint to char array
            System.out.println(c.length);
            String s = new String(c); //char array to String
            System.out.println(s);
            System.out.println(s.toCharArray()); // String to char array
            System.out.println(Integer.toHexString(s.codePointAt(0))); //String to codepoint
            System.out.println(Integer.toHexString(Character.codePointAt(c, 0))); //char array to codePoint
        }

        String s1 = "Hello";
        System.out.println(System.identityHashCode(s1));
        String s2 = "Hello";
        System.out.println(System.identityHashCode(s2));

         */


        Pattern p = Pattern.compile("a*b");
        Matcher m = null;

        String seq = "aaaaaab";
        m = p.matcher(seq);
        if(m.matches()) { //tries to match entire region of seq (matches)
            System.out.println("test1 starts");
            System.out.println(m.start() + ":" + m.end() + ":" + m.group());
            System.out.println("test1 ends");
        }

        seq = "aaabaab";
        m = p.matcher(seq);

        if(m.matches()) { //tries to match entire region of seq (does not match)
            System.out.println("test2 starts");
            System.out.println(m.start() + ":" + m.end() + ":" + m.group());
            System.out.println("test2 ends");
        }
        m.reset();
        while(m.find()) { //tries to match subsequence within given sequence(matches)
            System.out.println("test3 starts");
            System.out.println(m.start() + ":" + m.end() + ":" + m.group());
            System.out.println("test3 ends");
        }
        m.reset();
        if (m.lookingAt()) { //does not try to match entire sequence(matches)
            System.out.println("test4 starts");
            System.out.println(m.start() + ":" + m.end() + ":" + m.group());
            System.out.println("test4 ends");
        }

        seq = "This is a test.  How many???  Senteeeeeeeeeences are here... there should be 5!  Right?";
        //seq = "many???  Senteeeeeeeeeences are";
        p = Pattern.compile(".+?[.!?]+\\s*|.+$");
        m = p.matcher(seq);
        while(m.find()) { //tries to match subsequence within given sequence
            System.out.println("test5 starts");
            System.out.println(m.start() + ":" + m.end());
            System.out.println(">>" + m.group() + "<<");
            System.out.println("test5 ends");
        }

        p = Pattern.compile("[a-zA-Z]+");
        m = p.matcher(seq);
        while(m.find()) { //tries to match subsequence within given sequence
            System.out.println("test6 starts");
            System.out.println(m.start() + ":" + m.end());
            System.out.println(">>" + m.group() + "<<");
            System.out.println("test6 ends");
        }

        //seq = "Sentence";
        //seq = "etcpe";
        //seq = "e";
        //seq = "This is a test.  How many???  Senteeeeeeeeeences are here... there should be 5!  Right?";
        //seq = "many???  Senteeeeeeeeeences are";
        seq = "eeee";
//This is a test.  How many???  Senteeeeeeeeeences are here... there should be 5!  Right?
//many???  Senteeeeeeeeeences are
        p = Pattern.compile("[aiouyAIOUY]+\\b|[aeiouyAEIOUY]+(?!\\b)|\\b[bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ]*e\\b");
        m = p.matcher(seq);
        int count = 1;
        while(m.find()) { //tries to match subsequence within given sequence
            System.out.println("test7 starts");
            System.out.println(m.start() + ":" + m.end());
            System.out.println(">>" + m.group() + "<<" + count);
            System.out.println("test7 ends");
            count++;
        }

        double a = 206.835 - 1.015 * (4.0/1)  - 84.6 * (5.0/4);
        System.out.println(a);
        String s = "%one%";
        System.out.println(s.split("[one,two,three]").length);
    }
}
