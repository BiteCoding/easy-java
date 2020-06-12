import basis.*;
public class Picture
{
    Bild bild;
    public Picture(){
        bild = new Bild();
        bild.setzeSichtbar(false);
        bild.setzeMitMausVerschiebbar(true);
    }

    public void ladeBild(){
        bild.ladeBild();
        bild.setzeSichtbar(true);
    }

}
