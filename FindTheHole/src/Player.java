import basis.Hilfe;
import basis.Maus;
import basis.Stift;

import java.awt.*;

public class Player {
    private Point playerPos;
    private Maus mouse;
    private Stift pen;
    private Color c;

    private Point[] positions;
    private double[] angles;
    private int times;
    private boolean updated;

    public Player(int x, int y, Color color) {
        playerPos = new Point(x, y);
        mouse = new Maus();
        pen = new Stift();
        pen.bewegeAuf(playerPos.getX(),playerPos.getY());
        c = color;

        times = 0;
        updated = false;
        positions = new Point[200];
        angles = new double[positions.length];
    }

    public void move(){
        pen.dreheInRichtung(mouse.hPosition(),mouse.vPosition());
        pen.bewegeUm(1);
        playerPos.setLocation(pen.hPosition(),pen.vPosition());
        updated = false;

        Point temp = new Point(playerPos);
        if (positions[positions.length-1] == null){
            positions[times] = temp;
            angles[times] = penOrientation();
        } else {
            System.arraycopy(positions,1,positions,0,positions.length-1);
            positions[positions.length-1] = temp;

            System.arraycopy(angles,1,angles,0,angles.length-1);
            angles[angles.length-1] = penOrientation();
        }
        times++;
        Hilfe.warte(1);
    }

    public double[] getAngles() {
        return angles;
    }

    public double penOrientation(){
        return pen.winkel()+90;
    }

    public boolean isUpdated() {
        return updated;
    }

    public Point[] getPositions() {
        return positions;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public Color getColor() {
        return c;
    }

    public Point getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(Point playerPos) {
        this.playerPos = playerPos;
    }
}