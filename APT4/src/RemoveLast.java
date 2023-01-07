public class RemoveLast {
    public ListNode remove(ListNode list) {
        ListNode preLast = list;
        if (list == null) {
            return null;
        }
        else {
            while (preLast.next.next != null) {
                preLast = preLast.next;
            }
            preLast.next = null;
            return list;
        }
    }
}
