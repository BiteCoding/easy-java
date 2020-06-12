import basis.Hilfe;

import java.text.DecimalFormat;

public class rollThem {

    NumberPicker numberPicker;
    Output output;

    int values[];
    int pairValues[];
    int times;
    int dices;
    int pairs;

    public rollThem(){
        numberPicker = new NumberPicker();
        output = new Output();
        pairValues = new int[6];
    }

    public static void main(String[] args) {
        rollThem roll;
        roll = new rollThem();
        roll.rollIt();
    }

    private int scanNums() {
        try {
            this.times = numberPicker.chooseNums();
            this.dices = numberPicker.chooseDices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private String pairProbsForOne(int pairs){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(((double)pairs/(double)times)*100) + "%";
    }

    private String pairProbsForAll(){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(((double)pairs/(double)times)*100) + "%";
    }

    private boolean allEqual(int[] array){
        int num1 = array[0];
        for (int i = 0; i < array.length; i++){
            if (num1 == (array[i])){
                continue;
            } else {
                return false;
            }
        }
        pairValues[num1-1] += 1;
        return true;
    }

    private void startRolling(int times, int dices) {
        if (dices == 0 || times == 0) {
            System.err.println("Value of times or dices cant be 0");
            System.exit(1);
        }
        this.values = new int[dices * 6];
        for (int i = 0; i < times; i++) {
            int[] tempVals = new int[dices];
            int total = 0;
            for (int j = 0; j < dices; j++) {
                int value = roll();
                tempVals[j] = value;
                total += value;
            }
            if (allEqual(tempVals)){
                pairs++;
            }
            values[total - 1] += 1;
        }
        print();
    }

    private void print(){
        System.out.println("----------  RESULTS  -----------");
        System.out.println("NUMBERS:");
        for (int i = dices - 1; i < values.length; i++) {
            System.out.printf("%d: %s | %d%n", i + 1, probabilities()[i], values[i]);
        }
        System.out.println();
        System.out.println("PAIRS:");
        for (int i = 0; i < pairValues.length; i++){
            System.out.printf("%d: %d | %s%n", i+1, pairValues[i], pairProbsForOne(pairValues[i]));
        }
        System.out.println();
        System.out.println("STATS:");
        System.out.printf("Total Pairs: %d | %s%n", pairs, pairProbsForAll());
        System.out.printf("EyeSum: %d%n", totalEyeSum());
        System.out.printf("Average Number: %s", averageNum());
        output.setVisibility(true);
        output.drawGraph(output.trimArray(values), totalEyeSum());
    }

    private long totalEyeSum() {
        long total = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i] * i + i;
        }
        return total;
    }

    private String averageNum() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format((double) totalEyeSum() / (double) times);
    }

    private String[] probabilities() {
        DecimalFormat df = new DecimalFormat("0.00");
        String[] probs = new String[values.length];
        for (int i = 0; i < probs.length; i++) {
            probs[i] = df.format(((double) values[i] / (double) times) * 100) + "%";
        }
        return probs;
    }

    private int roll() {
        return Hilfe.zufall(1, 6);
    }

    public void rollIt() {
        scanNums();
        startRolling(times, dices);
    }

}
