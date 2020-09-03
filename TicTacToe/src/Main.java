import basis.*;
import writer.Writer;

import javax.swing.*;
import java.util.Objects;

class Main {
    private final Frame frame;
    private final Tastatur keyboard;
    private final Maus mouse;
    private final Pen pen;
    private final Writer writer;

    private int w;
    private int h;

    private String[][] grid;
    private int[][] free;
    private Main(){
        frame = new Frame();
        pen = new Pen(frame);
        keyboard = new Tastatur();
        mouse = new Maus();
        writer = new Writer("TicTacToe/src/doc/probabilitys.txt");
        writer.clear();

        w = frame.wigth()/3;
        h = frame.height()/3;

        grid = new String[][] {
                {"","",""},
                {"","",""},
                {"","",""}

        };

        free = new int[][] {
                {-1,-1,-1},
                {-1,-1,-1},
                {-1,-1,-1}

        };
    }

    private void computerMovement() {
        boolean isFree = false;
        while (!isFree) {
            int x = Hilfe.zufall(0, 2);
            int y = Hilfe.zufall(0, 2);
            if (free[x][y] == -1) {
                grid[x][y] = "O";
                free[x][y] = 0;
                isFree = true;
            }
        }
    }

    private void update(){
        w = frame.wigth()/100;
        h = w *100;
        w = h;
        frame.setSize(w,h);
        w = frame.wigth()/3;
        h = frame.height()/3;
        frame.reset();
        frame.middle();
        pen.drawGrid();
        place();
    }
    private int freeTiles(){
        int value = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (free[i][j] == -1){
                    value ++;
                }
            }
        }
        return value;
    }

    private void place(){
        //row
        for (int i = 0; i < 3; i++){
            //collumn
            for (int j = 0; j < 3; j++){
                int x = (j) * w;
                int y = (i) * h;
                if (Objects.equals(grid[i][j], "X")){
                    pen.drawX(x,y);
                } else if (grid[i][j].equals("O")) {
                    pen.drawO(x,y);
                }
            }
        }
    }

    private void playerMovement(){
        boolean placed = false;
        while (!placed){
            Hilfe.kurzePause();
            if (mouse.istGedrueckt()){
                double mouseX = mouse.vPosition();
                double mouseY = mouse.hPosition();

                mouseX = (int)(mouseX / w);
                mouseY = (int)(mouseY / h);
                if (free [(int)mouseX][(int)mouseY] == -1){
                    grid [(int)mouseX][(int)mouseY] = "X";
                    free [(int)mouseX][(int)mouseY] = 0;
                    placed = true;
                } else {
                    JOptionPane.showMessageDialog(null, "This field is not free!", "Warning", JOptionPane.ERROR_MESSAGE);
                    Hilfe.warte(250);
                    if (mouse.istGedrueckt()){
                        mouseX = mouse.vPosition();
                        mouseY = mouse.hPosition();

                        mouseX = (int) (mouseX / w);
                        mouseY = (int) (mouseY / h);
                        if (free[(int) mouseX][(int) mouseY] == -1) {
                            grid[(int) mouseX][(int) mouseY] = "X";
                            free[(int) mouseX][(int) mouseY] = 0;
                        }
                    }
                }

            }
        }
    }

    private String checkWin(){
        for (int i = 0; i < 3; i++){
            //vertical
            if ((Objects.equals(grid[i][0], grid[i][1])) && (grid[i][0].equals(grid[i][2])) && (grid[i][1].equals(grid[i][2])) && !grid[i][0].equals("")) {
                pen.drawWin(w/2 - 15, i* h+h/2, w*3-w/2+15, i*h+h/2);
                return grid[i][0]+ " won the game!";
            }
            //horizontal
            else if ((Objects.equals(grid[0][i], grid[1][i])) && (Objects.equals(grid[0][i], grid[2][i])) && (grid[1][i].equals(grid[2][i])) && !Objects.equals(grid[0][i], "")){
                pen.drawWin(i * w+w/2, h/2-15, i * w+w/2, 3*h-h/2+15 );
                return grid[0][i]+ " won the game!";
            }
            //diagonal: left to right
            else if ((grid[0][0].equals(grid[1][1])) && (Objects.equals(grid[1][1], grid[2][2])) && (Objects.equals(grid[0][0], grid[2][2])) && !Objects.equals(grid[0][0], "")){
                pen.drawWin(w/2, h/2, w*3-w/2,h*3-h/2);
                return grid[0][0] + " won the game!";
            }
            //diagonal: right to left
            else if ((Objects.equals(grid[2][0], grid[1][1])) && (Objects.equals(grid[1][1], grid[0][2])) && (Objects.equals(grid[2][0], grid[0][2])) && !Objects.equals(grid[2][0], "")){
                pen.drawWin(w*3-w/2,h/2, w/2, h*3-h/2);
                return grid[0][2] + " won the game!";
            }
        }

        return "tie";

    }

    private void run(){
        pen.drawGrid();
        for (int i = 0; i < 9; i++){
            if (w != frame.wigth()/3 || h != frame.height()/3){
                update();
            }
            System.out.println(frame.wigth());
            System.out.println(frame.height());
            Hilfe.kurzePause();
            //minimax(grid);
            computerMovement();
            place();
            if (!checkWin().equals("tie") || freeTiles() == 0){
                break;
            }
            playerMovement();
            place();
            if (!checkWin().equals("tie") || freeTiles() == 0){
                break;
            }
            Hilfe.warte(500);
        }
        if (checkWin().equals("tie")){
            pen.drawWin(0, 0, frame.wigth(), frame.height());
            pen.drawWin(frame.wigth(), 0, 0, frame.height());
        }
        writer.write(checkWin()+"\n", true);

        while (true){
            Hilfe.kurzePause();
            if (keyboard.istGedrueckt('f')){
                frame.reset();
                grid = new String[][] {
                        {"","",""},
                        {"","",""},
                        {"","",""}

                };

                free = new int[][] {
                        {-1,-1,-1},
                        {-1,-1,-1},
                        {-1,-1,-1}

                };
                run();
            } else if (keyboard.istGedrueckt(Zeichen.ESC)){
                System.exit(0);
            }

        }
    }

    public static void main(String[] args){
        Main m;
        m = new Main();
        m.run();
    }

}
