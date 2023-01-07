import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedList {
    public ListNode create(String[] words) {
        ArrayList<String> samewords = new ArrayList<>();
        Collections.addAll(samewords, words);
        ArrayList<String> mywords = new ArrayList<>();
        Collections.addAll(mywords, words);
        Collections.sort(mywords);
        int[] index = new int[words.length];
        for (int j = 0; j< mywords.size(); j++) {
            for (int k = 0; k<words.length; k++) {
                if (mywords.get(j).equals(words[k])) {
                    index[j] = samewords.indexOf(words[k]);
                }
            }
        }
        ListNode list = new ListNode(index[0]);
        ListNode first = list;
        for (int k = 1; k<words.length; k++) {
            ListNode temp = new ListNode(index[k]);
            list.next = temp;
            list = list.next;
        }
        return first;
    }
}