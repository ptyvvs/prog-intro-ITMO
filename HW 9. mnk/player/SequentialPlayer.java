package game.player;

import game.*;

public class SequentialPlayer implements Player {
    private int m, n;
    public SequentialPlayer(int m, int n, int k) {
        this.m = m;
        this.n = n;
    }

    @Override
    public Move makeMove(Position position, Cell cell) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col ++) {
                final Move move = new Move(row, col, cell);
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new AssertionError("No empty cells");
    }
}
