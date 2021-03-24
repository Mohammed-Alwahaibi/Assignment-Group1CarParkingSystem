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
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

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
    private Campus_security campusSecurity;
    private boolean raised = true;
    private JButton check;
    private JButton simulateV;
    private JButton CVehicle;
    private JButton quit;
    private JLabel lblStop;
    private String rNum;
    private JTextArea fdback;
    private JTextArea lbdt;
    private JTextField display;

    Barrier(System_status lnkSystem_status, Vehicle_list lnkVehicle_list, String barrier_screen) {
        this.lnkVehicle_list = lnkVehicle_list;
        this.lnkSystem_status = lnkSystem_status;
        this.campusSecurity = campusSecurity;
        lnkSystem_status.addObserver(this);
        active = lnkSystem_status.getStatus();
        
        // Configure the window
        setTitle("Barrier Screen");
        setLocation(40, 40);
        setSize(300, 220);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // Set up input GUI
        JLabel label = new JLabel("Enter Registration number");
        add(label);
        display = new JTextField(" ", 15);
        add(display);

        check = new JButton("Check vehicle");
        window.add(check);
        check.addActionListener(this);

        simulateV = new JButton("Pass vehicle");
        window.add(simulateV);
        simulateV.addActionListener(this);

        CVehicle = new JButton("Clear vehicle");
        window.add(CVehicle);
        CVehicle.addActionListener(this);

        quit = new JButton("Quit");
        window.add(quit);
        quit.addActionListener(this);

        fdback = new JTextArea("");
        window.add(fdback);
        lbdt = new JTextArea("");
        window.add(lbdt);
        // Display the frame
        setVisible(true);

    } //Constructor

    // Button click handling:
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            java.util.Date tDate = lnkSystem_status.getToday();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tDate);
            calendar.get(Calendar.DAY_OF_MONTH);
            lbdt.setText("Todays Date is: " + tDate);

            rNum = display.getText();
            int day = 0;
            lnkVehicle_list.checkPermitted(rNum, day);
            lnkSystem_status.getStatus();
            //display.setText(" Checked ");

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
         
        active = lnkSystem_status.getStatus();
        System.out.print("updated value is " + active);

        if (active == false) {
            fdback.setText("The barrier is lowered");
            //lblStop.setEnabled(true);
        }

        else if (active == true && raised == false) {
            fdback.setText("The barrier is raised");
            //lblStop.setEnabled(true);
        }
        
        if (raised == true) {
            raised = lnkSystem_status.getStatus();
            display.setText("True");

        } else if (active == false) {
           active = lnkSystem_status.getStatus();
            display.setText("False");
        }

    } // update

    public void clear() {
        display.setText("");
    } // clear
}
