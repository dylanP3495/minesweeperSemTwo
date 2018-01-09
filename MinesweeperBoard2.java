
/**
 * Write a description of class Minesweeper here.
 * 
 * @author Dylan
 * @version 11.16.17
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[] board;
    int rows;
    int columns;

    public MinesweeperBoard2(int rows, int columns, int bombs){
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;
        board = new Cell[rows* columns];

        //These pieces are for the GUI. Ignore them.
        JFrame frame = new JFrame();
        frame.add(addCells());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        addBombs (bombs);
        addNums();
    }

    public MinesweeperBoard2(){
        this (10,10,10);
    }

    public void addBombs(int bombs){// throws Exception{
        for (int i = 0; i < bombs; i++) {
            int a = (int) (Math.random() *( rows * columns));
            if(board[a].getValue() == -1 ){
                i--;
            }else{
                board[a].setValue(-1);
            }
        }
    }

    public void addNums(){
        for (int a = 0; a < (rows*columns); a++) {
            if (board[a].getValue() == -1 ){//bomb
                //top left
                if ((a >= columns) && (a % columns != 0) ){
                    board[a - columns -1].addValue();
                }

                // top bound
                if (a >= columns){
                    board[a - columns].addValue();
                }

                // top right
                if ((a >= columns) && (a % columns != (columns - 1))){
                    board[a - columns + 1].addValue();
                }

                // left bound
                if ((a % columns != 0)){
                    board[a - 1].addValue();
                }
                
                // right bound
                if (a % columns != (columns - 1)){
                    board[a + 1].addValue();
                }
                
                // bot left
                if ((a <= ((rows-1) * columns)) && (a % columns != 0)){
                    board[a + columns - 1].addValue();
                }
                
                // bot bound
                if (a < ((rows-1) * columns)){
                    board[a + columns].addValue();
                }
                
                // bot right
                if (a < ((rows - 1) * columns) && (a % columns !=(columns - 1))){
                    board[a + columns + 1].addValue();
                }
            }
        }
    }

    /**
     * This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int x = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if(board[x].getValue() == -1){
                    System.out.print ("x" + " ");
                }else{
                    System.out.print (board[x].getValue() + " ");
                }
                x++;
            }
            System.out.println ();
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< (rows*columns); i++){
            board[i]= new Cell();
            panel.add(board[i].getButton());
        }
        return panel;
    }
}
