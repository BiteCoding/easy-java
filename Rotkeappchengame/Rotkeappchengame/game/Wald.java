package game;

import java.awt.Point;

import basis.*;
import reader.ReaderRotkaeppchen;
import writer.WriterRotkaeppchen;

public class Wald {
	private Fenster meinFenster;
	private Tastatur keyboard;
	private Point house;
	private Bild houseSprite;
	private Bild baumSprite;
	private Bild gunfireSprite;
	private Bild schriftJaeger;
	private Bild schriftWolfRed;
	private Bild schriftWolfOma;
	private Bild schriftRedDa;
	private Bild rundeEnde;
	private Bild explosionSprite;
	private WriterRotkaeppchen writer;
	private WriterRotkaeppchen analytics;
	private ReaderRotkaeppchen reader;
	private Rotkeappchen red;
	private Wolf wolf;
	private Jaeger jaeger;
//----------------------------
	private int anzahl;
	

	public Wald() {
		meinFenster = new Fenster(1920, 1080);
		meinFenster.setzeTitel("Rotäppchen");
		meinFenster.setzeSichtbar(false);
		meinFenster.ladeBildInZeichenflaeche("res/Background500.png");
		
		keyboard = new Tastatur();
		
		anzahl = 1;
		
		house = new Point();
		
		rundeEnde = new Bild("res/RundeEnde.png");
		rundeEnde.setzeSichtbar(false);
		rundeEnde.setzeGroesse(meinFenster.breite(), meinFenster.hoehe());
		
		houseSprite = new Bild("res/house.png");
		houseSprite.setzeGroesse(houseSprite.breite() / 5, houseSprite.hoehe() / 5);
		
		gunfireSprite = new Bild("res/Gunfire.png");
		gunfireSprite.setzeSichtbar(false);
		gunfireSprite.setzeGroesse(gunfireSprite.breite()/4, gunfireSprite.hoehe()/4);
		
		red = new Rotkeappchen(meinFenster.breite(), meinFenster.hoehe(), house);
		wolf = new Wolf(meinFenster.breite(), meinFenster.hoehe(), red, house);
		jaeger = new Jaeger(meinFenster.breite(), meinFenster.hoehe(), wolf, house);
		

		explosionSprite = new Bild("res/explosion.png");
		explosionSprite.setzeGroesse(explosionSprite.breite()/8, explosionSprite.hoehe()/8);
		explosionSprite.setzeSichtbar(false);
		
		schriftJaeger = new Bild("res/JaegerGeschossen.png");
		schriftRedDa = new Bild("res/RotkaeppchenErreicht.png");
		schriftWolfOma = new Bild("res/WolfOmaGefressen.png");
		schriftWolfRed = new Bild("res/WolfGefressenSchrift.png");
		
		schriftJaeger.setzeGroesse(schriftJaeger.breite()/2, schriftJaeger.hoehe()/2);
		schriftJaeger.setzePosition(meinFenster.breite()/2-schriftJaeger.breite()/2, meinFenster.hoehe()/2-400);
		
		schriftRedDa.setzeGroesse(schriftRedDa.breite()/2, schriftRedDa.hoehe()/2);
		schriftRedDa.setzePosition(meinFenster.breite()/2-schriftRedDa.breite()/2, meinFenster.hoehe()/2-400);

		schriftWolfOma.setzeGroesse(schriftWolfOma.breite()/2, schriftWolfOma.hoehe()/2);
		schriftWolfOma.setzePosition(meinFenster.breite()/2-schriftWolfOma.breite()/2, meinFenster.hoehe()/2-400);
		
		schriftWolfRed.setzeGroesse(schriftWolfRed.breite()/2, schriftWolfRed.hoehe()/2);
		schriftWolfRed.setzePosition(meinFenster.breite()/2-schriftWolfRed.breite()/2, meinFenster.hoehe()/2-400);
		
		schriftJaeger.setzeSichtbar(false);
		schriftRedDa.setzeSichtbar(false);
		schriftWolfOma.setzeSichtbar(false);
		schriftWolfRed.setzeSichtbar(false);
		
		for (int i = 0; i < 200; i++) {
			baumSprite = new Bild("res/Baum.png");
			baumSprite.setzeGroesse(houseSprite.breite() / 1.5, houseSprite.hoehe() / 1.5);
			baumSprite.setzePosition(Hilfe.zufall(0, meinFenster.breite() - baumSprite.breite()),
					Hilfe.zufall(0, meinFenster.hoehe() - baumSprite.hoehe()));
		}
		
		//writer = new WriterRotkaeppchen("statistics/Run.txt");
		//analytics = new WriterRotkaeppchen("statistics/Results.txt");
		//reader = new ReaderRotkaeppchen("statistics/Run.txt");
		
		//writer.clear();
		//analytics.clear();
	}

