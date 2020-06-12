package game;

import java.awt.Point;
import basis.*;

public class Rotkeappchen {
	private Stift meinStift;
	private Point housePos;
	private Point redPos;
	private Bild redSprite;
	private Bild deadRedSpriteBild;
	private int fbreite;
	private int fhoehe;
	private boolean alive;

	public Rotkeappchen(int fensterbreite, int fensterhoehe, Point house) {
		meinStift = new Stift();
		this.fbreite = fensterbreite;
		this.fhoehe = fensterhoehe;
		alive = true;
		meinStift.setzeSchriftGroesse(30);
		meinStift.setzeFuellMuster(Muster.GEFUELLT);
		meinStift.setzeFarbe(Farbe.rgb(186, 59, 59));
		redPos = new Point();
		redSprite = new Bild("res/RotkeappchenSprite.png");
		redSprite.setzeGroesse(redSprite.breite() / 8, redSprite.hoehe() / 8);
		deadRedSpriteBild = new Bild("res/DeadRotkeappchenSprite.png");
		deadRedSpriteBild.setzeSichtbar(false);
		deadRedSpriteBild.setzeGroesse(deadRedSpriteBild.breite()/8, deadRedSpriteBild.hoehe()/8);
		this.housePos = house;
	}
	
	public double redX() {
		return redPos.getX();
	}
	
	public double redY() {
		return redPos.getY();
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void revive(){
		alive = true;
		deadRedSpriteBild.setzeSichtbar(false);
		redSprite.setzeSichtbar(true);
	}
	
	public void entferne() {
		redSprite.setzeSichtbar(false);
		alive = false;
		deadRedSpriteBild.setzePosition(redX()-deadRedSpriteBild.breite()/2, redY()-deadRedSpriteBild.hoehe()/2);
		deadRedSpriteBild.setzeSichtbar(true);
	}
	
	public void position() {
		redPos.setLocation(Hilfe.zufall(50,(int) housePos.getX()), Hilfe.zufall(50, (int) housePos.getY()));
		redSprite.setzePosition(redPos.getX() - redSprite.breite() / 2, redPos.getY() - redSprite.hoehe() / 1.5);
	}

	public void zeichne() {
		this.position();
		meinStift.bewegeAuf(redPos.getX(), redPos.getY());
		meinStift.zeichneKreis(1);
		meinStift.setzeSchriftGroesse(30);
	}

	public void bewege(int px) {
			meinStift.dreheInRichtung(housePos.getX(), housePos.getY());
			meinStift.dreheUm(Hilfe.zufall(-100, 100));
			Hilfe.kurzePause();
			meinStift.bewegeUm(px);
			redSprite.setzePosition(redPos.getX() - redSprite.breite() / 2, redPos.getY() - redSprite.hoehe() / 1.5);
			redPos.setLocation(meinStift.hPosition(), meinStift.vPosition());
			meinStift.setzeFarbe(Farbe.rgb(186, 59, 59));
			meinStift.zeichneKreis(2);
			Hilfe.warte(10);
	}

}
