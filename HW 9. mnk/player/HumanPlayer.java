package game.player;

import game.Cell;
import game.Move;
import game.Player;
import game.Position;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(final Scanner in) {
        this.in = in;
    }

    public HumanPlayer() { this(new Scanner(System.in)); }

    @Override
    public Move makeMove(Position position, Cell cell) {
        while (true) {
                System.out.println("Current position:");
                System.out.println((position.toString()));
                System.out.println("Enter" + cell + "'s turn");
                System.out.println(("Row: "));
                try {
                    int row = in.nextInt() - 1;
                    System.out.println("Col: ");
                    int col = in.nextInt() - 1;
                    final Move move = new Move(row, col, cell);
                    if (position.isValid(move)) {
                        return move;
                    }
                    System.out.println("Invalid move: " + (row + 1) + ", column: " + (col + 1) + " is not empty");
                } catch (InputMismatchException e) {
                    return new Move (-1, -1, Cell.E);
                }
        }
    }
}
