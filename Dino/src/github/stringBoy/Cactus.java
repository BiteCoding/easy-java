package github.stringBoy;

import basis.*;

public class Cactus extends Obstacle {
    private SpriteBild obstacleSprite;
    private Highscore highscore;

    private int width, height;

    public Cactus(int px, int py, Highscore highscore) {
        super(px, py);
        obstacleSprite = new SpriteBild("/home/simon/Dokumente/JavaCode/Dino/src/res/Cactus.png");

        width = obstacleSprite.breite();
        height = obstacleSprite.hoehe();

        obstacleSprite.setzeGroesse(width / 5, height / 7);
        this.highscore = highscore;

        place();
    }

    public SpriteBild getSprite() {
        return obstacleSprite;
    }

    @Override
    public void move(int score) {
        setX(((int) getX() - 5 - score / 50));
        place();
        if (getX() < 0) {
            if (Hilfe.zufall(0,1) == 1){
                obstacleSprite.setzeGroesse(width/5,height/10);
            } else {
                obstacleSprite.setzeGroesse(width/5,height/7);
            }
            setX(Hilfe.zufall(800 + highscore.getScore(), 1920));
        }
    }

         @Override
    public void place() {
        obstacleSprite.setzePosition(getX() - obstacleSprite.mittelpunkt().getX(), getY() - obstacleSprite.mittelpunkt().getY() * 2);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            move(highscore.getScore());
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
