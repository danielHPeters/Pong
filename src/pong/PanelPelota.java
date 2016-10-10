package pong;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class PanelPelota extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    // Positions on X and Y for the ball, player 1 and player 2
    private int pelotaX = 10, pelotaY = 100, playerOneX = 10, playerOneY = 100, playerTwoX = 230, playerTwoY = 100;
    Thread hilo;
    int moveRight = 5; // to the right
    int moveLeft = -5; //to the left
    int moveUp = 5; // upward
    int moveDown = -5; // down
    int ballWidth, ballHeight; // Width and height of the ball
    // Scores
    int contPlay1 = 0, contPlay2 = 0;
    boolean player1FlagArr, player1FlagAba, player2FlagArr, player2FlagAba;
    boolean juego, gameOver;
    Flipper playerOne = new Flipper(playerOneX, playerOneY, 10, 25);

    public PanelPelota() {
        juego = true;
        hilo = new Thread(this);
        hilo.start();
    }

    // Draw ball and ships
    @Override
    public void paintComponent(Graphics gc) {
        setOpaque(false);
        super.paintComponent(gc);

        // Draw ball
        gc.setColor(Color.black);
        gc.fillOval(pelotaX, pelotaY, 8, 8);

        // Draw Paddle
        /*Rectangle playerOne = new Rectangle(playerOneX,playerOneY,10,25);
        gc.fillRect(WIDTH, WIDTH, WIDTH, HEIGHT);*/
        gc.fillRect((int) playerOne.getX(), (int) playerOne.getY(), (int) playerOne.getWidth(), (int) playerOne.getHeight());
        /*gc.fillRect(playerOneX, playerOneY, 10, 25);*/
        gc.fillRect(playerTwoX, playerTwoY, 10, 25);

        //Draw scores
        gc.drawString("Jugador1: " + contPlay1, 25, 10);
        gc.drawString("Jugador2: " + contPlay2, 150, 10);

        if (gameOver) {
            gc.drawString("Game Over", 100, 125);
        }
    }

    // Positions on X and Y for the ball
    public void dibujarPelota(int nx, int ny) {
        pelotaX = nx;
        pelotaY = ny;
        this.ballWidth = this.getWidth();
        this.ballHeight = this.getHeight();
        repaint();
    }

    // Here we receive from the game container class the key pressed
    public void keyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            // Move ship 1
            case KeyEvent.VK_W:
                player1FlagArr = true;
                break;
            case KeyEvent.VK_S:
                player1FlagAba = true;
                break;

            // Move ship 2
            case KeyEvent.VK_UP:
                player2FlagArr = true;
                break;
            case KeyEvent.VK_DOWN:
                player2FlagAba = true;
                break;
        }
    }

    // Here we receive from the game container class the key released
    public void keyReleased(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            // Mover Nave1
            case KeyEvent.VK_W:
                player1FlagArr = false;
                break;
            case KeyEvent.VK_S:
                player1FlagAba = false;
                break;

            // Mover nave 2
            case KeyEvent.VK_UP:
                player2FlagArr = false;
                break;
            case KeyEvent.VK_DOWN:
                player2FlagAba = false;
                break;
        }
    }

    // Move player 1
    /*public void moverPlayer1() {
        if (player1FlagArr == true && playerOneY >= 0) {
            playerOneY += moveDown;
        }
        if (player1FlagAba == true && playerOneY <= (this.getHeight() - 25)) {
            playerOneY += moveUp;
        }
        dibujarPlayer1(playerOneX, playerOneY);
    }*/

    // Move player 2
    public void moverPlayer2() {
        if (player2FlagArr == true && playerTwoY >= 0) {
            playerTwoY += moveDown;
        }
        if (player2FlagAba == true && playerTwoY <= (this.getHeight() - 25)) {
            playerTwoY += moveUp;
        }
        dibujarPlayer2(playerTwoX, playerTwoY);
    }

    // Position on Y for the player 1
    public void dibujarPlayer1(int x, int y) {
        this.playerOneX = x;
        this.playerOneY = y;
        repaint();
    }
    // Position on Y for the player 2
    public void dibujarPlayer2(int x, int y) {
        this.playerTwoX = x;
        this.playerTwoY = y;
        repaint();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        boolean izqDer = false;
        boolean arrAba = false;

        while (true) {

            if (juego) {

                // The ball move from left to right
                if (izqDer) {
                    // a la moveRight
                    pelotaX += moveRight;
                    if (pelotaX >= (ballWidth - 8)) {
                        izqDer = false;
                    }
                } else {
                    // a la moveLeft
                    pelotaX += moveLeft;
                    if (pelotaX <= 0) {
                        izqDer = true;
                    }
                }

                // The ball moves from up to down
                if (arrAba) {
                    // hacia moveUp
                    pelotaY += moveUp;
                    if (pelotaY >= (ballHeight - 8)) {
                        arrAba = false;
                    }

                } else {
                    // hacia moveDown
                    pelotaY += moveDown;
                    if (pelotaY <= 0) {
                        arrAba = true;
                    }
                }
                dibujarPelota(pelotaX, pelotaY);

                // Delay
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }

                // Move player 1
                /*moverPlayer1();*/

                // Move player 2
                moverPlayer2();

                // The score of the player 1 increase
                if (pelotaX >= (ballWidth - 8)) {
                    contPlay1++;
                }

                // The score of the player 2 increase
                if (pelotaX == 0) {
                    contPlay2++;
                }

                // Game over. Here you can change 6 to any value
                // When the score reach to the value, the game will end
                if (contPlay1 == 6 || contPlay2 == 6) {
                    juego = false;
                    gameOver = true;
                }

                // The ball stroke with the player 1
                if (pelotaX == playerOneX + 10 && pelotaY >= playerOneY && pelotaY <= (playerOneY + 25)) {
                    izqDer = true;
                }

                // The ball stroke with the player 2
                if (pelotaX == (playerTwoX - 5) && pelotaY >= playerTwoY && pelotaY <= (playerTwoY + 25)) {
                    izqDer = false;
                }
            }
        }
    }

}
