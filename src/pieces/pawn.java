package pieces;

import game.gamePanel;

public class pawn extends piece{

    public pawn(int Color, int col, int row) {
        super(Color, col, row);

        System.out.println(getClass().getResource("/piece/w.pawn.png"));

    
        if (Color == gamePanel.WHITE) {
            image = getImage("/piece/w.pawn.png"); // Path starts with '/'
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/piece/b.pawn.png");
        }
    }
    
}
