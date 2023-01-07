import java.util.Arrays;

public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {

        int maxnuc = 0;
        String maxstrand = "";

        for (int k = 0; k < strands.length; k += 1) {
            int nuccount = 0;
            String strcount = "";
            for (int j = 0; j < strands[k].length(); j += 1) {

                if ((strands[k].charAt(j) + "").equals(nuc)) {
                    nuccount++;
                }

            }
            if (nuccount > maxnuc) {
                maxnuc = nuccount;
                maxstrand = strands[k];
            }
            else if (maxnuc == nuccount && strands[k].length() > maxstrand.length() && ! maxstrand.equals("")) {
                maxstrand = strands[k];
            }



        }
        return maxstrand;
    }

}




