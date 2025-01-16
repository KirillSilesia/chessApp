package pieces;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import game.gameBoard;

import java.awt.Graphics2D;

public class piece {

    public BufferedImage image;
    public int x, y;    
    public int col, row, preCol, preRow;
    public int Color; // 0 = white, 1 = black

    public piece(int Color, int col, int row) {
        this.Color = Color;
        this.col = col;
        this.row = row;
        x = getX(col);
        y = getY(row);
    }
    public BufferedImage getImage(String imagePath) {
        BufferedImage img = null;
        try {
            // Load resource using classpath
            img = ImageIO.read(getClass().getResourceAsStream(imagePath));
            if (img == null) {
                throw new IllegalArgumentException("Image not found: " + imagePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load image: " + imagePath, e);
        }
        return img;
    }
    
    public int getX(int col) {
        return col * gameBoard.SQUARE_SIZE;
    }   
    public int getY(int row) {
        return row * gameBoard.SQUARE_SIZE;
    }   
    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, gameBoard.SQUARE_SIZE, gameBoard.SQUARE_SIZE, null); 
}
}

