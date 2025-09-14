import javax.swing.*;
//main class to launch the game
/*  
 * Main class to launch the Pontoon Game.
 * It initializes the game by creating an instance of PontoonGame.
 * Usage: Run this class to start the game.
 */

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PontoonGame::new);
    }
}
