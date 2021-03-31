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
import org.junit.Ignore;

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
    @Ignore
    public void testGetPermit() {
        System.out.println("getPermit");
        String RegNum = "123456";
        Permit_list instance = new Permit_list();
        Permit expResult = instance.addR("123456","Lee","1","9");
        Permit result = instance.getPermit(RegNum);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of testCheckPermitted method, of class Permit_list.
     */
    @Ignore
    public void testCheckPermitted() {
        System.out.println("checkPermitted");
        String Cn = "1887";
        String On = "Salim";
        String Vd = "10";
        Permit_list instance = new Permit_list();
        Permit result = instance.addD("1234", "Kane", "11");
        Permit expResult = instance.getPermit(Cn);
        System.out.println("Result" + result);
        System.out.println("expected result" + expResult);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of addR method, of class Permit_list.
     */
    @Ignore
    public void testAddR() {
        System.out.println("addR");
        String Cn = "Ali";
        String On = "red";
        String Vd = "x1";
        String Ed = "y2";
        Permit_list instance = new Permit_list();
        Permit result = instance.addR("Ak8", "red", "9", "21");
        Permit expResult = instance.getPermit(Cn);
        System.out.println("Result" + result);
        System.out.println("expected result" + expResult);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of addD method, of class Permit_list.
     */
    @Ignore
    public void testAddD() {
        System.out.println("addD");
        String Cn = "1887";
        String On = "Ahmed";
        String Vd = "1";
        Permit_list instance = new Permit_list();
        Permit result = instance.addD("1654", "Gareth", "8");
        Permit expResult = instance.getPermit(Cn);
        System.out.println("Result" + result);
        System.out.println("expected result" + expResult);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of addP method, of class Permit_list.
     */
    @Ignore
    public void testAddP() {
        System.out.println("addP");
        String Cn = "236547";
        Permit_list instance = new Permit_list();
        Permit result = instance.addP("111111");
        Permit expResult = instance.getPermit(Cn);
        System.out.println("Result" + result);
        System.out.println("expected result" + expResult);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of addU method, of class Permit_list.
     */
    @Ignore
    public void testAddU() {
        System.out.println("addU");
        String Cn = "321654";
        String Vd = "10";
        Permit_list instance = new Permit_list();
        Permit expResult = instance.addU("123564", "", "18");
        Permit result = instance.getPermit(Cn);
         System.out.println("Result" + result);
        System.out.println("expected result" + expResult);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of print method, of class Permit_list.
     */
    @Ignore
    public void testPrint() {
        System.out.println("print");
        Permit_list instance = new Permit_list();
        instance.printP("123123","Ali","1","8");
    }

    /**
     * Test of remove method, of class Permit_list.
     */
    @Ignore
    public void testRemove() {
        System.out.println("remove");
        Permit_list instance = new Permit_list();
        instance.removeP("123123","Ali","1","8");
    }
}
