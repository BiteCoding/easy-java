import basis.*;

import java.awt.*;

public class Brush {
    Stift stift;

    public Brush() {
        stift = new Stift();
    }

    public void draw(){
        stift.runter();
    }

    public void dontDraw(){
        stift.hoch();
    }

    public int getBreite(){
        return stift.linienBreite();
    }

    public void setBreite(int breite){
        stift.setzeLinienBreite(breite);
    }

    public void setzePosition(int x, int y){
        stift.bewegeAuf(x,y);
    }

    public void color(int r, int g, int b){
        stift.setzeFarbe(Farbe.rgb(r,g,b));
    }

    public Color getColor(){
        return stift.farbe();
    }

    public void write(String text,int grösse){
        stift.setzeSchriftGroesse(grösse);
    }


}
