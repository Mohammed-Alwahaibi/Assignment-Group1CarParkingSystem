/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;

import java.util.Hashtable;
import java.util.Enumeration;


/* Generated by Together */
/**
 * Permit list manages the collection of permits currently issued and not yet
 * cancelled (or expired). It handles most of the use cases in the
 * Administration section. Note that each Permit must have a unique permit
 * holder name (so a HashTable is probably a good implementation of the
 * collection, with permit holder name as key).
 *
 * There will only be one instance of this class.
 */
public class Permit_list {

    /**
     * The Permit list maintains a collection of the Permits currently issued.
     *
     * This association must be implemented by an attribute holding a collection
     * data structure (for example: array, hash table - the latter is
     * recommended).
     *
     * Note that no two Permits may have the same permit holder name (this
     * information is not represented diagrammatically).
     *
     * @associates Permit
     * @label Contains
     * @clientCardinality 1
     * @supplierCardinality 0..
     *
     * @directed
     */
    private java.util.Hashtable lnkPermit_list;

    public Permit_list() {
        lnkPermit_list = new Hashtable();
    }

    public Permit getPermit(String RegNum) {
        return ((Permit) lnkPermit_list.get(RegNum));
    }

    public boolean checkPermitted(String RegNum, String CarC) {
        return lnkPermit_list.containsKey(RegNum);
    }

    public Permit addR(String Cn, String On, String Vd, String Ed) {
        Regular_visitor_permit Regular_visitor_permit = new Regular_visitor_permit(Cn, On, Vd, Ed);
        lnkPermit_list.put(Cn, Regular_visitor_permit);
        System.out.println("The permit table for regular visitor: " + lnkPermit_list);
        return Regular_visitor_permit;
    }

    public Permit addD(String Cn, String On, String Vd) {
        Day_visitor_permit Day_visitor_permit = new Day_visitor_permit(Cn, On, Vd);
        lnkPermit_list.put(Cn, Day_visitor_permit);
        System.out.println("The permit table for Day visitor: " + lnkPermit_list);
        return Day_visitor_permit;
    }

    public Permit addP(String Cn) {
        Permanent_visitor_permit Permanent_visitor_permit = new Permanent_visitor_permit(Cn);
        lnkPermit_list.put(Cn, Permanent_visitor_permit);
        System.out.println("The permit table for Permanent visitor: " + lnkPermit_list);
        return Permanent_visitor_permit;
    }

    public Permit addU(String Cn, String Vd) {
        University_member_permit University_member_permit = new University_member_permit(Cn, Vd);
        lnkPermit_list.put(Cn, University_member_permit);
        System.out.println("The permit table for University member: " + lnkPermit_list);
        return University_member_permit;
    }

    public Hashtable printP(String Cn, String On, String Vd, String Ed) {
        Enumeration e = lnkPermit_list.elements();
        while (e.hasMoreElements()) {
            System.out.println("Permit elements are\n:" + e.nextElement());
        }
        return lnkPermit_list;
    }

    public void removeP(String Cn, String On, String Vd, String Ed) {
        Object obj1 = lnkPermit_list.remove("");
        System.out.println(obj1 + " Permit Data has removed from Hashtable");
    }
}