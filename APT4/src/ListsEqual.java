public class ListsEqual {
    public int equal (ListNode a1, ListNode a2) {
        int countera1 = 1;
        int countera2 = 1;

        while (a1 != null) {
            countera1 ++;
            a1 = a1.next;
        }
        while (a2 != null) {
            countera2 ++;
            a2 = a2.next;
        }
        if (countera1 != countera2) {
            return 0;
        }

        int flag = 1;

        while (a1 != null) {
            if (a1.info != a2.info) {
                return 0;
            }
            if (a1.next != null) {
                a1 = a1.next;
                a2 = a2.next;
            }
        }
        return flag;
    }
}