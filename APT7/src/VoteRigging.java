import java.util.Arrays;
import java.util.Collections;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        // fill in code here
        int max = 0;
        if(votes.length == 1) {
            return 0;
        }
        int[] enemies = new int[votes.length-1];
        for (int k = 0; k<enemies.length; k++) {
            enemies[k] = votes[k+1];
        }
//        if (votes[0] == max) {
//            return 0;
//        }
        Arrays.sort(enemies);
        while (max + votes[0] <= enemies[enemies.length-1]) {
            enemies[enemies.length-1]--;
            max++;
            Arrays.sort(enemies);
        }
//        Integer[] bigvote = new Integer[votes.length];
//        for (int k = 0; k < votes.length; k++) {
//            bigvote[k] = votes[k];
//        }
//        Arrays.sort(bigvote, Collections.reverseOrder());
//        for (int k = 0; k < votes.length; k++) {
//
//        }
        return max;
    }
}
