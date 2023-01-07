import java.lang.reflect.Array;
import java.util.*;

public class MemberCheck {
    public String[] whosDishonest(String[] club1,
                                  String[] club2,
                                  String[] club3) {

        HashSet<String> patclub1 = new HashSet<>(Arrays.asList(club1));
        HashSet<String> patclub2 = new HashSet<>(Arrays.asList(club2));
        HashSet<String> patclub3 = new HashSet<>(Arrays.asList(club3));

        HashSet<String> dishonest = new HashSet<>();
        //System.out.println(patclub1);

        String[] truedishonest = new String[dishonest.size()];

        for (String s : patclub1) {
            if (patclub2.contains(s)) {
                dishonest.add(s);
            }
            if (patclub3.contains(s)) {
                dishonest.add(s);
            }
        }
        for (String t : patclub2) {
            if (patclub3.contains(t)) {
                dishonest.add(t);
            }
        }
        //System.out.println(dishonest);
        truedishonest = dishonest.toArray(truedishonest);
        Arrays.sort(truedishonest);
        return truedishonest;

    }
}