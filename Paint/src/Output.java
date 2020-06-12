import basis.*;

import java.awt.*;

public class Output {

    TextFeld textFeldBreite;
    TextFeld textFeldFarbe;
    TextFeld textFeldSchrift;

    public Output(double fensterbreite, int stiftbreite, Color stiftfarbe) {
        textFeldBreite = new TextFeld();
        textFeldBreite.setzeText("Stiftbreite: " + stiftbreite);
        textFeldBreite.setzeSchriftGroesse(20);
        textFeldBreite.setzeGroesse(textFeldBreite.text().length() * 11, 40);
        textFeldBreite.setzePosition(fensterbreite - textFeldBreite.breite() - 20, textFeldBreite.hoehe() / 2);
        textFeldBreite.entferneRand();
        textFeldBreite.setzeHintergrundFarbe(Farbe.DURCHSICHTIG);

        textFeldSchrift = new TextFeld();
        textFeldSchrift.setzeText("Stiftfarbe: ");
        textFeldSchrift.setzeSchriftGroesse(20);
        textFeldSchrift.setzeGroesse(textFeldSchrift.text().length()*11, 40);
        textFeldSchrift.setzePosition(fensterbreite - textFeldSchrift.breite() - 40, 45);
        textFeldSchrift.setzeHintergrundFarbe(Farbe.DURCHSICHTIG);
        textFeldSchrift.entferneRand();

        textFeldFarbe = new TextFeld();
        textFeldFarbe.setzeGroesse(20, 20);
        textFeldFarbe.setzePosition(fensterbreite - 65, 55);
        textFeldFarbe.setzeHintergrundFarbe(stiftfarbe);
        textFeldFarbe.entferneRand();



    }

    public void updateBreite(int stiftbreite) {
        textFeldBreite.setzeText("Stiftbreite: " + stiftbreite);
    }

    public void updateFarbe(Color stiftfarbe) {
        textFeldFarbe.setzeHintergrundFarbe(stiftfarbe);
    }

    public void readable(Color hintergrundfarbe){
        System.out.println(hintergrundfarbe);
        if (hintergrundfarbe.equals(Color.black)){
            textFeldSchrift.setzeSchriftFarbe(Farbe.WEISS);
            textFeldBreite.setzeSchriftFarbe(Farbe.WEISS);
        } else{
            textFeldSchrift.setzeSchriftFarbe(Farbe.SCHWARZ);
            textFeldBreite.setzeSchriftFarbe(Farbe.SCHWARZ);
        }
    }

}
