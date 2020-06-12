import basis.*;

public class DayCounter implements Runnable {

    private Stift pen;
    private TextFeld textField;

    private int days;
    private int discussion;

    public DayCounter(Output output) {
        pen = new Stift();
        textField = new TextFeld();
        //Customizing the textfield
        textField.setzeGroesse(140, 20);
        textField.setzePosition(output.getFrame().breite()-textField.breite()-15, output.getFrame().hoehe()-textField.hoehe()-10);
        textField.setzeText(" Days passed: 0");
        textField.setzeHintergrundFarbe(output.getFrame().hintergrundFarbe());
        textField.setzeSchriftFarbe(Farbe.rgb(217, 219, 66));
        textField.setzeSchriftStil(Schrift.FETT);
        textField.setzeRand(textField.schriftFarbe(), 2);

        days = 0;
        discussion = 0;
    }

    public void countDays(){
        discussion++;
        //If 100 discussions were made one day passes
        if (discussion % 100 == 1){
            days++;
        }
    }

    public void updateDays(){
        textField.setzeText("");
        textField.setzeText(" Days passed: " + days);
    }

    public int getDays() {
        return days;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            updateDays();
            Hilfe.kurzePause();
        }
    }
}
