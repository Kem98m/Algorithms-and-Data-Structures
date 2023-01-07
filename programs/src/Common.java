import java.util.*;
import java.io.*;

public class Common {
    public int count (String a, String b) {

        int[] a1 = new int[26];
        int[] b1 = new int[26];
        int counter = 0;
        for (int k = 0; k < a.length(); k++) {
            a1[a.charAt(k) - 'a'] +=1;
            b1[b.charAt(k) - 'a'] +=1;
        }
        for (int k = 0; k < 26; k++) {
            if (a1[k] != 0 && b1[k] != 0) {
                for (int j = 0; j < Math.min(a1[k], b1[k]); j++) {
                    counter ++;
                }
            }
        }
        return counter;
    }
}
