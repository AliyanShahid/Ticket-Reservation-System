package ticket_reservation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class readforcustomer {
	public void FileReading1()
	{
		
		try {
			FileReader fr = new FileReader("availableflights.txt");
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
