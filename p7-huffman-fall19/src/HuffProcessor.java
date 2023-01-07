import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Although this class has a history of several years,
 * it is starting from a blank-slate, new and clean implementation
 * as of Fall 2018.
 * <P>
 * Changes include relying solely on a tree for header information
 * and including debug and bits read/written information
 * 
 * @author Owen Astrachan
 */

public class HuffProcessor {

	public static final int BITS_PER_WORD = 8;
	public static final int BITS_PER_INT = 32;
	public static final int ALPH_SIZE = (1 << BITS_PER_WORD); 
	public static final int PSEUDO_EOF = ALPH_SIZE;
	public static final int HUFF_NUMBER = 0xface8200;
	public static final int HUFF_TREE  = HUFF_NUMBER | 1;

	private final int myDebugLevel;
	
	public static final int DEBUG_HIGH = 4;
	public static final int DEBUG_LOW = 1;
	
	public HuffProcessor() {
		this(0);
	}
	
	public HuffProcessor(int debug) {
		myDebugLevel = debug;
	}

	/**
	 * Compresses a file. Process must be reversible and loss-less.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be compressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */
	public void compress(BitInputStream in, BitOutputStream out){
		int[] ret = new int[ALPH_SIZE+1];


		for (int k = 0; k <ret.length; k++) {
			ret[k] = 0;
		}
//		HuffNode root = makeTreeFromCounts(counts);
//		String[] codings = makeCodingsFromTree(root);
//
//		out.writeBits(BITS_PER_INT, HUFF_TREE);
//		writeHeader(root, out);
//		in.reset();
//		writeCompressedBits(codings, in, out);
		while (true) {
			int val = in.readBits(BITS_PER_WORD);
			if (val == -1) {
				break;
			}
			//out.writeBits(BITS_PER_WORD, val);

			ret[val]++;

		}
		ret[PSEUDO_EOF] = 1;
		//PriorityQueue<Node> pq = new PriorityQueue<Node>()
		int[] counts = ret;
		PriorityQueue<HuffNode> pq = new PriorityQueue<>();
		for (int k = 0; k <counts.length; k++) {
			if (counts[k] > 0) {
				pq.add(new HuffNode(k, counts[k], null, null));
			}
		}
		while(pq.size()>1) {
			HuffNode left = pq.remove();
			HuffNode right = pq.remove();
			HuffNode tree = new HuffNode(0, left.myWeight + right.myWeight, left, right);
			pq.add(tree);
		}
		HuffNode root = pq.remove();
		String[] encode = new String[ALPH_SIZE+1];
		encoder(root, "", encode);
		String[] codings = encode;
		out.writeBits(BITS_PER_INT, HUFF_TREE);
		find(root, out);
		in.reset();


		while (true) {
			int val = in.readBits(BITS_PER_WORD);
			if (val == -1) {
				String code = codings[PSEUDO_EOF];
				out.writeBits(code.length(), Integer.parseInt(code, 2));
				break;
			}


			String code = codings[val];
			int bits = Integer.parseInt(code, 2);
			out.writeBits(code.length(), bits);
		}
		out.close();
	}

	private void find(HuffNode root, BitOutputStream out) {
		if (root.myLeft == null && root.myRight == null) {
			out.writeBits(1,1);
			out.writeBits(BITS_PER_WORD+1, root.myValue);
		}
		else {
			out.writeBits(1,0);
			if (root.myLeft != null) {
				find(root.myLeft, out);
			}
			if (root.myRight != null) {
				find(root.myRight, out);
			}
		}
	}

	private void encoder(HuffNode root, String path, String[] encode) {
		if (root.myRight == null && root.myLeft == null) {
			encode[root.myValue] = path;
			return;
		}
		else {
			if (root.myLeft != null) {
				encoder(root.myLeft, path + "0", encode);
			}
			if (root.myRight != null) {
				encoder(root.myRight, path + "1", encode);
			}
		}
	}

//	private int[] readForCounts(BitInputStream in) {
//		String mystr = new String(String.valueOf(in));
////		return mystr.length();
//		int[] array = new int[0];
//		return array;
//	}

	/**
	 * Decompresses a file. Output file must be identical bit-by-bit to the
	 * original.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be decompressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */
	public void decompress(BitInputStream in, BitOutputStream out){

		int magic = in.readBits(BITS_PER_INT);
		if (magic != HUFF_TREE) {
			throw new HuffException("invalid magic number "+magic);
		}
		HuffNode root = readTree(in);
		HuffNode current = root;
		//out.writeBits(BITS_PER_INT,magic);
		while (true) {
			int val = in.readBits(1);
			if (val == -1) {
				throw new HuffException("Invalid Input");
			}
			else if (val == 0) {
				current = current.myLeft;
			}
			else if (val == 1) {
				current = current.myRight;
			}
			if (Objects.isNull(current.myLeft) && Objects.isNull(current.myRight)) {
				if(current.myValue == PSEUDO_EOF) {
					break;
				}
				else {
					out.writeBits(BITS_PER_WORD, current.myValue);
					current = root;
				}
			}
		}
		out.close();
	}

	private HuffNode readTree(BitInputStream in) {
		int bit = in.readBits(1);
		if (bit == -1) {
			throw new HuffException("End of Stream");
		}
		if (bit == 0) {
			HuffNode left = readTree(in);
			HuffNode right = readTree(in);
			return new HuffNode(0, 0, left, right);
		}
		else {
			int value = in.readBits(BITS_PER_WORD + 1);
			return new HuffNode(value, 0, null, null);
		}
	}
}