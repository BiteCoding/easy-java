package github.stringBoy;

import basis.*;

import java.awt.*;

public class Frame {
    public boolean isVisible;
    private Fenster frame;
    private Stift pen;
    private Bild deadDino;

    public Frame(boolean normalFrame) {
        frame = new Fenster();
        frame.setzeGroesse(Hilfe.monitorBreite(), Hilfe.monitorHoehe());
        frame.setzeTitel("Dino Jump & Run");
        frame.setzeHintergrundFarbe(Farbe.rgb(154, 210, 255));

        if (!normalFrame){
            deadDino = new Bild("Dino/src/res/DeadDino.png");
            deadDino.setzeGroesse(deadDino.breite()*1.5,deadDino.hoehe()*1.5);
            deadDino.spiegeleBild(false);
            deadDino.setzePosition(frame.breite()/2-deadDino.breite()/2,frame.hoehe()/2-deadDino.hoehe()/2);
        }

        pen = new Stift(frame);
    }

    public Frame(Color customColor, boolean normalFrame) {
        frame = new Fenster();
        frame.setzeGroesse(Hilfe.monitorBreite(), Hilfe.monitorHoehe());
        frame.setzeTitel("Dino Jump & Run");
        frame.setzeHintergrundFarbe(customColor);

        if (!normalFrame){
            deadDino = new Bild("Dino/src/res/DeadDino.png");
            deadDino.setzeGroesse(deadDino.breite()*1.5,deadDino.hoehe()*1.5);
            deadDino.spiegeleBild(false);
            deadDino.setzePosition(frame.breite()/2-deadDino.breite()/2,frame.hoehe()/2-deadDino.hoehe()/2);
        }

        pen = new Stift(frame);
    }

    public void visible(boolean isVisible) {
        this.isVisible = isVisible;
        if (isVisible == true) {
            frame.setzeSichtbar(true);
        } else {
            frame.setzeSichtbar(false);
        }
    }

    public void makeDinoInvis(boolean invis) {
        if (invis) {
            deadDino.setzeSichtbar(false);
        }
    }

    public void writeText(String text, boolean centered, int size, Color color, int y){
        pen.setzeFarbe(color);
        if (centered){
            pen.bewegeAuf(this.width()/2 - text.length()*size/4,this.height()/2-y);
        } else {
            pen.bewegeAuf(0,100);
        }
        pen.setzeSchriftGroesse(size);
        pen.schreibeText(text);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public int width() {
        return frame.breite();
    }

    public int height() {
        return frame.hoehe();
    }

    public void delete() {
        frame.gibFrei();
    }

}
