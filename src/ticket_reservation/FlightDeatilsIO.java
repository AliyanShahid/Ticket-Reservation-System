package ticket_reservation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FlightDeatilsIO {

	public void FileWriting(String t, String f, String ts, String df) {
try {
			
			FileWriter myfile=new FileWriter("FlightDetails.txt");
			
			//myfile.write("Reservation Details");

			myfile.write("\nTo:"+t);

			myfile.write("\nFrom:"+f);
			

			myfile.write("\nTotal Seats:"+ts);

			myfile.write("\nDate Of flight"+df);
			myfile.close();
			
			System.out.println("Successfully written in a file");
		} catch(IOException e)
		{
			System.out.println("Error Occurred");
			e.printStackTrace();
		}
		
	}
		public void FileReading()
		{
			
			try {
				FileReader fr = new FileReader("FlightDetails.txt");
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

			
		}
	}

