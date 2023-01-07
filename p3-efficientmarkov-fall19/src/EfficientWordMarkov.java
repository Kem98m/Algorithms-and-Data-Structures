import java.util.*;

/**
 * Similar to BaseMarkov, but uses WordGram objects instead of String
 * objects to generate random text.
 *
 * @author Kenneth Marenco (kem78)
 *
 */
public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram,ArrayList<String>> myMap;

    /**
     * default order of the wordgram markov is 2
     */
    public EfficientWordMarkov() {
        this(2);
    }

    /**
     *
     * @param order changes the order of the
     *              wordgram markov and initializes
     *              the map
     */

    public EfficientWordMarkov(int order){
        super(order);
        myMap = new HashMap<>();
    }

    /**
     *
     * @param text is the text file that gets broken up
     *             and turned into a string array for
     *             wordgrams as it reads
     *             move through txt to find all myOrder grams
     * 	           and add them to ArrayList if not already there
     */
    @Override
    public void setTraining(String text){
        myWords = text.split("\\s+");
        myMap.clear();
        //System.out.println("help me");
        for (int index = 0; index < myWords.length - myOrder + 1; index++) {
            //System.out.println("I am stuck");
            WordGram key = new WordGram(myWords, index, myOrder);
            ArrayList<String> list = new ArrayList<String>();
            if (myMap.containsKey(key)) {
                if(index != myWords.length - myOrder) {
                    String nextword = myWords[index+myOrder];
                    myMap.get(key).add(nextword);
                }
                else {
                    myMap.get(key).add(PSEUDO_EOS);
                }
            }
            else {
                if(index != myWords.length - myOrder) {
                    String nextword = myWords[index+myOrder];
                    list.add(nextword);
                    myMap.put(key, list);
                    //System.out.println(key);
                } else {
                    list.add(PSEUDO_EOS);
                    myMap.put(key, list);
                }

            }
        }

    }

    /**
     *
     * @param key is the wordgram created in the set training method
     * @return returns the string ArrayList unless the key was not found
     */
    @Override
    public ArrayList<String> getFollows(WordGram key){
        if (!myMap.containsKey(key)) {
            //System.out.println(key);
            throw new NoSuchElementException(key+ " not in map");
        }
        return myMap.get(key);
    }
}