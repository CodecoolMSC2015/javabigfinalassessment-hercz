package csvreader;

import java.util.Set;

import persondetails.Person;

public abstract class DataReader {
	public String searchCriteria;
	public SearchType searchType;

	public SearchType getSearchType() {
		return searchType;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public Set<Person> getPersons(String searchCriteria, SearchType searchType) {
		return null;
	}
}
