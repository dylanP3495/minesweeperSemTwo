
/**
 * Write a description of class Cell here.
 * 
 * @author Dylan
 * @version 11.16.17
 * 
 * Notes: 
 *    0) make "isbomb" method
 *    1) make the board
 *       start with 10X10 grid
 *    2)make the "printBoard" method
 *       0000000000
 *       0000000000
 *       0000000000
 *       0000000000
 *       0000000000
 *       0000000000
 *       0000000000
 *       0000000000
 *       0000000000
 *       0000000000
 *       should all be zeroes first, don't be concerned over bombs, numbers yet.
 *    3)make the "add Bombs" method
 *       *bomb = -1, prints as "X"*
 *       *make sure it makes the correct # of bombs, it likes to lie*
 *       
 *    4) create the "add Nums" method
 *       *hardest method to make...idk, just do your best for now*
 *    5) make it look pretty (ui)*add spaces in between, (0 0 0 0 0)*
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell implements ActionListener{
    //Variables you need to work with
    private int value;
    
    //Variables you don't need to worry about or care about.
    private JButton button;
    
    //This constructor is complete and does not need modification
    
    public Cell(){
        button = new JButton();
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(20,20));
        button.setMargin(new Insets(0,0,0,0));
        value = 0;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(int newValue){
    	value = newValue;
    }
    
    public void addValue(){
    if (value != -1){
     value++;   
    }
    }
    
    /** This Method tells me if the cell is a bomb.
     * 
     * @return True if it is a bomb, otherwse false.
     */
    boolean isBomb(){
        if (value == -1){
            return true;
        }
        return false;
    }
    
    //Additional Methods may be required. Please make them yourself.
    //The following methods are used for the User Inferface. These methods are fully functional and do not need to be modified.
    public void checkCell(){
        button.setEnabled(false);
        displayValue();
    }
    
    
    public void displayValue(){
        if(this.isBomb()){
            button.setText("\u2600");
            button.setBackground(Color.RED);
        }else if(value!=0){
            button.setText(String.valueOf(value));
        }
    }
    
    public JButton getButton() {
        return button;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        checkCell();
    }
}