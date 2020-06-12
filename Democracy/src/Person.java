import basis.Hilfe;

import java.awt.*;

/**
 * @Author BiteCoding --> https://github.com/BiteCoding/JavaCode
 */

//----------------------------------------------------------------------------------------------------------------------
class Person {
    //------------------------------------------------------------------------------------------------------------------
    private Point position;
    private int party;

    //------------------------------------------------------------------------------------------------------------------
    Person(int x, int y, int rand) {
        position = new Point(x, y);
        party = rand;
    }

    //------------------------------------------------------------------------------------------------------------------
    void discuss(Person[][] persons, int redBorder, Render render) {
        Person person1 = persons[Hilfe.zufall(0, 49)][Hilfe.zufall(0, 49)];
        Person person2 = persons[Hilfe.zufall(0, 49)][Hilfe.zufall(0, 49)];
        //if person1.getParty() <= redBorder ==> member of the red party
        //if person1.getParty() > redBorder ==> member of the black party
        if (person1.getParty() > redBorder != person2.getParty() > redBorder) {
            int randValue = Hilfe.zufall(0, 1);
            if (randValue == 1) {
                person1.setParty(person2.getParty());
                render.renderOne(person1, redBorder);
            } else {
                person2.setParty(person1.getParty());
                render.renderOne(person2, redBorder);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    Point getPosition() {
        return position;
    }

    //------------------------------------------------------------------------------------------------------------------
    int getParty() {
        return party;
    }

    //------------------------------------------------------------------------------------------------------------------
    private void setParty(int party) {
        this.party = party;
    }
    //------------------------------------------------------------------------------------------------------------------
}
