package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import pieces.bishop;
import pieces.king;
import pieces.knight;
import pieces.pawn;
import pieces.piece;
import pieces.queen;
import pieces.rook;


public class gamePanel extends JPanel implements Runnable{

    public static final int WIDTH = 1100, HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    mouse mouse = new mouse();


    //pieces
    public static ArrayList<piece> pieces = new ArrayList<>();
    public static ArrayList<piece> SimPieces = new ArrayList<>();
    piece activeP;

    //color
    public static final int WHITE = 0, BLACK = 1;
    int currentColor = WHITE;

    public gamePanel(){
        setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        addMouseMotionListener(mouse);
        addMouseListener(mouse);

        setPieces();
        copyPieces(pieces, SimPieces);
    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setPieces(){
        //whites
        pieces.add(new pawn(WHITE, 0, 6));
        pieces.add(new pawn(WHITE, 1, 6));
        pieces.add(new pawn(WHITE, 2, 6));
        pieces.add(new pawn(WHITE, 3, 6));
        pieces.add(new pawn(WHITE, 4, 6));
        pieces.add(new pawn(WHITE, 5, 6));
        pieces.add(new pawn(WHITE, 6, 6));
        pieces.add(new pawn(WHITE, 7, 6));
        pieces.add(new rook(WHITE, 0, 7));
        pieces.add(new rook(WHITE, 7, 7));
        pieces.add(new knight(WHITE, 1, 7));
        pieces.add(new knight(WHITE, 6, 7));
        pieces.add(new bishop(WHITE, 2, 7));
        pieces.add(new bishop(WHITE, 5, 7));
        pieces.add(new queen(WHITE, 3, 7));
        pieces.add(new king(WHITE, 4, 7));
        

        //blacks
        pieces.add(new pawn(BLACK, 0, 1));
        pieces.add(new pawn(BLACK, 1, 1));
        pieces.add(new pawn(BLACK, 2, 1));
        pieces.add(new pawn(BLACK, 3, 1));
        pieces.add(new pawn(BLACK, 4, 1));
        pieces.add(new pawn(BLACK, 5, 1));
        pieces.add(new pawn(BLACK, 6, 1));
        pieces.add(new pawn(BLACK, 7, 1));
        pieces.add(new rook(BLACK, 0, 0));
        pieces.add(new rook(BLACK, 7, 0));
        pieces.add(new knight(BLACK, 1, 0));
        pieces.add(new knight(BLACK, 6, 0));
        pieces.add(new bishop(BLACK, 2, 0));
        pieces.add(new bishop(BLACK, 5, 0));
        pieces.add(new queen(BLACK, 3, 0));
        pieces.add(new king(BLACK, 4, 0));
    }

    private void copyPieces(ArrayList<piece> source, ArrayList<piece> target){
        target.clear();
        for (int i = 0; i< source.size(); i++){
            target.add(source.get(i));
        }
    }


    

    private void simulate() {
        if (activeP != null) {
            System.out.println("Moving piece: " + activeP.col + ", " + activeP.row);
            activeP.x = mouse.x;
            activeP.y = mouse.y;
        } else {
            System.out.println("simulate() called, but no active piece!");
        }
    }
    
    


    private void selectPiece() {
        int mouseCol = mouse.x / gameBoard.SQUARE_SIZE;
        int mouseRow = mouse.y / gameBoard.SQUARE_SIZE;
    
        System.out.println("Mouse clicked at: " + mouse.x + ", " + mouse.y);
        System.out.println("Calculated grid position: " + mouseCol + ", " + mouseRow);
    
        boolean foundPiece = false;
    
        for (piece piece : SimPieces) {
            System.out.println("Checking piece at: " + piece.col + ", " + piece.row);
    
            if (piece.Color == currentColor && piece.col == mouseCol && piece.row == mouseRow) {
                activeP = piece;
                foundPiece = true;
                System.out.println("Piece selected: " + piece.col + ", " + piece.row);
                break;
            }
        }
    
        if (!foundPiece) {
            System.out.println("No piece found at this position!");
        }
    }
    


    //mouse pressed
    private void update() {
        
        
        if (mouse.pressed) {
            if (activeP == null) { 
                selectPiece();
            } else { 
                simulate();
            }
        } else {
            activeP = null;
        }
    }
    
    
    
    
    

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


    //board
        gameBoard gameBoard = new gameBoard();
        gameBoard.draw(g2);

    //pieces
        for (piece p : SimPieces){
            p.draw(g2);
        }
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1){
                update();
                repaint();
                delta--;
            }
        }

    }
    
}
