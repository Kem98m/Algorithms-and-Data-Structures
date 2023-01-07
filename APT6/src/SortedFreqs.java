import java.util.*;

public class SortedFreqs {
    public int[] freqs(String[] data) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : data) {
            map.putIfAbsent(str, 0);
            map.put(str, map.get(str) + 1);
        }
        ArrayList<String> words = new ArrayList<>(map.keySet());
        Collections.sort(words);
        ArrayList<Integer> freqs = new ArrayList<>();
        for (String key : words) {
            freqs.add(map.get(key));
        }
        int[] newfreqs = new int[freqs.size()];
        for (int k = 0; k<newfreqs.length; k++) {
            newfreqs[k] = freqs.get(k).intValue();
        }
        return newfreqs;
    }
}