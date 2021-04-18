import java.util.List;

public class Practice {
    public static void main(String[] args) {
//        for(Character c: "Hithere".toCharArray()) {
//            System.out.println(c);
//        }
//        String s = "hithere";
//        for(int i = 0; i < s.length(); i++) {
//            System.out.print(s.substring(0,i));
//            System.out.print("x");
//            System.out.println(s.substring(i+1) + " : " + i);
//        }
//        int j = "a".codePointAt(0);
//        for(int subst = "a".codePointAt(0);  subst <= "z".codePointAt(0); subst++) {
//            if(subst != j) {
//                System.out.println((Character.toChars(subst))[0]);
//            }
//        }
        new Practice().substitution("abc");
    }
    public void substitution(String s) {
        StringBuilder word = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            int substituted = s.substring(i,i+1).codePointAt(0);
            for(int substitution = "a".codePointAt(0);  substitution <= "z".codePointAt(0); substitution++) {
                word.setLength(0); //clear the StringBuilder
                if(substitution != substituted) {
                    word.append(s.substring(0,i));
                    word.append(Character.toChars(substitution));
                    word.append(s.substring(i+1));
                    System.out.println(word);
                    count++;
                }

            }
        }
        System.out.println(count);
    }
}
