import java.util.*;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {

        int how = 0;
        int[] headlineCount = getCounts(headlines);
         for (String str : messages){
             int[] msgcount = new int[300];
             String[] words = str.split(" ");
             msgcount = getCounts(words);
             int count = 0;
             for (int k = 0; k < msgcount.length; k++){
                 if (headlineCount[k]>=msgcount[k]) {
                     count += 1;
                 }
             }
             if (count == 300) {
                 how ++;
             }
         }
         return how;

    }
    private int[] getCounts(String[] strings) {
        int[] counts = new int[300];
        for(String s : strings) {
            for(char ch : s.toLowerCase().toCharArray()) {
                counts[ch] ++;
            }
        }
        return counts;
    }
}