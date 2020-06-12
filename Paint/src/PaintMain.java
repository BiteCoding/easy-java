import basis.*;

import javax.swing.*;

public class PaintMain {
    private Canvas c;
    private Brush b;
    private Picture p;
    private ColorPicker color;
    private Output o;
    private Maus m;
    private Tastatur t;

    private String text;
    private int number;

    public PaintMain() {
        c = new Canvas(Hilfe.monitorBreite(), Hilfe.monitorHoehe(), "Paint");
        b = new Brush();
        b.setBreite(4);
        color = new ColorPicker();
        o = new Output(c.wigth(), b.getBreite(), b.getColor());
        m = new Maus();
        t = new Tastatur();
        text = null;
    }

    public void run() {
        while (!t.istGedrueckt(Zeichen.ESC)) {
            Hilfe.kurzePause();
            b.setzePosition(m.hPosition(), m.vPosition());
            if (m.istGedrueckt()) {
                b.draw();
            } else {
                b.dontDraw();
            }
            if (t.istGedrueckt(Zeichen.PFEILOBEN) && b.getBreite() < 15) {
                b.setBreite(b.getBreite() + 1);
                Hilfe.pause(200);
                System.out.println("Breite: " + b.getBreite());
                o.updateBreite(b.getBreite());
            }

            if (t.istGedrueckt(Zeichen.PFEILUNTEN) && b.getBreite() > 1) {
                b.setBreite(b.getBreite() - 1);
                Hilfe.pause(200);
                System.out.println("Breite: " + b.getBreite());
                o.updateBreite(b.getBreite());
            }

            if (t.istGedrueckt('f')) {
                try {
                    int[] rgb = color.choseColor();
                    b.color(rgb[0], rgb[1], rgb[2]);
                    o.updateFarbe(b.getColor());
                } catch (Exception e) {
                    System.err.println("Failed to pass values");
                }


            }

            if (t.istGedrueckt('s')) {
                c.savePicture();
            }

            if (t.istGedrueckt('b')) {
                int[] rgb = color.choseColor();
                c.setBackColor(rgb[0], rgb[1], rgb[2]);
                o.readable(c.getColor());
            }

            if (t.istGedrueckt('p')) {
                p = new Picture();
                p.ladeBild();
            }

            if (t.istGedrueckt('t')) {
                b.write(text = JOptionPane.showInputDialog(null, "Type in the text you want to print on the screen") ,number = Integer.parseInt(JOptionPane.showInputDialog(null,"How big shall the text be?", 30)));
                Hilfe.warte(500);
            }
        }
        int n = JOptionPane.showConfirmDialog(null, "Möchten Sie das Projekt vor dem beenden speichern?", "Speichern?", 1, JOptionPane.WARNING_MESSAGE);
        if (n == 0) {
            c.savePicture();
            System.exit(0);
        } else if (n == 2) {
            run();
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        PaintMain m;
        m = new PaintMain();
        m.run();
    }
}

