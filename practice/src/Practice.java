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
        //seq = "eeee";
//This is a test.  How many???  Senteeeeeeeeeences are here... there should be 5!  Right?
//many???  Senteeeeeeeeeences are
        seq = "Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad. Vidit mnesarchum quo ut, tempor volutpat contentiones ex pro, quo at elitr dolore. Idque placerat id his, nisl dicit has cu, cu quo clita detracto prodesset. Est tale voluptua cu, in ornatus epicuri nam. Ut falli nobis vel, mei salutatus referrentur et. Quo nisl augue vituperata in, percipit intellegat usu in. Has esse sensibus splendide te, bonorum perpetua eum an. No sit mediocrem deseruisse, graece vocent eos ea, nibh summo praesent et sea. Melius maiorum persequeris vis an, usu ad eirmod definitionem, ne vis odio tamquam repudiare. Id est esse graeco oporteat. Pro et erat persius, his stet libris ridens et. Animal vulputate disputando eam at. Per an zril nostro suavitate, eum te exerci comprehensam. Et eos cetero labores, eam graeci tamquam ei. Eu pri perfecto ocurreret liberavisse. Et nulla feugiat philosophia vix, at mei oratio explicari deterruisset. Ea mea aliquip fuisset suscipiantur. Cum inani nonumes appetere at, nibh senserit his eu. Pri nusquam iudicabit signiferumque ut, his ex debet oportere deseruisse. Inermis reprimique ei pri. Summo salutatus sed at, cu vel enim quodsi definitiones. Quo facete eligendi iracundia in, pri vero prima quaerendum ad, solet gubergren cum eu. Duo te volumus singulis adipisci. Veri omnesque in vix. At mel stet erant ludus, id usu congue persequeris. Sit omnesque convenire ne. Vis an verterem reformidans, vim suas singulis definitionem eu. Has sale aeque efficiantur in, cu eam agam tota maiestatis, te sea repudiare mnesarchum. Eu maiorum epicuri sed, ullum affert omittantur at est. Eum dolorum reprehendunt ad. Vivendum invenire sea no, ne vis suas liber adipiscing. Consequat expetendis at sed, est eu labore aperiri ocurreret, est noster voluptua contentiones eu. Te nam lorem signiferumque, per te ludus quodsi. Sea vidit porro an, eos ea aeterno maiestatis consectetuer, te sed constituto ullamcorper philosophia. Dicta appareat maiestatis ius ut, vis illud viderer temporibus eu, quas elitr eos et. Hinc vidit possit ius id, altera adversarium eum ad. Cu debitis epicurei pro, postea deseruisse nec ad. No mel eruditi efficiantur. No sea meis imperdiet disputationi. Per labore atomorum tractatos an. Cum quot nostrum perpetua id, dico mundi nam ex. Eam an iriure vulputate voluptatum. Eu sit insolens iracundia contentiones. Nostrud tincidunt no usu, cum at cetero vivendo inimicus, no stet gubergren splendide has. Aliquip placerat reformidans te his, verterem convenire forensibus te pro, cu pri voluptua honestatis. Ex summo munere placerat sea, pro ei essent integre definitiones, per ex epicuri scripserit. Cu dico omnes sit, eu ius tale partem, mei quis errem eripuit ex. Et homero aliquam tibique pri. Mea ut utinam tamquam, at erat mucius sapientem qui. Te eam error euripidis accommodare, et quod nostrum vix. Ex quo tale ipsum vivendo. An persecuti liberavisse sed, eum cu viderer eruditi, id ius discere utroque aliquando. Regione vocibus assentior duo te. Meis legere vivendum vel ut, per repudiare vulputate ea, cum in offendit indoctum rationibus. Aeque affert forensibus cu vix, ea tibique neglegentur eam. Case civibus nam et. An mei dicit similique. Has in malorum scaevola omittantur. Vim et habemus detraxit, te sed dico invenire electram. Usu viderer fabellas intellegam an, no saepe facete vis, aliquip reformidans qui ne. Ad mea scaevola pertinax, has an amet aeque. Ut sit affert mandamus. Erant dicunt maiorum ea eam. Usu purto movet explicari et, inani legere facilis cum no. No his putant nonumes perpetua, cum fugit necessitatibus at. Eu has agam moderatius, eos ei omnis percipitur honestatis, verterem scribentur eloquentiam eam an. Ex vis quod reprimique, an vix utroque officiis. Cu sumo option rationibus mea, aliquid facilisis qui ne. Eirmod petentium conclusionemque mei te, sonet altera sadipscing per at. Aliquam corpora ut cum, cu hinc posse malorum usu, no quo graeci qualisque honestatis. Blandit accusata adipiscing ea his. Vix ea tale iuvaret periculis. Autem ignota ei pro, ad cum dicam timeam. Duo officiis phaedrum repudiandae id, usu ut brute inani tincidunt. Sit semper impedit cotidieque ei. Nostrud propriae voluptatum cum ea. Nec clita dolorum oportere et, sea ne accusamus efficiendi complectitur, nulla nostro ut mei. Aliquid fierent ex est, vis ullum tamquam dissentiet ne. Epicurei reformidans te mel, ius malis maluisset ex. Id perfecto sensibus mei, mei sanctus fastidii periculis id. Atomorum incorrupte an cum, elit nostrud sadipscing ad sed. Saepe nostrud ad nam. Est congue veritus percipit ut, te mundi populo oportere sea. Corpora probatus efficiantur ei eum. Altera pertinax postulant mei ne, error partem offendit sit cu. Modo semper tincidunt ius id, mei an stet imperdiet delicatissimi. Id mea homero efficiendi. Diam minim similique duo ut. Eu mucius delenit pri. Cu ridens expetenda corrumpit eum, id per impedit mediocrem, idque audiam te mel. Ad probo aliquid mel, eruditi inermis offendit ius te, voluptua conceptam pri id. In error invidunt aliquando vis. Veniam splendide assentior ad duo, an dicta vocent sit. Ad ubique indoctum philosophia usu, ea eum dolores dissentiunt. Mea salutandi temporibus ut, iusto oblique at est, tollit postea putent his te. Ad ius atqui liber latine. Porro abhorreant vituperata an pro, sit choro deserunt at, tale verear ceteros vim an. Per detracto facilisis signiferumque ex, vis et platonem eloquentiam, in mutat eruditi mei. Antiopam explicari ut sea, diam maiorum temporibus no est, vix cu consul dolorem menandri. His eu meis albucius adipiscing. Pri audire appareat complectitur ea, vis eu homero aperiam denique. Qui inimicus pertinacia ei, voluptua partiendo qui ei. Tacimates rationibus percipitur pri ea, ea duo wisi apeirian dissentiet. Per eu equidem repudiare. Modus saepe laoreet vix cu, mucius euripidis est ea, mea iudico noster quodsi et. Rebum idque disputando eam no. Mel quodsi audire ad, quo iuvaret denique vituperata ad. Et mea possim sapientem maiestatis, usu congue labore ornatus ad, consul ceteros conceptam per in. Ad eam amet etiam voluptaria. In cum labore timeam, ex putant dolorum usu. Usu offendit reprehendunt ex, cu eripuit nostrum gubergren his. Docendi democritum his et, cu eos mazim erant sapientem. Ad vim iriure philosophia. Dico voluptua ea sea, an mundi utamur iisque eum, justo aliquid ut ius. Mea et alia tritani.";
        //seq = "Mea";

        p = Pattern.compile("[aeiouyAEIOUY]+?[aiouyAIOUY]+\\b|[aiouyAIOUY]+\\b|[aeiouyAEIOUY]+(?!\\b)|\\b[bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ]*e\\b");
        //"[ebcdfghjklmnpqrstvwxzEBCDFGHJKLMNPQRSTVWXZ]+?[aiouyAIOUY]+\\b|"
        m = p.matcher(seq);
        int count = 1;
        while(m.find()) { //tries to match subsequence within given sequence
            System.out.println("test7 starts");
            System.out.println(m.start() + ":" + m.end());
            System.out.println(">>" + m.group() + "<<" + count);
            System.out.println("test7 ends");
            count++;
            //System.out.println(m.group() + " >> " + m.start() + ":" + m.end());
        }

        double a = 206.835 - 1.015 * (4.0/1)  - 84.6 * (5.0/4);
        System.out.println(a);
        String s = "%one%";
        System.out.println(s.split("[one,two,three]").length);
    }
}
