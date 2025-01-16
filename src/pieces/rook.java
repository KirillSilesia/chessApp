package pieces;

import game.gamePanel;

public class rook extends piece{

    public rook(int Color, int col, int row) {
        super(Color, col, row);

        System.out.println(getClass().getResource("/piece/w.rook.png"));

    
        if (Color == gamePanel.WHITE) {
            image = getImage("/piece/w.rook.png"); // Path starts with '/'
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/piece/b.rook.png");
        }
    }
}
