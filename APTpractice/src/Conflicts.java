import java.util.*;

import static java.lang.System.arraycopy;

public class Conflicts {
    public String[] conflict(String[] info){
        // write code here
        HashMap<String, String[]> map = new HashMap<>();
        TreeSet<String> rooms = new TreeSet<>(); // where everything gets added
        for (String str : info) {
            //str = str.toLowerCase();        //everything is lowercase
            String[] words = str.split(":");
            String[] array = Arrays.copyOfRange(words, 0, words.length);
            String[] currenttimes = words[2].split(",");
            //if (!map.containsKey(words[1]))


            if (!map.containsKey(words[1])) {
                map.put(words[1], array);
            }
            else if (!map.get(words[1]).equals(array)){
                String[] array1 = map.get(words[1]);
                String[] times = array1[2].split(","); //what's in the map
                for (String s : times) {
                    if (Arrays.asList(currenttimes).contains(s)) {
                        rooms.add(words[1]);
                    }
                }

            }
        }

        // sort rooms in the end
        return rooms.toArray(new String[0]);
    }
}