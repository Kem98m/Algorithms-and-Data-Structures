import java.util.*;

public class PercolationUF implements IPercolate{

    private IUnionFind myFinder;
    private int[][] myGrid;
    //private final int VTOP;
    //private final int VBOTTOM;
    private int myOpenCount;

    /**
     *
     * @param finder is the object from the IPercolate interface to keep
     *               track of open and full cells
     * @param size the size of the grid which is equivalent to myGrid.length
     *
     *             A grid is initialized and blocked. The IUnionFind is
     *             initialized and the variables are set.
     */
    public PercolationUF(IUnionFind finder, int size) {
        myGrid = new int[size][size];
        myOpenCount = 0;
        for (int[] row : myGrid)
            Arrays.fill(row, BLOCKED);
        finder.initialize(size*size+2);
        myFinder = finder;
    }

    /**
     *
     * @param row
     *            row index in range [0,N-1]
     * @param col
     *            col index in range [0,N-1]
     *
     *            Using myFinder, the open cells are connected
     *            together and checked if they are connected to
     *            VTOP or VBOTTOM
     */
    @Override
    public void open(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        if (myGrid[row][col] != BLOCKED) return;
        myOpenCount += 1;
        myGrid[row][col] = OPEN;
        if (row == 0) {
            myFinder.union(row*myGrid.length+col, myGrid.length*myGrid.length);
        }
        if (row == myGrid.length-1) {
            myFinder.union(row*myGrid.length+col, myGrid.length*myGrid.length+1);
        }
        if (inBounds(row-1, col) && isOpen(row-1, col)) {
            myFinder.union(row*myGrid.length+col, (row-1)*myGrid.length+col);
        }
        if (inBounds(row+1, col) && isOpen(row+1, col)) {
            myFinder.union(row*myGrid.length+col, (row+1)*myGrid.length+col);
        }
        if (inBounds(row, col-1) && isOpen(row, col-1)) {
            myFinder.union(row*myGrid.length+col, (row)*myGrid.length+(col-1));
        }
        if (inBounds(row, col+1) && isOpen(row, col+1)) {
            myFinder.union(row*myGrid.length+col, (row)*myGrid.length+(col+1));
        }
        //updateOnOpen(row,col);
    }

    /**
     *
     * @param row
     *            row index in range [0,N-1]
     * @param col
     *            col index in range [0,N-1]
     * @return boolean
     *            whether or not the cell is open
     */
    @Override
    public boolean isOpen(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        return myGrid[row][col] != BLOCKED;
    }

    /**
     *
     * @param row
     *            row index in range [0,N-1]
     * @param col
     *            col index in range [0,N-1]
     * @return boolean
     *            whether or not the cell is Full by
     *            checking if it connects to VTOP
     */
    @Override
    public boolean isFull(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        if (myFinder.connected((row*myGrid.length+col), myGrid.length*myGrid.length)){
            return true;
        }
        return false;
    }

    /**
     *
     * @return boolean
     *              whether or not VTOP and VBOTTOM connect
     */
    @Override
    public boolean percolates() {
        if(myFinder.connected(myGrid.length*myGrid.length, myGrid.length*myGrid.length+1)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @return myOpenCount
     *              # of cells opened
     */
    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }

    /**
     *
     * @param row
     *              row index in range [0,N-1]
     * @param col
     *              col index in range [0,N-1]
     *
     * @return boolean
     *              whether the cell is valid aka within the grid
     */
    protected boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }
}
