import java.util.Scanner;

import board.*;
import player.*;
import game.*;

public class App {
    public static void main(String[] args) {
        Board b = new Board(3, '-');

        Player p1 = new Player();
        p1.setPlayerNameAndSymobl("A", 'X');
        p1.getPlayerNameAndSymbol();

        Player p2 = new Player();
        p2.setPlayerNameAndSymobl("B", 'O');
        p2.getPlayerNameAndSymbol();

        Game game = new Game(new Player[] {p1, p2}, b);
        game.play();
    }
}
