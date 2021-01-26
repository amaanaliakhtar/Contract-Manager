/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Amaan
 */
public class ContractTest {
    
    public ContractTest() {
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
    
     public String getDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        return sdf.format(cal.getTime());
    }

    /**
     * Test of accountType method, of class Contract.
     */
    @Test
    public void testAccountType() {
        System.out.println("accountType");
        String refNumber = "AA123C";
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        instance.accountType(refNumber);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Contract.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String expResult = getDate();
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of packageReference method, of class Contract.
     */
    @Test
    public void testPackageReference() {
        System.out.println("packageReference");
        String packageSize = "Medium";
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String expResult = "2";
        String result = instance.packageReference(packageSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of bundleReference method, of class Contract.
     */
    @Test
    public void testBundleReference() {
        System.out.println("bundleReference");
        String dataBundle = "High";
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String expResult = "3";
        String result = instance.bundleReference(dataBundle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientName method, of class Contract.
     */
    @Test
    public void testGetClientName() {
        System.out.println("getClientName");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String expResult = "A Akhtar";
        String result = instance.getClientName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPackageSize method, of class Contract.
     */
    @Test
    public void testGetPackageSize() {
        System.out.println("getPackageSize");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String expResult = "Medium";
        String result = instance.getPackageSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataBundle method, of class Contract.
     */
    @Test
    public void testGetDataBundle() {
        System.out.println("getDataBundle");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String expResult = "High";
        String result = instance.getDataBundle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getRefNumber method, of class Contract.
     */
    @Test
    public void testGetRefNumber() {
        System.out.println("getRefNumber");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String expResult = "AA123C";
        String result = instance.getRefNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getContractPeriod method, of class Contract.
     */
    @Test
    public void testGetContractPeriod() {
        System.out.println("getContractPeriod");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        int expResult = 12;
        int result = instance.getContractPeriod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getInternationalCalls method, of class Contract.
     */
    @Test
    public void testGetInternationalCalls() {
        System.out.println("getInternationalCalls");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String expResult = "Yes";
        String result = instance.getInternationalCalls();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiscount method, of class Contract.
     */
    @Test
    public void testGetDiscount() {
        System.out.println("getDiscount");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        double expResult = 0.0;
        double result = instance.getDiscount();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonthlyCharge method, of class Contract.
     */
    @Test
    public void testGetMonthlyCharge() {
        System.out.println("getMonthlyCharge");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        double expResult = 0.0;
        double result = instance.getMonthlyCharge();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientName method, of class Contract.
     */
    @Test
    public void testSetClientName() {
        System.out.println("setClientName");
        String clientName = "";
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        instance.setClientName(clientName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setPackageSize method, of class Contract.
     */
    @Test
    public void testSetPackageSize() {
        System.out.println("setPackageSize");
        String packageSize = "";
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        instance.setPackageSize(packageSize);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataBundle method, of class Contract.
     */
    @Test
    public void testSetDataBundle() {
        System.out.println("setDataBundle");
        String dataBundle = "";
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        instance.setDataBundle(dataBundle);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setRefNumber method, of class Contract.
     */
    @Test
    public void testSetRefNumber() {
        System.out.println("setRefNumber");
        String refNumber = "";
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        instance.setRefNumber(refNumber);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setContractPeriod method, of class Contract.
     */
    @Test
    public void testSetContractPeriod() {
        System.out.println("setContractPeriod");
        int contractPeriod = 0;
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        instance.setContractPeriod(contractPeriod);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setInternationalCalls method, of class Contract.
     */
    @Test
    public void testSetInternationalCalls() {
        System.out.println("setInternationalCalls");
        String internationalCalls = "";
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        instance.setInternationalCalls(internationalCalls);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setMonthlyCharge method, of class Contract.
     */
    @Test
    public void testSetMonthlyCharge() {
        System.out.println("setMonthlyCharge");
        double monthlyCharge = 0.0;
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        instance.setMonthlyCharge(monthlyCharge);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiscount method, of class Contract.
     */
    @Test
    public void testSetDiscount() {
        System.out.println("setDiscount");
        double discount = 0.0;
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        instance.setDiscount(discount);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Contract.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String border = new String(new char[45]).replace("\0", "-");
        Contract instance = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String dmc = "\n|\n|      Discounted Monthly Charge: £0.00";
        
        String expResult = border + String.format("\n| Customer: A Akhtar" + "\n|\n|      Ref: AA123C" + "\t  Date: %s" + "\n|  Package: Medium" + "\t  Data: High" + "\n|   Period: 12 Month(s)" + "\t  Type: null" + "\n|\n| Discount: 100%s" + "\t   Intl. Calls: Yes " + "%s" + "\n", getDate(), "%", dmc) + border;
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    public class ContractImpl extends Contract {

        public ContractImpl() {
            super("", "", "", "", 0, "");
        }
    }
//    border + String.format("\nCustomer: A Akhtar" + "\nRef: AA123C" + "\tDate: %s" + "\nPackage: Medium" + "\tData: High" + "\nPeriod: 12 Month(s)" + "\tType: null" + "\nDiscount: 100" + "\tIntl. Calls: Yes" + "\nDiscounted Monthly Charge: £0.00\n", getDate()) + border;
}
