/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;

/* Generated by Together */

/**
 * This is an outline of a main program to build the operational infrastructure
 * of PACSUS. Look at the description and code for the main method.
 */
public class Main {

    /**
     * This main method builds the operational infrastructure of PACSUS as it
     * starts up:
     *
     * The fixed internal "model" classes holding data are instantiated: one
     * instance each of System status, Vehicle list and Permit list.
     *
     * Boundary class objects are instantiated, supplied with references to the
     * model classes. They are presumed to put themselves on display, and
     * register as Observers as necessary.
     */
    public static void main(String[] args) {
        System_status systemStatus = new System_status();
        Vehicle_list vehicleList = new Vehicle_list();
        Permit_list permitList = new Permit_list();
        //Barrier barrier1 = new Barrier(systemStatus, vehicleList);  // Frame, boundary class
        Barrier barrier = new Barrier(systemStatus, "Barrier screen");
        // Repeat for as many barriers as required

        //Campus_security campusSecurity1 = new Campus_security(systemStatus, vehicleList);  // Frame, boundary class
        Campus_security campusSecurity = new Campus_security(systemStatus, "Campus security screen");
        // Repeat for as many campus security screens as required

        Administration_office adminOffice = new Administration_office(systemStatus, vehicleList, permitList, "Administration Office Screen");  // Frame, boundary class
        //Administration_office adminOffice1 = new Administration_office(vehicleList); 
        // Repeat for as many admin office screens as required
    } 
} // main
