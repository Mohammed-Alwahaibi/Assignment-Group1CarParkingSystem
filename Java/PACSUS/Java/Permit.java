/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;

import java.util.ArrayList;

/* Generated by Together */
abstract public class Permit {

    // Useful program constants
    private String permitHolder;
    private int noOfEntries = 0;
    private int warnings;
    private String suspended;
    private boolean enteredToday = false;
    private Vehicle_info vehicleUsedToday;
    private String permitType;
    private String visitday;
    private String endday;
    private ArrayList permittedVehicles = new ArrayList();

    public Permit(String Cn) {
        //initialize the values 
        this.permitType = permitType;
        permitHolder = Cn;
        int i = 1;
        noOfEntries = i++;
        warnings = 0;
        suspended = Cn;
        enteredToday = false;
        permittedVehicles = new ArrayList();
    }

    //Set the permit type
    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    //Set the visit day
    public void setVisitday(String visitday) {
        this.visitday = visitday;
    }

    //Set the end day
    public void setEndday(String endday) {
        this.endday = endday;
    }

    //Set the Entries
    public void setNumEntries(int noOfEntries) {
        this.noOfEntries = noOfEntries;
    }
    
    //Set the warnings
    public void setNumWarning(int warnings) {
        this.warnings = warnings;
    }

    //Set the Suspended
    public void setSuspended(String suspended) {
        this.suspended = suspended;
    }
    
    //Get the warnings
    public int getNumWarning() {
        return warnings;
    }

    //Get the Suspended
    public String getSuspended() {
        return suspended;
    }

    //Get the 
    public int getNumEntries() {
        return noOfEntries;
    }

    //Get the permit type
    public String getPermitType() {
        return permitType;
    }

    //Get the visit day
    public String getVisitday() {
        return visitday;
    }

    //Get the end day
    public String getEndday() {
        return endday;
    }

    @Override
    //ToString method
    public String toString() {
        return "Permit{" + "permitHolder=" + permitHolder + ", noOfEntries=" + noOfEntries + ", warnings=" + warnings
                + ", suspended=" + suspended + ", enteredToday=" + enteredToday + ", vehicleUsedToday=" + vehicleUsedToday
                + ", permitType=" + permitType + ", visitday=" + visitday + ", endday=" + endday
                + ", permittedVehicles=" + permittedVehicles + '}';
    }

}
