public class DoubleList {
    public ListNode bigify(ListNode list) {
        // replace statement below with code you write
        ListNode first = list;
        while (list != null) {
            ListNode temp = new ListNode(list.info);
            temp.next = list.next;
            list.next = temp;
            list = temp.next;
        }

        return first;
    }
}
