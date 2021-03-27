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

/* Generated by Together */
/**
 * This class represents the interactive interface to PACSUS administration
 * functions carried out in the Estates and Campus Services Office. Information
 * about these functions is in the Administration use case diagram (hyperlinked
 * from this class).
 *
 * The interface comprises one screen with all the functions present on it: they
 * could all be on view at once, or perhaps in alternative JPanels (in a JFrame
 * with JTabbedPane); the current date (day number) is always displayed.
 *
 * There could be any number of instances of this class, potentially one for
 * each workstation in the office, with different staff carrying different
 * functions.
 *
 * The class implements Observer, and observes the system status so that it can
 * keep the displayed current date correct.
 *
 * @stereotype boundary
 */
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
    private System_status lnkSystem_status;
    private JButton add;
    private JButton remove;
    private JButton print;
    private JButton addP;
    private JButton removeP;
    private JButton printP;
    private JTextField text1;
    private JTextField text2;
    private JTextField txN;
    private JTextField txV;
    private JTextField txE;
    private JTextField txC;
    private TextArea textArea1;
    private JTextArea printArea;
    private JComboBox<String> comboPerType;
    Permit LPermit = null;

    String[] perTypes = {"Day Visitor", "Regular Visitor", "Permanent Visitor", "University Visitor"};

    public Administration_office(System_status lnkSystem_status, Vehicle_list lnkVehicle_list, Permit_list lnkPermit_list, String administration_Office_Screen) {
        // code for the fields and buttons
        this.lnkVehicle_list = lnkVehicle_list;
        this.lnkPermit_list = lnkPermit_list;

        JFrame window = new JFrame("Window 1");
        JFrame window1 = new JFrame("Window 2");

        Container container = window.getContentPane();
        container.setLayout(new FlowLayout());

        window.setTitle("AdministrationOffice Screen");
        window.setLocation(870, 40);
        window.setSize(300, 240);
        window.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        window.setLayout(new FlowLayout());

        JLabel label = new JLabel("Registration number:");
        window.add(label);
        text1 = new JTextField(" ", 20);
        window.add(text1);
        JLabel label2 = new JLabel("Car color:");
        window.add(label2);
        text2 = new JTextField(" ", 20);
        window.add(text2);
        JLabel labelC = new JLabel("Car Name:");
        window.add(labelC);
        txC = new JTextField(" ", 20);
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

        // Display the frame
        window.setVisible(true);

        // for permit
        // Configure the window
        window1.setTitle("Permit Screen");
        window1.setLocation(870, 280);
        window1.setSize(290, 270);
        window1.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        window1.setLayout(new FlowLayout());

        JLabel labelp = new JLabel("Select the permit type:");
        window1.add(labelp);
        comboPerType = new JComboBox(perTypes);
        comboPerType.setSelectedIndex(0);
        window1.add(comboPerType);
        comboPerType.addActionListener(this);

        JLabel labeln = new JLabel("Owenr Name:");
        window1.add(labeln);
        txN = new JTextField(" ", 20);
        window1.add(txN);

        JLabel labelV = new JLabel("Visit Day:");
        window1.add(labelV);
        txV = new JTextField(" ", 20);
        window1.add(txV);

        JLabel labelE = new JLabel("End Day:");
        window1.add(labelE);
        txE = new JTextField(" ", 20);
        window1.add(txE);

        addP = new JButton("Permit Add");
        window1.add(addP);
        addP.addActionListener(this);

        removeP = new JButton("Permit Remove");
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

                lnkVehicle_list.add(LPermit, text1.getText(), text2.getText());
                System.out.println("Vehicle is added");
            } else {
                System.out.println("Registration number is alredy existing");
            }

        } else if (e.getSource() == print) {
            Hashtable lnkVehicle1 = lnkVehicle_list.print(text1.getText(), text2.getText());
            textArea1.setText("HashTable" + lnkVehicle1.toString());

        } else if (e.getSource() == remove) {
            lnkVehicle_list.remove(txC.getText(), txN.getText(), txV.getText(), txE.getText());
        }

        if (e.getSource() == addP) {
            if (((String) comboPerType.getSelectedItem()).equals("Day Visitor")) {
                lnkPermit_list.addD(txC.getText(), txN.getText(), txV.getText());
            } else if (((String) comboPerType.getSelectedItem()).equals("Regular Visitor")) {
                lnkPermit_list.addR(txC.getText(), txN.getText(), txV.getText(), txE.getText());
            } else if (((String) comboPerType.getSelectedItem()).equals("Permanent Visitor")) {
                lnkPermit_list.addP(txC.getText());
            } else if (((String) comboPerType.getSelectedItem()).equals("University Visitor")) {
                lnkPermit_list.addU(txC.getText(), txV.getText());
            }
        }

        if (e.getSource() == printP) {
            JFrame window3 = new JFrame("Window 3");
            window3.setTitle("print Screen");
            window3.setLocation(70, 80);
            window3.setSize(290, 270);
            window3.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            window3.setLayout(new FlowLayout());
            JLabel labelp = new JLabel("Printed Permit:\n ");
            window3.add(labelp);

            Hashtable lnkPermit = lnkPermit_list.printP(txC.getText(), txN.getText(), txV.getText(), txE.getText());
            printArea.setText("HashTable" + lnkPermit.toString());
            printArea.setEditable(false);
            window3.add(printArea);
            window3.setVisible(true);

        } else if (e.getSource() == removeP) {
            lnkPermit_list.removeP(txC.getText(), txN.getText(), txV.getText(), txE.getText());
        }

    }

    @Override
    public void update(Observable o, Object o1) {
    }
}