public class ListCount {
    public int count (ListNode list) {
        int counter = 0;
        while (list != null) {
            counter ++;
            list = list.next;
        }
        return counter;
    }
}