import javax.swing.*;

public class NumberPicker {

    private String input = null;

    public int chooseNums(){
        String[] choices = {"100", "1.000", "10.000", "100.000", "1.000.000", "10.000.000", "100.000.000", "1.000.000.000", "Eigener Wert"};
        input = (String) JOptionPane.showInputDialog(null, "How many times do you want to roll the dice?",
                "Choose a Number", JOptionPane.QUESTION_MESSAGE, null, // Use default icon
                choices, // Initial choice
                "100.000");

        switch (input){
            case "100":
                return 100;
            case "1.000":
                return 1_000;
            case "10.000":
                return 10_000;
            case "100.000":
                return 100_000;
            case "1.000.000":
                return 1_000_000;
            case "10.000.000":
                return 10_000_000;
            case "100.000.000":
                return 100_000_000;
            case "1.000.000.000":
                return 1_000_000_000;
            case "Choose Number yourself":
                int n = Integer.parseInt(JOptionPane.showInputDialog("Set your custom value"));
                return n;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }

    }

    public int chooseDices(){
        String[] choices = {"1", "2", "3", "4", "5", "6", "7", "8","9","10", "Custom value"};
        input = (String) JOptionPane.showInputDialog(null, "How many dices do you want to use?",
                "Choose a Number", JOptionPane.QUESTION_MESSAGE, null, // Use default icon
                choices, // Initial choice
                "2");

        switch (input){
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "Choose Number yourself":
                int n = Integer.parseInt(JOptionPane.showInputDialog("Set your custom value"));
                return n;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }

    }
}

