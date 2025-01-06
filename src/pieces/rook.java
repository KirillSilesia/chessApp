package pieces;

import game.gamePanel;

public class rook extends piece{

    public rook(int Color, int col, int row) {
        super(Color, col, row);

        if (Color == gamePanel.WHITE) {
            image = getImage("/resources/piece/w.rook.png");
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/resources/piece/b.rook.png");
        }
    }
}
