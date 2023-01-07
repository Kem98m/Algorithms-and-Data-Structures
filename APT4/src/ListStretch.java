public class ListStretch {
    public ListNode stretch (ListNode list, int amount){

        ListNode first = list;
        while (list != null) {

            for (int k = 1; k<amount; k++) {
                ListNode temp = new ListNode(list.info);
                temp.next = list.next;
                list.next = temp;

            }
            for (int j = 0; j<amount;j++) {
                list = list.next;
            }
        }

        return first;
    }
}