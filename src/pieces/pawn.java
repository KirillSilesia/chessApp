package pieces;

import game.gamePanel;

public class pawn extends piece{

    public pawn(int Color, int col, int row) {
        super(Color, col, row);

        if (Color == gamePanel.WHITE) {
            image = getImage("/resources/piece/w.pawn.png");
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/resources/piece/b.pawn.png");
        }
    }
}
