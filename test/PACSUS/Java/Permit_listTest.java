/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACSUS.Java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TOSHIBA
 */
public class Permit_listTest {
    
    public Permit_listTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPermit method, of class Permit_list.
     */
    @Test
    public void testGetPermit() {
        System.out.println("getPermit");
        String RegNum = "";
        Permit_list instance = new Permit_list();
        Permit expResult = null;
        Permit result = instance.getPermit(RegNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addR method, of class Permit_list.
     */
    @Test
    public void testAddR() {
        System.out.println("addR");
        String Cn = "";
        String On = "";
        String Vd = "";
        String Ed = "";
        Permit_list instance = new Permit_list();
        Permit expResult = null;
        Permit result = instance.addR(Cn, On, Vd, Ed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addD method, of class Permit_list.
     */
    @Test
    public void testAddD() {
        System.out.println("addD");
        String Cn = "";
        String On = "";
        String Vd = "";
        Permit_list instance = new Permit_list();
        Permit expResult = null;
        Permit result = instance.addD(Cn, On, Vd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addP method, of class Permit_list.
     */
    @Test
    public void testAddP() {
        System.out.println("addP");
        String Cn = "";
        Permit_list instance = new Permit_list();
        Permit expResult = null;
        Permit result = instance.addP(Cn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addU method, of class Permit_list.
     */
    @Test
    public void testAddU() {
        System.out.println("addU");
        String Cn = "";
        String Vd = "";
        Permit_list instance = new Permit_list();
        Permit expResult = null;
        Permit result = instance.addU(Cn, Vd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Permit_list.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Permit_list instance = new Permit_list();
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Permit_list.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Permit_list instance = new Permit_list();
        instance.remove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
