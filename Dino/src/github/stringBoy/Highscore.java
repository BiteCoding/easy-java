package github.stringBoy;

import basis.*;
import reader.NumberReader;

public class Highscore implements Runnable {
    private TextFeld scoreFeld;
    private TextFeld highscoreFeld;
    private NumberReader reader;
    private int score;
    private int highscore;

    public Highscore() {
        scoreFeld = new TextFeld();
        scoreFeld.setzeHintergrundFarbe(Farbe.rgb(154, 210, 255));
        scoreFeld.setzeText("Score: " + String.format("%03d",score));
        scoreFeld.setzeSchriftGroesse(35);
        scoreFeld.setzeGroesse(230, 50);
        scoreFeld.setzePosition(960 - scoreFeld.breite() / 2, 50);
        scoreFeld.setzeSchriftStil(Schrift.FETT);
        scoreFeld.entferneRand();

        reader = new NumberReader("/home/simon/Dokumente/JavaCode/Dino/src/res/.highscore.txt");
        highscore = reader.read();

        highscoreFeld = new TextFeld();
        highscoreFeld.setzeHintergrundFarbe(Farbe.rgb(154, 210, 255));
        highscoreFeld.setzeText("Highscore: " + highscore);
        highscoreFeld.setzeSchriftGroesse(15);
        highscoreFeld.setzeGroesse(150, 30);
        highscoreFeld.setzePosition(960 - highscoreFeld.breite() / 2, 100);
        highscoreFeld.setzeSchriftStil(Schrift.FETT);
        highscoreFeld.entferneRand();

        score = 0;
    }

    public int getScore() {
        return score;
    }

    public int getHighscore() {
        return highscore;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            ++score;
            scoreFeld.setzeText("Score: " + String.format("%03d",score));
        }
    }
}
