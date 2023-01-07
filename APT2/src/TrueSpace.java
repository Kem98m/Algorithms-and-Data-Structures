import java.util.*;

public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        int Totalwaste = 0;
        for (int k = 0; k < sizes.length; k++) {
            int currentwaste = 0;
            while (currentwaste<sizes[k] && sizes[k] != 0) {
                currentwaste = currentwaste + clusterSize;
            }
            //currentwaste = currentwaste + clusterSize*count;
            /*
            if (sizes[k] % clusterSize != 0 && sizes[k] != 0) {
                currentwaste = currentwaste + clusterSize;
            }

             */
            Totalwaste = Totalwaste + currentwaste;
        }
        return Totalwaste;
    }
}
