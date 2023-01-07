import java.util.*;

public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        String maxaccess = "";
        for(int k = 0; k < rights.length; k += 1) {
            if (minPermission <= rights[k]) {
                maxaccess += "A";
            }
            else maxaccess += "D";
        }
        return maxaccess;
    }
}