/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

/**
 *
 * @author Amaan
 */
public class NonBusiness extends Contract {
    
    public NonBusiness(String clientName, String packageSize, String dataBundle, String refNumber, int contractPeriod, String internationalCalls){
        super(clientName, packageSize, dataBundle, refNumber, contractPeriod, internationalCalls);
    }
}
