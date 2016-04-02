package homework_2016_3_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 * file io
 * @author 151250137
 */
public class Homework2 {
	public static void main(String[] args) {
		try {
			// read fileA
			File fileA = new File("src/txts/fileA.txt");
			FileReader fileReaderA = new FileReader(fileA);
			BufferedReader bufferedReaderA = new BufferedReader(fileReaderA);
			ArrayList<String> stringA = new ArrayList<>();
			String contentA = null;
			// use while to read all contents in fileA
			while((contentA = bufferedReaderA.readLine())!= null){
				stringA.add(contentA);
			}
					bufferedReaderA.readLine();
			System.out.println(contentA);
			bufferedReaderA.close();
			// read fileB
			File fileB = new File("src/txts/fileB.txt");
			FileReader fileReaderB = new FileReader(fileB);
			BufferedReader bufferedReaderB = new BufferedReader(fileReaderB);
			
			ArrayList<String> stringB = new ArrayList<>();
			String contentB = null;
			// use while to read all contents in fileA
			while((contentB = bufferedReaderB.readLine()) != null){
				stringB.add(contentB);
			}
			// write fileB
			FileWriter fileWriterB = new FileWriter(fileB);
			// add fileA's content to fileB's end
			stringB.addAll(stringA);
			for(String s : stringB){
				fileWriterB.write(s);
				// use this to start a new line
				fileWriterB.write('\r');
				fileWriterB.write('\n');
			}
			fileWriterB.close();
			bufferedReaderB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
