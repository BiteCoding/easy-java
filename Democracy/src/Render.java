import basis.Farbe;
import basis.Muster;
import basis.Stift;

/**
 * @Author BiteCoding --> https://github.com/BiteCoding/JavaCode
 */

//----------------------------------------------------------------------------------------------------------------------
public class Render {
    Stift pen;
    Person [][] villager;
    double radius;

    //------------------------------------------------------------------------------------------------------------------
    public Render(Person[][] villager, int frameWidth) {
        pen = new Stift();
        pen.setzeFuellMuster(Muster.GEFUELLT);
        this.villager = villager;
        radius = ((frameWidth-50)/ villager.length) / 2 - (frameWidth/villager.length)*0.05;
    }

    //------------------------------------------------------------------------------------------------------------------
    //DRAWING THE VILLAGERS TO THE FRAME
    public void renderAll(int redPercentage) {
        for (int i = 0; i < villager.length; i++) {
            for (int j = 0; j < villager.length; j++) {
                if (villager[i][j].getParty() <= redPercentage) {
                    pen.setzeFarbe(Farbe.ROT);
                } else {
                    pen.setzeFarbe(Farbe.SCHWARZ);
                }
                pen.kreis(villager[i][j].getPosition().getX(),
                        villager[i][j].getPosition().getY(),
                        radius);
            }
        }
    }

        public void renderOne(Person villager, int redPercentage) {
                    if (villager.getParty() <= redPercentage) {
                        pen.setzeFarbe(Farbe.ROT);
                    } else {
                        pen.setzeFarbe(Farbe.SCHWARZ);
                    }
                    pen.kreis(villager.getPosition().getX(),
                            villager.getPosition().getY(),
                            radius);
    }


    //------------------------------------------------------------------------------------------------------------------
    public double getRadius() {
        return radius;
    }
}
