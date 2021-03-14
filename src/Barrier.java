/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* Generated by Together */
/**
 * This class represents the access control barriers. Information about the
 * barrier functions is in the Barrier use case diagram (hyperlinked from this
 * class). Although in reality this class will be realised by (programmable)
 * hardware with a moveable barrier, and a camera with a registration number
 * recognition system, here the interface comprises one screen with the various
 * functions present on it, all on view at once since there aren't many.
 *
 * There will be a large word PASS or STOP on display at all times: PASS when
 * the barrier is up because the system is inactive or temporarily when a
 * permitted vehicle is being allowed through, and STOP when the barrier is
 * down.
 *
 * There will be a text field to enter the registration number read by the
 * camera, and a button to indicate that the number has been read and is ready
 * for checking (and raising the barrier or not, as appropriate).
 *
 * To simulate the passage of a vehicle through the raised barrier, there is
 * another button to be clicked to simulate when a buried electronic sensor
 * indicates that the vehicle is now clear - the barrier can then be lowered
 * (unless, of course, the system has been deactivated by security staff in the
 * interim...).
 *
 * There could be many instances of this class: one at each entrance lane to the
 * University. The class implements Observer, and observes the system status so
 * that it can keep its activated/deactivated status up to date.
 *
 * @stereotype boundary
 */
public class Barrier extends JFrame implements Observer, ActionListener {

    /**
     * Each instance of Barrier has a navigable association to the permit list
     * so that when a vehicle's registration number has been recognized by the
     * camera, the barrier can check whether to raise itself or not by checking
     * the status of that vehicle's permit.
     *
     * @clientCardinality 1..
     *
     * @supplierCardinality 1
     * @label Access permits
     * @directed
     */
    private Vehicle_list lnkVehicle_list;

    /**
     * Each instance of Barrier has a navigable association to the system status
     * so that it can check whether the barrier system as a whole is active or
     * inactive, and so that it can send event messages to be recorded in the
     * log.
     *
     * @clientCardinality 1..
     *
     * @supplierCardinality 1
     * @label Fetch system status info
     * @directed
     */
    private System_status lnkSystem_status;

    /**
     * This attribute indicates the active/inactive state of the barrier system
     * - as notified by the system status when it changes (Barrier Observes
     * System status). If false then the barrier must be up. If true then the
     * barrier position is determined by attribute raised.
     */
    private boolean active = false;

    /**
     * If the barrier system is active, this attribute indicates whether the
     * barrier is currently in its raised or lowered position. The position is
     * controlled by the result of checking a registration number with the
     * permitted vehicles list, and the "vehicle clear" button.
     */
    private System_status systemStatus;
    private Campus_security campusSecurity;
    private boolean raised = true;
    private JButton check;
    private JButton simulateV;
    private JButton CVehicle;
    private JButton quit;
    private JTextField display;

    Barrier(System_status systemStatus, String barrier_screen) {
        this.lnkVehicle_list = lnkVehicle_list;
        this.lnkSystem_status = lnkSystem_status;
        this.systemStatus = systemStatus;
        this.campusSecurity = campusSecurity;
        systemStatus.addObserver(this);

        // Configure the window
        setTitle("Barrier Screen");
        setLocation(40, 40);
        setSize(350, 150);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // Set up input GUI
        JLabel label = new JLabel("Enter Regestration number");
        add(label);
        display = new JTextField(" ", 15);
        add(display);

        check = new JButton("Get Vehicle");
        window.add(check);
        check.addActionListener(this);

        simulateV = new JButton("Simulate vehicle");
        window.add(simulateV);
        simulateV.addActionListener(this);

        CVehicle = new JButton("Clear Vehicle");
        window.add(CVehicle);
        CVehicle.addActionListener(this);

        quit = new JButton("Quit");
        window.add(quit);
        quit.addActionListener(this);

        // Display the frame
        setVisible(true);

    } //Constructor

    // Button click handling:
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            display.setText(" Checked ");
        } else if (e.getSource() == simulateV) {
            display.setText(" simulated ");
        }

        if (e.getSource() == quit) {
            System.exit(0);
        } else if (e.getSource() == CVehicle) {
            display.setText("");
        }
    } // actionPerformed

    // Notified by the system when it is altered:
    public void update(Observable o, Object arg) {

        if (raised == true) {
            raised = systemStatus.getStatus();
            display.setText("True");

        } else if (raised == false) {
            active = systemStatus.getStatus();
            display.setText("False");

        }
    } // update

    public void clear() {
        display.setText("");
    } // clear
}
