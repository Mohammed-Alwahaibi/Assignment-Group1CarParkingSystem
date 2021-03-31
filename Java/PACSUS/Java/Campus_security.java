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
import java.util.Calendar;
import java.util.Observable;
import javax.swing.*;

public class Campus_security extends JFrame implements Observer, ActionListener {

    // Useful program constants
    private Vehicle_list lnkVehicle_list;
    private System_status systemStatus;
    private System_status lnkSystem_status;
    private String rNum;
    private JButton active;
    private JButton warnings;
    private JButton deactivate;
    private JTextArea lbdpr;
    private JTextField display;

    Campus_security(System_status systemStatus, String Campus_security_screen) {
        //codes for linking between the classes
        this.lnkVehicle_list = lnkVehicle_list;
        this.lnkSystem_status = lnkSystem_status;
        this.systemStatus = systemStatus;
        systemStatus.addObserver(this);

        //Campus security interface
        // Configure the window
        setTitle("Campus security screen");
        setLocation(490, 40);
        setSize(300, 150);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // Set up input GUI
        active = new JButton("Active");
        window.add(active);
        active.addActionListener(this);
        deactivate = new JButton("Deactivate");
        window.add(deactivate);
        deactivate.addActionListener(this);
        warnings = new JButton("Warnings");
        window.add(warnings);
        warnings.addActionListener(this);
        lbdpr = new JTextArea("                                     ");
        window.add(lbdpr);

        // Display the frame
        setVisible(true);
    } //Constructor

    // Button click handling:
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == active) {
            systemStatus.active();
            lbdpr.setText("Vehicle has permisson");
        } else if (e.getSource() == deactivate) {
            systemStatus.deactivate();
            lbdpr.setText("Vehicle has no permisson");
        } 
        if (e.getSource() == warnings) {
        }
        
    } // actionPerformed

    @Override
    public void update(Observable o, Object arg) {
    }
}
