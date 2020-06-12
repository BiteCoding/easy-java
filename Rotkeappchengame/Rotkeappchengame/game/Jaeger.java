package game;

import java.awt.Point;

import com.sun.org.apache.regexp.internal.REDebugCompiler;

import basis.*;

public class Jaeger {
	private Stift meinStift;
	private Point jaegerPos;
	private Wolf wolf;
	private Point house;
	private Bild jaegerSpriteLinks;
	private Bild jaegerSpriteRechts;
	private int fbreite;
	private int fhoehe;
	private boolean alive;

	public Jaeger(int fensterbreite, int fensterhoehe, Wolf wolfPos, Point phouse) {
		meinStift = new Stift();
		this.fbreite = fensterbreite;
		this.fhoehe = fensterhoehe;
		
		alive = true;
		
		meinStift.setzeSchriftGroesse(30);
		meinStift.setzeFuellMuster(Muster.GEFUELLT);
		meinStift.setzeFarbe(Farbe.rgb(180, 249, 167));
		
		jaegerPos = new Point();
		
		jaegerSpriteLinks = new Bild("res/Jaeger.png");
		jaegerSpriteLinks.setzeGroesse(jaegerSpriteLinks.breite() / 7.5, jaegerSpriteLinks.hoehe() / 7.5);
		
		jaegerSpriteRechts = new Bild("res/Jaeger.png");
		jaegerSpriteRechts.setzeGroesse(jaegerSpriteRechts.breite() / 7.5, jaegerSpriteRechts.hoehe() / 7.5);
		jaegerSpriteRechts.spiegeleBild(false);
		
		this.wolf = wolfPos;
		this.house = phouse;
	}

	public double jaegerX() {
		return jaegerPos.getX();
	}

	public double jaegerY() {
		return jaegerPos.getY();
	}

	public boolean isAlive() {
		return alive;
	}
	
	public void revive(){
		alive = true;
		jaegerSpriteLinks.setzeSichtbar(true);
	}
	
	public void entferne() {
		jaegerSpriteLinks.setzeSichtbar(false);
		alive = false;
	}
	
	public void richtung(boolean b) {
		if(b) {
			jaegerSpriteLinks.setzeSichtbar(false);
			jaegerSpriteRechts.setzeSichtbar(true);
		} else {
			jaegerSpriteLinks.setzeSichtbar(true);
			jaegerSpriteRechts.setzeSichtbar(false);
		}
	}
	
	public void position() {
		jaegerPos.setLocation(Hilfe.zufall((int) house.getX(),fbreite - jaegerSpriteLinks.breite()),
				Hilfe.zufall((int) house.getY(),fhoehe - jaegerSpriteLinks.hoehe()));
		jaegerSpriteLinks.setzePosition(jaegerPos.getX() - jaegerSpriteLinks.breite() / 2, jaegerPos.getY() - jaegerSpriteLinks.hoehe() / 1.5);
		jaegerSpriteRechts.setzePosition(jaegerPos.getX() - jaegerSpriteRechts.breite() / 2, jaegerPos.getY() - jaegerSpriteRechts.hoehe() / 1.5);
	}

	public void zeichne() {
		this.position();
		meinStift.bewegeAuf(jaegerPos.getX(), jaegerPos.getY());
		meinStift.zeichneKreis(2);
		meinStift.setzeSchriftGroesse(30);
	}

	public void bewege(int px) {
		meinStift.dreheInRichtung(wolf.wolfX(), wolf.wolfY());
		Hilfe.kurzePause();
		meinStift.dreheUm(Hilfe.zufall(-100, 100));
		meinStift.bewegeUm(px);
		jaegerSpriteLinks.setzePosition(jaegerPos.getX() - jaegerSpriteLinks.breite() / 2, jaegerPos.getY() - jaegerSpriteLinks.hoehe() / 1.5);
		jaegerSpriteRechts.setzePosition(jaegerPos.getX() - jaegerSpriteRechts.breite() / 2, jaegerPos.getY() - jaegerSpriteRechts.hoehe() / 1.5);
		jaegerPos.setLocation(meinStift.hPosition(), meinStift.vPosition());
		meinStift.setzeFarbe(Farbe.rgb(180, 249, 167));
		meinStift.setzeTransparenzGrad(0.02);
		meinStift.zeichneKreis(7.5);
		meinStift.setzeFarbe(Farbe.rgb(180, 249, 167));
		meinStift.setzeTransparenzGrad(1);
		meinStift.zeichneKreis(2);
		Hilfe.warte(10);
	}

}
