public class Hitdetection implements Runnable {
    Player player;
    Player target;
    public Hitdetection(Player player1, Player player2) {
        player = player1;
        target = player2;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            if (player.getPlayerPos().distance(target.getPlayerPos())<50){
                Thread.currentThread().interrupt();
            }
        }
        System.exit(0);
    }
}
