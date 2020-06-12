import basis.Hilfe;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Operator {
    private Output out;
    private Player player;
    private Player target;
    private Render playerRender;
    private Hitdetection hitdetection;
    private Distance distance;

    private Runnable[] runnables;

    private ExecutorService executor = Executors.newCachedThreadPool();
    public Operator() {
        out = new Output();
        player = new Player(Hilfe.zufall(50, 1870), Hilfe.zufall(50, 1030), Color.GREEN);
        target = new Player(Hilfe.zufall(50, 1870), Hilfe.zufall(50, 1030), Color.BLACK);
        playerRender = new Render(player);
        hitdetection = new Hitdetection(player,target);
        distance = new Distance(player,target,out.getFrame().breite(),
                out.getFrame().hintergrundFarbe());
        runnables = new Runnable[]{playerRender, hitdetection};
    }

    private void operate() {
        player.move();
        for (Runnable r : runnables
        ) {
            executor.execute(r);
        }
        while (true){
            player.move();
            distance.getValue();
        }

    }

    public static void main(String[] args) {
        Operator op = new Operator();
        op.operate();
    }
}
