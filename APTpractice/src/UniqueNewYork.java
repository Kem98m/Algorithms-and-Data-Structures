import java.util.*;

public class UniqueNewYork {
    public int seen(String[] records) {
        HashSet<String> plates = new HashSet<>();

        for (String str : records) {
            String[] words = str.split(",");
            plates.addAll(Arrays.asList(words));
        }


        return plates.size(); //replace with your code
    }
}