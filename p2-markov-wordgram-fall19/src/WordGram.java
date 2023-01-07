import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Kenneth Marenco
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;
		// TODO: initialize all instance variable
		int counter = 0;
		for (int k = start; k < source.length; k++) {
			if (counter<size) {
				myWords[counter] = source[k];
				counter += 1;
			}
		}
		//myWords = source; // from start! to end
		StringBuilder sb = new StringBuilder();
		for (String str : myWords) {
			sb.append(str + " ");
		}
		String mystring = sb.toString().substring(0, sb.toString().length() - 1);
		myToString = mystring; // combine the strings in the array
		myHash = hashCode();
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return the length of the myWords
	 */
	public int length(){
		// TODO: change this ....done
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		// TODO: Complete this method
		WordGram wg = (WordGram) o;
		int counter = 0;
		for (int k= 0; k< myWords.length; k++) {
			if (myWords[k].equals(((WordGram) o).wordAt(k))) {
				counter ++;
			}
		}
		if (counter == myWords.length) {
			return true;
		}
		else {
			return false;
		}
//
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		return this.toString().hashCode();
		// hashcode for loop to make sure each array gets multiplied by a unique number to
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		//WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		String[] lastwords = new String[myWords.length];
		for (int k=0; k < myWords.length-1; k++) {
			lastwords[k] = myWords[k+1];
		}
		lastwords[myWords.length-1] = last;
		WordGram wg = new WordGram(lastwords, 0, myWords.length);
		//remove the first element and shift to add d in the end
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method
		StringBuilder sb = new StringBuilder();
		for (String str : myWords) {
			sb.append(str + " ");
		}
		String mystring = sb.toString().substring(0, sb.toString().length() - 1);
		myToString = mystring; // combine the strings in the array
		return myToString;
	}

}
