public class ListSum {
    public int sum(ListNode list, int thresh) {
        int sum = 0;
        if (list == null) {
            return 0;
        }
        else {
            while (list != null) {
                if (list.info > thresh) {
                    sum = sum + list.info;
                    list = list.next;
                } else {
                    list = list.next;
                }
            }
            return sum;
        }
    }
}