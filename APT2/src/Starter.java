import java.util.*;

public class Starter {
    public int begins(String[] words, String first) {
        char[] newfirst = first.toCharArray();
        Set<String> uniquewords = new HashSet<>(Arrays.asList(words));
        String[] newwords = new String[uniquewords.size()];
        newwords = uniquewords.toArray(newwords);
        int count = 0;
        for (int k = 0; k<uniquewords.size(); k++) {
            char[] chars = newwords[k].toCharArray();
            if (chars[0] == newfirst[0]) {
                count ++;
            }
        }
        return count;
    }
}