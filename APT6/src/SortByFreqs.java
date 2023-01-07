import java.util.*;

public class SortByFreqs {
    public HashMap<String, Integer> myMap;

    public String[] sort(String[] data) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : data) {
            map.putIfAbsent(str, 0);
            map.put(str, map.get(str) + 1);
        }
        myMap = map;
        ArrayList<String> words = new ArrayList<>(map.keySet());
        Collections.sort(words, new DataComp());
        return words.toArray(new String[0]);
    }

    private class DataComp implements Comparator<String>{

        @Override
        public int compare(String a, String b) {
            if (myMap.get(a) < myMap.get(b)) {
                return 1;
            }
            if (myMap.get(a) > myMap.get(b)) {
                return -1;
            }
            int small = Math.min(a.length(), b.length());

            for (int k = 0; k<small; k++) {
                if (a.charAt(k) - b.charAt(k) < 0) {
                    return -1;
                }
                else if (a.charAt(k) - b.charAt(k) > 0) {
                    return 1;
                }
            }
            if (a.length() < b.length()) {
                return -1;
            }
            if (a.length() > b.length()) {
                return 1;
            }
            return 0;
        }
    }
}