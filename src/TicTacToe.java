import utils.WinChecker;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class TicTacToe extends JFrame implements ActionListener{
    private final JButton[][] matrixButtons;

    private boolean currentPlayerTurn = true ;

    public TicTacToe(){
        //create a frame object
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        //for (int i = 0; i < 9; i++){
           // JButton button = new JButton("click me");
            //panel.add(button);
            //button.addActionListener( this);
        this.matrixButtons = new JButton[rows][cols];

        Font font = new Font("Arial", Font.PLAIN,60);

        for(int i = 0; i<this.rows; i++){
            for (int j = 0; j<cols; j++){
                this.matrixButtons[i][j] = new JButton();
                this.matrixButtons[i][j].addActionListener(this);
                this.matrixButtons[i][j].setFont(font);
                panel.add(this.matrixButtons[i][j]);

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
    private final int cols = 5;
    private final int rows = 5;
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
            checkRows();
            checkColumns();
            checkDiagonalA();
            checkDiagonalB();
/*

            for(int i = 0; i < cols; i++) {
                if(matrixButtons[0][i].getText().equals(matrixButtons[1][i].getText()) && matrixButtons[0][i].getText().equals(
                    matrixButtons[2][i].getText()) && !matrixButtons[2][i].getText().equals("")) {
                    winner = matrixButtons[0][i].getText();
                    matrixButtons[0][i].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                    matrixButtons[1][i].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                    matrixButtons[2][i].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));

                }
            }
            //check diagonals

            if (matrixButtons[0][0].getText().equals(matrixButtons[1][1].getText()) && matrixButtons[0][0].getText().equals(
                matrixButtons[2][2].getText()) && !matrixButtons[0][0].getText().equals("")) {
                winner = matrixButtons[0][0].getText();
                matrixButtons[0][0].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                matrixButtons[1][1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                matrixButtons[2][2].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
            }
            if (matrixButtons[0][2].getText().equals(matrixButtons[1][1].getText()) && matrixButtons[0][2].getText().equals(
                matrixButtons[2][0].getText()) && !matrixButtons[2][0].getText().equals("")) {
                winner = matrixButtons[2][0].getText();
                matrixButtons[0][2].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                matrixButtons[1][1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                matrixButtons[2][0].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
            }


            //else {
                //JOptionPane.showMessageDialog(this, "draw");
                //System.exit(0);
            //}*/
        }

    private void checkDiagonalB() {
        JButton[] diagonalB = new JButton[rows];
        for(int idx = 0; idx < rows; idx++) {
            diagonalB[idx] = matrixButtons[idx][idx];
        }
        WinChecker winChecker = new WinChecker(diagonalB, this);
        winChecker.checkWin();
    }

    private void checkDiagonalA() {
        JButton[] diagonalA = new JButton[rows];
        for(int idx = 0; idx < rows; idx++) {
            diagonalA[idx] = matrixButtons[idx][rows - idx - 1];
        }
        WinChecker winChecker = new WinChecker(diagonalA, this);
        winChecker.checkWin();
    }

    private void checkColumns() {
        for(int colIdx = 0; colIdx < cols; colIdx++){
            JButton[] column = new JButton[cols];
            for(int cellIdx = 0; cellIdx < rows; cellIdx++) {
                column[cellIdx] = matrixButtons[cellIdx][colIdx];
            }
            WinChecker winChecker = new WinChecker(column, this);
            winChecker.checkWin();
        }
    }

    private void checkRows() {
        for(int rowIdx = 0; rowIdx < rows; rowIdx++){
            JButton[] row = matrixButtons[rowIdx];
            WinChecker winChecker = new WinChecker(row, this);
            winChecker.checkWin();
        }
    }

    private void drawCheck() {
            if(count == rows * rows) {
                for(JButton[] row : matrixButtons) {
                    for(JButton cell: row) { // row is an array
                        cell.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                    }
                }
//                for (int i = 0; i < matrixButtons.length; i++) {
//                    for (int j = 0; j < matrixButtons.length; j++) {
//                        matrixButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
//                    }
//                }
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

        TicTacToe tacToe = new TicTacToe();
    }
}
