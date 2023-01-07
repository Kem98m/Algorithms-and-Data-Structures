import java.util.*;

public class WordScore {
    public int[] score(String[] words, String want, String avoid) {
        // replace with your code
        char[] wanted = want.toCharArray();
        char[] reject = avoid.toCharArray();
        Set<Character> wantedset = new LinkedHashSet<Character>();
        for (char ch : wanted) {
            wantedset.add(ch);
        }
        Set<Character> rejectset = new LinkedHashSet<>();
        for (char ch : reject) {
            rejectset.add(ch);
        }
////        Object[] newwanted = wantedset.toArray();
////        StrinCollections.addAll(newwanted)
//        StringBuilder sb = new StringBuilder();
//        for (Character c : wantedset) {
//            sb.append(c);
//        }
//        char[] points = sb.toString().toCharArray();
//        StringBuilder builder = new StringBuilder();
//        for (Character c : wantedset) {
//            builder.append(c);
//        }
//        char[] negpoints = builder.toString().toCharArray();

        int[] myscores = new int[words.length];
        int counter = 0;
        for (String str : words) {
            char[] letters = str.toCharArray();
            for (int k = 0; k < letters.length; k++) {
                if (wantedset.contains(letters[k])) {
                    myscores[counter] +=1;
                }
                if (rejectset.contains(letters[k])) {
                    myscores[counter] -=1;
                }
            }
            counter ++;
        }
        return myscores;
    }
}