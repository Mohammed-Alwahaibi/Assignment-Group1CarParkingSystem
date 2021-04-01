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
import java.util.Hashtable;
import javax.swing.*;

public class Barrier extends JFrame implements Observer, ActionListener {

    // Useful program constants
    private System_status lnkSystem_status;
    private Campus_security campusSecurity;
    private Vehicle_list lnkVehicle_list;
    private boolean raised = true;
    private boolean active = false;
    private JButton check;
    private JButton quit;
    private JButton go;
    private JButton warningsI;
    private JButton warningsC;
    private String rNum;
    private JTextArea fdback;
    private JTextArea labI;
    private JTextArea labC;
    private JTextField display;
    private JLabel lblWarningRecord;
    private JLabel lblWarning;

    Barrier(System_status lnkSystem_status, Vehicle_list lnkVehicle_list, String barrier_screen) {
        this.lnkVehicle_list = lnkVehicle_list;
        this.lnkSystem_status = lnkSystem_status;
        this.campusSecurity = campusSecurity;
        lnkSystem_status.addObserver(this);
        active = lnkSystem_status.getStatus();

        //Barrier window
        // Configure the window
        setTitle("Barrier Screen");
        setLocation(110, 40);
        setSize(380, 250);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // Set up input GUI for Barrier
        JLabel label = new JLabel("Enter Registration number");
        add(label);
        display = new JTextField("", 15);
        add(display);
        check = new JButton("Check vehicle");
        window.add(check);
        check.addActionListener(this);
        quit = new JButton("Quit");
        window.add(quit);
        quit.addActionListener(this);
        fdback = new JTextArea("                                    ");
        window.add(fdback);
        //Button for Go with color green change to red
        go = new JButton("GO");
        window.add(go);
        go.addActionListener(this);

        warningsI = new JButton("Issue Warnings");
        window.add(warningsI);
        warningsI.addActionListener(this);
        lblWarning = new JLabel("Issue Warning");
        window.add(lblWarning);

        warningsC = new JButton("Check Warnings");
        window.add(warningsC);
        warningsC.addActionListener(this);
        lblWarningRecord = new JLabel("Record Warning");
        window.add(lblWarningRecord);

        // Display the frame
        setVisible(true);

    } //Constructor

    // Button click handling:
    public void actionPerformed(ActionEvent e) {
        //Check buttons codes
        if (e.getSource() == check) {
            java.util.Date tDate = lnkSystem_status.getToday();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tDate);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.get(Calendar.DAY_OF_MONTH);
            //lbdt.setText(""+tDate);

            //CheckPermit codes
            rNum = display.getText();
            lnkVehicle_list.checkPermitted(rNum, day);
            //  lnkVehicle_list.checkPermitted1(rNum, day);
            lnkSystem_status.getStatus();
        }
        //Quit button
        if (e.getSource() == quit) {
            System.exit(0);
        }

        if (e.getSource() == warningsI) {
            Hashtable lnkVehicle = lnkVehicle_list.print1();
            String NoofWarning = (((Vehicle_info) lnkVehicle.get(display.getText())).getNumWarning());
            int noWarning = Integer.parseInt(NoofWarning);

            if (noWarning >= 3) {
                lblWarning.setText("This permit is suspended , because warning reached above 3");
            } else {
                lblWarning.setText("This permit is allowed");
            }

        }

        if (e.getSource() == warningsC) {

            rNum = display.getText();

            Hashtable lnkVehicle = lnkVehicle_list.print1();
            String NoOfEntries = (((Vehicle_info) lnkVehicle.get(display.getText())).getNumEntries());
            int noEntry = Integer.parseInt(NoOfEntries);

            if (noEntry == 3) {
                lblWarningRecord.setText(" First Warning added to permit");
            } else if (noEntry == 4) {
                lblWarningRecord.setText("Second Warning added to permit");
            } else if (noEntry >= 5) {
                lblWarningRecord.setText("Third Warning added to permit");
            } else if (noEntry >= 6) {
                lblWarningRecord.setText("The vehicle permission is suspended");
            }

        }

    } // actionPerformed

    // Notified by the system when it is altered:
    public void update(Observable o, Object arg) {

        //active to get status from system status 
        active = lnkSystem_status.getStatus();
        //System.out.print("updated value is " + active);

        if (active == true) {
            fdback.setText("The barrier is raised");

        } else if (active == false && raised == true) {
            fdback.setText("The barrier is lowered");
        }

        if (raised == true) {
            raised = lnkSystem_status.getStatus();
            go.setBackground(Color.GREEN);
            go.setText("GO");

        } else if (raised == false) {
            raised = lnkSystem_status.getStatus();
            go.setBackground(Color.RED);
            go.setText("STOP!");
        }
    } // update

    public void clear() {
        display.setText("");
    } // clear
}
