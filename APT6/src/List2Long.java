import java.util.*;

public class List2Long {
    public long convert(ListNode list) {
        if (list == null) {
            return 0;
        }
        long num = 0;
        num = list.info;
        list = list.next;
        while (list!=null) {
            num = num*10 + list.info;
            list = list.next;
        }
        return num;
    }
}