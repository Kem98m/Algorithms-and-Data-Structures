import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Infrequent {
    public String find(String[] phrases){
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : phrases) {
            str = str.toLowerCase();
            String[] words = str.split(" ");
            for (int k = 0; k < words.length; k++) {
                if (!map.containsKey(words[k])) {
                    map.put(words[k], 1);
                }
                else {
                    map.put(words[k], map.get(words[k]) + 1);
                }
            }
        }
        Integer minfreq = Collections.min(map.values());
//        for (Entry<String, Integer> entry : map.entrySet())

        return (String) getkey(map, minfreq);
    }
    public static Object getkey(Map hash, Integer value) {
        for (Object I : hash.keySet()) {
            if (hash.get(I).equals(value)) {
                return I;
            }
        }
        return null;
    }
}