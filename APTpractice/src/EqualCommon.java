import java.util.*;

public class EqualCommon {
    public String[] matches(String[] a1, String[] a2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (String str : a1) {
            if (! map1.containsKey(str)) {
                map1.put(str, 1);
            }
            else {
                map1.put(str, map1.get(str) + 1);
            }
        }
        for (String str : a2) {
            if (! map2.containsKey(str)) {
                map2.put(str, 1);
            }
            else {
                map2.put(str, map2.get(str) + 1);
            }
        }
        Set<String> set1 = map1.keySet();
        Set<String> set2 = map2.keySet();
        HashSet<String> match = new HashSet<>();
        for (int k =0; k< set1.size(); k++) {
            for (int j = 0; j<set2.size();j++) {
                if (set1.toArray()[k].equals(set2.toArray()[j])) {
                    if (map1.get(set1.toArray()[k]) == map2.get(set2.toArray()[j])) {
                        Object obj = set1.toArray()[k];
                        match.add(obj.toString());
                    }
                }
            }
        }
        String[] finished = (String[]) match.toArray();
//        for (int k = 0; k< map1.size(); k++) {
//            if (map1.containsKey(map2)) {
//
//            }
//        }


        // change this code
        return finished;
    }
}