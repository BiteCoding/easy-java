package github.stringBoy;

import basis.SpriteBild;

public class CrashDetection implements Runnable {
    private SpriteBild dinoSprite;
    private SpriteBild obstacleSprite;

    private Dino dino;
    private Obstacle obstacle;

    private boolean crashed;

    public CrashDetection(SpriteBild dinoSp, SpriteBild obstacleSp, Dino dino, Obstacle obstacle) {
        this.dinoSprite = dinoSp;
        this.obstacleSprite = obstacleSp;

        this.dino = dino;
        this.obstacle = obstacle;

        crashed = false;

        obstacleSprite.setzeVereinfachteKollisionerkennung(false);
    }

    public void crashed() {
        if (obstacleSprite.kollisionErkanntMit(dinoSprite)) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isCrashed() {
        return crashed;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            crashed();
        }
        crashed = true;
    }
}
