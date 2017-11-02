/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SUDOKU extends JFrame {

    private int[][] maps = null;
    private int SIZE_OF_MAPS;
    private int SIZE_OF_CELL = 75;
    private JPanel panel_Main = null;
    private JButton[][] list_cells = null;
    private String NAME_FILE_INPUT = "input.txt";
    private Color[] list_colors = {Color.red, Color.gray, Color.orange, Color.pink, Color.GREEN};

    public SUDOKU() {
        Inits();
        InitFrame();
        Solve();

    }

    public void InitFrame() {
        this.setTitle("SUDOKU");
        this.setSize(this.SIZE_OF_MAPS * this.SIZE_OF_CELL, this.SIZE_OF_MAPS * this.SIZE_OF_CELL);
        this.setPreferredSize(new Dimension(this.SIZE_OF_MAPS * this.SIZE_OF_CELL, this.SIZE_OF_MAPS * this.SIZE_OF_CELL));
        this.add(this.panel_Main);
        this.setLocation(350, 50);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * void Inits() The Inits() function for read file input for alocated memory
     * and values for data in class
     */
    public void Inits() {
        try {
            Scanner scanner = new Scanner(new File(NAME_FILE_INPUT));
            this.SIZE_OF_MAPS = scanner.nextInt();

            //alocated the memory for maps
            this.maps = new int[SIZE_OF_MAPS][SIZE_OF_MAPS];
            this.list_cells = new JButton[SIZE_OF_MAPS][SIZE_OF_MAPS];
            this.panel_Main = new JPanel(new GridLayout(SIZE_OF_MAPS, SIZE_OF_MAPS));

            //alocated the values for maps
            for (int i = 0; i < this.SIZE_OF_MAPS; i++) {
                for (int j = 0; j < this.SIZE_OF_MAPS; j++) {
                    maps[i][j] = scanner.nextInt();
                    if (maps[i][j] != 0) {
                        this.list_cells[i][j] = new JButton(maps[i][j] + "");
                        //this.list_cells[i][j].setText(maps[i][j] + "");
                        //this.list_cells[i][j].setEditable(false);
                    } else {
                        this.list_cells[i][j] = new JButton();
                    }
                    this.list_cells[i][j].setOpaque(true);
                    this.list_cells[i][j].setBorderPainted(true);
                    //this.list_cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    //this.list_cells[i][j].setBorderPainted(true);
                    if (this.maps[i][j] != 0) {
                        this.list_cells[i][j].setBackground(Color.white);
                    } else {
                        int index = new Random().nextInt(4);
                        this.list_cells[i][j].setBackground(this.list_colors[index]);

                    }
                    this.panel_Main.add(this.list_cells[i][j]);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SUDOKU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * boolean IsSafeInRows(int rowIndex, int number) the fucntion check in a
     * row where have rowIdex if a this row we have a cell hava value is number
     * return false else return true
     */
    public boolean IsSafeInRows(int rowIndex, int number) {
        for (int i = 0; i < this.SIZE_OF_MAPS; i++) {
            if (this.maps[rowIndex][i] == number) {
                return false;
            }
        }
        return true;
    }

    /**
     * boolean IsSafeInColums(int rowIndex, int number) the fucntion check in a
     * colum where have rowIdex if a this colum we have a cell hava value is
     * number return false else return true
     */
    public boolean IsSafeInColums(int columIndex, int number) {
        for (int i = 0; i < this.SIZE_OF_MAPS; i++) {
            if (this.maps[i][columIndex] == number) {
                return false;
            }
        }
        return true;
    }

    /**
     * boolean IsSafeIbBoxs(int rowIndex, int columIndex, int number) return if
     * in a box have rowIndex and colums Index have cell where have the value is
     * number return false else return false rowIndex = rowIndex - rowIndex%3
     * columIndex = columIndex - coLumIndex%3 Example : 8 - 8%3 = 6; 7 - 7%3 =
     * 6; We convert the size is 9*9 to 3*3
     */
    public boolean IsSafeIbBoxs(int rowIndex, int columIndex, int number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.maps[rowIndex + i][columIndex + j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * boolean IsSafe(int rowIndex, int columIndex, int number) if the number is
     * acepted return true if the number is not acepted return false
     */
    public boolean IsSafe(int rowIndex, int columIndex, int number) {

        if (!IsSafeInRows(rowIndex, number) || !IsSafeInColums(columIndex, number)
                || !IsSafeIbBoxs(rowIndex - rowIndex % 3, columIndex - columIndex % 3, number)) {
            return false;
        }
        return true;
    }

    /**
     * public void ExportMaps() the function export the data of maps
     */
    public void ExportMaps() {
        for (int i = 0; i < this.SIZE_OF_MAPS; i++) {
            for (int j = 0; j < this.SIZE_OF_MAPS; j++) {
                System.out.print(maps[i][j] + "  ");
            }
            System.out.println("");
        }

        System.out.println("Endl");
    }

    /**
     * boolean SolveSudoku() the result is a maps have data of solve
     */
    public boolean SolveSudoku() {
        int rowIndex = 0;
        int columIndex = 0;
        boolean flag = true;

        //find rowIndex and columIndex where maps is not have value acepted
        for (rowIndex = 0; rowIndex < this.SIZE_OF_MAPS; rowIndex++) {
            for (columIndex = 0; columIndex < this.SIZE_OF_MAPS; columIndex++) {
                if (this.maps[rowIndex][columIndex] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == false) {
                break;
            }
        }

        //if we can't find indexRow and indexColum return true
        if (flag == true) {
            return true;
        }

        //System.out.println("rowIndex :" + rowIndex);
        //System.out.println("columIndex :" + columIndex);
        for (int number = 1; number <= 9; number++) {
            if (IsSafe(rowIndex, columIndex, number) == true) {
                this.maps[rowIndex][columIndex] = number;
                if (this.SolveSudoku() == true) {
                    return true;
                }

                this.maps[rowIndex][columIndex] = 0;
            }
        }
        return false;
    }

    public void DrawResult() {
        for (int i = 0; i < this.SIZE_OF_MAPS; i++) {
            for (int j = 0; j < this.SIZE_OF_MAPS; j++) {
                if (this.list_cells[i][j].getText() == "") {
                    try {
                        this.list_cells[i][j].setText(maps[i][j] + "");
                        int index = new Random().nextInt(5);
                        this.list_cells[i][j].setBackground(this.list_colors[index]);
                        //this.list_cells[i][j].set;
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SUDOKU.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void Solve() {
        if (this.SolveSudoku() == true) {
            this.DrawResult();
        } else {
            System.out.println("Can not files solve for this problems");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SUDOKU sudoku = new SUDOKU();
        // TODO code application logic here
    }

}
