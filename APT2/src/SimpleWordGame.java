import java.util.*;

public class SimpleWordGame {
    public int points(String[] player,
                      String[] dictionary) {
        HashSet<String> playerset = new HashSet<>(Arrays.asList(player));
        List<String> newplayer = new ArrayList<>(playerset);
        String[] playerarray = new String[newplayer.size()];
        playerarray = newplayer.toArray(playerarray);
        int currentpoints = 0;
        for (int k = 0; k<newplayer.size(); k++) {
            if (Arrays.asList(dictionary).contains(playerarray[k])) {
                currentpoints = currentpoints + playerarray[k].length()*playerarray[k].length();
            }
        }
        return currentpoints;
    }
}