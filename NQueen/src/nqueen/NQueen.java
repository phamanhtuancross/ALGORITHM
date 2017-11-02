/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class NQueen extends JFrame {

    private int SIZE_OF_CHESS_BOARD = 16;
    private int SIZE_OF_CELL = 50;

    private JPanel panel_ChessBoard;
    private JButton[][] list_cells = null;
    private boolean maps[][] = null;

    /**
     * Constructor function
     */
    public NQueen() {
        this.InitFrame();
        InitChessBoard();;
        DoDrawing();
        this.add(this.panel_ChessBoard);
        this.setVisible(true);
        InitMaps();

    }

    public void InitMaps() {
        this.maps = new boolean[this.SIZE_OF_CHESS_BOARD][this.SIZE_OF_CHESS_BOARD];
        for (int i = 0; i < this.SIZE_OF_CHESS_BOARD; i++) {
            for (int j = 0; j < this.SIZE_OF_CHESS_BOARD; j++) {
                this.maps[i][j] = false;
            }
        }
    }

    public boolean IsSafe(int rowIndex, int columIndex) {

        //this.list_cells[rowIndex][columIndex].setBackground(Color.red);
        //check in a rows
        for (int i = 0; i < this.SIZE_OF_CHESS_BOARD; i++) {
            //this.list_cells[rowIndex][i].setBackground(Color.red);
            if (maps[rowIndex][i] == true) {
                return false;
            }
        }

        //check in a colums
        for (int i = 0; i < this.SIZE_OF_CHESS_BOARD; i++) {
            //this.list_cells[i][columIndex].setBackground(Color.red);
            if (maps[i][columIndex] == true) {
                return false;
            }
        }

        //check in a diagonal line
        for (int x = -(this.SIZE_OF_CHESS_BOARD - 1); x < this.SIZE_OF_CHESS_BOARD; x++) {
            for (int y = -(this.SIZE_OF_CHESS_BOARD - 1); y < this.SIZE_OF_CHESS_BOARD; y++) {
                int newRowIndex = x + rowIndex;
                int newColumIndex = y + columIndex;
                if (newColumIndex >= 0 && newColumIndex < this.SIZE_OF_CHESS_BOARD && newRowIndex >= 0 && newRowIndex < this.SIZE_OF_CHESS_BOARD) {
                    if (newColumIndex + newRowIndex == columIndex + rowIndex || columIndex - rowIndex == newColumIndex - newRowIndex) {
                        // System.out.println(newRowIndex + "," + newColumIndex);
                        if (maps[newRowIndex][newColumIndex] == true) {
                            return false;
                        }
                        //this.list_cells[newRowIndex][newColumIndex].setBackground(Color.red);
                    }
                }
            }
        }
        return true;
    }

    public boolean SolveNQueenProblem(int columIndex) {

        //the resul return true if columIndex >= Size of chess board which is mean
        //We can set N queen in the chess board
        if (columIndex >= this.SIZE_OF_CHESS_BOARD) {
            return true;
        }

        for (int i = 0; i < this.SIZE_OF_CHESS_BOARD; i++) {
            if (this.IsSafe(i, columIndex)) {
                this.maps[i][columIndex] = true;

                //if this case is true and we can set all queen i the chess board
                if (this.SolveNQueenProblem(columIndex + 1) == true) {
                    return true;
                }
                this.maps[i][columIndex] = false;//back tracking
            }
        }
        return false;
    }

    public void InitFrame() {
        this.setSize(this.SIZE_OF_CHESS_BOARD * this.SIZE_OF_CELL, this.SIZE_OF_CHESS_BOARD * this.SIZE_OF_CELL);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(350, 100);
        this.setResizable(false);

    }

    public void InitChessBoard() {
        this.list_cells = new JButton[this.SIZE_OF_CHESS_BOARD][this.SIZE_OF_CHESS_BOARD];
        for (int x = 0; x < this.SIZE_OF_CHESS_BOARD; x++) {
            for (int y = 0; y < this.SIZE_OF_CHESS_BOARD; y++) {
                this.list_cells[x][y] = new JButton();
                this.list_cells[x][y].setOpaque(true);
                this.list_cells[x][y].setBorderPainted(true);
            }
        }
    }

    public void DoDrawing() {
        this.panel_ChessBoard = new JPanel(new GridLayout(this.SIZE_OF_CHESS_BOARD, this.SIZE_OF_CHESS_BOARD));
        this.setPreferredSize(new Dimension(this.SIZE_OF_CHESS_BOARD * this.SIZE_OF_CELL, this.SIZE_OF_CHESS_BOARD * this.SIZE_OF_CELL));
        for (int y = 0; y < this.SIZE_OF_CHESS_BOARD; y++) {
            for (int x = 0; x < this.SIZE_OF_CHESS_BOARD; x++) {
                if (y % 2 == 0) {
                    if (x % 2 != 0) {
                        this.list_cells[y][x].setBackground(Color.gray);
                    } else {
                        this.list_cells[y][x].setBackground(Color.white);
                    }
                } else {
                    if (x % 2 == 0) {
                        this.list_cells[y][x].setBackground(Color.gray);
                    } else {
                        this.list_cells[y][x].setBackground(Color.white);
                    }
                }
                this.panel_ChessBoard.add(this.list_cells[y][x]);
            }
        }

    }

    public void ExportResult() {
        for (int x = 0; x < this.SIZE_OF_CHESS_BOARD; x++) {
            for (int y = 0; y < this.SIZE_OF_CHESS_BOARD; y++) {
                if (maps[x][y] == true) {
                    try {
                        this.list_cells[x][y].setBackground(Color.red);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NQueen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void SolveProblemAndExport() {
        //for (int i = 0; i < this.SIZE_OF_CHESS_BOARD; i++) {
        if (this.SolveNQueenProblem(0) == true) {
            this.ExportResult();
            System.out.println("FIND THE PATH");
        } else {
            System.out.println("WE CAN FIND THE PAHT");
        }
        // }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NQueen temp = new NQueen();
        temp.SolveProblemAndExport();
        // temp.SolveProblemAndExport();
        // TODO code application logic here
    }

}
