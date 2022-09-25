package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class DataProviderforcontact {
public static Object[][] getTest(String filename){
	Object[][] data = null;
	
	FileReader filereader = null;
	try {
		filereader = new FileReader(filename);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	  
    // create csvReader object and skip first Line
    CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();                 
     List<String[]> allData = null;
	try {
		allData = csvReader.readAll();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (CsvException e) {
		e.printStackTrace();
	}
     data= new Object[allData.size()][5];
    for (int i = 0; i < allData.size(); i++) {
        String[] strings = allData.get(i);
        for (int j = 0; j < strings.length; j++) {
            data[i][j]=strings[j].toString();
        }	}
	return data;	
}

}
