package ForTesting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WriterFile {
	public int writeToFile(int num) {
		Set<String> sets = new HashSet<>();
		
		try {
			int minLimit = 65;
			int buffer = 1;
			int counter = 1;

			FileWriter myWriter = new FileWriter("testing.txt");
			BufferedWriter out = new BufferedWriter(myWriter);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 100; i++) {
				if (i % 26 != 0) {
					sb.append((char) minLimit++);
				} else {
					minLimit = 65;
					sb.append((char) minLimit++);
				}
			}
			
			out.write(sb.toString());
			sets.add(sb.toString());

			for (int i = 1; i < num; i++) {
				out.newLine();
				String currentVal = sb.toString();
				if (buffer + counter <= 100) {
					String valCurrent = currentVal.substring(buffer - counter, buffer);
					String toReplace = currentVal.substring(buffer, buffer + counter);
					while (valCurrent.equals(toReplace)) {
						buffer++;
						valCurrent = currentVal.substring(buffer - counter, buffer);
						toReplace = currentVal.substring(buffer, buffer + counter);
					}
					sb.replace(buffer - counter, buffer, toReplace);
					sb.replace(buffer, buffer + counter, valCurrent);
					buffer++;
					sets.add(sb.toString());
				} else {
					counter++;
					buffer = counter;
					String valCurrent = currentVal.substring(buffer - counter, buffer);
					sb.replace(buffer - counter, buffer, currentVal.substring(buffer, buffer + counter));
					sb.replace(buffer, buffer + counter, valCurrent);
					buffer++;
					sets.add(sb.toString());
				}
				out.write(sb.toString());
			}

			out.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return sets.size();
	}
}