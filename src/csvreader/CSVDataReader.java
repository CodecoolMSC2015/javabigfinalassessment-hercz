package csvreader;

import java.util.List;

import persondetails.Person;

public class CSVDataReader extends DataReader {
	private String csvFilePath;
	private List<Person> persons;

	public CSVDataReader(String csvFilePath) {
	}

	public List<Person> getPersons() {
		return persons;
	}

}
