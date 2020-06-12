package github.stringBoy;

import basis.*;
import writer.Writer;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Logic {
    private Frame startFrame;
    private Animation animation;
    private Frame gameFrame;
    private Dino dino;
    private Background background;
    private Obstacle cactus;
    private Frame endFrame;
    private CrashDetection crashDetection;
    private Highscore highscore;
    private Writer writer;
    //Threads
    private ExecutorService executor = Executors.newCachedThreadPool();

    private Runnable[] runables;

    private Tastatur keyboard;

    boolean interrupted;

    public Logic() {
        startFrame = new Frame(Color.BLACK,true);
        gameFrame = new Frame(true);
        gameFrame.visible(false);
        highscore = new Highscore();
        dino = new Dino(200, gameFrame.height() - 200);
        background = new Background(gameFrame, gameFrame.height() - 200);
        cactus = new Cactus(1800, gameFrame.height() - 200, highscore);
        animation = new Animation(dino);
        crashDetection = new CrashDetection(animation.getSprite(), (SpriteBild) cactus.getSprite(), dino, cactus);
        endFrame = new Frame(Color.RED,false);
        endFrame.visible(false);

        writer = new Writer("Dino/src/res/.highscore.txt");

        keyboard = new Tastatur();
        
        runables = new Runnable[]{highscore, dino, crashDetection, cactus, animation};

        interrupted = false;
    }

    /*TODO: Make a function that enables the player to play the game
            multiple times without having to start a new game every Time.*/

    public static void main(String[] args) {
        Logic l;
        l = new Logic();
        l.runThis();
    }

    private void prepEndFrame(){
        if (highscore.getScore() < highscore.getHighscore()) {
            endFrame.writeText("YOU DIED!", true, 100, Farbe.WEISS, 400);
            endFrame.writeText("Dein Score: " + highscore.getScore(), true, 75, Farbe.WEISS, -endFrame.height() / 2 + 150);
            endFrame.writeText("Dein Highscore: " + highscore.getHighscore(), true, 25, Farbe.WEISS, -endFrame.height() / 2 + 100);
        } else {
            endFrame.writeText("YOU DIED!", true, 100, Farbe.WEISS, 400);
        }
    }

    private void prepInterruptFrame(){
            endFrame.writeText("INTERRUPTED", true, 100, Farbe.WEISS, 0);
            endFrame.makeDinoInvis(true);
    }

    public void runThis() {
        boolean stopped = false;
        startFrame.writeText("Press ENTER to start the game!", true, 75, Farbe.WEISS, 0);
        while (!stopped){
            Hilfe.kurzePause();
            if (keyboard.istGedrueckt(Zeichen.ENTER)){
                startFrame.visible(false);
                gameFrame.visible(true);
                stopped = true;
            }
        }
        background.drawGround();
        for (Runnable r : runables) {
            executor.execute(r);
        }
        new  Sound();
        while (!executor.isShutdown()) {
            if (keyboard.istGedrueckt(Zeichen.ESC)) {
                executor.shutdown();
                executor.shutdownNow();
                interrupted = true;
            } else if (crashDetection.isCrashed()) {
                executor.shutdown();
                executor.shutdownNow();
            }
        }
        if (highscore.getHighscore() < highscore.getScore()) {
            writer.write("" + highscore.getScore(), false);
            System.out.println("NEW HIGHSCORE!");
        }
        if (!interrupted) {
            endFrame.visible(true);
            gameFrame.visible(false);
            prepEndFrame();
            Hilfe.warte(2000);
            System.exit(0);
        } else {
            endFrame.visible(true);
            gameFrame.visible(false);
            prepInterruptFrame();
            Hilfe.warte(2000);
            System.exit(0);
        }
    }
}
