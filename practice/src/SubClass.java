import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubClass extends SuperClass {

    public SubClass(String text) {
        super(text);
    }

    public String getText() {
         return this.giveText();
    }
    protected int countSyllables(String word)
    {
        // TODO: Implement this method so that you can call it from the
        // getNumSyllables method in BasicDocument (module 2) and
        // EfficientDocument (module 3).
        int count = 0;
        Set<Character> vowels = new HashSet<Character>(Arrays.asList(new Character[]{'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'y', 'Y'}));
        boolean syllableFound = false;

        for(int i = 0; i < word.length() ; i++) {

            if (vowels.contains(word.charAt(i))) {
                syllableFound = true;
            } else {
                if(syllableFound) {
                    count+=1;
                    syllableFound = false;
                }
            }
        }
        if(syllableFound) {
            count += 1;
        }
        Character lastChar = null, lastButOneChar = null;
        if(word.length() > 1) {
            lastChar = Character.toUpperCase(word.charAt(word.length() - 1));
            lastButOneChar = Character.toUpperCase(word.charAt(word.length() - 2));

            if (lastChar.equals('E') && (!vowels.contains(lastButOneChar)) && count >= 2) {
                count -= 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        SubClass subClass = new SubClass("this is");
        System.out.println("Seetee" + subClass.countSyllables("Seetee"));
        System.out.println("Sssse" + subClass.countSyllables("Sssse"));
        System.out.println("Ssese" + subClass.countSyllables("Ssese"));
        System.out.println("Ssyese" + subClass.countSyllables("Ssyese"));
        System.out.println("Ssyvese" + subClass.countSyllables("Ssyvese"));
        System.out.println("Seeteb" + subClass.countSyllables("Seeteb"));
        System.out.println("e"  + subClass.countSyllables("e"));
        System.out.println("ee" + subClass.countSyllables("ee"));
    }
}
