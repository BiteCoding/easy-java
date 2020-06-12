import basis.Fenster;
import basis.Hilfe;

class Frame {
    private final Fenster frame;
    public Frame(){
        frame = new Fenster(300,300);
        frame.setzePosition(Hilfe.monitorBreite()/2-frame.breite()/2, Hilfe.monitorHoehe()/2-frame.hoehe()/2);
        frame.setzeSichtbar(true);
        frame.setzeTitel("TIC - TAC - TOE");
    }
    public void setSize(int w, int h){
        frame.setzeGroesse(w,h);
    }

   public  int wigth(){
        return frame.breite();
   }

   public int height(){
        return  frame.hoehe();
   }

   public void reset(){
        frame.loescheAlles();
   }

    public void middle() {
        frame.setzePosition(Hilfe.monitorBreite()/2-frame.breite()/2, Hilfe.monitorHoehe()/2-frame.hoehe()/2);
    }
}
