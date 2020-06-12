import basis.Farbe;
import basis.Stift;

class Pen {
    private final Stift stift;
    private final Frame frame;
    public Pen(Frame fenster){
        stift = new Stift();
        frame = fenster;
        stift.setzeLinienBreite(5);
    }

    public void drawGrid(){
        //vertical
        stift.linie(0, frame.height()/3, frame.wigth(), frame.height()/3);
        stift.linie(0, frame.height()/3 + frame.height()/3, frame.wigth(), frame.height()/3+frame.height()/3);

        //horizontal
        stift.linie(frame.wigth()/3, 0, frame.wigth()/3, frame.height());
        stift.linie(frame.wigth()/3+frame.wigth()/3, 0, frame.wigth()/3+frame.wigth()/3, frame.height());
    }

    public void drawWin(int x1, int y1, int x2, int y2){
        stift.setzeFarbe(Farbe.ROT);
        stift.setzeLinienBreite(12);
        stift.linie(x1,y1,x2,y2);
        stift.setzeFarbe(Farbe.SCHWARZ);
        stift.setzeLinienBreite(5);
    }

    public void drawX(int x, int y){
        x = x +frame.wigth()/6;
        y = y+ frame.height()/6;
        stift.linie(x - frame.wigth()/8,y - frame.height()/8, x + frame.wigth()/8, y + frame.wigth()/8);
        stift.linie(x + frame.wigth()/8,y - frame.wigth()/8, x - frame.wigth()/8, y + frame.wigth()/8);
    }

    public void drawO(int x, int y){
        stift.kreis(x+frame.wigth()/6, y+frame.height()/6, frame.wigth()/8);
    }

}
