/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;

/* Generated by Together */
/**
 * Each instance of Vehicle_info models an actual physical vehicle, so no two
 * instances may have the same registration number. There is no direct notation
 * for this. Instead the Vehicle list object collecting the Vehicles must
 * enforce it by checking new additions - the use of a HashTable in Vehicle_list
 * with the registration number as key is helpful with this.
 *
 * This class must contain at least the registration number, and may have any
 * other attributes that the University may from time to time find useful (such
 * as car make, model, colour...).
 */
public class Vehicle_info {

    /**
     * The vehicle's registration number.
     */
    // Useful program constants
    private String regNo;
    private String carc;
    private String carName;
    private Permit lnkPermit;

    public Vehicle_info(Permit permit, String c1, String c2, String c3) {
        lnkPermit = permit; //Permit hashtable
        regNo = c1; //regerstration number
        carc = c2; //Car color
        carName = c3;
    }

    //Get the permit type from lnkPermit hashtable
    public String getPermitType() {
        return lnkPermit.getPermitType();
    }

    //Get the Warning
    public String getWarning() {
        return lnkPermit.getWarning();
    }

    //Get Suspended
    public String getSuspended() {
        return lnkPermit.getSuspended();
    }

    //Get permit from lnkPermit hashtable
    public Permit getPermit() {
        return lnkPermit;
    }

    //Get the visit day
    public String getVisitday() {
        return lnkPermit.getVisitday();
    }

    //Get the end day
    public String getEndday() {
        return lnkPermit.getEndday();
    }

    @Override
    //ToString method for printing the vehicle info
    public String toString() {
        return "Vehicle_info{" + "regNo=" + regNo + ", carcolor=" + carc + ", carName=" + carName + ", lnkPermit=" + lnkPermit + '}';
    }
}
