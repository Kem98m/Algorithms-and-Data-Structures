

public class PercolationDFSFast extends PercolationDFS{
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationDFSFast(int n) {
        super(n);
    }

    /**
     *          This Override checks whether the cell is in the top row or next
     *          to a full cell before calling dfs
     *
     * @param row
     *              is the row coordinate of the cell being checked/marked
     * @param col
     *              is the col coordinate of the cell being checked/marked
     */
    @Override
    protected void updateOnOpen(int row, int col) {

        if (row == 0 && myGrid[row][col] != FULL) {
            dfs(row, col);
            return;
        }
        if (inBounds(row-1,col)){
            if (myGrid[row-1][col] == FULL) { //&& myGrid[row][col] != FULL && myGrid[row][col] == OPEN) {
                dfs(row, col);
                return;
            }
        }
        if (inBounds(row,col-1)) {
            if (myGrid[row][col-1] == FULL) { // && myGrid[row][col] != FULL && myGrid[row][col] == OPEN) {
                dfs(row, col);
                return;
            }
        }
        if (inBounds(row,col+1)) {
            if (myGrid[row][col+1] == FULL) { // && myGrid[row][col] != FULL && myGrid[row][col] == OPEN) {
                dfs(row, col);
                return;
            }
        }
        if (inBounds(row+1,col)) {
            if (myGrid[row+1][col] == FULL) { //  && myGrid[row][col] != FULL && myGrid[row][col] == OPEN) {
                dfs(row, col);
                return;
            }
        }
    }
}
