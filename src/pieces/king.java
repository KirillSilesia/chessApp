package pieces;

import game.gamePanel;

public class king extends piece{

    public king(int Color, int col, int row) {
        super(Color, col, row);

        if (Color == gamePanel.WHITE) {
            image = getImage("/resources/piece/w.king.png");
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/resources/piece/b.king.png");
        }
    }
}

