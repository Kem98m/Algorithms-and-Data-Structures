import java.util.*;

public class Encryption {
    public String encrypt(String message){
        // you write code here
        //Character[] msg = new Character[message.length()];
        String[] letters = message.split("");
        //int[] values = new int[255];
        ArrayList<String> used = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for ( int k=0; k<letters.length; k++) {
            if (!used.contains(letters[k])) {
                used.add(letters[k]);
                sb.append((char) ('a'+counter));
                counter ++;
            }
            else {
                int index = used.indexOf(letters[k]);
                sb.append((char) ('a'+index));

            }

        }

        return sb.toString();
    }
}