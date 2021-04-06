/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;
//This is done by Mohammed ID:2732720
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
    private JButton warnings;
    private JButton warnings1;
    private JTextField regNum;
    private JTextField carCl;
    private JTextField carName;
    private JTextField owenerNm;
    private JTextField visitDay;
    private JTextField endDay;
    private JTextField display;
    private JTextField displayW;
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
        regNum = new JTextField("", 15);
        window.add(regNum);
        JLabel label2 = new JLabel("Car color:");
        window.add(label2);
        carCl = new JTextField("", 15);
        window.add(carCl);
        JLabel labelC = new JLabel("Car Name:");
        window.add(labelC);
        carName = new JTextField("", 15);
        window.add(carName);
        //the number of Entries
        JLabel labele = new JLabel("No of Entries:");
        window.add(labele);
        display = new JTextField("", 7);
        window.add(display);
        
        ////the number of warnings
        JLabel labele1 = new JLabel("No of warnings:");
        window.add(labele1);
        displayW = new JTextField("", 7);
        window.add(displayW);
        //Buttons
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
        owenerNm = new JTextField("", 20);
        window1.add(owenerNm);
        JLabel labelV = new JLabel("Visit Day:");
        window1.add(labelV);
        visitDay = new JTextField("", 20);
        window1.add(visitDay);
        JLabel labelE = new JLabel("End Day:");
        window1.add(labelE);
        endDay = new JTextField("", 20);
        window1.add(endDay);
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
            if (!lnkVehicle_list.checkPermitted(regNum.getText())) {
                LPermit = lnkPermit_list.getPermit(carName.getText());
                lnkVehicle_list.add(LPermit, regNum.getText(), carCl.getText(), carName.getText(), display.getText(), displayW.getText());
                System.out.println("Vehicle is added");
            } else {
                System.out.println("Registration number is alredy existing");
            }
            regNum.setText("");
            carCl.setText("");
            carName.setText("");
            display.setText("");
            displayW.setText("");

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
            Hashtable lnkVehicle = lnkVehicle_list.print(regNum.getText(), carCl.getText());
            JLabel labelpr = new JLabel("Vehicle HashTable" + lnkVehicle.toString());
            window3.add(labelpr);
            window3.setVisible(true);

            // code for remove vehicle button
        } else if (e.getSource() == remove) {
            lnkVehicle_list.remove1(regNum.getText(), carCl.getText());
        }

        // code for add permit button
        if (e.getSource() == addP) {

            if (((String) comboPerType.getSelectedItem()).equals("Day Visitor")) {
                lnkPermit_list.addD(carName.getText(), owenerNm.getText(), visitDay.getText());
                
            } else if (((String) comboPerType.getSelectedItem()).equals("Regular Visitor")) {
                lnkPermit_list.addR(carName.getText(), owenerNm.getText(), visitDay.getText(), endDay.getText());
                
            } else if (((String) comboPerType.getSelectedItem()).equals("Permanent Visitor")) {
                lnkPermit_list.addP(carName.getText());
                
            } else if (((String) comboPerType.getSelectedItem()).equals("University Visitor")) {
                lnkPermit_list.addU(carName.getText(), owenerNm.getText(), visitDay.getText());

            }
            endDay.setText("");
            owenerNm.setText("");
            visitDay.setText("");
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
            Hashtable lnkPermit = lnkPermit_list.printP(carName.getText(), owenerNm.getText(), visitDay.getText(), endDay.getText());
            JLabel labelpr = new JLabel("Permit HashTable\n: " + lnkPermit.toString());
            window3.add(labelpr);
            window3.setVisible(true);

            // code for remove permit button   
        } else if (e.getSource() == removeP) {
            lnkPermit_list.removeP(carName.getText(), owenerNm.getText(), visitDay.getText(), endDay.getText());
        }
        
        if (e.getSource() == warnings) {
            display1.getText();
            
        } else if (e.getSource() == warnings1) {
            display1.getText();
            
        }
    }

    @Override
    public void update(Observable o, Object o1) {
    }
}