	public void zeichneHaus() {
		meinFenster.ladeBildInZeichenflaeche("res/Background500.png");
		meinFenster.setzeSichtbar(true);
		house.setLocation(Hilfe.zufall(50, meinFenster.breite() - 50), Hilfe.zufall(50, meinFenster.hoehe() - 50));
		houseSprite.setzePosition(house.getX() - houseSprite.breite() / 2, house.getY() - houseSprite.hoehe() / 2);
	}

	public void fuehreAus() {
		System.out.println("------ " + "Runde " + anzahl + " ------");
		//writer.write("------ " + "Runde " + anzahl + " ------\n");
		this.zeichneHaus();
		red.zeichne();
		wolf.zeichne();
		jaeger.zeichne();
		while (!keyboard.istGedrueckt(Zeichen.ESC)) {
			if(red.isAlive()) {
				if(wolf.isAlive()) {
					red.bewege(3);
				}
				else {
					red.bewege(2);
				}
			}
			if(wolf.isAlive()) {
			jaeger.bewege(3);
			jaeger.richtung(wolf.wolfX() > jaeger.jaegerX());
			}
			
			if(red.isAlive()) {
				if (((red.redX() > wolf.wolfX() - 15) && (red.redX() < wolf.wolfX() + 15)
						&& (red.redY() > wolf.wolfY() - 15 && red.redY() < wolf.wolfY() + 15))) {
					System.out.println("Der Wolf hat das Rotk�ppchen gefressen!");
					//writer.write("Der Wolf hat das Rotkaeppchen gefressen!\n");
					schriftWolfRed.setzeSichtbar(true);
					red.entferne();
					Hilfe.warte(1000);
					schriftWolfRed.setzeSichtbar(false);
					
				}
			}
			
			if(wolf.isAlive()) {
				wolf.bewege(4);
				if ((wolf.wolfX() > jaeger.jaegerX() - 75 && wolf.wolfX() < jaeger.jaegerX() + 75)
						&& (wolf.wolfY() > jaeger.jaegerY() - 75 && wolf.wolfY() < jaeger.jaegerY() + 75)) {
					System.out.println("Der J�ger hat den Wolf erschossen!");
					//writer.write("Der Jaeger hat den Wolf erschossen!\n");
					schriftJaeger.setzeSichtbar(true);
					wolf.entferne();
					explosionSprite.setzePosition(jaeger.jaegerX()-explosionSprite.breite()/2, jaeger.jaegerY()-explosionSprite.hoehe()/2);
					explosionSprite.setzeSichtbar(true);
					gunfireSprite.setzePosition(wolf.wolfX(), wolf.wolfY());
					gunfireSprite.setzeSichtbar(true);
					Hilfe.warte(1000);
					explosionSprite.setzeSichtbar(false);
					gunfireSprite.setzeSichtbar(false);
					schriftJaeger.setzeSichtbar(false);
					
				}
			}
			
			if ((red.redX() == house.getX()) && (red.redY() == house.getY())) {
				System.out.println("Das Rotk�ppchen hat das Haus erreicht!");
				//writer.write("Das Rotkaeppchen hat das Haus erreicht!\n");
				schriftRedDa.setzeSichtbar(true);
				Hilfe.warte(1000);
				schriftRedDa.setzeSichtbar(false);
				break;
			}
			
			if ((wolf.wolfX() == house.getX()) && (wolf.wolfY() == house.getY())) {
				System.out.println("Der Wolf hat die Oma gefressen!");
				//writer.write("Der Wolf hat die Oma gefressen!\n");
				schriftWolfOma.setzeSichtbar(true);
				Hilfe.warte(1000);
				schriftWolfOma.setzeSichtbar(false);
				break;
			}
			
			if(!wolf.isAlive() && !red.isAlive()) {
				break;
			}
			
		}
		
		System.err.println("    Runde beendet");
		//writer.write("    Runde beendet\n");
		rundeEnde.setzeSichtbar(true);
		//analytics.clear();
		//reader.read();
		//for(int i = 0; i < reader.stringsLength(); i++) {
			//analytics.write(reader.results()[i]);
		//}
				Hilfe.warte(1000);
				meinFenster.loescheAlles();
				rundeEnde.setzeSichtbar(false);
				wolf.revive();
				jaeger.revive();
				red.revive();
				anzahl++;
				this.fuehreAus();
	}

	public static void main(String[] args) {
		Wald wald = new Wald();
		wald.fuehreAus();
	}

}
