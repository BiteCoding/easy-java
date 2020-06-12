package github.stringBoy;

import basis.SpriteBild;

public class Animation implements Runnable {
    Dino dino;
    int i;
    private SpriteBild spriteLinks;
    private SpriteBild spriteRechts;
    private SpriteBild spriteMitte;

    public Animation(Dino dino) {
        this.dino = dino;

        spriteLinks = new SpriteBild("/home/simon/Dokumente/JavaCode/Dino/src/res/DinoLinks.png");
        spriteLinks.setzeGroesse(spriteLinks.breite() / 2, spriteLinks.hoehe() / 2);
        spriteLinks.spiegeleBild(false);

        spriteMitte = new SpriteBild("/home/simon/Dokumente/JavaCode/Dino/src/res/Dino.png");
        spriteMitte.setzeGroesse(spriteMitte.breite() / 2, spriteMitte.hoehe() / 2);
        spriteMitte.spiegeleBild(false);

        spriteRechts = new SpriteBild("/home/simon/Dokumente/JavaCode/Dino/src/res/DinoRechts.png");
        spriteRechts.setzeGroesse(spriteRechts.breite() / 2, spriteRechts.hoehe() / 2);
        spriteRechts.spiegeleBild(false);

        i = 0;
    }

    public void placeDino(int x, int y) {
        spriteLinks.setzePosition(x - spriteLinks.mittelpunkt().getX(), y - spriteLinks.mittelpunkt().getY() * 2);
        spriteMitte.setzePosition(x - spriteMitte.mittelpunkt().getX(), y - spriteMitte.mittelpunkt().getY() * 2);
        spriteRechts.setzePosition(x - spriteRechts.mittelpunkt().getX(), y - spriteRechts.mittelpunkt().getY() * 2);
    }

    public SpriteBild getSprite() {
        return spriteLinks;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            placeDino(dino.getX(), dino.getY());
            if (!dino.isJumping) {
                if (i == 0) {
                    spriteLinks.setzeSichtbar(true);
                    spriteMitte.setzeSichtbar(false);
                    spriteRechts.setzeSichtbar(false);
                    i = 1;
                } else if (i == 1) {
                    spriteLinks.setzeSichtbar(false);
                    spriteMitte.setzeSichtbar(true);
                    spriteRechts.setzeSichtbar(false);
                    i = 2;
                } else if (i == 2) {
                    spriteLinks.setzeSichtbar(false);
                    spriteMitte.setzeSichtbar(false);
                    spriteRechts.setzeSichtbar(true);
                    i = 0;
                }
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(10);
                        placeDino(dino.getX(), dino.getY());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
