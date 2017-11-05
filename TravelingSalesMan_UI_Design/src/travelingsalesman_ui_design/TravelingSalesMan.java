/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsalesman_ui_design;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TravelingSalesMan {

    //--------------------variables prototype-----------------------------------
    private int[][] map = null;
    private int[] path = null;
    private boolean[] is_visited = null;
    private int[] sum_cost = null;
    private int[] best_way = null;
    private int SIZE_OF_MAP;
    private int MIN_SPENDING_COST = Integer.MAX_VALUE;
    private String NAME_FILE_INPUT = "input.txt";
    //--------------------end of variables prototype----------------------------

    public TravelingSalesMan() {
        this.Initialization();
        this.Solve();
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int[] getPath() {
        return path;
    }

    public void setPath(int[] path) {
        this.path = path;
    }

    public boolean[] getIs_visited() {
        return is_visited;
    }

    public void setIs_visited(boolean[] is_visited) {
        this.is_visited = is_visited;
    }

    public int[] getSum_cost() {
        return sum_cost;
    }

    public void setSum_cost(int[] sum_cost) {
        this.sum_cost = sum_cost;
    }

    public int[] getBest_way() {
        return best_way;
    }

    public void setBest_way(int[] best_way) {
        this.best_way = best_way;
    }

    public int getSIZE_OF_MAP() {
        return SIZE_OF_MAP;
    }

    public void setSIZE_OF_MAP(int SIZE_OF_MAP) {
        this.SIZE_OF_MAP = SIZE_OF_MAP;
    }

    public int getMIN_SPENDING_COST() {
        return MIN_SPENDING_COST;
    }

    public void setMIN_SPENDING_COST(int MIN_SPENDING_COST) {
        this.MIN_SPENDING_COST = MIN_SPENDING_COST;
    }

    public String getNAME_FILE_INPUT() {
        return NAME_FILE_INPUT;
    }

    public void setNAME_FILE_INPUT(String NAME_FILE_INPUT) {
        this.NAME_FILE_INPUT = NAME_FILE_INPUT;
    }

    /**
     * void Initialization() : public The function read data from file and the
     * allocated memory and data for class if we can't find the file input then
     * display to screen can't find file
     */
    public void Initialization() {
        try {

            Scanner scanner = new Scanner(new File(NAME_FILE_INPUT));//read file

            this.SIZE_OF_MAP = scanner.nextInt();

            //allocated the memory for data in class----------------------------
            this.map = new int[SIZE_OF_MAP][SIZE_OF_MAP];
            this.path = new int[SIZE_OF_MAP];
            this.sum_cost = new int[SIZE_OF_MAP];
            this.is_visited = new boolean[SIZE_OF_MAP];
            this.best_way = new int[SIZE_OF_MAP];

            //allocated the data for map----------------------------------------
            for (int i = 0; i < this.SIZE_OF_MAP; i++) {
                for (int j = 0; j < this.SIZE_OF_MAP; j++) {
                    this.map[i][j] = scanner.nextInt();
                }
            }

            //alocated the data for is_visited and path and sum_cost------------
            for (int i = 0; i < this.SIZE_OF_MAP; i++) {
                //this.path[i] = 0;
                //this.sum_cost[i] = 0;
                this.is_visited[i] = false;
            }

            //allocated the state begin when we start find the path-------------
            this.is_visited[0] = true;
            this.path[0] = 0;
            this.sum_cost[0] = 0;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TravelingSalesMan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //--------------------------end of function---------------------------------

    /**
     * void ExportMap() : public The function for export data in a map display
     * to screen
     */
    public void ExportMap() {
        for (int i = 0; i < this.SIZE_OF_MAP; i++) {
            for (int j = 0; j < this.SIZE_OF_MAP; j++) {
                System.out.print(this.map[i][j] + "");
            }
            System.out.println("");
        }
    }
    //---------------------------end of function--------------------------------

    public void ExportPath() {
        System.out.println("The path of traveling sales man problems is :");
        System.out.print(best_way[0] + " ");
        for (int i = this.SIZE_OF_MAP - 1; i >= 0; i--) {
            System.out.print(this.best_way[i] + " ");
        }

        System.out.println("End of path");
    }
    //-------------------------end of function ---------------------------------

    public boolean IsSafe(int indexVertices, int i) {
        if (this.map[this.path[indexVertices - 1]][i] == 0 || this.is_visited[i] == true) {
            return false;
        }
        return true;
    }
    //-------------------------end of function----------------------------------

    public void CopyDataOfArray(int[] source, int[] dest) {
        for (int i = 0; i < source.length; i++) {
            dest[i] = source[i];
        }
    }
    //---------------------------end of function ------------------------------

    /**
     * void TravelingSalesManSolution(integer indexVertices) : public the
     * function for find the path form index 0 to last vertices if we can find
     * the path so changed the values of the best_way
     */
    public void TravelingSalesManSolution(int indexVertices) {
        for (int i = 1; i < this.SIZE_OF_MAP; i++) {
            if (this.IsSafe(indexVertices, i) == true) {

                this.path[indexVertices] = i;
                this.sum_cost[indexVertices] = this.sum_cost[indexVertices - 1] + this.map[this.path[indexVertices - 1]][i];
                this.is_visited[i] = true;

                if (sum_cost[indexVertices] < this.MIN_SPENDING_COST) {
                    if (indexVertices < this.SIZE_OF_MAP - 1) {
                        this.TravelingSalesManSolution(indexVertices + 1);
                    } else {
                        if (this.sum_cost[this.SIZE_OF_MAP - 1] + this.map[this.path[this.SIZE_OF_MAP - 1]][0] < this.MIN_SPENDING_COST) {
                            this.MIN_SPENDING_COST = this.sum_cost[this.SIZE_OF_MAP - 1] + this.map[this.path[this.SIZE_OF_MAP - 1]][0];
                            this.CopyDataOfArray(path, this.best_way);
                        }
                    }
                }

                this.is_visited[i] = false;
            }
        }
    }
    //---------------------------end of function--------------------------------

    public void Solve() {
        this.TravelingSalesManSolution(1);
    }
    //---------------------------end fo function -------------------------------
}
