import java.lang.reflect.Array;
import java.util.*;

public class ClientsList {
    public String[] dataCleanup(String[] names) {
        ArrayList<String> fixed = new ArrayList<>();
        for (String str : names) {
            if (str.contains(",")) {
                String[] fl = str.split(", ");
                String correct = fl[1]+" "+fl[0];
                str = correct;
            }
            fixed.add(str);
        }
        Collections.sort(fixed, new fixComp());
        return fixed.toArray(new String[0]);
    }

    private class fixComp implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String[] newa = a.split(" ");
            String[] newb = b.split(" ");

            int small = Math.min(newa[1].length(), newb[1].length());
            for (int k = 0; k<small; k++) {
                if (newa[1].charAt(k) - newb[1].charAt(k) < 0) {
                    return -1;
                }
                if (newa[1].charAt(k) - newb[1].charAt(k) > 0) {
                    return 1;
                }
            }
            if (newa[1].length() < newb[1].length()) {
                return -1;
            }
            if (newa[1].length() > newb[1].length()) {
                return 1;
            }
            int smallfirst = Math.min(newa[0].length(), newb[0].length());
            for (int k = 0; k<smallfirst; k++) {
                if (newa[0].charAt(k) - newb[0].charAt(k) < 0) {
                    return -1;
                }
                if (newa[0].charAt(k) - newb[0].charAt(k) > 0) {
                    return 1;
                }
            }
            if (newa[0].length() < newb[0].length()) {
                return -1;
            }
            if (newa[0].length() > newb[0].length()) {
                return 1;
            }
            return 0;
        }
    }
}
