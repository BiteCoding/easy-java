import basis.Hilfe;

public class Stern {
    int x;
    int y;
    double size;

    public Stern() {
    }

    public void pickLocation() {
        this.x = Hilfe.zufall(100, Hilfe.monitorBreite() - 100);
        this.y = Hilfe.zufall(100, Hilfe.monitorHoehe() - 100);
    }

    public void size() {
        this.size = (double)Hilfe.zufall(30, 120);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return this.size;
    }
}
