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

    Barrier(System_status lnkSystem_status, Vehicle_list lnkVehicle_list, String barrier_screen) {
        this.lnkVehicle_list = lnkVehicle_list;
        this.lnkSystem_status = lnkSystem_status;
        this.campusSecurity = campusSecurity;
        lnkSystem_status.addObserver(this);
        active = lnkSystem_status.getStatus();

        //Barrier window
        // Configure the window
        setTitle("Barrier Screen");
        setLocation(140, 40);
        setSize(270, 250);
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
        labI = new JTextArea("                  ");
        window.add(labI);

        
        warningsC = new JButton("Check Warnings");
        window.add(warningsC);
        warningsC.addActionListener(this);
        

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
            lnkVehicle_list.checkPermitted1(rNum, day);
            lnkSystem_status.getStatus();
        }
        //Quit button
        if (e.getSource() == quit) {
            System.exit(0);
        }
        
        if (e.getSource() == warningsC) {
            java.util.Date tDate = lnkSystem_status.getToday();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tDate);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.get(Calendar.DAY_OF_MONTH);
            
            rNum = display.getText();
            lnkVehicle_list.checkPermitted2(rNum, day);
            lnkSystem_status.getStatus();  
        }
        
        if (e.getSource() == warningsI) {
            java.util.Date tDate = lnkSystem_status.getToday();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tDate);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.get(Calendar.DAY_OF_MONTH);
            
            rNum = display.getText();
            lnkVehicle_list.checkPermitted2(rNum, day);
            lnkSystem_status.getStatus();  
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
