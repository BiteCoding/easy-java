import basis.Farbe;
import basis.Fenster;
import basis.Hilfe;

public class Output {
    private Fenster frame;

    public Output() {
        frame = new Fenster(Hilfe.monitorBreite(), Hilfe.monitorHoehe());
        frame.setzeHintergrundFarbe(Farbe.rgb(40, 40, 40));
    }

    public Fenster getFrame() {
        return frame;
    }
}
