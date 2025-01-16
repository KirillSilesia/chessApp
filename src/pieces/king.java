package pieces;

import game.gamePanel;

public class king extends piece{

    public king(int Color, int col, int row) {
        super(Color, col, row);

        System.out.println(getClass().getResource("/piece/w.king.png"));

    
        if (Color == gamePanel.WHITE) {
            image = getImage("/piece/w.king.png"); // Path starts with '/'
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/piece/b.king.png");
        }
    }
}

