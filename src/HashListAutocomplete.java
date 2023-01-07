import java.util.*;

public class HashListAutocomplete implements Autocompletor {
    /**
     * Global variables
     *  MAX_PREFIX is the max length a prefx can be
     *  myMap is the map used to store the prefix keys
     *  myTerms is the array of terms used to populate the map
     *  mySize is the amount of storage used
     */
    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;
    private Term[] myTerms;

    public HashListAutocomplete(String[] terms, double[] weights) {
        if (terms == null || weights == null) {
            throw new NullPointerException("One or more arguments null");
        }

        initialize(terms,weights);
    }
    /**
     *
     * @param prefix
     *           - A prefix which all returned words must start with
     * @param k
     * 	         - The (maximum) number of words to be returned
     * @return list
     *          - the list of size k that are the most weighted terms
     */
    @Override
    public List<Term> topMatches(String prefix, int k) {
        if (k<0 ) {
            throw new IllegalArgumentException();
        }
        if (k== 0) {
            return new ArrayList<Term>();
        }
        if (prefix == null) {
            throw new IllegalArgumentException();
        }
        if (MAX_PREFIX < prefix.length()) {
            prefix = prefix.substring(0, MAX_PREFIX);
        }
        if (!myMap.containsKey(prefix)) {
            return new ArrayList<Term>();
        }
        List<Term> all = myMap.get(prefix);
        List<Term> list = all.subList(0, Math.min(k, all.size()));
        return list;


//        if (myMap.get(prefix) != null && k != 0) {
//            if (MAX_PREFIX < prefix.length()) {
//                prefix = prefix.substring(0, MAX_PREFIX);
//                if (!myMap.containsKey(prefix)) {
//                    return new ArrayList<Term>();
//                }
//                else {
//                    List<Term> all = myMap.get(prefix);
//                    List<Term> list = all.subList(0, Math.min(k, all.size()));
//                    return list;
//                }
//            }
//            else {
//                List<Term> all = myMap.get(prefix);
//                List<Term> list = all.subList(0, Math.min(k, all.size()));
//                return list;
//            }
//        }
//        else {
//            return null;
//        }
    }

    /**
     *
     * @param terms is array of Strings for words in each Term
     * @param weights is corresponding weight for word in terms
     *        The map is populated with the terms and weights
     *                found in the terms array
     *
     */
    @Override
    public void initialize(String[] terms, double[] weights) {
        myTerms = new Term[terms.length];
        myMap = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            myTerms[i] = new Term(terms[i], weights[i]);
            int newprefix = myTerms[i].getWord().length();
            if (newprefix < MAX_PREFIX) {
                for (int j = 0; j< newprefix +1; j++) {
                    String newword = terms[i].substring(0, j);
                    myMap.putIfAbsent(newword, new ArrayList<Term>());
                    myMap.get(newword).add(myTerms[i]);
                }
            }
            else {
                for (int k = 0; k< MAX_PREFIX+1; k++) {
                    String newword = terms[i].substring(0, k);
                    myMap.putIfAbsent(newword, new ArrayList<Term>());
                    myMap.get(newword).add(myTerms[i]);
                }
            }
        }
        for (String str : myMap.keySet()) {
            Collections.sort(myMap.get(str),Comparator.comparing(Term::getWeight).reversed());
        }
        mySize = 0;
    }

    /**
     *
     * @return mySize
     *              - The amount of storage used to store the map with its terms
     */
    @Override
    public int sizeInBytes() {
        if (mySize == 0) {
            for(Term t : myTerms) {
                //mySize += BYTES_PER_CHAR*t.getWord().length() ;
                mySize += BYTES_PER_CHAR*t.getWord().length() + BYTES_PER_DOUBLE;
            }
            for(String str : myMap.keySet()) {
                mySize += BYTES_PER_CHAR*str.length();
            }
        }
        return mySize;
    }
}
