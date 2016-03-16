package csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;

import persondetails.Person;

public class CSVDataReader extends DataReader {
	String csvFilePath;
	Set<Person> persons;

	public CSVDataReader(String csvFilePath) {
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFilePath));
			while ((line = br.readLine()) != null) {
				String[] text = line.split(csvSplitBy);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<Person> getPersons() {
		return persons;
	}

	// public static void main(String[] args) {
	// new CSVDataReader(
	// "C:\\Users\\herczkumihalybalazs\\git\\javabigfinalassessment-hercz\\Documentation\\persons.csv");
	// }
}
