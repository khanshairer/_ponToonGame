import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Main game class
/*
 * PontoonGame class sets up the main game window and handles game logic.
 * It includes a grid of tiles, score tracking, and player turns.
 * Usage: new PontoonGame() to start the game.
 */

public class PontoonGame extends JFrame {
    public PontoonGame() {
        final int[] gameScore = {0}; // array wrapper for mutable integer
        Random random = new Random();
        int num = random.nextInt(2) + 1; // random number between 1 and 5
        final String[] playerTurn = {String.valueOf(num)};


        setTitle("Pontoon Game");


        // Prevent resizing for better layout control
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // BorderLayout fixes the cross-platform issue
        getContentPane().setBackground(Color.WHITE);

         // TOP PANEL FOR FIRST ROW
        

       // ---------- TOP BAR (nEW GAEM, SCORE, PLAYERS TURN) ----------
        JPanel topPanel = new JPanel(new BorderLayout(12, 8));
        topPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8)); // padding

        JButton newGameButton = new JButton("New Game");

        JLabel turnLabel = new JLabel("Press New Game to Start!", SwingConstants.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel scoreLabel = new JLabel("Score: --", SwingConstants.RIGHT);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));

        topPanel.add(newGameButton, BorderLayout.WEST);
        topPanel.add(turnLabel,     BorderLayout.CENTER);
        topPanel.add(scoreLabel,    BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Create a panel just for tiles
JPanel gridPanel = new JPanel(new GridLayout(5, 5, 10, 10)); // 5x5 grid, 10px gap between tiles

newGameButton.addActionListener(e -> {
    // Reset game state
    gameScore[0] = 0;
    scoreLabel.setText("Score: " + gameScore[0]);
    int newNum = random.nextInt(2) + 1;
    playerTurn[0] = String.valueOf(newNum);
    if(playerTurn[0].equals("1")) {
        turnLabel.setForeground(Color.GREEN);
    } else {
        turnLabel.setForeground(Color.RED);
    }
    turnLabel.setText("Player " + playerTurn[0] + "'s Turn");

    // Reset all tiles
    Component[] components = gridPanel.getComponents();
    for (Component comp : components) {
            int buttonNum = random.nextInt(5) + 1; // random number between 1 and 5

        if (comp instanceof Tile) {
            Tile tile = (Tile) comp;
            tile.getButton().setText(String.valueOf(buttonNum)); // Reset button text
            tile.getButton().setEnabled(true);
            // Reset button colors
            tile.getButton().setBackground(Color.WHITE);
            tile.getButton().setForeground(Color.BLACK);
        }
    }
});

for (int i = 0; i < 25; i++) {
    Color color = (i % 2 == 0) ? Color.RED : Color.BLUE;
    Tile tile = new Tile(0, 0, color);
    gridPanel.add(tile);
        //Allow interaction with each tile
    tile.getButton().addActionListener(e -> {
    int currentNum = Integer.parseInt(tile.getButton().getText());
    gameScore[0] += currentNum; // update score after click
    scoreLabel.setText("Score: " + gameScore[0]); // update displayed score
    tile.getButton().setEnabled(false); // disable button after click
    
       
    
    // Determine if there's a winner
    if(gameScore[0]>=22){
        if(playerTurn[0].equals("1")) {
        tile.getButton().setBackground(Color.GREEN);
        tile.getButton().setForeground(Color.WHITE);           
        turnLabel.setForeground(Color.RED);
        turnLabel.setText("Player 2 Wins!");
        JOptionPane.showMessageDialog(this, "Player 2 Wins!");
        // Disable all buttons
        }
        else{
        turnLabel.setForeground(Color.GREEN);
             tile.getButton().setBackground(Color.RED);
        tile.getButton().setForeground(Color.WHITE);
            turnLabel.setText("Player 1 Wins!");
            JOptionPane.showMessageDialog(this, "Player 1 Wins!");
        }
    
        Component[] components = gridPanel.getComponents();
        for (Component comp : components) {
            if (comp instanceof Tile) {
                ((Tile) comp).getButton().setEnabled(false);
            }
        }
        return; // exit the method to prevent further actions
    }
    else if (playerTurn[0].equals("1")) {
        playerTurn[0] = "2";
        turnLabel.setText("Player " + playerTurn[0] + "'s Turn");
        turnLabel.setForeground(Color.RED);
        tile.getButton().setBackground(Color.GREEN);
        tile.getButton().setForeground(Color.WHITE);
    } else {
        playerTurn[0] = "1";
        turnLabel.setText("Player " + playerTurn[0] + "'s Turn");
        turnLabel.setForeground(Color.GREEN);

        tile.getButton().setBackground(Color.RED);
        tile.getButton().setForeground(Color.WHITE);
    }

});
}


// Add the grid panel to the main frame
add(gridPanel);


 pack();                   // Calculate final size automatically
setResizable(false);      // Lock window size
setLocationRelativeTo(null); // Center on screen
setVisible(true);      
        
    }
}
