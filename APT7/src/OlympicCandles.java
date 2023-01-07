import java.util.*;

public class OlympicCandles{
    public int numberOfNights(int[] candles){

        int counter = 1;
        if (candles.length == 0) {
            return 0;
        }
        if (candles.length == 1) {
            return 1;
        }
        while(true) {
            Arrays.sort(candles);
            for (int k = 0; k < counter; k++) {
                int index = candles.length - 1 - k;
                if (index < 0 || candles[index] == 0) {
                    return counter - 1;
                }
                else {
                    candles[index]--;
                }
            }
            counter++;
        }

//        ArrayList<Integer> list = new ArrayList<>();
//        for (int k = 0; k < candles.length; k++) {
//            list.add(candles[k]);
//        }
////        Collections.sort(list, Collections.reverseOrder());
//        if (candles.length == 0) {
//            return 0;
//        }
//        if (candles.length == 1) {
//            return 1;
//        }
//        for (int i = 1; i < candles.length; i++) {
//            list = new ArrayList<>();
//            for (int k = 0; k < candles.length; k++) {
//                list.add(candles[k]);
//            }
//            Collections.sort(list, Collections.reverseOrder());
//            for (int k = 0; k < candles.length; k++) {
//                candles[k] = list.get(k);
//            }
//            for (int j = 0; j < i; j++) {
//                if (j >= candles.length-1 || candles[j] == 0) {
//                    return i-1;
//                }
//                candles[j]--;
//            }
//        }
//        return 0;
    }
}