package game;

import java.awt.Point;
import basis.*;

public class Wolf {
	private Stift meinStift;
	private Point wolfPos;
	private Rotkeappchen red;
	private Point house;
	private Bild wolfSprite;		
	private Bild deadWolfSprite;
	private int fbreite;
	private int fhoehe;
	private boolean alive;

	public Wolf(int fensterbreite, int fensterhoehe, Rotkeappchen redPos, Point phouse) {
		meinStift = new Stift();
		this.fbreite = fensterbreite;
		this.fhoehe = fensterhoehe;
		alive = true;
		meinStift.setzeSchriftGroesse(30);
		meinStift.setzeFuellMuster(Muster.GEFUELLT);
		meinStift.setzeFarbe(Farbe.rgb(126,126,126));
		wolfPos = new Point();
		wolfSprite = new Bild("res/Wolf.png");
		wolfSprite.setzeGroesse(wolfSprite.breite() / 13, wolfSprite.hoehe() / 13);
		deadWolfSprite = new Bild("res/DeadWolf.png");
		deadWolfSprite.setzeSichtbar(false);
		deadWolfSprite.setzeGroesse(deadWolfSprite.breite() / 13, deadWolfSprite.hoehe() / 13);
		this.red = redPos;
		this.house = phouse;
	}

	public double wolfX() {
		return wolfPos.getX();
	}

	public double wolfY() {
		return wolfPos.getY();
	}

	public void position() {
		wolfPos.setLocation(Hilfe.zufall((int) house.getX(),fbreite - wolfSprite.breite()),
				Hilfe.zufall((int) house.getY(),fhoehe - wolfSprite.hoehe()));
		wolfSprite.setzePosition(wolfPos.getX() - wolfSprite.breite() / 2, wolfPos.getY() - wolfSprite.hoehe() / 1.5);
	}

	public void zeichne() {
		this.position();
		meinStift.bewegeAuf(wolfPos.getX(), wolfPos.getY());
		meinStift.zeichneKreis(2);
		meinStift.setzeSchriftGroesse(30);
	}
	
	public void entferne() {
		wolfSprite.setzeSichtbar(false);
		deadWolfSprite.setzePosition(wolfX()-deadWolfSprite.breite()/2, wolfY()-deadWolfSprite.hoehe()/2);
		deadWolfSprite.setzeSichtbar(true);
		alive = false;
	}

	public boolean isAlive() {
		return alive;
	}
	
	public void revive(){
		alive = true;
		deadWolfSprite.setzeSichtbar(false);
		wolfSprite.setzeSichtbar(true);
	}
	
	public void bewege(int px) {
		if(red.isAlive()) {
		meinStift.dreheInRichtung(red.redX(), red.redY());
		meinStift.dreheUm(Hilfe.zufall(-100, 100));
		Hilfe.kurzePause();
		meinStift.bewegeUm(px);
		wolfSprite.setzePosition(wolfPos.getX() - wolfSprite.breite() / 2, wolfPos.getY() - wolfSprite.hoehe() / 1.5);
		wolfPos.setLocation(meinStift.hPosition(), meinStift.vPosition());
		meinStift.setzeFarbe(Farbe.rgb(126, 126, 126));
		meinStift.setzeTransparenzGrad(0.02);
		meinStift.zeichneKreis(7.5);
		meinStift.setzeFarbe(Farbe.rgb(126, 126, 126));
		meinStift.setzeTransparenzGrad(1);
		meinStift.zeichneKreis(2);
		Hilfe.warte(10);
		}
		else {
			meinStift.dreheInRichtung(house.getX(), house.getY());
			meinStift.dreheUm(Hilfe.zufall(-100, 100));
			Hilfe.kurzePause();
			meinStift.bewegeUm(px);
			wolfSprite.setzePosition(wolfPos.getX() - wolfSprite.breite() / 2, wolfPos.getY() - wolfSprite.hoehe() / 1.5);
			wolfPos.setLocation(meinStift.hPosition(), meinStift.vPosition());
			meinStift.setzeFarbe(Farbe.rgb(126, 126, 126));
			meinStift.setzeTransparenzGrad(0.02);
			meinStift.zeichneKreis(7.5);
			meinStift.setzeFarbe(Farbe.rgb(126, 126, 126));
			meinStift.setzeTransparenzGrad(1);
			meinStift.zeichneKreis(2);
			Hilfe.warte(10);
			
			meinStift.dreheInRichtung(house.getX(), house.getY());
			meinStift.dreheUm(Hilfe.zufall(-100, 100));
			Hilfe.kurzePause();
			meinStift.bewegeUm(px);
			wolfSprite.setzePosition(wolfPos.getX() - wolfSprite.breite() / 2, wolfPos.getY() - wolfSprite.hoehe() / 1.5);
			wolfPos.setLocation(meinStift.hPosition(), meinStift.vPosition());
			meinStift.setzeFarbe(Farbe.rgb(126, 126, 126));
			meinStift.setzeTransparenzGrad(0.02);
			meinStift.zeichneKreis(7.5);
			meinStift.setzeFarbe(Farbe.rgb(126, 126, 126));
			meinStift.setzeTransparenzGrad(1);
			meinStift.zeichneKreis(2);
			Hilfe.warte(10);
		}
	}

}
