package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import basis.Hilfe;
import reader.ReaderRakete;

public class WriterRaketeGame {
	
	private String filePath;
	private ReaderRakete reader;
	
	public WriterRaketeGame(String PATH) {
		this.filePath = PATH;
		reader = new ReaderRakete(PATH);
	}
	
	public void write(String oldText,String readed, String newText) {
		File file = new File(filePath);
		FileWriter fr = null;
		try {
			// Below constructor argument decides whether to append or override
			if(oldText.equals(readed)) {
				fr = new FileWriter(file, true);
				fr.write(oldText);
			} else {
				fr = new FileWriter(file, true);
				fr.write(newText);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void clear() {
		File file = new File(filePath);

		FileWriter fr = null;
		try {
			// Below constructor argument decides whether to append or override
			fr = new FileWriter(filePath, false);
			fr.write("");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete() {
		File file = new File(filePath);
		file.delete();
	}

	public static void main(String[] args) {
		WriterRaketeGame writer = new WriterRaketeGame("E:/JavaCode/RaketeGame/src/RaketeGame/res/highscores.txt");
		writer.clear();
//		for( int i = 0; i < 3; i++) {
//			if(i < 2)
//				writer.write();
//			else {
//				writer.write((10-i)+"");
//			}
//		}
//		writer.clear();
	}
}
