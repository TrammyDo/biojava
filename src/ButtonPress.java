/**
 * A button class that will wait for the user's interaction
 *
 * @author Tram Do
 *
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPress implements ActionListener {

    /**
     * The action performed upon user interaction with button
     *
     * @param e the action
     *
     */
    public void actionPerformed (ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Calculate!");
    }
}
