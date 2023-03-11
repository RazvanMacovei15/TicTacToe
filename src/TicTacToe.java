import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.*;


public class TicTacToe
{
    public TicTacToe(){
        //create a jframe object
        JFrame frame = new JFrame();

        //set the title of the JFrame
        frame.setTitle("TicTacToe");

        //set the size of the JFrame
        frame.setSize(600, 600);

        //set the jframe to exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //show the Jframe
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
