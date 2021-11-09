package game;

import game.player.HumanPlayer;
import game.player.RandomPlayer;

public class Match {
    public static void match(int m, int n, int k, int winNum){
        int numWin1 = 0;
        int numWin2 = 0;
        int result;
        int i = 0;
        HumanPlayer player1 = new HumanPlayer();
        RandomPlayer player2 = new RandomPlayer(m, n);
        while (true) {
            if (i % 2 == 0) {
                final Game game = new Game(player1, player2, false);
                result = game.play(new Board(m, n, k));
                if (result == 1) {
                    numWin1++;
                } else if (result == 2) {
                    numWin2++;
                }
                System.out.println("Game №" + (i + 1) + " result: " + result);
            } else {
                final Game game = new Game(player2, player1, false);
                result = game.play(new Board(m, n, k));
                if (result > 0) {
                    if (result == 1) {
                        numWin2++;
                    } else if (result == 2) {
                        numWin1++;
                    }
                    System.out.println("Game №" + (i + 1) + " result: " + (3 - result));
                } else {
                    System.out.println("Game №" + (i + 1) + " result: " + result);
                }
            }
            if (numWin1 == winNum || numWin2 == winNum){
                if (numWin1 == winNum) {
                    System.out.println("Winner is player № 1");
                } else {
                    System.out.println("Winner is player № 2");
                }
                break;
            }
            i++;
        }
    }
}
