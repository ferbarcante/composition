package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
    public static void main(String[]args) throws ParseException{
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department name: ");
        String departmentName = scan.next();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName = scan.next();
        System.out.println("Level: ");
        String workerLevel = scan.next();
        System.out.println("Base salary: ");
        double baseSalary = scan.nextDouble();
        
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
        
        System.out.println("How many contracts to this worker? ");
        int n = scan.nextInt();
        
        for(int i = 1; i<= n; i++) {
        	System.out.println("Enter contract #" + i + " data: ");
        	System.out.println("Date (DD/MM/YY): ");
        	Date contractDate = sdf.parse(scan.next());
        	System.out.println("Value per hour: ");
        	double valuePerHour = scan.nextDouble();
        	System.out.println("Duration hours: ");
        	int hours = scan.nextInt();
        	
        	HourContract contract = new HourContract(contractDate, valuePerHour, hours);
        	worker.addContract(contract);	
        }
        
        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/yyyy: ");
        String monthAndYear = scan.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + worker.income(year, month));
        
        
    }
}
