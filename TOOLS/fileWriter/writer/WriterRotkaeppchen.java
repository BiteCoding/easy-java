package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import basis.Hilfe;

public class WriterRotkaeppchen {
	
	private String filePath;
	
	public WriterRotkaeppchen(String PATH) {
		this.filePath = PATH;
	}
	
	public void write( String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		try {
			// Below constructor argument decides whether to append or override
			fr = new FileWriter(file, true);
			fr.write(text);

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
		WriterRotkaeppchen writer = new WriterRotkaeppchen("FileWriter/res/3.txt");
		writer.delete();
	}
}
