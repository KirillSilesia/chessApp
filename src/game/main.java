package game;

import javax.swing.JFrame;

public class main {

    public static void main(String[] args) {

        JFrame window = new JFrame("Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel panel = new gamePanel();
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel gamePanel = new gamePanel();
        gamePanel.startGame();
    }
}
