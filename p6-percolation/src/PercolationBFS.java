import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {
        super(n);
    }

    @Override
    protected void dfs(int row, int col) {
        // out of bounds?
        if (! inBounds(row,col)) return;
        // full or NOT open, don't process
        if (isFull(row, col) || !isOpen(row, col))
            return;

       // int[] rowDelta = {-1,1,0,0};
       // int[] colDelta = {0,0,-1,1};
        Queue<Integer> qp = new LinkedList<>();
        myGrid[row][col] = FULL;
        Integer value = row*myGrid.length+col;
        int size = myGrid.length;
        qp.add(value);
        while (qp.size() != 0) {
            int p = qp.remove();
            //for(int k =0; k< rowDelta.length;k++) {
                //qp.remove();
                if(inBounds((p/size)-1, (p%size)) && isOpen((p/size)-1, (p%size)) && myGrid[(p/size)-1][(p%size)] != FULL) {
                    myGrid[((p/size)-1)][p%size] = FULL;
                    value = ((p/size)-1)*size+(p%size);
                    qp.add(value);
                }
                if(inBounds((p/size)+1, (p%size)) && isOpen((p/size)+1, (p%size)) && myGrid[(p/size)+1][(p%size)] != FULL) {
                    myGrid[(p/size)+1][p%size] = FULL;
                    value = ((p/size)+1)*size+(p%size);
                    qp.add(value);
                }
                if(inBounds((p/size), (p%size)-1) && isOpen((p/size), (p%size)-1) && myGrid[(p/size)][(p%size-1)] != FULL) {
                    myGrid[p/size][(p%size)-1] = FULL;
                    value = ((p/size))*size+((p%size)-1);
                    qp.add(value);
                }
                if(inBounds((p/size), (p%size)+1) && isOpen((p/size), (p%size)+1) && myGrid[(p/size)][(p%size+1)] != FULL) {
                    myGrid[p/size][(p%size)+1] = FULL;
                    value = ((p/size))*size+((p%size)+1);
                    qp.add(value);
            //    }
            }
        }

    }
}
