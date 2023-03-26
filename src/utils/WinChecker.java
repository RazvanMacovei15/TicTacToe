package utils;

import javax.swing.*;
import java.awt.*;

public class WinChecker {

    private JButton[] array;

    private JFrame parent;

    public WinChecker(JButton[] array, JFrame parent) {
        this.array = array;
        this.parent = parent;
    }

    public void checkWin() {
        JButton firstCell = this.array[0];
        String winnerFound = firstCell.getText();

        for(JButton cell : array) {
            if (!cell.getText().equals(firstCell.getText())) {
                winnerFound = "";
                break;
            }
        }

        if(!winnerFound.isEmpty()) {
            for(JButton cell: array) {
                cell.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
            }
        }
        checkWin(winnerFound);
    }

    private void checkWin(String winner) {
        if(!winner.equals("")) {
            JOptionPane.showMessageDialog(this.parent, winner + " wins!");
            System.exit(0);
        }
    }
}
