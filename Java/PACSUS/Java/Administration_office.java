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
import java.util.Hashtable;
import javax.swing.*;

public class Administration_office extends JFrame implements Observer, ActionListener {

    /**
     * Each instance of Administration_office has a navigable association to the
     * permit list so that it can Esquire about/add/delete/modify permits.
     *
     * @supplierCardinality 1
     * @clientCardinality 1..
     *
     * @label Administration functions
     * @directed
     */
    private Permit_list lnkPermit_list;

    /**
     * Each instance of Administration_office has a navigable association to the
     * vehicle list so that it can enquire about/add/delete/modify vehicle
     * details.
     *
     * @clientCardinality 1..
     *
     * @supplierCardinality 1
     * @label Administration functions
     * @directed
     */
    private Vehicle_list lnkVehicle_list;

    /**
     * Each instance of Administration_office has a navigable association to the
     * system status so that it can find out status information about the
     * system.
     *
     * @clientCardinality 1..
     *
     * @supplierCardinality 1
     * @label See date
     * @directed
     */
    // Useful program constants
    private int count;
    private JButton add;
    private JButton remove;
    private JButton print;
    private JButton addP;
    private JButton removeP;
    private JButton printP;
    private JButton addBtn;
    private JButton decBtn;
    private JButton warnings;
    private JButton warnings1;
    private JTextField text1;
    private JTextField text2;
    private JTextField txN;
    private JTextField txV;
    private JTextField txE;
    private JTextField txC;
    private JTextField display;
    private JTextField display1;
    Permit LPermit = null;
    private JComboBox<String> comboPerType;
    String[] perTypes = {"Regular Visitor", "Day Visitor", "Permanent Visitor", "University Visitor"};

    public Administration_office(System_status lnkSystem_status, Vehicle_list lnkVehicle_list, Permit_list lnkPermit_list, String administration_Office_Screen) {
        // code for the fields and buttons
        this.lnkVehicle_list = lnkVehicle_list;
        this.lnkPermit_list = lnkPermit_list;

        JFrame window = new JFrame("Window 1");
        JFrame window1 = new JFrame("Window 2");
        Container container = window.getContentPane();
        container.setLayout(new FlowLayout());
        //AdministrationOffice window
        window.setTitle("AdministrationOffice Screen");
        window.setLocation(870, 40);
        window.setSize(240, 420);
        window.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        window.setLayout(new FlowLayout());
        //AdministrationOffice TextFields and labels
        JLabel label = new JLabel("Registration number:");
        window.add(label);
        text1 = new JTextField("", 15);
        window.add(text1);
        JLabel label2 = new JLabel("Car color:");
        window.add(label2);
        text2 = new JTextField("", 15);
        window.add(text2);
        JLabel labelC = new JLabel("Car Name:");
        window.add(labelC);
        txC = new JTextField("", 15);
        window.add(txC);
        add = new JButton("Add");
        window.add(add);
        add.addActionListener(this);
        remove = new JButton("Remove");
        window.add(remove);
        remove.addActionListener(this);
        print = new JButton("Print");
        window.add(print);
        print.addActionListener(this);

        //the number of Entries
        JLabel labele = new JLabel("No of Entries:");
        window.add(labele);
        display = new JTextField("", 5);
        window.add(display);
        count = 0;
        addBtn = new JButton("Add Entry");
        window.add(addBtn);
        addBtn.addActionListener(this);
        decBtn = new JButton("Remove Entry");
        window.add(decBtn);
        decBtn.addActionListener(this);
        display1 = new JTextField("", 10);
        window.add(display1);
        warnings = new JButton("Add Warnings");
        window.add(warnings);
        warnings.addActionListener(this);
        warnings1 = new JButton("Delete Warnings");
        window.add(warnings1);
        warnings1.addActionListener(this);

        // Display the frame
        window.setVisible(true);

        // for permit
        // Configure the window
        window1.setTitle("Permit Screen");
        window1.setLocation(490, 190);
        window1.setSize(290, 280);
        window1.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        window1.setLayout(new FlowLayout());
        //TextFields and labels for permit
        JLabel labelp = new JLabel("Select the permit type:");
        window1.add(labelp);
        comboPerType = new JComboBox(perTypes);
        comboPerType.setSelectedIndex(0);
        window1.add(comboPerType);
        comboPerType.addActionListener(this);

        JLabel labeln = new JLabel("Owenr Name:");
        window1.add(labeln);
        txN = new JTextField("", 20);
        window1.add(txN);
        JLabel labelV = new JLabel("Visit Day:");
        window1.add(labelV);
        txV = new JTextField("", 20);
        window1.add(txV);
        JLabel labelE = new JLabel("End Day:");
        window1.add(labelE);
        txE = new JTextField("", 20);
        window1.add(txE);
        addP = new JButton("Permit Add");
        window1.add(addP);
        addP.addActionListener(this);
        removeP = new JButton("Permit Cancel");
        window1.add(removeP);
        removeP.addActionListener(this);
        printP = new JButton("Permit Print");
        window1.add(printP);
        printP.addActionListener(this);

        // Display the frame
        window1.setVisible(true);

    }//Constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            // code for add vehicle button  
            if (!lnkVehicle_list.checkPermitted(text1.getText())) {
                LPermit = lnkPermit_list.getPermit(txC.getText());
                lnkVehicle_list.add(LPermit, text1.getText(), text2.getText(), txC.getText());
                System.out.println("Vehicle is added");
            } else {
                System.out.println("Registration number is alredy existing");
            }
            text1.setText("");
            text2.setText("");
            txC.setText("");

