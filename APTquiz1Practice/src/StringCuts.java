import java.util.*;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        // replace this with your code
        HashSet<String> modlist = new HashSet<>(Arrays.asList(list));
        List<String> results = new List;
        for (String str : modlist) {
            if (str.length() >= minLength) {
                Arrays.asList(results).add(str);
            }
        }
        return results;
    }
}