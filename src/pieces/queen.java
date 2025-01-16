package pieces;

import game.gamePanel;

public class queen extends piece{

    public queen(int Color, int col, int row) {
        super(Color, col, row);

        System.out.println(getClass().getResource("/piece/w.queen.png"));

    
        if (Color == gamePanel.WHITE) {
            image = getImage("/piece/w.queen.png"); // Path starts with '/'
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/piece/b.queen.png");
        }
    }
}
