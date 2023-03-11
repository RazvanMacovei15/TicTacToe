import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;


public class TicTacToe extends JFrame implements ActionListener{
    private char currentPlayer ;
    public TicTacToe(){
        //create a jframe object
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++){
            JButton button = new JButton("click me");
            panel.add(button);
            button.addActionListener( this);


        }
        frame.add(panel);

        //make the frame not resizeable
        frame.setResizable(false);

        //set the title of the JFrame
        frame.setTitle("TicTacToe");

        //set the size of the JFrame
        frame.setSize(600, 600);

        //set the Jframe to exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //show the magical Jframe
        frame.setVisible(true);

        currentPlayer = 'x';

        }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Display "x" when the button is clicked
        JButton button = (JButton) e.getSource();

        // Update the button's text and disable it
        button.setText(Character.toString(currentPlayer));
        button.setEnabled(false);

        //if (currentPlayer == 'x'){
        //    currentPlayer = '0';
        //}
        //i just learned i need to use a ternary operator to switch from 'x' to '0' and back around

        currentPlayer = (currentPlayer == 'x') ? '0' : 'x';

    }
    public static void main(String[] args) {

        new TicTacToe();
    }
}
