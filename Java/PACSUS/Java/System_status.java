/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;

import java.util.Observable;
import java.util.Date;

/* Generated by Together */
/**
 * This class holds key control information for the operation of the barrier
 * system.
 *
 * It extends Observable, and notifies its observers whenever either the date
 * changes (caused by the Timer class), or the barrier system activity status
 * changes (caused by an instance of the Campus security class), or the barrier
 * event log changes (caused by an instance of the Barrier class).
 *
 * There will only be one instance of this class.
 */
public class System_status extends Observable {

    /**
     * This attribute is the central indication of the activity status of the
     * whole barrier system. It is set/unset by messages from instances of the
     * Campus security class.
     */
    private boolean systemActive = false;
    /**
     * An array of strings showing recent attempts to pass through the barriers
     * (both successful and unsuccessful). The last 20 should be enough? These
     * are intended for display on the Campus_security screens.
     */
    private String[] log;
    private boolean active = false;
    private boolean deactivate = true;

    /**
     * This attribute is kept up to date by the Timer.
     *
     * @clientCardinality 1
     * @supplierCardinality 1
     * @link aggregation
     * @label Contains
     * @directed
     */
    private Date today;

    public System_status() {
        today = new Date();
    }

    public Date getToday() {
        return today;
    }
       
    public void active() {
        systemActive = true;
        setChanged();
        notifyObservers();
    } // active

    public void deactivate() {
        systemActive = false;
        setChanged();
        notifyObservers();
    } // deactivate

    public boolean getStatus() {
        return systemActive;
    } // getActive
    
    public boolean addEntry(String rNum) {
        return systemActive;
    } 
}
