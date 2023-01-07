import java.util.*;

public class Misspelled {
    public int howMany(String[] words, String[] dictionary) {
//        ArrayList<String> dictlist = new ArrayList<String>();
//        for (String str : dictionary) {
//            dictlist.addAll(str);
//        }
        List<String> dictlist = Arrays.asList(dictionary);
        int counter = 0;
        for (String str : words) {
            if (!dictlist.contains(str)) {
                counter ++;
            }
        }
        return counter;
    }
}