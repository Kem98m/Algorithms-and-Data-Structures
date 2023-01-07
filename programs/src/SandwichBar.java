import java.util.Arrays;

public class SandwichBar {
    public int whichOrder(String[] available, String[] orders){
        for(int k = 0; k < orders.length; k += 1) {
            String sandwich = orders[k];
            if (canMake(available,sandwich) == true) {
                return k;
            }
        }
        return -1;
    }

    private boolean canMake(String[] available, String sandwich) {
        String[] all = sandwich.split(" ");
        for (String one : all) {
            if (!Arrays.asList(available).contains(one)) {
                return false;
            }
        }
        return true;
    }
}