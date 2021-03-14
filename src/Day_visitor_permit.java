/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;
/* Generated by Together */

/**
 * For a description of Day visitors, follow hyperlink to the Administration use case for
 * issuing a new Day visitor permit.
 */
public class Day_visitor_permit extends Permit {
    /**
     * The name of the University member hosting the visit.
     */
    private String hostName;

    /**
     * The date that the visitor is visiting on - entry will be allowed on that date only.
     * @clientCardinality 1
     * @supplierCardinality 1
     * @label Visiting on
     * @link aggregation
     * @directed
     */
    private Date lnkDate;
     private String owenerName;
    private String visitDay;

    public Day_visitor_permit(String Cn, String On, String Vd) {
        super(Cn);
        owenerName=On;
        visitDay=Vd;
    }

    @Override
    public String toString() {
        return "Day_visitor_permit{" + "hostName=" + hostName + ", lnkDate=" + lnkDate + ", owenerName=" + owenerName + ", visitDay=" + visitDay + '}';
    }
}
