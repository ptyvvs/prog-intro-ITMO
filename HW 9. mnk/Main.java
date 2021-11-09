package game;

import game.player.HumanPlayer;
import game.player.RandomPlayer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            try {
                int m = in.nextInt();
                int n = in.nextInt();
                int k = in.nextInt();
                int winNum = in.nextInt();
                Match.match(m, n, k, winNum);
            } catch (InputMismatchException e) {
                System.out.println("Invalid parameters for the game");
        }
    }
}
