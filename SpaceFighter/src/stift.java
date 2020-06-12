import basis.Farbe;
import basis.Hilfe;
import basis.Stift;

public class stift {
    private Stift meinStift = new Stift();
    double score = 0.0D;
    double Sterne;

    public stift() {
        this.meinStift.setzeFarbe(Farbe.WEISS);
    }

    public void end() {
        this.meinStift.bewegeAuf((double)(Hilfe.monitorBreite() / 2 - 270), (double)(Hilfe.monitorHoehe() / 2));
        this.meinStift.setzeSchriftGroesse(50);
        this.meinStift.schreibe("Du hast Gewonnen :)");
        this.meinStift.bewegeAuf((double)(Hilfe.monitorBreite() / 2 - 800), (double)(Hilfe.monitorHoehe() / 2 + 75));
        this.meinStift.schreibe("Um das Programm zu schlie�en m�sst du die ESC-Taste dr�cken.");
    }

    private void Sterne() {
        this.Sterne = this.score / 10.0D * 100.0D;
    }

    public void lose() {
        this.meinStift.bewegeAuf((double)(Hilfe.monitorBreite() / 2 - 400), (double)(Hilfe.monitorHoehe() / 2 + 400));
        this.meinStift.setzeSchriftGroesse(50);
        this.meinStift.setzeFarbe(Farbe.rgb(234.0D, 22.0D, 62.0D));
        this.Sterne();
        this.meinStift.schreibe("Du hast " + (int)this.Sterne + "% der Sterne gesammelt!");
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
