import java.util.*;

public class LengthSort {
    public String[] rearrange(String[] values){
        Arrays.sort(values, new ValComp());
        return values;
    }

    private class ValComp implements Comparator<String>{
        @Override
        public int compare(String a, String b) {
            int small = Math.min(a.length(), b.length());
            if (a.length() < b.length()) {
                return -1;
            }
            if (a.length() > b.length()) {
                return 1;
            }
            for (int k = 0; k<small; k++) {
                if (a.charAt(k) - b.charAt(k) < 0) {
                    return -1;
                }
                else if (a.charAt(k) - b.charAt(k) > 0) {
                    return 1;
                }
            }
            return 0;
        }
    }
}