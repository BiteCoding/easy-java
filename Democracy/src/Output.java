import basis.*;
import util.Timer;

import java.awt.*;
import java.text.DecimalFormat;

/**
 * @Author BiteCoding --> https://github.com/BiteCoding/JavaCode
 */

//----------------------------------------------------------------------------------------------------------------------
public class Output {
    private Fenster frame;
    private Stift pen;
    private TextFeld textField;
    private Knopf startButton;
    private Knopf endButton;
    //------------------------------------------------------------------------------------------------------------------
    private boolean startButtonPressed, endButtonPressed, textChange;
    private int percentageRed, width, height, startReds, startBlacks, endReds, endBlacks;
    private String text;

    private Render render;

    //------------------------------------------------------------------------------------------------------------------
    public Output() {
        this.initFrame();
        //--------------------------------------------------------------------------------------------------------------
        this.initPen();
        //--------------------------------------------------------------------------------------------------------------
        this.initTextFields();
        //--------------------------------------------------------------------------------------------------------------
       this.initButtons();
        //--------------------------------------------------------------------------------------------------------------
        startButtonPressed = textChange = false;
        percentageRed = -1;
        text = textField.text();
    }

    public void setRenderer(Render render){
        this.render = render;
        pen.setzeLinienBreite((int)render.getRadius());
    }

    private void initFrame(){
        frame = new Fenster();
        //Scaling the frame
        frame.setzeGroesse(900, 900);
        this.getMonitorSize();
        //Centering the frame in the middle of the screen
        //this.getMonitorSizes();
        frame.setzePosition(width / 2 - frame.breite() / 2,
                height / 2 - frame.hoehe() / 2);
        frame.setzeHintergrundFarbe(Farbe.rgb(61, 50, 91));
        //naming the frame
        frame.setzeTitel("~~~~ DEMOCRACY ~~~~");
    }

    private void initPen(){
        pen = new Stift();
    }

    private void initTextFields(){
        textField = new TextFeld();
        //Customizing the textfield
        textField.setzeGroesse(140, 20);
        //Centering the textfield
        this.getMonitorSize();
        textField.setzePosition(15, 5);
        textField.setzeText(" Proportion red: ");
        textField.setzeHintergrundFarbe(frame.hintergrundFarbe());
        textField.setzeSchriftFarbe(Farbe.rgb(217, 219, 66));
        textField.setzeSchriftStil(Schrift.FETT);
        textField.setzeRand(textField.schriftFarbe(), 2);
    }

    private void initButtons(){
        //START
        startButton = new Knopf();
        //Customizing the startButton
        startButton.setzeGroesse(100, 20);
        //Setting the position of the startButton relative to the position of the textfield
        startButton.setzePosition(frame.breite() / 2 - startButton.breite()/2,
                textField.vPosition());
        startButton.setzeText("START");
        startButton.setzeRand(Farbe.rgb(217, 219, 66), 2);
        startButton.setzeSchriftFarbe(Farbe.rgb(217, 219, 66));
        startButton.setzeHintergrundFarbe(frame.hintergrundFarbe());

        //END
        endButton = new Knopf();
        //Customizing the startButton
        endButton.setzeGroesse(100, 20);
        //Setting the position of the startButton relative to the position of the textfield
        endButton.setzePosition(frame.breite()/2 - endButton.breite()/2,
                frame.hoehe() - 20 - endButton.hoehe() / 2);
        endButton.setzeText("END");
        endButton.setzeRand(Farbe.rgb(217, 219, 66), 2);
        endButton.setzeSchriftFarbe(Farbe.rgb(217, 219, 66));
        endButton.setzeHintergrundFarbe(frame.hintergrundFarbe());
    }

