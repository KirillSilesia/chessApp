package pieces;

import game.gamePanel;

public class bishop extends piece{

    public bishop(int Color, int col, int row) {
        super(Color, col, row);

        System.out.println(getClass().getResource("/piece/w.bishop.png"));

    
        if (Color == gamePanel.WHITE) {
            image = getImage("/piece/w.bishop.png"); // Path starts with '/'
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/piece/b.bishop.png");
        }
    }
}

