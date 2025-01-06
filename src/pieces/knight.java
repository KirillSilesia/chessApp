package pieces;

import game.gamePanel;

public class knight extends piece{

    public knight(int Color, int col, int row) {
        super(Color, col, row);

        if (Color == gamePanel.WHITE) {
            image = getImage("/resources/piece/w.knight.png");
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/resources/piece/b.knight.png");
        }
    }
}
