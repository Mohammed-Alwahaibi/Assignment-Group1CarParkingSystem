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
    private JButton modif;
    private JButton addP;
    private JButton removeP;
    private JButton printP;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JTextField txN;
    private JTextField txV;
    private JTextField txE;
    private JTextField txC;
    private JComboBox<String> cPermitType;
    String[] perTypes = { "Day Visitor", "Regular Visitor", "Permanent Visitor", "University Visitor" };

    public Administration_office(System_status systemStatus, Vehicle_list lnkVehicle_list, Permit_list lnkPermit_list, String administration_Office_Screen) {
        // code for the fields and buttons
        this.lnkVehicle_list = lnkVehicle_list;
        this.lnkPermit_list = lnkPermit_list;
        //lnkSystem_status.addObserver(this);

        setTitle("AdministrationOffice Screen");
        setLocation(870, 40);
        setSize(290, 550);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        JLabel label = new JLabel("Regestration number:");
        add(label);
        text1 = new JTextField(" ", 20);
        add(text1);
        JLabel label2 = new JLabel("Car number:");
        add(label2);
        text2 = new JTextField(" ", 20);
        add(text2);
        JLabel label3 = new JLabel("Car color:");
        add(label3);
        text3 = new JTextField(" ", 20);
        add(text3);
        JLabel label4 = new JLabel("Car type:");
        add(label4);
        text4 = new JTextField(" ", 20);
        add(text4);

        add = new JButton("Add");
        window.add(add);
        add.addActionListener(this);
        remove = new JButton("Remove");
        window.add(remove);
        remove.addActionListener(this);
        print = new JButton("Print");
        window.add(print);
        print.addActionListener(this);
        modif = new JButton("Modify");
        window.add(modif);
        modif.addActionListener(this);
        
        // for permit
        JLabel labelp = new JLabel("Select the permit type:");
        add(labelp);
        cPermitType = new JComboBox(perTypes);
        cPermitType.setSelectedIndex(0); 
        window.add(cPermitType);
        cPermitType.addActionListener(this);
        
        JLabel labelC = new JLabel("Car Name:");
        add(labelC);
        txC = new JTextField(" ", 20);
        add(txC);
        
        JLabel labeln = new JLabel("Owenr Name:");
        add(labeln);
        txN = new JTextField(" ", 20);
        add(txN);
        
        JLabel labelV = new JLabel("Visit Day:");
        add(labelV);
        txV = new JTextField(" ", 20);
        add(txV);
        
        JLabel labelE = new JLabel("End Day:");
        add(labelE);
        txE = new JTextField(" ", 20);
        add(txE);
        
        addP = new JButton("Permit Add");
        window.add(addP);
        addP.addActionListener(this);
        
        removeP = new JButton("Permit Remove");
        window.add(removeP);
        removeP.addActionListener(this);
        
        printP = new JButton("Permit Print");
        window.add(printP);
        printP.addActionListener(this);

        // Display the frame
        setVisible(true);
    }//Constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            // code for add button  
            lnkVehicle_list.add(text1.getText(), text2.getText(), text3.getText(), text4.getText());
        } else if (e.getSource() == print) {
            lnkVehicle_list.print(text1.getText(), text2.getText(), text3.getText(), text4.getText());
        } else if (e.getSource() == remove) {
            lnkVehicle_list.check(text1.getText(), text2.getText(), text3.getText(), text4.getText());
        } else if (e.getSource() == modif) {
            lnkVehicle_list.modif(text1.getText(), text2.getText(), text3.getText(), text4.getText());
        }
        text1.setText("");
         text2.setText("");
         text3.setText("");
         text4.setText("");
        
        if (e.getSource() == addP) {  
         if (((String)cPermitType.getSelectedItem()).equals("Day Visitor"))
         {
            lnkPermit_list.addD(txC.getText(), txN.getText(), txV.getText());
         }
         else if (((String)cPermitType.getSelectedItem()).equals("Regular Visitor"))
         {
           lnkPermit_list.addR(txC.getText(), txN.getText(), txV.getText(), txE.getText());    
         }
         else if (((String)cPermitType.getSelectedItem()).equals("Permanent Visitor"))
         {
            lnkPermit_list.addP(txC.getText());    
         }
         else if (((String)cPermitType.getSelectedItem()).equals("University Visitor"))
         {
            lnkPermit_list.addU(txC.getText(), txV.getText());    
         } 
         txC.setText("");
         txN.setText("");
         txV.setText("");
         txE.setText("");   
        }

         if (e.getSource() == printP) {
           
             if (((String)cPermitType.getSelectedItem()).equals("Day Visitor"))
         {
            lnkPermit_list.addD(txC.getText(), txN.getText(), txV.getText());
         }
         else if (((String)cPermitType.getSelectedItem()).equals("Regular Visitor"))
         {
           lnkPermit_list.addR(txC.getText(), txN.getText(), txV.getText(), txE.getText());    
         }
         else if (((String)cPermitType.getSelectedItem()).equals("Permanent Visitor"))
         {
            lnkPermit_list.addP(txC.getText());    
         }
         else if (((String)cPermitType.getSelectedItem()).equals("University Visitor"))
         {
            lnkPermit_list.addU(txC.getText(), txV.getText());    
         } 
        } 
        else if (e.getSource() == removeP) {
           if (((String)cPermitType.getSelectedItem()).equals("Day Visitor"))
         {
            lnkPermit_list.addD(txC.getText(), txN.getText(), txV.getText());
         }
         else if (((String)cPermitType.getSelectedItem()).equals("Regular Visitor"))
         {
           lnkPermit_list.addR(txC.getText(), txN.getText(), txV.getText(), txE.getText());    
         }
         else if (((String)cPermitType.getSelectedItem()).equals("Permanent Visitor"))
         {
            lnkPermit_list.addP(txC.getText());    
         }
         else if (((String)cPermitType.getSelectedItem()).equals("University Visitor"))
         {
            lnkPermit_list.addU(txC.getText(), txV.getText());    
         }  
        } 
        
    }

    @Override
    public void update(Observable o, Object o1) {
    }
}