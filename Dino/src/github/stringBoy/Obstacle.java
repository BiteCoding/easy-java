package github.stringBoy;

import basis.Bild;

import java.awt.*;

public abstract class Obstacle implements Runnable {
    private Point obstacle;

    public Obstacle(int x, int y) {
        obstacle = new Point(x, y);
    }

    abstract public void move(int score);

    abstract public void place();

    abstract public void run();

    abstract Bild getSprite();

    public double getX() {
        return obstacle.getX();
    }

    public void setX(int x) {
        obstacle.x = x;
    }

    public double getY() {
        return obstacle.getY();
    }

    public void setY(int y) {
        obstacle.y = y;
    }
}

