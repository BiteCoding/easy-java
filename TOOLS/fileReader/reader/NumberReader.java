package reader;

import java.io.*;

public class NumberReader {

    private String path;
    int i;

    public NumberReader(String PATH) {
        this.path = PATH;
    }

    public int read() {
        File file = new File(path);

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                char[] chars = st.toCharArray();
                st = "";
                for (int i = 0; i < chars.length; i++) {
                    String j = "" + chars[i];
                    try {
                        st += Integer.parseInt(j);
                    } catch (Exception e) {

                    }
                }
                i = Integer.parseInt(st);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return i;
    }
}