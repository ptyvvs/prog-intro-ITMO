package game;

import java.util.Arrays;

public class Board implements Position {


    private final Cell[][] cells;
    private Cell turn;
    int  m, n, k;

    public Board(int m, int n, int k) {
        this.m = m;
        this.k = k;
        this.n = n;
        cells = new Cell[n][m];
        for (int i = 0; i < n; i++) {
                Arrays.fill(cells[i], Cell.E);
        }
        turn = Cell.X;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < m; i++) {
            sb.append(i + 1);
        }
        sb.append('\n');
        for (int i = 0; i < n; i++) {
            sb.append(i + 1);
            for (Cell cell : cells[i]) {
                if (cell == Cell.E) {
                    sb.append('.');
                } else {
                    sb.append(cell);
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public Cell getTurn() {
        return turn;
    }

    @Override
    public Cell get(int row, int col) {
        return cells[row][col];
    }

    @Override
    public boolean isValid(Move move) {
        return 0 <= move.getRow() && move.getRow() < n && 0 <= move.getCol() && move.getCol() < m
                && get(move.getRow(), move.getCol()) == Cell.E && move.getValue() == turn
                && move.getRow() % 1 == 0 && move.getCol() % 1 == 0;
    }

    public Result makeMove(final Move move) {
        if (!isValid(move)) {
            return Result.LOSE;
        }
        cells[move.getRow()][move.getCol()] = move.getValue();
        int empty = 0;
        int [] dx = {1, 0, 1, 1};
        int [] dy = {0, 1, 1, -1};
        int [] res = {0, 0, 0, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < 4; l++) {
                    if (get(i,j) == turn) {
                        if ( i + dx[l] < n || j + dy[l] < m  || j + dy[l] >= 0
                                || get(i + dx[l], j + dy[l]) == turn) {
                            res[l]++;
                            if (res[l] == k) {
                                return Result.WIN;
                            }
                        } else {
                            res[l] = 0;
                        }
                    } else if (get(i,j) == Cell.E) {
                        empty++;
                    }
                }
                
            }
            
        }
        if (empty == 0) {
            return Result.DRAW;
        }
        turn = turn == Cell.X ? Cell.O : Cell.X;
        return Result.UNKNOWN;
    }
}
