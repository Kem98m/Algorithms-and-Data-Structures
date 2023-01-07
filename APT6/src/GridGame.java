import java.util.*;

public class GridGame {
    public int winningMoves(String[] grid){
//        for (int k = 0; k<grid.length; k++) {
//            for (int j = 0; j<grid.length; j++) {
//
//            }
//        }
        return 0;
    }

    private int winCount(char[][] board) {
        int count = 0;
        for(int r=0; r<4; r++) {
            for(int c=0; c<4; c++) {
                if (isMoveLegal(board, r, c)) {
                    board[r][c] = 'X';
                    int opponentCount = winCount(board);
                    if (opponentCount == 0) {
                        count += 1;
                    }
                    board[r][c] = '.';
                }
            }
        }
        return count;
    }

    private boolean isMoveLegal(char[][] board, int r, int c) {
        if (board[r][c+1] == 'X') {
            return false;
        }
        if (board[r][c-1] == 'X') {
            return false;
        }
        if (board[r+1][c] == 'X') {
            return false;
        }
        if (board[r-1][c] == 'X') {
            return false;
        }
        if (board[r][c] == 'X') {
            return false;
        }
        return true;
    }
}