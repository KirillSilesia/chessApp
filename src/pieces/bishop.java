package pieces;

import game.gamePanel;

public class bishop extends piece{

    public bishop(int Color, int col, int row) {
        super(Color, col, row);

        if (Color == gamePanel.WHITE) {
            image = getImage("/resources/piece/w.bishop.png");
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/resources/piece/b.bishop.png");
        }
    }
}

