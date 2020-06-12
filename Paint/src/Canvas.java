import basis.*;

public class Canvas
{
    Fenster fenster;
    public Canvas(int width, int height, String name) {
        fenster = new Fenster(width, height);
        fenster.setzeTitel(name);
    }

    public void setBackColor(int r, int g, int b){
        fenster.setzeHintergrundFarbe(Farbe.rgb(r,g,b));
    }

    public java.awt.Color getColor(){
        return fenster.hintergrundFarbe();
    }


    public double wigth(){
        return fenster.breite();
    }

    public void savePicture(){
            fenster.speichereZeichenflaeche();
        }

}
