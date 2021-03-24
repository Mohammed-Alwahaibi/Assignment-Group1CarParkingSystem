/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;

/* Generated by Together */

/**
 * For simplicity, dates are represented as simple integers, counting from 1 up
 * to 365 (we will ignore Leap years in PACSUS) from the 1st September each year
 * - so the PACSUS "year" runs from 1st September to 31st August. When the date
 * is incremented it "wraps" automatically from 365 to 1.
 *
 * !!!!!**** During testing it might be convenient to set the year "length" at,
 * say, 10 days. !!!!!****
 *
 * No permits are issued to span from one year into the next; instead re-issue
 * occurs "automatically" at the start of the year (see the Timer use case
 * diagram - follow hyperlink) - all permits are simply carried over to the new
 * year (except Day visitor and Regular visitor permits that expire on the last
 * day of the year). Permits which have a limited period of validity (Day
 * visitor and Regular visitor permits) are automatically cancelled from PACSUS
 * at the start of the day following their last valid day.
 *
 * Useful services offered by this class would probably be for checking if it's
 * the first day of a new academic year, and comparing dates within the year for
 * equal, before and after.
 */
public class Date {

    /**
     * This operation adds one to the day number, wrapping round to 1 after 365
     * automatically.
     */
    public void increment() {
    }

    /**
     * For simplicity, dates will be represented just by an integer in the range
     * 1-365. No Leap years!
     */
    private int dayNumber;
}
