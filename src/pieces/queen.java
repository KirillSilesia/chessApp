package pieces;

import game.gamePanel;

public class queen extends piece{

    public queen(int Color, int col, int row) {
        super(Color, col, row);

        if (Color == gamePanel.WHITE) {
            image = getImage("/resources/piece/w.queen.png");
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/resources/piece/b.queen.png");
        }
    }
}
