package ForTesting;

import java.io.File;
import java.io.IOException;

public class Main {

	public static int driver(int input) {
		int val = 0;
		if (input >= 1 && input < 230) {
			try {
				File myObj = new File("testing.txt");
				if (!myObj.exists()) {
					myObj.createNewFile();
				}
				WriterFile writerFile = new WriterFile();
				val = writerFile.writeToFile(input);
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			System.out.println("Terminated, Entered value : " + input + " ,Please only enter an integer between 1 and 229.	");
		}
		return val;
	}
}