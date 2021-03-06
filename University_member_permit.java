/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;
/* Generated by Together */

/**
 * For a description of University member permits, follow hyperlink to the Administration
 * use case for issuing a new University member permit.
 */
public class University_member_permit extends Permit {
    /**
     * The date that this permit was issued. This information is required in case a member
     * of the University leaves the University part way through the year and becomes eligible for a pro-rata rebate.
     * @label Issued on
     * @clientCardinality 1
     * @supplierCardinality 1
     * @link aggregation
     * @directed
     */
    private Date lnkDate;
    private String permitType;
    private String visitDay;

    public University_member_permit(String Cn,String Vd) {
        super(Cn);
        visitDay=Vd;
        setPermitType(permitType);
        setVisitday(visitDay);
    }

    @Override
    public String toString() {
        return "University_member_permit{" + "lnkDate=" + lnkDate + ", visitDay=" + visitDay + '}';
    }
}
