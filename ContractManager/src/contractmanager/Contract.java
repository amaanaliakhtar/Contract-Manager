/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Amaan
 */
public abstract class Contract implements Serializable {
    //instance variables
    protected String clientName;
    protected String packageSize;
    protected String dataBundle;
    protected String refNumber;
    protected int contractPeriod;
    protected String internationalCalls;
    protected double discount;
    protected double monthlyCharge;
    protected String accountType;
    public String contractDate;
    
    //constructor
    public Contract(String clientName, String packageSize, String dataBundle, String refNumber, int contractPeriod, String internationalCalls){
        //sets the private instance variables to the arguments passed into the constructor
        this.clientName = clientName;
        this.packageSize = packageSize;
        this.dataBundle = dataBundle;
        this.refNumber = refNumber;
        this.contractPeriod = contractPeriod;
        this.internationalCalls = internationalCalls;
       
    }
    
    public void accountType(String refNumber){
        switch(refNumber.charAt(5)){
            case 'B':
                accountType = "Business";
                break;
            case 'C':
                accountType = "Charity";
                break;
            case 'N':
                accountType = "Non-Business";
                break;
        }
    }
    
    public String getDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        return sdf.format(cal.getTime());
    }
    
    public String packageReference(String packageSize){
        String packageReference = null;
        
        switch(packageSize){
            case "Small":
                packageReference = "1";
                break;
            case "Medium":
                packageReference = "2";
                break;
            case "Large":
                packageReference = "3";
                break;
       }
        return packageReference;
    }
    
    public String bundleReference(String dataBundle){
        String bundleReference = null;
        
        switch(dataBundle){
            case "Low":
                bundleReference = "1";
                break;
            case "Medium":
                bundleReference = "2";
                break;
            case "High":
                bundleReference = "3";
                break;
            case "Unlimited":
                bundleReference = "4";
       }
        return bundleReference;
    }

    
    //getters
    public String getClientName(){
        return clientName;
    }
    
    public String getPackageSize(){
        return packageSize;
    }
    
    public String getDataBundle(){
        return dataBundle;
    }
    
    public String getRefNumber(){
        return refNumber;
    }
    
    public int getContractPeriod(){
        return contractPeriod;
    }
    
    public String getInternationalCalls(){
        return internationalCalls;
    }

    public double getDiscount() {
        return discount;
    }

    public double getMonthlyCharge() {
        return monthlyCharge;
    }
    
    
    //setters
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    public void setDataBundle(String dataBundle) {
        this.dataBundle = dataBundle;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public void setContractPeriod(int contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public void setInternationalCalls(String internationalCalls) {
        this.internationalCalls = internationalCalls;
    }
    
    public void setMonthlyCharge(double monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    
    @Override
     public String toString(){
       String dmc;
       if(discount < 1){
           dmc = String.format("\n|\n|      Discounted Monthly Charge: £%.2f", monthlyCharge);
       }
       else{
           dmc = String.format("\n|\n|\t    Monthly Charge: £%.2f", monthlyCharge);
       }
       String border = new String(new char[45]).replace("\0", "-"); // repeats "-" 45 times
       
       String output = String.format("\n| Customer: %s" + "\n|\n|      Ref: %s" + "\t  Date: %s" + "\n|  Package: %s" + "\t  Data: %s" + "\n|   Period: %d Month(s)" + "\t  Type: %s" + "\n|\n| Discount: %.0f%s" + "\t   Intl. Calls: %s" + " %s" + "\n", clientName, refNumber, getDate(), packageSize, dataBundle, contractPeriod, accountType, (1-discount)*100, "%", internationalCalls, dmc);
           
       return border + output + border;
   }
    
}

