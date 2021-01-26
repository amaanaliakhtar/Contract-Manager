/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Amaan
 */
public class ContractManager {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        displayMenu();
    }
    
    public static void displayMenu(){
        
        Scanner keyboardInput  = new Scanner(System.in);
        boolean quit = false;
        
        do{     // do the following while quit = false / !quit
            System.out.println("\nMenu:");
            System.out.println("1. Enter new Contract");
            System.out.println("2. Display Summary of Contracts");
            System.out.println("3. Display Summary of Contracts for Selected Month");
            System.out.println("4. Find and display Contract");
            System.out.println("0. Exit");
            System.out.println("Please Select an Option:");
            
            int userOption = validateMenuInput(keyboardInput);
            
            switch(userOption){  //takes int userOption as arguments and executes corresponding case
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3();
                    break;
                case 4:
                    option4();
                    break;
                case 0:
                    System.out.println("Option 0 selected");
                    System.out.println("Thank You - Application Ended");
                    quit = true;
                    break;
                default:    //if userInput is a int other than 0-4 then default is executed
                    System.err.println("Invalid Option - Please enter a valid option");
                    break;
            }
        }
        while(!quit);
    }
    
    public static int validateMenuInput(Scanner keyboardInput){
        
        while(true){
            
            try{    //try to set selectedOption as the next int
                int selectedOption = keyboardInput.nextInt();
                if(selectedOption >= 0 && selectedOption <= 4){  //validates the int is in range 0-4
                   return selectedOption; 
                }
                System.err.println("Invalid Option - Please enter a valid option:");
            }
            catch(InputMismatchException error){  //if the InputMismatchException occurs
                System.err.println("Invalid Option - Please enter a valid option:");
                keyboardInput.nextLine(); //refreshes the Scanner keyboardinput
            }
        }
    }
    
    public static void option1(){
        
        Scanner keyboardInput = new Scanner(System.in);
        
        System.out.println("Option 1 Selected:");
        
        String clientName = validateClientName(keyboardInput);      //set variables as validated inputs
        
        String refNumber = validateReferenceNumber(keyboardInput);
        
        String packageSize = validatePackageSize(keyboardInput);
        
        String dataBundle = validateDataBundle(keyboardInput, packageSize);
        
        int contractPeriod = validateContractPeriod(keyboardInput, refNumber);
        
        String internationalCalls = validateInternationalCalls(keyboardInput);
        
        Contract contract = contractType(clientName, packageSize, dataBundle, refNumber, contractPeriod, internationalCalls); //creates subclass object
        
        double discount = calcDiscount(refNumber, contractPeriod);
        contract.setDiscount(discount);
        calcMonthlyCharge(contract, packageSize, dataBundle, internationalCalls, discount);
        contract.accountType(refNumber);
        
        System.out.println(contract.toString());
        appendToFile(contract);
    }
    
    public static String validateClientName(Scanner keyboardInput){
        String clientName;
        
        System.out.println("Please enter the  Client Name (Max 25 Characters):");
        while(true){
            clientName = keyboardInput.nextLine();
            if(clientName.matches("[a-zA-Z ]+") && clientName.length() <= 25){  //regex - if client name contains only letters or spaces
                return clientName;
            }
            else{
                System.err.println("Invalid Client Name - Please enter a valid Client Name:");
            }
        }
    }
    
    public static String validateReferenceNumber(Scanner keyboardInput){
        String refNumber;
        
        System.out.println("Please enter a Reference Number e.g. AA123X - Where X is account type (B, C, N):");
        while(true){
            refNumber = keyboardInput.nextLine().toUpperCase(); //capitalise for easy comparison
            if(refNumber.matches("^[A-Z]{2}[0-9]{3}[BCN]{1}$")){  //if first 2 chars are letters, next 3 chars are numbers, last char is B,C or N
                 return refNumber;
            }
            else{
                System.err.println("Invalid Reference Number - Please enter a valid Reference Number:");
            }
        }  
    }
    
    public static String validatePackageSize(Scanner keyboardInput){
        String packageSize;
        String[] packageOptions = {"Small", "Medium","Large"};
        
        List<String> packageOptionsList = Arrays.asList(packageOptions); //convert array to list to access list methods
        
        System.out.println("Please enter the Package Size (Small, Medium, Large) or Estimated Minutes (0-1200):");
        
        while(true){
            packageSize = keyboardInput.nextLine(); 
            
            packageSize = packageSize.substring(0, 1).toUpperCase() + packageSize.substring(1).toLowerCase(); //capitalise first letter for easy comparison
            
            if(packageOptionsList.contains(packageSize)){  //if user input is contained in packageOptionsList
                return packageSize;
            }
            else if(!packageOptionsList.contains(packageSize) && packageSize.matches("[0-9]+")){ //if package options are not inputted 
                if(Integer.parseInt(packageSize) >= 0 && Integer.parseInt(packageSize) <= 300){    //convert estimated minutes to package options
                    packageSize = "Small";
                }
                else if(Integer.parseInt(packageSize) > 300 && Integer.parseInt(packageSize) <= 600){
                    packageSize = "Medium";
                }
                else if(Integer.parseInt(packageSize) > 600){
                    packageSize = "Large";
                }
                return packageSize;
            }
            
            else{
                System.err.println("Invalid Package Size - Please enter a valid Package Size:");
            }
        }
    }
    
    public static String validateDataBundle(Scanner keyboardInput, String packageSize){ 
        String dataBundle;
        String[] bundleOptions = {"Low", "Medium","High"};
        
        List<String> bundleOptionsList = Arrays.asList(bundleOptions);
        
        System.out.println("Please enter the Data Bundle (Low, Medium, High or Unlimited - only if package size is large) or Estimated Megabytes of Data(0-8000+):");
        
        while(true){
            dataBundle = keyboardInput.nextLine();
            
            dataBundle = dataBundle.substring(0, 1).toUpperCase() + dataBundle.substring(1).toLowerCase(); //capitalise first letter for easy comparison
            
            if(packageSize.equals("Large") && dataBundle.equals("Unlimited") || packageSize.equals("Large") && Integer.parseInt(dataBundle) > 8000){
                dataBundle = "Unlimited";  // allows unlimited data only if the selected packageSize is large
                return dataBundle;
            }
            if(bundleOptionsList.contains(dataBundle)){  //if user input is contained in packageOptions
                 return dataBundle;
            }
            else if(!bundleOptionsList.contains(dataBundle) && dataBundle.matches("[0-9]+")){
                if(Integer.parseInt(dataBundle) >= 0 && Integer.parseInt(dataBundle) <= 1000){    //convert estimated data to bundle options
                    dataBundle = "Low";
                    return dataBundle;
                }
                else if(Integer.parseInt(dataBundle) > 1000 && Integer.parseInt(dataBundle) <= 4000){
                    dataBundle = "Medium";
                    return dataBundle;
                }
                else if(Integer.parseInt(dataBundle) > 4000 && Integer.parseInt(dataBundle) <= 8000){
                    dataBundle = "High";
                    return dataBundle;
                }
                else{
                    System.err.println("Invalid Data Bundle - Please enter a valid Data Bundle:");
                }
            }
            else{
                System.err.println("Invalid Data Bundle - Please enter a valid Data Bundle:");
            }
        }
       
    }
    
    public static int validateContractPeriod(Scanner keyboardInput, String refNum ){
        int contractPeriod;
        
        System.out.println("Please enter the Contract Period (1, 12, 18, 24):"); 
        while(true){
            try{    //try to set selectedOption as the next inputted int
                contractPeriod = keyboardInput.nextInt();
                char accountType = refNum.charAt(5); // account type is indicated by the last character of the refNumber
               
                if(contractPeriod == 1 || contractPeriod == 12 || contractPeriod == 18 || contractPeriod == 24){
                   if(accountType != 'B'){
                       return contractPeriod;
                   }
                   else if(accountType == 'B' && contractPeriod >= 12){  //business account period must be >= 12 
                       return contractPeriod;
                   }
                   else{
                       System.err.println("Invalid Contract Period - Business Contracts require minimum 12 months - Please Enter a valid Contract Period:");
                   }
                }
                else{
                    System.err.println("Invalid Contract Period - Please enter a valid Contract Period:");
                }
                
            }
            catch(InputMismatchException error){  //if the InputMismatchException occurs
                System.err.println("Invalid Contract Period - Please enter a valid Contract Period:");
                keyboardInput.nextLine(); //refreshes the Scanner keyboardinput
            }
        }
    }
    
    public static String validateInternationalCalls(Scanner keyboardInput){
        String internationalCalls;
        
        System.out.println("Please enter if the contract includes International Calls (Yes, No)");
        internationalCalls = keyboardInput.nextLine(); //resets scanner - had error without
        
        while(true){
            internationalCalls = keyboardInput.nextLine();
            internationalCalls = internationalCalls.substring(0, 1).toUpperCase() + internationalCalls.substring(1).toLowerCase(); //capitalise first letter for easy comparison
            
            if(internationalCalls.equals("Yes") || internationalCalls.equals("No")){
                return internationalCalls;
            }
            else{
                System.err.println("Invalid - Please enter Yes or No:");
            }
        }
    }
    
    public static Contract contractType(String clientName, String packageSize, String dataBundle, String refNumber, int contractPeriod, String internationalCalls){
        char accountType = refNumber.charAt(5);
        Contract contract = null;
        
        switch (accountType) {  //checks the account type and creates corresponding subclass object
            case 'B':
                contract = new Business(clientName, packageSize, dataBundle, refNumber, contractPeriod, internationalCalls);
                break;
            case 'N':
                contract = new NonBusiness(clientName, packageSize, dataBundle, refNumber, contractPeriod, internationalCalls);
                break;
            case 'C':
                contract = new Charity(clientName, packageSize, dataBundle, refNumber, contractPeriod, internationalCalls);
                break;
            default:
                break;
        }
     return contract;
    }
    
    public static double calcDiscount(String refNumber, int contractPeriod){
        char accountType = refNumber.charAt(5);
        double discount = 0;
        
        switch (accountType) {
            case 'B':
                discount = 0.9;
                break;
            case 'C':
                discount = 0.7;
                break;
            case 'N':
                if(contractPeriod == 12 || contractPeriod == 18){
                    discount = 0.95;
                }
                else if(contractPeriod == 24){
                    discount = 0.90;
                }
                else{
                    discount = 1;
                }   break;
            default:
                break;
        }
        return discount;
        
    }
    
    public static void calcMonthlyCharge(Contract contract, String packageSize, String dataBundle, String internationalCalls, double discount) {
        double monthlyCharge = 0;
        
        if(packageSize.equals("Small") && dataBundle.equals("Low")){
            monthlyCharge = 500;
        }
        else if(packageSize.equals("Small") && dataBundle.equals("Medium")){
            monthlyCharge = 700;
        }
        else if(packageSize.equals("Small") && dataBundle.equals("High")){
            monthlyCharge = 900;
        }
        else if(packageSize.equals("Medium") && dataBundle.equals("Low")){
            monthlyCharge = 650;
        }
        else if(packageSize.equals("Medium") && dataBundle.equals("Medium")){
            monthlyCharge = 850;
        }
        else if(packageSize.equals("Medium") && dataBundle.equals("High")){
            monthlyCharge = 1050;
        }
        else if(packageSize.equals("Large") && dataBundle.equals("Low")){
            monthlyCharge = 850;
        }
        else if(packageSize.equals("Large") && dataBundle.equals("Medium")){
            monthlyCharge = 1050;
        }
        else if(packageSize.equals("Large") && dataBundle.equals("High")){
            monthlyCharge = 1250;
        }
        else if(packageSize.equals("Large") && dataBundle.equals("Unlimited")){
            monthlyCharge = 2000;
        }
        
        if(internationalCalls.equals("Yes")){
            monthlyCharge = monthlyCharge * 1.15;
        }
        
        monthlyCharge = (monthlyCharge/100) * discount;
        contract.setMonthlyCharge(monthlyCharge);   
    }
    
    public static void appendToFile(Contract contract){
        
        File contracts = new File("contracts.txt");
        
        String output = String.format("%s \t %s \t %s \t %d \t %s \t %s \t %.0f \t %s", contract.getDate(), contract.packageReference(contract.getPackageSize()), contract.bundleReference(contract.getDataBundle()), contract.getContractPeriod(), contract.getInternationalCalls().charAt(0), contract.getRefNumber(), contract.getMonthlyCharge()*100, contract.getClientName() + "\n");
        
        try{
            FileWriter fos = new FileWriter(contracts, true); // put true as second argument to append
            
            fos.write(output);  
            fos.close();
            
        }
        catch(FileNotFoundException error){
            System.err.println("Error - Cannot find File");
            System.exit(0);
        }
        catch(IOException ioError){
            System.err.println("Error - Output Failed");
        }
        
    }
    
    public static void option2(){
        Scanner keyboardInput = new Scanner(System.in);
        Scanner dateReader = null;
        
        System.out.println("Option 2 Selected - Please select a File (archive.txt / contracts.txt):");
        
        String fileName = keyboardInput.next();
        
        try{
            dateReader = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException error){  //if the file is not found - display error and exit application
            System.err.println("Error - File Not Found");
            System.exit(0);
        }  
        
        int totalContracts = totalContracts(fileName);
        int totalBundles = totalBundles(fileName);
        double largePackageAverage = largePackageAverage(fileName);
       
        int janContracts = 0;
        int febContracts = 0;
        int marContracts = 0;
        int aprContracts = 0;
        int mayContracts = 0;
        int junContracts = 0;
        int julContracts = 0;
        int augContracts = 0;
        int sepContracts = 0;
        int octContracts = 0;
        int novContracts = 0;
        int decContracts = 0;
        
        while(dateReader.hasNextLine()){  //todo - put into method
            
            String month = dateReader.next().substring(3, 6);  //reads the month from date on the file
            
            switch(month){  //sum total contracts for each month
                case "Jan":
                    janContracts++;
                    break;
                case "Feb":
                    febContracts++;
                    break;
                case "Mar":
                    marContracts++;
                    break;
                case "Apr":
                    aprContracts++;
                    break;
                case "May":
                    mayContracts++;
                    break;
                case "Jun":
                    junContracts++;
                    break;
                case "Jul":
                    julContracts++;
                    break;
                case "Aug":
                    augContracts++;
                    break;
                case "Sep":
                    sepContracts++;
                    break;
                case "Oct":
                    octContracts++;
                    break;
                case "Nov":
                    novContracts++;
                    break;
                case "Dec":
                    decContracts++;
                    break;
            }
            dateReader.nextLine();
            
        }
        dateReader.close();
        
        System.out.println("Total Contracts: " + totalContracts);
        System.out.println("Total Contracts with Large or Unlimited Data Bundles: " + totalBundles);
        System.out.println(String.format("Average Charge of Large Package Contracts: £%.2f", largePackageAverage));
        System.out.println("Number of Contracts per Month:");
        System.out.println("Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec");
        System.out.println(janContracts + "\t" + febContracts + "\t"  + marContracts + "\t"  + aprContracts + "\t"  + mayContracts + "\t"  + junContracts + "\t"  + julContracts + "\t"  + augContracts + "\t"  + sepContracts + "\t"  + octContracts + "\t"  + novContracts + "\t"  + decContracts);
    }
    
    public static int totalContracts(String fileName){
        Scanner fileReader = null;
        int totalContracts = 0;
        
        try{
            fileReader = new Scanner(new File(fileName)); //opens new file and creates a scanner that will read the file
        }
         catch(FileNotFoundException error){  //if the file is not found - display error and exit application
            System.err.println("Error - File Not Found");
            System.exit(0);
        }
        
        while(fileReader.hasNextLine() && fileReader.hasNext()){  //while the file has another line - negates any white space at end
            totalContracts++;   //adds 1 to total for every line
            fileReader.nextLine();  //moves to next line
        }
        fileReader.close();
        return totalContracts;
        
    }
    
    public static int totalBundles(String fileName){
        Scanner bundleReader = null;
        int totalBundles = 0;
        
        try{
            bundleReader = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException error){  //if the file is not found - display error and exit application
            System.err.println("Error - File Not Found");
            System.exit(0);
        }  
        
        while(bundleReader.hasNextLine()){
            bundleReader.next();    //skips first column
            bundleReader.nextInt();   //skips second column
            int bundleRef = bundleReader.nextInt();  //stores third column
            
            if(bundleRef == 3 || bundleRef == 4){
                totalBundles++;         //add to total if the bundle is large/unlimited
            }
            bundleReader.nextLine();
        }
        bundleReader.close();
        return totalBundles;
    }
    
    public static double largePackageAverage(String fileName){
        Scanner packageReader = null;
        double largePackageAverage;
        int largePackageCount = 0;
        double charge = 0;
        
        try{
            packageReader = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException error){  //if the file is not found - display error and exit application
            System.err.println("Error - File Not Found");
            System.exit(0);
        }
        
        while(packageReader.hasNextLine()){
            
            packageReader.next();
            
            int packageRef = packageReader.nextInt(); 
            
            //skip columns between package and monthly charge
            packageReader.nextInt();
            packageReader.nextInt();  
            packageReader.next();
            packageReader.next();
            
            
            if(packageRef == 3){
                largePackageCount++;  //adds to total if package is large
                charge += packageReader.nextInt(); //sums the total charge of large package contracts
            }
            
            packageReader.nextLine();
            
        }
        largePackageAverage = (charge/largePackageCount) / 100;     //calculates average of large package contracts
        
        packageReader.close();
        return largePackageAverage;
        
        
    }
    
    public static void option3(){
        Scanner keyboardInput = new Scanner(System.in);
        Scanner fileReader = null;
        
        System.out.println("Option 3 selected:");
        
        System.out.println("Please Select a File (archive.txt / contracts.txt):");
        
        String fileName = keyboardInput.next();
        
        try{
            fileReader = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException error){  //if the file is not found - display error and exit application
            System.err.println("Error - File Not Found");
            System.exit(0);
        }
        
        String selectedMonth = validateMonth(keyboardInput);
        String monthRef = selectedMonth.substring(0, 3);
        
        int totalContracts = 0;
        int totalBundles = 0;
        double largePackageAverage;
        int largePackageCount = 0;
        double charge = 0;
        
        while(fileReader.hasNextLine()){
            String date = fileReader.next();
            
            if(date.contains(monthRef)){
                totalContracts++;
                
                //set neccessary file columns as varaiables and skip uneccessary columns
                int packageRef = fileReader.nextInt();
                int bundleRef = fileReader.nextInt();
                fileReader.nextInt();
                fileReader.next();
                fileReader.next();
                
                if(packageRef == 3){
                    largePackageCount++;
                    charge += fileReader.nextInt();
                }
                
                if(bundleRef == 3 || bundleRef == 4){
                    totalBundles++;
                }
                
            }
            fileReader.nextLine();
            
        }
        largePackageAverage = (charge/largePackageCount) / 100;
        fileReader.close();
        
        System.out.println("\n" + selectedMonth + " Summary:");
        System.out.println("Total Contracts: " + totalContracts);
        System.out.println("Total Contracts with Large or Unlimited Data Bundles: " + totalBundles);
        System.out.println(String.format("Average Charge of Large Package Contracts: £%.2f", largePackageAverage));
        
    }
    
    public static String validateMonth(Scanner keyboardInput){
        
        String selectedMonth;
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
       
        List<String> monthList = Arrays.asList(months); //convert array to list to access list methods
        
        System.out.println("Please select a Month:");
        while(true){
            selectedMonth = keyboardInput.next();
            selectedMonth = selectedMonth.substring(0, 1).toUpperCase() + selectedMonth.substring(1).toLowerCase();  //capitalise first letter for easy comparison
            
            if(monthList.contains(selectedMonth)){  //if inputted month is conatined in the List
                return selectedMonth;
            }
            else{
                System.err.println("Invalid - Please enter a valid Month:");
            }
        }
    }
    
    public static void option4(){
        Scanner keyboardInput = new Scanner(System.in);
        Scanner fileReader = null;
        Scanner lineReader = null;
        
        System.out.println("Option 4 selected:");
        
        System.out.println("Please Select a File (archive.txt / contracts.txt):");
        
        String fileName = keyboardInput.next();
        
        try{
            fileReader = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException error){  //if the file is not found - display error and exit application
            System.err.println("Error - File Not Found");
            System.exit(0);
        }
        keyboardInput.nextLine();
        
        System.out.println("Please enter Search:");
        
        String userSearch = keyboardInput.nextLine().toLowerCase();  // edit so doesnt accept >1 words
        boolean resultFound = false;
        
        while(fileReader.hasNextLine()){
            String line = fileReader.nextLine().toLowerCase();  //makes full line lowercase for easy reading
            lineReader = new Scanner(line);
            
            
            if(line.contains(userSearch)){
                resultFound = true;
                //each column in file assigned to its corresponding data value - conversion methods called
                String date = lineReader.next();  
                String packageSize = packageConversion(lineReader.next());
                String dataBundle = bundleConversion(lineReader.next());
                int contractPeriod = Integer.parseInt(lineReader.next());
                String internationalCalls = callsConversion(lineReader.next());
                String refNumber = lineReader.next().toUpperCase();
                lineReader.next();
                String clientName;
                String initial = lineReader.next();
                if(lineReader.hasNext()){
                    String surname = lineReader.next();
                    clientName = initial.toUpperCase() + " " + surname.substring(0, 1).toUpperCase() + surname.substring(1); //concatenate to form full name
                }
                else{
                    clientName = initial.substring(0, 1).toUpperCase() + initial.substring(1);
                }
                
                Contract contract = contractType(clientName, packageSize, dataBundle, refNumber, contractPeriod, internationalCalls); //creates subclass from data read from file
                
                double discount = calcDiscount(refNumber,contractPeriod); 
                contract.setDiscount(discount);
                calcMonthlyCharge(contract, packageSize, dataBundle, internationalCalls, discount);
                contract.accountType(refNumber);
                
                System.out.println(contract.toString());
                System.out.println("\n");
            }
        }
        if(!fileReader.hasNextLine() && !resultFound){ // if the file doesnt contain the search
                System.out.println("No Results Found");
            }
        
        
    }
    
    public static String packageConversion(String packageRef){
        String packageDisplay = null;
        
        switch(packageRef){
            case "1":
                packageDisplay = "Small";
                break;
            case "2":
                packageDisplay = "Medium";
                break;
            case "3":
                packageDisplay = "Large";
                break;
        }
        return packageDisplay;
    }
    
    public static String bundleConversion(String bundleRef){
        String bundleDisplay = null;
        
        switch(bundleRef){
            case "1":
                bundleDisplay = "Low";
                break;
            case "2":
                bundleDisplay = "Medium";
                break;
            case "3":
                bundleDisplay = "High";
                break;
            case "4":
                bundleDisplay = "Unlimited";
                break;
        }
        return bundleDisplay;
    }
    
    public static String callsConversion(String ic){
        String callsDisplay = null;
        
        if(ic.equals("y")){
            callsDisplay = "Yes";
        }
        else{
            callsDisplay = "No";
        }
        return callsDisplay;
    }
}