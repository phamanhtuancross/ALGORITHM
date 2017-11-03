/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.shortest.safe.route.in.a.path;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
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
public class FindShortestSafeRouteInAPath extends JFrame {

    //prototype of variables---------------------------------------------------------------------------------------
    private int[][] maps = null;
    private boolean[][] maps_visited = null;
    private int SIZE_OF_CELL = 45;
    private int HEIGHT_OF_MAPS;
    private int WITH_OF_MAPS;
    private String NAME_FILE_INPUT = "input.txt";
    private int MIN_DIST = 10000;
    private int[] move_x = {-1, 0, 0, 1};
    private int[] move_y = {0, -1, 1, 0};
    private JPanel panel_main = null;
    private JButton[][] list_cells = null;
    private Color[] list_colors = {Color.CYAN, Color.green, Color.pink, Color.red, Color.orange, Color.white, Color.magenta};
    //--------------end-------------------------------------------------------------------------------------------

    /**
     * Constructor function
     */
    public FindShortestSafeRouteInAPath() {
        this.Innitialization();
        this.InitializationPanel();
        this.InitializationFrame();
        this.ExportMaps();
        this.SolveProblems();
    }
    //----------------------------------------end of function-----------------------------------------------------

    /**
     * void InitializationPanle() function initialization for list_panel and
     * panel_main
     */
    public void InitializationPanel() {
        this.panel_main = new JPanel(new GridLayout(this.HEIGHT_OF_MAPS, this.WITH_OF_MAPS));
        this.list_cells = new JButton[HEIGHT_OF_MAPS][WITH_OF_MAPS];

        for (int i = 0; i < this.HEIGHT_OF_MAPS; i++) {
            for (int j = 0; j < this.WITH_OF_MAPS; j++) {
                this.list_cells[i][j] = new JButton(this.maps[i][j] + "");
                this.list_cells[i][j].setOpaque(true);
                this.list_cells[i][j].setBorderPainted(true);
                //this.list_cells[i][j].set
                if (this.maps[i][j] == 0) {
                    this.list_cells[i][j].setBackground(Color.black);

                } else {
                    this.list_cells[i][j].setBackground(Color.gray);
                }
                this.panel_main.add(this.list_cells[i][j]);
            }
        }
    }
    //-------------------------------------------end of function-----------------------------------------------------------

