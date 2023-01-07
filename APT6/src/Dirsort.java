import java.util.*;

public class Dirsort {
    public String[] sort(String[] dirs) {
        Arrays.sort(dirs, new DirComp());
        return dirs;
    }

    public class DirComp implements Comparator<String> {


        @Override
        public int compare(String a, String b) {
            String[] arr = a.split("/");
            String[] brr = b.split("/");
            int small = Math.min(arr.length, brr.length);
            if (arr.length < brr.length) {
                return -1;
            }
            if (arr.length > brr.length) {
                return 1;
            }
            for (int k = 0; k<small; k++) {
                if (arr[k].compareTo(brr[k]) != 0) {
                    return arr[k].compareTo(brr[k]);
                }
            }

//            for (int k = 0; k<small; k++) {
//                if (arr[k] - brr[k] < 0) {
//                    return -1;
//                }
//                else if (a.charAt(k) - b.charAt(k) > 0) {
//                    return 1;
//                }
//            }
//
//            if (arr.length < brr.length) {
//                return -1;
//            }
//            if (arr.length > brr.length) {
//                return 1;
//            }
            return 0;
        }

    }
}
