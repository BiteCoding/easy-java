import basis.Hilfe;
import basis.Muster;
import basis.Stift;

public class Render implements Runnable {
    private Stift pen;
    private Player posPlayer;

    private int times;

    public Render(Player player) {
        pen = new Stift();
        pen.setzeFarbe(player.getColor());
        pen.setzeFuellMuster(Muster.GEFUELLT);

        posPlayer = player;

        times = 0;
    }

    public void draw() {
        pen.kreis(posPlayer.getPlayerPos().getX(), posPlayer.getPlayerPos().getY(), 20);
        pen.setzeTransparenzGrad(0.05);
        pen.kreis(posPlayer.getPlayerPos().getX(), posPlayer.getPlayerPos().getY(), 30);
    }

    private void erase(){
        pen.radiere();
        pen.setzeFuellMuster(Muster.DURCHSICHTIG);
        pen.kreisBogen(posPlayer.getPositions()[0].getX(),posPlayer.getPositions()[0].getY(),30,posPlayer.getAngles()[0],180);
        pen.setzeFuellMuster(Muster.GEFUELLT);
        pen.normal();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            if (!posPlayer.isUpdated()) {
                draw();
                posPlayer.setUpdated(true);
                if (posPlayer.getPositions()[posPlayer.getPositions().length-1] != null) {
                    this.erase();
                }
                times++;
            }
        }
    }
}