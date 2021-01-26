/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.text.DecimalFormat;
import java.util.Scanner;
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
public class ContractManagerTest {
    
    public ContractManagerTest() {
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
    
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    /**
     * Test of main method, of class ContractManager.
     */@Ignore
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ContractManager.main(args);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMenu method, of class ContractManager.
     */@Ignore
    @Test
    public void testDisplayMenu() {
        System.out.println("displayMenu");
        ContractManager.displayMenu();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of validateMenuInput method, of class ContractManager.
     */
    @Test
    public void testValidateMenuInput() {
        System.out.println("validateMenuInput");
        String userOption = "3";
        Scanner keyboardInput = new Scanner(userOption); //converted userOption from int to String so its readable by Scanner
        String expResult = "3";
        String result = String.valueOf(ContractManager.validateMenuInput(keyboardInput)); //method call returns string so .valueof converts it to String for comparison
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of option1 method, of class ContractManager.
     */@Ignore
    @Test
    public void testOption1() {
        System.out.println("option1");
        ContractManager.option1();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of validateClientName method, of class ContractManager.
     */
    @Test
    public void testValidateClientName() {
        System.out.println("validateClientName");
        String clientName = "A Akhtar";
        Scanner keyboardInput = new Scanner(clientName);
        String expResult = "A Akhtar";
        String result = ContractManager.validateClientName(keyboardInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of validateReferenceNumber method, of class ContractManager.
     */
    @Test
    public void testValidateReferenceNumber() {
        System.out.println("validateReferenceNumber");
        String refNum = "AA123C";
        Scanner keyboardInput = new Scanner(refNum);
        String expResult = "AA123C";
        String result = ContractManager.validateReferenceNumber(keyboardInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePackageSize method, of class ContractManager.
     */
    @Test
    public void testValidatePackageSize() {
        System.out.println("validatePackageSize");
        String packageSize = "medium";
        Scanner keyboardInput = new Scanner(packageSize);
        String expResult = "Medium";
        String result = ContractManager.validatePackageSize(keyboardInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of validateDataBundle method, of class ContractManager.
     */
    @Test
    public void testValidateDataBundle() {
        System.out.println("validateDataBundle");
        String dataBundle = "high";
        Scanner keyboardInput = new Scanner(dataBundle);
        String packageSize = "Medium";
        String expResult = "High";
        String result = ContractManager.validateDataBundle(keyboardInput, packageSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of validateContractPeriod method, of class ContractManager.
     */
    @Test
    public void testValidateContractPeriod() {
        System.out.println("validateContractPeriod");
        String cp = "12";
        Scanner keyboardInput = new Scanner(cp);
        String refNum = "AA123B";
        String expResult = "12";
        String result = String.valueOf(ContractManager.validateContractPeriod(keyboardInput, refNum));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of validateInternationalCalls method, of class ContractManager.
     */@Ignore
    @Test
    public void testValidateInternationalCalls() {
        System.out.println("validateInternationalCalls");
        String ic = "yes";
        Scanner keyboardInput = new Scanner(ic);
        String expResult = "Yes";
        String result = ContractManager.validateInternationalCalls(keyboardInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of contractType method, of class ContractManager.
     */@Ignore
    @Test
    public void testContractType() {
        System.out.println("contractType");
        String clientName = "A Akhtar";
        String packageSize = "Medium";
        String dataBundle = "High";
        String refNumber = "AA123C";
        int contractPeriod = 12;
        String internationalCalls = "Yes";
        Contract expResult = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        Contract result = ContractManager.contractType(clientName, packageSize, dataBundle, refNumber, contractPeriod, internationalCalls);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of calcDiscount method, of class ContractManager.
     */
    @Test
    public void testCalcDiscount() {
        System.out.println("calcDiscount");
        String refNumber = "AA123C";
        int contractPeriod = 12;
        double expResult = 0.7;
        double result = ContractManager.calcDiscount(refNumber, contractPeriod);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of calcMonthlyCharge method, of class ContractManager.
     */
    @Test
    public void testCalcMonthlyCharge() {
        System.out.println("calcMonthlyCharge");
        Contract contract = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");
        String packageSize = "Medium";
        String dataBundle = "High";
        String internationalCalls = "Yes";
        double discount = 0.7;
        ContractManager.calcMonthlyCharge(contract, packageSize, dataBundle, internationalCalls, discount);
        String result = df2.format(contract.getMonthlyCharge());    //changed doubles to strings to round to 2 decimal places
        String expResult = "8.45";
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of appendToFile method, of class ContractManager.
     */
    @Test
    public void testAppendToFile() {
        System.out.println("appendToFile");
        Contract contract = new Charity("A Akhtar", "Medium", "High", "AA123C", 12, "Yes");  //successful test as this contract is printed to contracts.txt
        ContractManager.appendToFile(contract);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of option2 method, of class ContractManager.
     */@Ignore
    @Test
    public void testOption2() {
        System.out.println("option2");
        ContractManager.option2();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of totalContracts method, of class ContractManager.
     */
    @Test
    public void testTotalContracts() {
        System.out.println("totalContracts");
        String fileName = "archive.txt";
        int expResult = 1000;
        int result = ContractManager.totalContracts(fileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of totalBundles method, of class ContractManager.
     */
    @Test
    public void testTotalBundles() {
        System.out.println("totalBundles");
        String fileName = "archive.txt";
        int expResult = 300;
        int result = ContractManager.totalBundles(fileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of largePackageAverage method, of class ContractManager.
     */
    @Test
    public void testLargePackageAverage() {
        System.out.println("largePackageAverage");
        String fileName = "archive.txt";        
        String expResult = "12.78";     //changed doubles to strings to round to 2 decimal places
        String result = df2.format(ContractManager.largePackageAverage(fileName));
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of option3 method, of class ContractManager.
     */@Ignore
    @Test
    public void testOption3() {
        System.out.println("option3");
        ContractManager.option3();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of validateMonth method, of class ContractManager.
     */
    @Test
    public void testValidateMonth() {
        System.out.println("validateMonth");
        String month = "october";
        Scanner keyboardInput = new Scanner(month);
        String expResult = "October";
        String result = ContractManager.validateMonth(keyboardInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of option4 method, of class ContractManager.
     */@Ignore
    @Test
    public void testOption4() {
        System.out.println("option4");
        ContractManager.option4();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of packageConversion method, of class ContractManager.
     */
    @Test
    public void testPackageConversion() {
        System.out.println("packageConversion");
        String packageRef = "3";
        String expResult = "Large";
        String result = ContractManager.packageConversion(packageRef);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of bundleConversion method, of class ContractManager.
     */
    @Test
    public void testBundleConversion() {
        System.out.println("bundleConversion");
        String bundleRef = "1";
        String expResult = "Low";
        String result = ContractManager.bundleConversion(bundleRef);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of callsConversion method, of class ContractManager.
     */
    @Test
    public void testCallsConversion() {
        System.out.println("callsConversion");
        String ic = "y";
        String expResult = "Yes";
        String result = ContractManager.callsConversion(ic);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
