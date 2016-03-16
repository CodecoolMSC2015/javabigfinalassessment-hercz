package csvreader;

import java.util.Set;

import persondetails.Person;

public abstract class DataReader {
	private String searchCriteria;
	private SearchType searchType;

	public abstract void setSearchType(SearchType searchType);

	public abstract void setSearchCriteria(String searchCriteria);

	public abstract Set<Person> getPersons();
}
