import java.util.*;

public class PrefixCode {
    public String isOne(String[] words) {
        if (words.length == 1) {
            return "Yes";
        }
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (s.length()>t1.length()) {
                    return 1;
                }
                else if (s.length()<t1.length()) {
                    return -1;
                }
                return 0;
            }
        });
        int counter = 0;
//        for (int k = 0; k < list.size(); k++) {
//            for (int j = 1; j < list.size(); j++) {
//                int sum = 0;
//                for (int i = 0; i < list.get(k).length();i++) {
//                    if (list.get(k).charAt(i) - list.get(j).charAt(i) != 0) {
//                        sum = sum + list.get(k).charAt(i) - list.get(j).charAt(i);
//                    }
//                }
//                if (sum == 0) {
//                    counter ++;
//                }
//            }
//        }
//        if (counter != 0) {
//            return "No, " + counter;
//        }
//        else {
//            return "Yes";
//        }
        return list.toString();
    }
}