import java.awt.*;
import javax.swing.*;
// Tile class representing each tile in the grid
/*
 * Tile class creates a JPanel containing a JButton.
 * Each tile can be clicked to reveal a number and update the game score.
 * Usage: new Tile() to create a tile with a button.
 */

public class Tile extends JPanel {
    private int size = 120;
    private JButton button;  // make button instance variable




    public Tile(int x, int y, Color color) {

    setLayout(new BorderLayout()); // stretch child to full area
    
    
    button = new JButton("-");
    button.setFont(new Font("Arial", Font.BOLD, 48)); // big font
    button.setBackground(Color.WHITE);
    button.setEnabled(false);
    add(button, BorderLayout.CENTER); // button fills the entire Tile

    setPreferredSize(new Dimension(size, size)); // make tile 150x150
}


    
      public JButton getButton() {  //getter method to access button
        return button;
    }
}
