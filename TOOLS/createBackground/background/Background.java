package background;

	import basis.Bild;
	import basis.Farbe;
	import basis.Fenster;
	import basis.Hilfe;
	public class Background {
		private Fenster fenster;
		private Bild NAME;
		
		private String PATH = "createBackground/background/res/Baum.png";
		private int dichte = 1000;
		
	public Background() {
		fenster = new Fenster(Hilfe.monitorBreite(), Hilfe.monitorHoehe());
		fenster.setzeTitel("Dichte: "+ dichte);
		fenster.setzeHintergrundFarbe(Farbe.rgb(22, 136, 0));
		fenster.setzeSichtbar(false);
		for (int i = 0; i < dichte; i++) {
			NAME = new Bild(PATH);
			NAME.setzeGroesse(NAME.breite()/4, NAME.hoehe()/4);
			NAME.setzePosition(Hilfe.zufall(0,fenster.breite()), Hilfe.zufall(0,fenster.hoehe()));
		}
		fenster.setzeSichtbar(true);
		}
		public static void main(String[] args) {
			Background back = new Background();
		}

	}

