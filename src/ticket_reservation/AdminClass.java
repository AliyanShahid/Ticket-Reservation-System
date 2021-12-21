

package ticket_reservation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdminClass<FlightDetailsIO> {
   
	public void MainMenu()
	{
		int val = 0;
	
		while (val!=3)
		{
		Scanner ch = new Scanner(System.in);
		Scanner chs = new Scanner(System.in);
		String t,f,ts,df;
	
		System.out.println("Select one of the following operarion you want to perform : ");
		System.out.println("1-Add a Flight");
		System.out.println("2-See Recent Flight Booked");
		System.out.println("3-See All Flight Booked");
		System.out.println("4-Exit");
		FlightDeatilsIO obj = new FlightDeatilsIO();
	
		System.out.println("Enter choice to perform: ");
		val = ch.nextInt();
	
	
		switch(val)
		{
		case 1:
		{
			System.out.println(" >> Enter Following Details");
			System.out.println(" 1. To : ");
			t = chs.nextLine();
			System.out.println(" 2. From : ");
			f = chs.nextLine();
			System.out.println(" 3. Total Seats : ");
			ts = chs.nextLine();
			System.out.println(" 4. Date for Flight : ");
			df = chs.nextLine();
			System.out.println("Flight added Successfully !!!");
				obj.FileWriting(t,f, ts, df);
			
			break;
		}
		case 2:
		{
			
				obj.FileReading();
			
			break;
		}
	
		case 3:
		{
			System.out.println("DISPLAYING ALL FLIGHTS BOOKED");
			try {
				FileReader fr = new FileReader("flightsbooked.txt");
				Scanner myreader = new Scanner(fr);
				//System.out.println("THE FOLLOWING CUSTOMERS HAVE BOOKED THE FLIGHT AND THE DETAILS ARE AS FOLLOWS:");
				//int i = input.read();
				while (myreader.hasNextLine()) {
					String data = myreader.nextLine();
					System.out.println(data);
					//i = input.read();
				}
				myreader.close();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		case 4:
		{
			System.out.println("Exiting ... ");
			break;
		}
		default:
		{
			System.out.println("Error !!! ");
			break;
		}
	}
}
	}
}