    public void InitializationFrame() {
        this.setSize(this.HEIGHT_OF_MAPS * this.SIZE_OF_CELL, this.WITH_OF_MAPS * SIZE_OF_CELL);
        this.setPreferredSize(new Dimension(this.HEIGHT_OF_MAPS * this.SIZE_OF_CELL, this.WITH_OF_MAPS * SIZE_OF_CELL));
        this.setTitle("SHORTEST ROUTE");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.panel_main);

    }
    //---------------------------------------------end of fuction------------------------------------------------------------

    public void ResetListCells() {
        for (int i = 0; i < this.HEIGHT_OF_MAPS; i++) {
            for (int j = 0; j < this.WITH_OF_MAPS; j++) {
                if (this.maps[i][j] != 0) {
                    this.list_cells[i][j].setBackground(Color.gray);

                }
            }
        }
    }

    public void DoDrawing() {
        for (int i = 0; i < this.HEIGHT_OF_MAPS; i++) {
            for (int j = 0; j < this.WITH_OF_MAPS; j++) {
                if (this.maps_visited[i][j] == true) {
                    try {
                        Thread.sleep(200);
                        int lengthOfListColors = this.list_colors.length;
                        int indexColor = new Random().nextInt(lengthOfListColors);
                        this.list_cells[i][j].setBackground(this.list_colors[indexColor]);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FindShortestSafeRouteInAPath.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    /**
     * booleans IsValid(integer x, integer y) function the function check Is a
     * cell exist in a maps if it 's so then return TRUE if it 's not then
     * return FALSE
     */
    public boolean IsValid(int x, int y) {
        if (x >= 0 && x < this.HEIGHT_OF_MAPS && y >= 0 && y < this.WITH_OF_MAPS) {
            return true;
        }
        return false;
    }
    //----------------------------------------------end of function-------------------------------------------------

    /**
     * Initialization() function The function allocated memory and data for
     * class if can't find the file input so display to screen a sentences is
     * :"Can't not file"
     */
    public void Innitialization() {
        try {
            System.out.println("Reading.....................");
            Scanner scanner = new Scanner(new File(NAME_FILE_INPUT));

            //alcoated the size for maps and maps_visited
            this.HEIGHT_OF_MAPS = scanner.nextInt();
            this.WITH_OF_MAPS = scanner.nextInt();

            //alocated memory for maps and maps_visited
            this.maps = new int[HEIGHT_OF_MAPS][WITH_OF_MAPS];
            this.maps_visited = new boolean[HEIGHT_OF_MAPS][WITH_OF_MAPS];

            //alocated the data for maps
            for (int i = 0; i < this.HEIGHT_OF_MAPS; i++) {
                for (int j = 0; j < this.WITH_OF_MAPS; j++) {
                    maps[i][j] = scanner.nextInt();
                }
            }

            //reset the value in a maps - mark all cell where we can't cross
            for (int i = 0; i < this.HEIGHT_OF_MAPS; i++) {
                for (int j = 0; j < this.WITH_OF_MAPS; j++) {
                    if (maps[i][j] == 0) {
                        for (int k = 0; k < 4; k++) {
                            if (IsValid(i + move_y[k], j + move_x[k])) {
                                maps[i + move_y[k]][j + move_x[k]] = -1;
                            }
                        }
                    }
                }
            }

            //reset value -1 to 0
            for (int i = 0; i < this.HEIGHT_OF_MAPS; i++) {
                for (int j = 0; j < this.WITH_OF_MAPS; j++) {
                    //if the value at this cell is -1 so we reset the value is zero
                    if (this.maps[i][j] == -1) {
                        this.maps[i][j] = 0;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FindShortestSafeRouteInAPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //-----------------------------------------end of function---------------------------------------------

    /**
     * void ExportMaps() function for export data of maps to display screen
     */
    public void ExportMaps() {
        for (int i = 0; i < this.HEIGHT_OF_MAPS; i++) {
            for (int j = 0; j < this.WITH_OF_MAPS; j++) {
                System.out.print(this.maps[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //-----------------------------------------end of function---------------------------------------------
    /**
     * void InitializationMapsVisited() function allocated all cell in
     * maps_visited is unchecked
     */
    public void InitializationMapsVisited() {
        for (int i = 0; i < this.HEIGHT_OF_MAPS; i++) {
            for (int j = 0; j < this.WITH_OF_MAPS; j++) {
                this.maps_visited[i][j] = false;
            }
        }
    }

    //----------------------------end of function-----------------------------------------------------------
    /**
     * boolean IsSafe(integer rowIndex, integer columIndex) function check is
     * Can we cross this cell if we cant return TRUE if we can't return FALSE
     */
    public boolean IsSafe(int rowIndex, int columIndex) {

        //if this cell have path and this cell is unchecked
        if (this.maps[rowIndex][columIndex] == 0 || this.maps_visited[rowIndex][columIndex] == true) {
            return false;
        }
        return true;
    }
    //----------------------------------end of function-------------------------------------------------------

    /**
     * void FindShortedRouteInPaht(integer rowIndex, integer columIndex, integer
     * currentDist) the function for find min_distance of path form first colum
     * to end colum the values of min_distance can't be change
     */
    public void FindShortedRouteInPaht(int rowIndex, int columIndex, int currentDist) {
        try {
            //if we go to the last colums so we update the min of distance
            if (columIndex == this.WITH_OF_MAPS - 1) {
                this.MIN_DIST = Math.min(this.MIN_DIST, currentDist);
                //this.maps_visited[rowIndex][columIndex] = true;
                this.list_cells[rowIndex][columIndex].setBackground(Color.black);
                Thread.sleep(100);
                this.list_cells[rowIndex][columIndex].setBackground(Color.gray);

                //JOptionPane.showMessageDialog(rootPane, null);
                return;
            }

            //if current distance biger than min disatance so we return
            if (currentDist > this.MIN_DIST) {
                return;
            }

            //mark cell is visisted
            this.maps_visited[rowIndex][columIndex] = true;
            int idexColor = new Random().nextInt(this.list_colors.length);
            this.list_cells[rowIndex][columIndex].setBackground(this.list_colors[idexColor]);
            Thread.sleep(5);
            for (int i = 0; i < 4; i++) {
                if (this.IsValid(rowIndex + move_y[i], columIndex + move_x[i]) && this.IsSafe(rowIndex + move_y[i], columIndex + move_x[i])) {
                    //this.maps_visited[rowIndex + move_y[i]][columIndex + move_x[i]] = true;

                    this.FindShortedRouteInPaht(rowIndex + move_y[i], columIndex + move_x[i], currentDist + 1);
                    //DoDrawing();
                    // this.maps_visited[rowIndex + move_y[i]][columIndex + move_x[i]] = false;// return false;

                }
            }
            this.maps_visited[rowIndex][columIndex] = false;
            this.list_cells[rowIndex][columIndex].setBackground(Color.gray);
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(FindShortestSafeRouteInAPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //----------------------------------end of function------------------------------------------------------

    /**
     * void SolveProblems() the function for solve the problems find the
     * shortest route in a paths within mine
     */
    public void SolveProblems() {
        for (int i = 0; i < this.HEIGHT_OF_MAPS; i++) {
            if (this.maps[i][0] == 1) {
                this.InitializationMapsVisited();
                this.maps_visited[i][0] = true;
                this.FindShortedRouteInPaht(i, 0, 0);
                /* for (int ii = 0; ii < this.HEIGHT_OF_MAPS; ii++) {
                    for (int jj = 0; jj < this.WITH_OF_MAPS; jj++) {
                        System.out.print(maps_visited[ii][jj] + " ");
                    }
                    System.out.println("");
                }*/

                //the min distacen is the size with of maps
                // DoDrawing();
                if (this.MIN_DIST == this.WITH_OF_MAPS - 1) {
                    break;
                }

            }
        }
        System.out.println(MIN_DIST);
    }
    //-----------------------------------end of function---------------------------------------------------------

    /**
     * Driver prograrm
     */
    public static void main(String[] args) {
        FindShortestSafeRouteInAPath temp = new FindShortestSafeRouteInAPath();
    }
    //-----------------------------------end of function---------------------------------------------------------
}