    /**
     * Created my own Method to detect the displaysize because the Method provided by the {@link basis.Hilfe} library
     * detected my dual monitor setup as one giant monitor
     */
    public void getMonitorSize() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        for (int i = 0; i < gs.length; i++) {
            DisplayMode dm = gs[i].getDisplayMode();
            width = dm.getWidth();
            height = dm.getHeight();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight(){
        return height;
    }

    private int reds(Person[][] villager) {
        int reds = 0;
        for (int i = 0; i < villager.length; i++) {
            for (int j = 0; j < villager.length; j++) {
                if (villager[i][j].getParty() <= this.getPercentageRed()) {
                    reds++;
                }
            }
        }
        return reds;
    }

    private int blacks(Person[][] villager) {
        int blacks = 0;
        for (int i = 0; i < villager.length; i++) {
            for (int j = 0; j < villager.length; j++) {
                if (villager[i][j].getParty() > this.getPercentageRed()) {
                    blacks++;
                }
            }
        }
        return blacks;
    }

    public void setBorder(double x, double y, double lastX, double lastY, double radius){
        pen.rechteck(x - radius-pen.linienBreite(),y - radius - pen.linienBreite(),
                lastX + 2*(radius + pen.linienBreite()),lastY + 2*(radius+pen.linienBreite()));
    }

    public void setFirstValues(Person[][] villagers) {
        startBlacks = blacks(villagers);
        startReds = reds(villagers);
    }

    public void setEndValues(Person[][] villagers) {
        endBlacks = blacks(villagers);
        endReds = reds(villagers);
    }

    //------------------------------------------------------------------------------------------------------------------
    public Fenster getFrame() {
        return frame;
    }

    //------------------------------------------------------------------------------------------------------------------
    private String getNumber(String str) {
        String number = "";
        for (int i = text.length(); i < str.length(); i++) {
            number += (str.charAt(i));
        }
        return number;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*METHOD THAT RETURNS IF THE TEXT IN THE TEXTBOX CHANGED AND SETS THE CHANGED VALUE
      AS THE PERCENTAGE OF THE VOTERS WHO VOTE FOR THE RED PARTY*/
    //------------------------------------------------------------------------------------------------------------------
    public boolean textChanged() {
        //checking if the text changed
        if (!textField.text().equals(text) && textField.fokusVerloren()) {
            textChange = true;
            //is the value a valid value?
            try {
                percentageRed = Integer.parseInt(getNumber(textField.text()));
                //values that are not between 0 and 100 are not allowed
                if (percentageRed < 0 || percentageRed > 100) {
                    textField.setzeText(text);
                    throw new IllegalArgumentException();
                }
                textField.setzeEditierbar(false);
            } catch (Exception e1) {
                System.err.println("NOT A VALID VALUE!");
                //resetting the text in the textbox
                textField.setzeText(text);
                //repeat loop until a valid value got inserted
                boolean validValue = false;
                while (!validValue) {
                    //checking if text changed
                    if (!textField.text().equals(text) && textField.fokusVerloren()) {
                        //is the value a valid value?
                        try {
                            percentageRed = Integer.parseInt(getNumber(textField.text()));
                            //values that are not between 0 and 100 are not allowed
                            if (percentageRed < 0 || percentageRed > 100) {
                                textField.setzeText(text);
                                throw new IllegalArgumentException();
                            }
                            textField.setzeEditierbar(false);
                            validValue = true;
                        } catch (Exception e2) {
                            System.err.println("NOT A VALID VALUE!");
                            textField.setzeText(text);
                        }
                    }
                }
            }
        }
        return textChange;
    }

    //------------------------------------------------------------------------------------------------------------------
    public int getPercentageRed() {
        return percentageRed;
    }

    //------------------------------------------------------------------------------------------------------------------
    public boolean isStartButtonPressed() {
        if (startButton.wurdeGedrueckt()) {
            startButtonPressed = true;
        }
        return startButtonPressed;
    }

    //------------------------------------------------------------------------------------------------------------------
    public boolean isEndButtonPressed() {
        if (endButton.wurdeGedrueckt()) {
            endButtonPressed = true;
        }
        return endButtonPressed;
    }

    //------------------------------------------------------------------------------------------------------------------
    public void displayResults(DayCounter dayCounter) {
        DecimalFormat dc = new DecimalFormat("#.##");
        String timeTaken = "The simulation has ended after " + dayCounter.getDays() + " days.";
        String first = "Red starting value: " + startReds + " | " + "Black starting value: " + startBlacks;
        String last = "Red ending value: " + endReds + " | " + "Black ending value: " + endBlacks;
        String totalChange = "Red: " + (endReds - startReds) + " | " + "Black: " + (endBlacks - startBlacks);
        String percentages = "Red: " + dc.format((double)endReds/2500 *100) + "% | "
                + " Blacks: " + dc.format((double)endBlacks/2500 *100)+ "%";
        System.out.println(timeTaken);
        System.out.println(first);
        System.out.println(last);
        System.out.println(totalChange);
        System.out.println(percentages);
    }
}
