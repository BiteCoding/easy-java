import basis.Farbe;
import basis.Stift;

public class rocket {
    private Stift meinStift;
    double xPos;
    double yPos;
    double streckung;
    int Score = 0;

    public rocket() {
        this.xPos = 200.0D;
        this.yPos = 200.0D;
        this.streckung = 2.55D;
        this.meinStift = new Stift();
        this.meinStift.setzeFarbe(Farbe.WEISS);
    }

    public rocket(double pxPos, double pyPos, double pstreckung) {
        this.xPos = pxPos;
        this.yPos = pyPos;
        this.streckung = pstreckung;
        this.meinStift = new Stift();
    }

    public double getxPos() {
        return this.xPos;
    }

    public int getScore() {
        return this.Score;
    }

    public void setScore(int score) {
        this.Score = score;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return this.yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public double getStreckung() {
        return this.streckung;
    }

    public void setStreckung(double streckung) {
        this.streckung = streckung;
    }
}
