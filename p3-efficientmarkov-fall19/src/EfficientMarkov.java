import java.util.*;

public class EfficientMarkov extends BaseMarkov {

	private Map<String,ArrayList<String>> myMap;

	/**
	 *
	 * @param order
	 * Initialize myMap and extend the order methods from
	 * BaseMarkov
	 */
	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	/**
	 * Default constructor has order 3
	 */
	public EfficientMarkov() {
		this(3);
	}

	/**
	 *
	 * @param key
	 * @return the ArrayList that is created unless none was made
	 */
	@Override
	public ArrayList<String> getFollows(String key){
		if (!myMap.containsKey(key)) {
			throw new NoSuchElementException(key+ " not in map");
		}
		return myMap.get(key);
	}

	/**
	 *
	 * @param text is the txt file that it reads
	 *        move through txt to find all myOrder grams
	 *        and add them to ArrayList if not already there
	 */
	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();
		//System.out.println("help me");
		for (int index = 0; index < text.length() - myOrder + 1; index++) {
			//System.out.println("I am stuck");
			String key = myText.substring(index, index+myOrder);
			ArrayList<String> list = new ArrayList<String>();
			if (myMap.containsKey(key)) {
				if(index != text.length() - myOrder) {
					String nextchar = myText.substring(index + myOrder, index+myOrder+1);
					myMap.get(key).add(nextchar);
				}
				else {
					myMap.get(key).add(PSEUDO_EOS);
				}
			}
			else {
				if(index != text.length() - myOrder) {
					String nextchar = myText.substring(index + myOrder, index+myOrder+1);
					list.add(nextchar);
					myMap.put(key, list);
				} else {
					list.add(PSEUDO_EOS);
					myMap.put(key, list);
				}

			}
		}
	}
}	
