import java.util.Arrays;
import java.util.Comparator;

public class TheBestName {
    public String[] sort(String[] names) {
        Arrays.sort(names, new NameComp());
        //Arrays.sort(names, Comparator.reverseOrder());
        return names;
    }

    private class NameComp implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            if (a.equals("JOHN") && !b.equals("JOHN")) {
                return -1;
            }
            if (!a.equals("JOHN") && b.equals("JOHN")) {
                return 1;
            }
            if (a.equals("JOHN") && b.equals("JOHN")) {
                return 0;
            }
            int suma = 0;
            for (int k = 0; k < a.length(); k++) {
                suma = suma + (((int) a.charAt(k)) - 64);
            }
            int sumb = 0;
            for (int k = 0; k < b.length(); k++) {
                sumb = sumb + (((int) b.charAt(k)) - 64);
            }
            if (suma < sumb) {
                return 1;
            }
            if (suma > sumb) {
                return -1;
            }
            int small = Math.min(a.length(), b.length());
            for (int k = 0; k<small; k++) {
                if (a.charAt(k) - b.charAt(k) < 0) {
                    return -1;
                }
                if (a.charAt(k) - b.charAt(k) > 0) {
                    return 1;
                }
            }

            if (a.length()<b.length()) {
                return 1;
            }
            if (a.length()>b.length()) {
                return -1;
            }
            return 0;
        }
    }
}
