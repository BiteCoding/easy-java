import basis.Hilfe;
import util.Timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author BiteCoding --> https://github.com/BiteCoding/JavaCode
 */

//----------------------------------------------------------------------------------------------------------------------
public class Operator {

    //--------------------------------------------------Needed classes--------------------------------------------------
    private Output output;
    private Render render;
    private Person villagers;
    private DayCounter dayCounter;
    private Timer timer;

    private ExecutorService executor = Executors.newCachedThreadPool();
    //----------------------------------------Array that represents the village-----------------------------------------
    private Person[][] village;

    //---------------------------------------------------Constructor----------------------------------------------------
    public Operator() {
        output = new Output();
        village = new Person[50][50];
        render = new Render(village,output.getFrame().breite());
        dayCounter = new DayCounter(output);
        output.setRenderer(render);
        timer = new Timer();
        //dummy for operating methods
        villagers = new Person(-1, -1, -1);
    }

    private boolean isAutocracy(int border) {
        int value = village[0][0].getParty();
        for (int i = 0; i < village.length; i++) {
            for (int j = 0; j < village.length; j++) {
                if (value > border != village[i][j].getParty() > border){
                    return false;
                }
            }
        }
        return true;
    }

    private void fillVillage() {
        for (int i = 0; i < village.length; i++) {
            for (int j = 0; j < village.length; j++) {
                //Positions the Person in between a rectangle with x:50, y:50, w:framewidth - 100, h: frameheight - 100
                Person villager = new Person(
                        //------------------------------------------ x -------------------------------------------------
                        ((1 + i) * (output.getFrame().breite() - 100) / village.length) + 50 - 7,
                        //------------------------------------------ y -------------------------------------------------
                        ((1 + j) * (output.getFrame().hoehe() - 100) / village.length) + 50 - 7,
                        //----------------------------------------random------------------------------------------------
                        Hilfe.zufall(1, 100));
                village[i][j] = villager;
            }
        }
    }

    private void drawBorder() {
        output.setBorder(village[0][0].getPosition().getX(), village[0][0].getPosition().getX(),
                village[village.length - 1][village.length - 1].getPosition().getX()
                        - village[0][0].getPosition().getX(),
                village[village.length - 1][village.length - 1].getPosition().getY()
                        - village[0][0].getPosition().getY(), render.getRadius() + render.getRadius() * 0.5);
    }

    //-------------------------------------------------operating method-------------------------------------------------
    private void start(){
        while (!output.isStartButtonPressed() || !output.textChanged()) {
            Hilfe.kurzePause();
        }
        timer.start();
        render.renderAll(output.getPercentageRed());
        output.setFirstValues(village);
        executor.execute(dayCounter);
        while (!output.isEndButtonPressed() && !this.isAutocracy(output.getPercentageRed())) {
            villagers.discuss(village, output.getPercentageRed(), render);
            dayCounter.countDays();
        }
        timer.end();
        System.out.println(timer.timeNeeded());
        output.setEndValues(village);
        output.displayResults(dayCounter);
        Hilfe.warte(500);
        System.exit(0);
    }

    //-----------------------------------------------------main method--------------------------------------------------
    public static void main(String[] args) {
        Operator op = new Operator();
        op.fillVillage();
        op.drawBorder();
        op.start();
    }
//----------------------------------------------------------------------------------------------------------------------
}
