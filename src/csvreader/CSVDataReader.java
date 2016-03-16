package csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;

import persondetails.Person;

public class CSVDataReader extends DataReader {
	String csvFilePath;
	Set<Person> persons;
	private String searhCriteria;
	private SearchType searchType;

	public CSVDataReader(String csvFilePath) {
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFilePath));
			while ((line = br.readLine()) != null) {
				String[] coloumn = line.split(csvSplitBy);
				if (coloumn[5].equals(searhCriteria)) {
					persons.add(new Person(coloumn[0], coloumn[1]));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<Person> getPersons() {
		return persons;
	}

	@Override
	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}

	@Override
	public void setSearchCriteria(String searchCriteria) {
		this.searhCriteria = searchCriteria;

	}

}
