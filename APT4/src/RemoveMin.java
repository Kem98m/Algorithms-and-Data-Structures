public class RemoveMin {
    public ListNode remove (ListNode list) {
        ListNode min = list;
        ListNode first = list;
        while (list != null) {
            if (list.info <min.info) {
                min = list;
                list = list.next;
            }
            else {
                list = list.next;
            }
        }
        list = first;

        while (list != null) {
            if (list.info == min.info) {
                first = list.next;
                return first;
            }
            else if (list.next.info == min.info) {
                list.next = list.next.next;
                return first;
            }
            else {
                list = list.next;
            }
        }
        return null;
    }

}