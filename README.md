# **_ponToonGame** 🎮  

Pontoon Game is a **two-player interactive strategy game** built using **Java Swing**.  
Players take turns clicking on tiles in a **5×5 grid**, where each tile contains a random value between **1 and 5**.  

The goal is **not just to score high**, but to **strategically force the other player to exceed 22 points**, causing them to lose the game.  
This creates a mix of **strategy, luck, and quick thinking**, making every match unique and exciting!

---

## **✨ Features**
- 🎲 **Randomized gameplay**: Each new game board is randomly generated to ensure fresh matches every time.
- 👥 **Two-player competitive mode**:
  - Player 1 is **Green**.
  - Player 2 is **Red**.
- 🖌️ **Dynamic visual feedback**:
  - Green tiles indicate Player 1's moves.
  - Red tiles indicate Player 2's moves.
- 📊 **Real-time score tracking** at the top of the window.
- 🔄 **New Game button** to instantly reset the board and start over.
- ❌ **Disabled tiles** once clicked — no repeat moves allowed!
- 🌍 **Cross-platform compatibility**: Works perfectly on **Windows**, **Linux**, and **macOS**.

---

## **🎮 How to Play**
1. Click **New Game** to generate a fresh grid of random numbers (1-5).
2. A random player is chosen to **start first**:
   - **Green text** = Player 1's turn.
   - **Red text** = Player 2's turn.
3. On your turn, **click any available white tile**:
   - The tile's number is added to **your score**.
   - The tile changes to **your color** and becomes disabled.
4. **Winning condition:**
   - The first player to **force their opponent's score to go above 22** wins the game!
5. Once a winner is declared, all tiles are disabled until you click **New Game** to reset.

---

## **🖥️ Screenshot**
Here’s a preview of the game interface:

![Pontoon Game Screenshot](screenshot.png)  
*Example showing Player 1 winning the game*

---

## **⚙️ Tech Stack**
- **Language:** Java (JDK 17 or later)
- **GUI Framework:** Java Swing
- **Layouts Used:**
  - `GridLayout` for the game board.
  - `BorderLayout` for the top panel.
- **Core Concepts:**
  - Event handling (`ActionListener`)
  - Dynamic UI updates
  - Cross-platform compatibility

---

## **🚀 Getting Started**

### **Prerequisites**
Make sure you have **Java JDK 17 or higher** installed.  
You can check your version by running:
```bash
java -version
