import basis.*;

import java.text.DecimalFormat;

public class Output {
    private Fenster frame;
    private Stift pen;
    private int values;
    private int nullSlots;
    private double YSCALE;
    private double MAXIMUM;
    private double GRIDSIZE;

    public Output() {
        frame = new Fenster("Gamble Results",
                Hilfe.monitorBreite() / 2 - 400,
                Hilfe.monitorHoehe() / 2 - 400,
                800, 800);
        frame.setzeSichtbar(false);
        pen = new Stift();
        pen.setzeFarbe(Farbe.ROT);
        pen.setzeFuellMuster(Muster.GEFUELLT);
    }

    public void setVisibility(boolean visible) {
        frame.setzeSichtbar(visible);
    }

    public int[] trimArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                values++;
            } else if (values == 0) {
                nullSlots++;
            }
        }
        int[] trimmedArray = new int[values];
        for (int i = 0; i < trimmedArray.length; i++) {
            trimmedArray[i] = array[i + nullSlots];
        }
        return trimmedArray;
    }

    private void makeScala(int[] array, long total) {
        int max = 0;
        for (int value : array
        ) {
            if (max < value) {
                max = value;
            }
        }

        MAXIMUM = max;

        double average = max / array.length;
        YSCALE = frame.hoehe() / average;

        GRIDSIZE = (frame.breite()-50) / array.length;

        double zahl = 1;
        for (double i = 0; i < 0.8; i+=0.1) {
            TextFeld scalaY = new TextFeld(0, frame.hoehe()*i,50,20);
            scalaY.setzeHintergrundFarbe(Farbe.DURCHSICHTIG);
            scalaY.setzeEditierbar(false);
            scalaY.entferneRand();
            DecimalFormat df = new DecimalFormat("0");
            String partNumber = df.format(max*zahl);
            zahl-=0.1;
            Hilfe.pause(10);
            scalaY.setzeText(partNumber);
        }
    }

    public void drawGraph(int[] array, long total) {
        makeScala(array, total);
        Hilfe.kurzePause();
        for (int i = 0; i < array.length; i++) {
            double yValue = ((double) array[i] / MAXIMUM) * (frame.hoehe() - 100);
            pen.rechteck(50+GRIDSIZE * i + GRIDSIZE / 4, frame.breite() - yValue - GRIDSIZE, GRIDSIZE / 2, yValue);
            Hilfe.kurzePause();

            Hilfe.kurzePause();
            ZahlenFeld scalaX = new ZahlenFeld(50+GRIDSIZE * i + GRIDSIZE / 2 - 10, frame.breite() - GRIDSIZE, 20, 20);
            scalaX.setzeGroesse(GRIDSIZE, GRIDSIZE);
            scalaX.setzeHintergrundFarbe(Farbe.DURCHSICHTIG);
            scalaX.setzeEditierbar(false);
            scalaX.entferneRand();
            scalaX.setzeZahl(i + nullSlots + 1);
        }
    }


}
