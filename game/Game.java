package game;

import player.Player;
import board.Board;
import java.util.Scanner;

public class Game {
    Player[] players;
    Board board;
    int turn;
    int noOfMoves;
    boolean gameOver;
    String zero;
    String cross;

    public Game(Player[] players, Board board) {
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.noOfMoves = 0;
        this.gameOver = false;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for (int i=0 ; i<board.size ; i++) {
            z.append('O');
            c.append('X');
        }

        this.zero = z.toString();
        this.cross = c.toString();
    }

    public void printBoardConfig() {
        int sz = this.board.size;
        for (int i=0 ; i<sz ; i++) {
            for (int j=0 ; j<sz ; j++) {
                System.out.print(board.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        printBoardConfig();
        int sz = board.size; 

        while (!gameOver) {
            noOfMoves++;
            int pos = getIndex();

            int row = pos / sz;
            int col = pos % sz;

            board.matrix[row][col] = players[turn].getPlayerSymbol();

            if (noOfMoves >= sz*sz) {
                System.out.println("Game Draw");
                return;
            }

            if (noOfMoves >= 2*sz-1 && checkCombinations()) {
                gameOver = true;
                printBoardConfig();
                System.out.println("Winner is : " + players[turn].getPlayerName());
                return;
            }

            turn = (turn + 1) % 2;

            printBoardConfig();
        }
    }

    public int getIndex() {
        while (true) {
            System.out.println("Player : " + players[turn].getPlayerName() + " give one position");
            Scanner sc = new Scanner(System.in);
            int pos = sc.nextInt() - 1;
            
            int sz = board.size; 

            int row = pos / sz;
            int col = pos % sz;

            // Checking for invalid position
            if (row < 0 || row >= sz || col < 0 || col >= sz) {
                System.out.println("Invalid position");
                continue;
            }

            // Checking for vaccant position
            if (board.matrix[row][col] != '-') {
                System.out.println("Position is already occupied");
                continue;
            }

            return pos;
        }
    }

    public boolean checkCombinations() {
        int sz = board.size;

        // rowWise
        for (int i = 0; i < sz ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz ; j++) {
                sb.append(board.matrix[i][j]);
            }

            String pattern = sb.toString();
            if (pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }
        }

        // columnWise 
        for (int i = 0; i < sz ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz ; j++) {
                sb.append(board.matrix[j][i]);
            }

            String pattern = sb.toString();
            if (pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }
        }

        // diagonal
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < sz) {
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }
        String pattern = sb.toString();
        if (pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }

        // anti-digonal
        i = 0;
        j = sz - 1;
        sb = new StringBuilder();
        while (i < sz) {
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }
        pattern = sb.toString();
        if (pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }

        return false;
    }
}
