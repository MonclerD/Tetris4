package game;
import piece.Piece;
import piece.PieceGenerator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;

public class Launcher implements KeyListener{
    private static final int NEXT_PIECE_X = 11;
    private static final int NEXT_PIECE_Y = 1;
    public static Queue<Piece> pieceQueue;

    public static void main(String[] args) {
        pieceQueue = new LinkedList<>();

        pieceQueue.add(PieceGenerator.generatePiece());

        System.out.println(pieceQueue.element());
        System.out.println(pieceQueue.size());


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(pieceQueue.size() < 5){
                        pieceQueue.add(PieceGenerator.generatePiece());
                        System.out.println(pieceQueue.size());
                    }

                }
            }
        });
        t.start();

        InfoDisplay id = new InfoDisplay();

        Thread t0 = new Thread(new Game("Tetris Thread 1", null));
        t0.start();




       // Thread t1 = new Thread(new Game("Tetris Thread 2", id));
       // t1.start();


       // Game game = new Game("Tetris");
       // game.run();
       // Game game1 = new Game("My Tetris 1");
       // game1.start();

       // Game game2 = new Game("My Tetris 2");
       // game2.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_S) {

            System.out.println(pieceQueue.poll());
            System.out.println(pieceQueue.size());

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
