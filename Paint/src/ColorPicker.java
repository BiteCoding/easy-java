import javax.swing.JOptionPane;

public class ColorPicker {

    private String input = null;

    private String rgbValues(){
        String[] choices = {"Rot", "Grün", "Blau", "Lila", "Cyan", "Gelb", "Schwarz", "Weiß", "Rosa", "Selber RGB-Werte eintragen"};
        input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "Choose a Color", JOptionPane.QUESTION_MESSAGE, null, // Use default icon
                choices, // Initial choice
                null);

        switch (input){
            case "Rot":
                return "255,0,0";
            case "Grün":
                return "0,255,0";
            case "Blau":
                return "0,0,255";
            case "Lila":
                return "187,13,222";
            case "Cyan":
                return "18,224,204";
            case "Gelb":
                return "246,255,0";
            case "Schwarz":
                return "0,0,0";
            case "Weiß":
                return "255,255,255";
            case "Rosa":
                return "255,84,133";
            case "Selber RGB-Werte eintragen":
                String n = JOptionPane.showInputDialog("Set value between 0 to 255 for RED,GREEN,BLUE");
                return n;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }

    }

    public int[] choseColor(){
        String value = rgbValues();
        value = value.replaceAll("\\s", "");
        String[] parts = value.split(",");
        int[] rgb = new int[parts.length];
        for (int i = 0; i < parts.length; i++){
            rgb[i]= Integer.parseInt(parts[i]);
        }
        return rgb;
    }
}

