package pieces;

import game.gamePanel;

public class knight extends piece{

    public knight(int Color, int col, int row) {
        super(Color, col, row);

        System.out.println(getClass().getResource("/piece/w.knight.png"));

    
        if (Color == gamePanel.WHITE) {
            image = getImage("/piece/w.knight.png"); // Path starts with '/'
        } else if (Color == gamePanel.BLACK) {
            image = getImage("/piece/b.knight.png");
        }
    }
}
