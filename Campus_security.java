/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;

import java.util.Observer;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.*;

public class Campus_security extends JFrame implements Observer, ActionListener {

    private static void deactivateB() {
    }
    /**
     * Each instance of Campus_security has a navigable association to the
     * vehicle list so that warnings can be recorded on the permit for vehicles
     * that breach parking regulations. Note that this process goes via the
     * vehicle list as the only information available about such a vehicle is
     * its registration number.
     *
     * @clientCardinality 1..
     *
     * @supplierCardinality 1
     * @label Record warning
     * @directed
     */
    private Vehicle_list lnkVehicle_list;

    /**
     * Each instance of Campus_security has a navigable association to the
     * system status so that it can both find out status information about the
     * system, and send controlling messages to the system status (to
     * activate/deactivate the system).
     *
     * @clientCardinality 1..
     *
     * @supplierCardinality 1
     * @label Control/monitor
     * @directed
     */
    private System_status systemStatus;
    private System_status lnkSystem_status;
    private JButton active;
    private JButton deactivate;
    private JButton warnings;
    private JTextField display;

    Campus_security(System_status systemStatus, String Campus_security_screen) {
        this.lnkVehicle_list = lnkVehicle_list;
        this.lnkSystem_status = lnkSystem_status;
        this.systemStatus = systemStatus;
        systemStatus.addObserver(this);

        // Configure the window
        setTitle("Campus security screen");
        setLocation(440, 40);
        setSize(350, 150);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // Set up input GUI
        display = new JTextField(" ", 15);
        add(display);

        active = new JButton("Active");
        window.add(active);
        active.addActionListener(this);

        deactivate = new JButton("Deactivate");
        window.add(deactivate);
        deactivate.addActionListener(this);

        warnings = new JButton("Warnings");
        window.add(warnings);
        warnings.addActionListener(this);
        // Display the frame
        setVisible(true);
    } //Constructor

    // Button click handling:
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == active) {
            systemStatus.active();
        } else if (e.getSource() == deactivate) {
            systemStatus.deactivate();
        } else if (e.getSource() == warnings) {
            display.setText("Warnings");
        }
    } // actionPerformed

    @Override
    public void update(Observable o, Object arg) {
    }
}
