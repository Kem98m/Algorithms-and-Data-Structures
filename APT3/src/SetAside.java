import java.util.*;

public class SetAside {
    public String common(String[] list) {
        int length = list.length;
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str : list) {

            String[] words = str.split(" ");
            TreeSet<String> uniquewords = new TreeSet<>();
            uniquewords.addAll(Arrays.asList(words));
            words = uniquewords.toArray(new String[0]);

            //System.out.println(words);
            for (int k = 0; k < words.length; k++) {
                if (!map.containsKey(words[k])) {
                    map.put(words[k], 1);
                }
                else {
                    map.put(words[k], map.get(words[k]) + 1);
                }

            }
        }
        for (String str : map.keySet()) {
            if (map.get(str) == length) {
                sb.append(str + " ");
            }
        }
        if (sb.toString().equals("")) {
            return "";
        }
        else {
            String ret = sb.toString().substring(0, sb.toString().length() - 1);
            return ret;
        }
    }
}