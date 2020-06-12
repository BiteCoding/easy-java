package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderRotkaeppchen {

	// OPTIONAL
	private double wolfRot, wolfOma, jaegerWolf, rotOma;
	private double gesamt, fehler, runden, male;
	private String path;
	private String[] strings;

	public ReaderRotkaeppchen(String PATH) {
		// OPTIONAL
		wolfRot = 0;
		wolfOma = 0;
		jaegerWolf = 0;
		rotOma = 0;
		gesamt = 0;
		runden = 0;
		male = 0;
		strings = new String[13];
		this.path = PATH;

	}

	public void read() {
		File file = new File(path);

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			male++;
			while ((st = br.readLine()) != null) {
				// OPTIONAL
				switch (st) {
				case "Der Wolf hat das Rotkaeppchen gefressen!":
					this.setWolfRot(this.getWolfRot()+1);
					break;

				case "Der Wolf hat die Oma gefressen!":
					this.setWolfOma(this.getWolfOma()+1);
					break;

				case "Der Jaeger hat den Wolf erschossen!":
					this.setJaegerWolf(this.getJaegerWolf()+1);
					break;

				case "Das Rotkaeppchen hat das Haus erreicht!":
					this.setRotOma(this.getRotOma()+1);
					break;
					
				case "    Runde beendet":
					this.setRunden(this.getRunden()+1);

				default:
					this.setFehler(this.getFehler()+1);
					break;
				}
			}

			// OPTIONAL
			this.setGesamt( this.getWolfOma() + this.getWolfRot() + this.getJaegerWolf() + this.getRotOma());
			
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int stringsLength() {
		return strings.length;
	}

	public String[] results() {
		
		strings[0] = "Gesamte Aktionen: " + Math.round(gesamt) + "\n";
		
		strings[1] = "Der Wolf hat das Rotk�ppchen " + Math.round(wolfRot) + "-mal gefressen. ";
		strings[2] = "(" + (Math.round((wolfRot / gesamt)*100)) + "%)\n";
		
		strings[3] = "Der Wolf hat die Oma " + Math.round(wolfOma) + "-mal gefressen. ";
		strings[4] = "(" + (Math.round((wolfOma / gesamt) * 100)) + "%)\n";
		
		strings[5] = "Der J�ger hat den Wolf " + Math.round(jaegerWolf) + "-mal erschossen. ";
		strings[6] = "(" + Math.round((jaegerWolf / gesamt) * 100)  + "%)\n";
		
		strings[7] = "Das Rotk�ppchen hat das Haus der Oma " + Math.round(rotOma) + "-mal erreicht. ";
		strings[8] = "(" + (Math.round((rotOma / gesamt) * 100)) + "%)\n";
		
		strings[9] = "Not matched: " + Math.round(fehler) + " / Gesamt: " + Math.round(gesamt + fehler);
		strings[10] = " (" + Math.round(fehler / (gesamt + fehler) * 100) + "%)\n";
		
		strings[11] = "Runden: " + (Math.round(this.getRunden()) + "\n");
		
		strings[12] = "Male durchgelaufen: " + male + "\n";
		
		return strings;
	}

	public double getWolfRot() {
		return wolfRot;
	}

	public void setWolfRot(double wolfRot) {
		this.wolfRot = wolfRot;
	}

	public double getWolfOma() {
		return wolfOma;
	}

	public void setWolfOma(double wolfOma) {
		this.wolfOma = wolfOma;
	}

	public double getJaegerWolf() {
		return jaegerWolf;
	}

	public void setJaegerWolf(double jaegerWolf) {
		this.jaegerWolf = jaegerWolf;
	}

	public double getRotOma() {
		return rotOma;
	}

	public void setRotOma(double rotOma) {
		this.rotOma = rotOma;
	}

	public double getGesamt() {
		return gesamt;
	}

	public void setGesamt(double gesamt) {
		this.gesamt = gesamt;
	}

	public double getFehler() {
		return fehler;
	}

	public void setFehler(double fehler) {
		this.fehler = fehler;
	}

	public double getRunden() {
		return runden;
	}

	public void setRunden(double runden) {
		this.runden = runden;
	}


public static void main(String[] args) throws Exception {
		ReaderRotkaeppchen r = new ReaderRotkaeppchen("E:\\JavaCode\\Rotkeappchengame\\Rotkeappchengame\\statistics\\Run.txt");
		r.read();
		for(int i = 0; i < r.stringsLength(); i++)
		System.out.print(r.results()[i]);
	}
}