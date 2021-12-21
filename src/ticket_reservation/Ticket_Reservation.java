package ticket_reservation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

class Custom_Exception extends Exception
{
    public Custom_Exception()
    {
        super();
    }
}

class Passenger
{
    private String name;
    private String passportNumber;
    private char gender;
    private String destination;
    private String address;
    private int age;
    
    Passenger(String name,String passportNumber, String destination,char gender,String address, int age)
    {
        this.name=name;
        this.passportNumber=passportNumber;
        this.gender=gender;
        this.destination=destination;
        this.age=age;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
public class Ticket_Reservation 
{
    
    public static void main(String[] args) 
    {
        Scanner scan=new Scanner(System.in);
        LinkedList<Passenger> passengers=new LinkedList<Passenger>();
        char input='0';
        char input1='0';
        readforcustomer obj1 = new readforcustomer(); 
        System.out.println("---------------------WELCOME TO TICKET RESERVATION--------------------------------\n\n");
       
           System.out.println("Select One of the following Option : ");
           System.out.println("1-Login As Admin");
           System.out.println("2-Login As Customer");
           System.out.println("3-Exit");
           Scanner scan1=new Scanner(System.in);   
        input1=scan.next().charAt(0);
        switch(input1)
        {
        case '1':
        
        	System.out.println("---------------ENTER LOGIN PASSWORD-------------");
        	String s;
        	System.out.println("Enter Password : ");
        	s=scan1.nextLine();
        	while(!(s.equals("1234")))
        	{
        		System.out.println("Try Again");
        		s=scan1.nextLine();
        	}
        	
        	System.out.println("*************Login Successfull****************");
	           AdminClass c=new AdminClass(); c.MainMenu();
	
			/*
			 * if(s.equals("1234")) {
			 * System.out.println("*************Login Successfull****************");
			 * AdminClass c=new AdminClass(); c.MainMenu();
			 * 
			 * } else {
			 * 
			 * System.out.println("------Login Again----");
			 * 
			 * }
			 */
        	
        case '2':
        	       while(input!=3)
        	       {
        	    	   System.out.println("1)Book a flight\n2)Cancel a flight\n3)Exit");
        	            input=scan.next().charAt(0);
        	            
        	            switch(input)
        	            {
        	                case '1':
        	                	obj1.FileReading1();
        	                    System.out.println("Enter Your Name=");
        	                    String name=scan.next();
        	                    System.out.println("Enter Your Age=");
        	                    int age;
        	                    try
        	                    {
        	                         age=scan.nextInt();
        	                        if(age<18)
        	                        {
        	                            throw new Custom_Exception();
        	                        }
        	                    }
        	                    catch(Custom_Exception e)
        	                    {
        	                        System.out.println("Invalid Age Exception: "+e);
        	                        break;
        	                    }
        	                    System.out.println("Enter Your Gender M/F=");
        	                    char gender;
        	                    try
        	                    {
        	                        gender=scan.next().charAt(0);
        	                        if(gender=='M' || gender=='m' || gender=='f' || gender=='F')
        	                        {
        	                        }
        	                        else
        	                        {
        	                            throw new Custom_Exception();
        	                        }
        	                    }
        	                    catch(Custom_Exception e)
        	                    {
        	                        System.out.println("Invalid Gender Exception: "+e);
        	                        break;
        	                    }
        	                    System.out.println("Enter Choice from Above");
        	                    String destination=scan.next();
        	                    System.out.println("Enter Your Passport Number");
        	                    String passport=scan.next();
        	                    System.out.println("Enter Your Address=");
        	                    String address= scan.next();
        	                    Passenger pass=new Passenger(name, passport, destination, gender, address, age);
        	                    passengers.add(pass);
        	                    System.out.println("\n Ticket Has been reserved Successfully:");
        	                    System.out.println("Name="+name);
        	                    System.out.println("Destination="+destination);
        	                    System.out.println("Address="+address);
        	                    System.out.println("Passport Number="+passport);
        	                    break;
        	                
        	                case '2':
        	                	
        	                	int i = 0;
        	                	String[] PassNo = new String[8];
        	                	System.out.println("TO CANCEL TICKET ENTER YOUR PASSPORT NUMBER");
        	                	String passport1=scan.next();
        	                	try {
        	            			FileReader fr = new FileReader("passportinfo.txt");
        	            			Scanner myreader = new Scanner(fr);
        	            			//System.out.println("THE FOLLOWING CUSTOMERS HAVE BOOKED THE FLIGHT AND THE DETAILS ARE AS FOLLOWS:");
        	            			//int i = input.read();
        	            			while (myreader.hasNextLine()) {
        	            				String data = myreader.nextLine();
        	            				PassNo[i] = data;
        	            				i++;
        	            				//i = input.read();
        	            			}
        	            			myreader.close();
        	            		}catch(FileNotFoundException e) {
        	            			e.printStackTrace();
        	            		}
        	                	
        	                	boolean flag = false;
        	                	System.out.println(PassNo.length);
        	                	for (int i1=0; i1<PassNo.length; i1++)
        	                	{
        	                		if(passport1.equals(PassNo[i1]))
        	                		{
        	                			flag = true;
        	                			System.out.println("\n Cancelling Ticket....");
        	                			System.out.println("\n Ticket Cancelled....");
        	                		}
        	                	}
        	            			if (flag == false) {
    	                			System.out.println("PASSPORT NUMBER NOT FOUND");
 
        	            }
        	            			break;
        	                
        	                case '3':
   	                			System.out.println("Exiting....");
   	                			System.exit(0);
   	                			break;
   	                		default :
   	                				 break;

        }
    }
        case '3':
        	        System.out.println("Exiting....");
        	        break;
}
}
}