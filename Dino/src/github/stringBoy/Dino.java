package github.stringBoy;

import basis.*;

import java.awt.*;

public class Dino implements Runnable {
    public boolean isJumping;
    private Point dino;

    SpriteBild[] sprites;

    private Tastatur keyboard;

    public Dino(int x, int y) {
        dino = new Point(x, y);

        keyboard = new Tastatur();

        isJumping = false;
    }

    public int getX() {
        return (int) dino.getX();
    }

    public int getY() {
        return (int) dino.getY();
    }

    public void setY(int y) {
        dino.y = y;
    }


    public void jump() {
        isJumping = true;
        for (int i = 0; i < 9; i++) {
            setY((int) dino.getY() - 20);
            Hilfe.warte(12);
        }
        for (int i = 0; i < 5; i++) {
            setY((int) dino.getY() - 4);
            Hilfe.warte(15);
        }
        for (int i = 5; i > 0; i--) {
            setY((int) dino.getY() + 4);
            Hilfe.warte(15);
        }
        for (int i = 9; i > 0; i--) {
            setY((int) dino.getY() + 20);
            Hilfe.warte(12  );
        }
        isJumping = false;
    }

    @Override
    public void run() {
        int i = 0;
        Hilfe.kurzePause();
        while (!Thread.currentThread().isInterrupted()) {
            Hilfe.kurzePause();
            if (keyboard.istGedrueckt(' ')) {
                jump();
            }
        }
    }
}
