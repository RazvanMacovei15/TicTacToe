import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class TicTacToe extends JFrame implements ActionListener{
    private final JButton[][] buttons;

    private boolean currentPlayerTurn = true ;

    public TicTacToe(){
        //create a frame object
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        //for (int i = 0; i < 9; i++){
           // JButton button = new JButton("click me");
            //panel.add(button);
            //button.addActionListener( this);
        buttons = new JButton[3][3];

        Font font = new Font("Arial", Font.PLAIN,60);

        for(int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
                buttons[i][j].setFont(font);
                panel.add(buttons[i][j]);

            }

        }
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 100));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("status");
        statusLabel.setFont(font);
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        //add the panel to the frame
        frame.add(panel);

        //make the frame not resizeable
        frame.setResizable(false);

        //set the title of the JFrame
        frame.setTitle("TicTacToe");

        //set the size of the JFrame
        frame.setSize(600, 700);

        //set the Frame to exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //show the magical Frame
        frame.setVisible(true);

        //currentPlayer = 'x';

        }
    private int count = 0;
    private final int cols = 3;
    private final int rows = 3;
    @Override
    public void actionPerformed(ActionEvent e) {
        // Display "x" when the button is clicked
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("")) {
            button.setText(currentPlayerTurn ? "X" : "0");
            currentPlayerTurn = !currentPlayerTurn;
            count++;
        }

        winCheck();
        drawCheck();
    }
        private void winCheck(){
            String winner = "";

            //Check rows
            //private boolean player1Turn = true;

            for(int i = 0; i < rows; i++){
                if(buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][0].getText().equals(buttons[i][2].getText()) && !buttons[i][0].getText().equals("")) {
                    winner = buttons[i][0].getText();
                    buttons[i][0].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                    buttons[i][1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                    buttons[i][2].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                }
            }
            //check columns

            for(int i = 0; i < cols; i++) {
                if(buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[0][i].getText().equals(buttons[2][i].getText()) && !buttons[2][i].getText().equals("")) {
                    winner = buttons[0][i].getText();
                    buttons[0][i].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                    buttons[1][i].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                    buttons[2][i].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                }
            }
            //check diagonals

            if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().equals("")) {
                winner = buttons[0][0].getText();
                buttons[0][0].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                buttons[1][1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                buttons[2][2].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
            }
            if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText()) && !buttons[2][0].getText().equals("")) {
                winner = buttons[2][0].getText();
                buttons[0][2].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                buttons[1][1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                buttons[2][0].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
            }

            if(!winner.equals("")) {
                JOptionPane.showMessageDialog(this, winner + " wins!");
                System.exit(0);
            }
            //else {
                //JOptionPane.showMessageDialog(this, "draw");
                //System.exit(0);
            //}
        }
        private void drawCheck() {

            if(count == 9) {
                buttons[0][0].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                buttons[0][1].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                buttons[0][2].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                buttons[1][0].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                buttons[1][1].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                buttons[1][2].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                buttons[2][0].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                buttons[2][1].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                buttons[2][2].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                JOptionPane.showMessageDialog(this, "draw!");
                System.exit(0);
        }


    }

        // Update the button's text and disable it
        //button.setText(Character.toString(currentPlayer));
        //button.setEnabled(false);

        //if (currentPlayer == 'x'){
        //    currentPlayer = '0';
        //}
        //I just learned I need to use a ternary operator to switch from 'x' to '0' and back around
        //currentPlayer = (currentPlayer == 'x') ? '0' : 'x';

    public static void main(String[] args) {

        new TicTacToe();
    }
}
