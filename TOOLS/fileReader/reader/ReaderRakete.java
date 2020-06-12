package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderRakete {

	private String path;
	private int[] fluege;
	private int entrys;

	public ReaderRakete(String PATH) {
		this.path = PATH;
		fluege = new int [3];
	}

	public int read() {
		File file = new File(path);

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				if(st != "") {
				fluege[entrys] = Integer.parseInt(st);
				System.out.println(fluege[entrys]);
				entrys++;
				}
				}
			
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return entrys;

	}

public static void main(String[] args) throws Exception {
		ReaderRakete r = new ReaderRakete("F:/JavaCode/RaketeGame/src/RaketeGame/res/highscores.txt");
		r.read();
	}
}