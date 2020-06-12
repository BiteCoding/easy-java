import basis.TextFeld;

import java.awt.*;
import java.text.DecimalFormat;

public class Distance {
    TextFeld textFeld;
    Player player;
    Player target;
    DecimalFormat dc;
    public Distance(Player player, Player target, int frameWidth, Color framColor) {
        this.player = player;
        this.target = target;
        textFeld = new TextFeld();
        textFeld.setzeGroesse(200,50);
        textFeld.setzeHintergrundFarbe(framColor);
        textFeld.setzeSchriftFarbe(player.getColor());
        textFeld.setzePosition(frameWidth/2-textFeld.breite()/2,textFeld.hoehe());
        textFeld.setzeSchriftGroesse(25);
        textFeld.entferneRand();
        dc = new DecimalFormat("0");
    }

    public void getValue(){
        textFeld.setzeText("Distance: " + dc.format(player.getPlayerPos().distance(target.getPlayerPos())));
    }
}
