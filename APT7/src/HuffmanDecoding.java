import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary) {
        HashMap<String, String> map = new HashMap<>();
        //ArrayList<String> list = new ArrayList<>();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder rest = new StringBuilder();
        char alpha = 'A';
        for (String defs: dictionary) {
            //list.add(defs);
//            map.putIfAbsent(defs, (char)'A'+counter)
            map.put(defs, Character.toString(alpha));
            alpha++;
        }

        String[] file = archive.split("");
        for (int index = 0; index < file.length ; index++) {//String defs : list) {
            //int size = defs.length();
            rest.append(file[index]);
            if (map.containsKey(rest.toString())) {
                sb.append(map.get(rest.toString()));
                rest = new StringBuilder();
            }
//            String letter = archive.substring(0, size);
//            if (defs.equals(letter)) {
//                //map.put(defs, )
//
        }
        return sb.toString();
    }
}
