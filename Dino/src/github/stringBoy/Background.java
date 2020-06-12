package github.stringBoy;

import basis.*;

public class Background {
    private Stift pen;
    private Frame frame;
    private Bild sonne;
    private int y;

    public Background(Frame frame, int y) {
        this.frame = frame;
        pen = new Stift();
        pen.setzeLinienBreite(5);
        pen.setzeFuellMuster(1);
        sonne = new Bild("/home/simon/Dokumente/JavaCode/Dino/src/res/Sonne.png");
        sonne.setzeGroesse(sonne.breite() / 2.5, sonne.hoehe() / 2.5);
        sonne.setzePosition(frame.width() - sonne.breite() - 50, 50);
        this.y = y;
    }

    public void drawGround() {
        pen.setzeFarbe(Farbe.rgb(235, 255, 86));
        pen.rechteck(0, y, frame.width(), frame.height() - y);
    }
}
