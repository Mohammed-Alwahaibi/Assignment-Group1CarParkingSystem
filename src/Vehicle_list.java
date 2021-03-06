/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;
//This is done by Stirling ID:2732720
import java.util.Enumeration;
import java.util.Hashtable;

/* Generated by Together */
/**
 * Vehicle list manages the collection of vehicles currently associated with
 * permits. It handles checks of whether vehicles are allowed through the
 * barriers, records warnings, and various other functions. Note that each
 * Vehicle_info object must have a unique registration number, to allow sensible
 * checking and recording of entries onto the campus (so a HashTable is probably
 * a good implementation of the collection, with registration number as key).
 *
 * There will only be one instance of this class.
 */
public class Vehicle_list {

    private java.util.Hashtable lnkVehicle;
    private Vehicle_info Vehicle_info;

    public Vehicle_list() {
        lnkVehicle = new Hashtable(); //The vehicle hashtable that we have used
    }

    //CheckPermitted to check whether contains key or not
    public boolean checkPermitted(String RegNum) {
        return lnkVehicle.containsKey(RegNum);
    }

    //CheckPermitted method in barrier
    public boolean checkPermitted(String RegNum, int day) {
        boolean flag = true;
        if (lnkVehicle.containsKey(RegNum)) {
            {
                //Get Permit type
                String p2 = ((Vehicle_info) lnkVehicle.get(RegNum)).getPermitType();
                System.out.println("The Permit type is " + p2);
                System.out.println("Day " + day);
                //Get visit day
                String p3 = (((Vehicle_info) lnkVehicle.get(RegNum)).getVisitday());
                System.out.println("The Visit day details are " + p3);
                //Get end day
                String p4 = (((Vehicle_info) lnkVehicle.get(RegNum)).getEndday());
                System.out.println("The End date details are " + p4);

                
                String p5 = (((Vehicle_info) lnkVehicle.get(RegNum)).getNumEntries());
                System.out.println("The Number of Entries are" + p5);
                
               
                
                String p6 = (((Vehicle_info) lnkVehicle.get(RegNum)).getNumWarning());
                System.out.println("The Number of Warning is" + p6);
                
                //Checking the Regular Visitor
                if (p2 == "Regular Visitor") {
                    if (day >= Integer.parseInt(p3) && day <= Integer.parseInt(p4)&& Integer.parseInt(p5) <=3 && Integer.parseInt(p6) <=3)
                    {
                        flag = true;
                        System.out.println("The regular visitor with Registration number " + RegNum + " has permission");
                    } else {
                        flag = false;
                        System.out.println("The regular visitor with Registration number " + RegNum + " has no permission");
                    }
                }

                //Checking the Day Visitor
                if (p2 == "Day Visitor") {
                    if (day <= Integer.parseInt(p3) && day <= Integer.parseInt(p3)&& Integer.parseInt(p5) <=3 && Integer.parseInt(p6) <=3) {
                        flag = true;
                        System.out.println("The Day visitor with Rgestration number " + RegNum + " has permission");
                    } else {
                        flag = false;
                        System.out.println("The Day visitor with Registration number " + RegNum + " has no permission");
                    }
                }

                //Checking the Unevesity member
                if (p2 == "University member") {
                    if (Integer.parseInt(p5) <=3 && Integer.parseInt(p6) <=3) {
                        flag = true;
                        System.out.println("The University Member with Registration number " + RegNum + " has permission");
                    } else {
                        flag = false;
                        System.out.println("The University Member with Registration number " + RegNum + " has no permission");
                    }
                }

                if (p2 == "Permanent Visitor") {
                    if (Integer.parseInt(p5) <=3 && Integer.parseInt(p6) <=3) {
                        flag = true;
                        System.out.println("The Parmenent Visitor with Rgestration number " + RegNum + " has permission");
                    } else {
                        flag = false;
                        System.out.println("The Parmenent Visitor has no permission" + RegNum + " has no permission");
                    }
                }
            }
        }
        return flag;
    }

    //Codes for adding new vehicle to the Hashtable
    public void add(Permit permit, String RegNum, String CarC, String CarName, String NoEnt, String NoWar) {
        Vehicle_info = new Vehicle_info(permit, RegNum, CarC, CarName, NoEnt, NoWar);
        lnkVehicle.put(RegNum, Vehicle_info);
        System.out.println("The Vehicle table is\n: " + lnkVehicle);
    }

    //Codes for printing vehicle to the Hashtable
    public Hashtable print(String RegNum, String CarC) {
        Enumeration e = lnkVehicle.elements();
        while (e.hasMoreElements()) {
            System.out.println("The elements are\n:" + e.nextElement());
        }
        return lnkVehicle;
    }
    
    public Hashtable print1() {
        
        return lnkVehicle;
    }

    //Codes for removing vehicle from the Hashtable
    public boolean remove(String RegNum, String CarC) {
        return lnkVehicle.containsKey(RegNum);
    }

    //Codes for removing vehicle from the Hashtable
    public void remove1(String RegNum, String CarC) {
        Object obj1 = lnkVehicle.remove(RegNum, CarC);
        System.out.println(" Vehicle Data has removed from Hashtable" + obj1);
    }

 

  

}