            // code for print vehicle button
        } else if (e.getSource() == print) {
            JFrame window3 = new JFrame("Window 3");
            window3.setTitle("print Screen");
            window3.setLocation(150, 300);
            window3.setSize(850, 290);
            window3.setLayout(new FlowLayout());
            JLabel labelp = new JLabel("Printed Vehicle:\n ");
            window3.add(labelp);
            //Vehicle Hashtable
            Hashtable lnkVehicle = lnkVehicle_list.print(text1.getText(), text2.getText());
            JLabel labelpr = new JLabel("Vehicle HashTable" + lnkVehicle.toString());
            window3.add(labelpr);
            window3.setVisible(true);

            // code for remove vehicle button
        } else if (e.getSource() == remove) {
            lnkVehicle_list.remove1(text1.getText(), text2.getText());
        }

        // code for add permit button
        if (e.getSource() == addP) {

            if (((String) comboPerType.getSelectedItem()).equals("Day Visitor")) {
                lnkPermit_list.addD(txN.getText(), txV.getText(), txE.getText());

            } else if (((String) comboPerType.getSelectedItem()).equals("Regular Visitor")) {
                lnkPermit_list.addR(txC.getText(), txN.getText(), txV.getText(), txE.getText());
            } else if (((String) comboPerType.getSelectedItem()).equals("Permanent Visitor")) {
                lnkPermit_list.addP(txC.getText());

            } else if (((String) comboPerType.getSelectedItem()).equals("University Visitor")) {
                lnkPermit_list.addU(txC.getText(), txV.getText());

            }
            txE.setText("");
            txN.setText("");
            txV.setText("");
        }

        // code for print permit button
        if (e.getSource() == printP) {
            JFrame window3 = new JFrame("Window 3");
            window3.setTitle("print Screen");
            window3.setLocation(150, 300);
            window3.setSize(710, 290);
            window3.setLayout(new FlowLayout());
            JLabel labelp = new JLabel("Printed Permit:\n ");
            window3.add(labelp);
            //Vehicle Hashtable
            Hashtable lnkPermit = lnkPermit_list.printP(txC.getText(), txN.getText(), txV.getText(), txE.getText());
            JLabel labelpr = new JLabel("Permit HashTable\n: " + lnkPermit.toString());
            window3.add(labelpr);
            window3.setVisible(true);

            // code for remove permit button   
        } else if (e.getSource() == removeP) {
            lnkPermit_list.removeP(txC.getText(), txN.getText(), txV.getText(), txE.getText());
        }

        //Add Entry button
        if (e.getSource() == addBtn) {
            count++; // increment the coiunt by 1
            display.setText(String.valueOf(count));
            repaint();
        } //Remove Entry button
        else if (e.getSource() == decBtn) {
            count--; // increment the coiunt by 1
            display.setText(String.valueOf(count));
            repaint();
        } 
        
        if (e.getSource() == warnings) {
            
            
        } else if (e.getSource() == warnings) {
            
            
        }
    }

    @Override
    public void update(Observable o, Object o1) {
    }
}
