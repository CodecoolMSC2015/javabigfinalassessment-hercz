package csvreader;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PersonStoreServerSocket {
	CSVDataReader store = new CSVDataReader(
			"C:\\Users\\herczkumihalybalazs\\git\\javabigfinalassessment-hercz\\Documentation\\persons.csv");

	public void start() {

		try {

			System.out.println("---SERVER---");
			ServerSocket serverSocket = new ServerSocket(1555);
			System.out.println("\nserver is waiting...");

			Socket pipe = serverSocket.accept();

			System.out.println("Client Connected!");

			ObjectInputStream serverInputStream = new ObjectInputStream(pipe.getInputStream());
			ObjectOutputStream serverOutputStream = new ObjectOutputStream(pipe.getOutputStream());

			SearchType searchType = (SearchType) serverInputStream.readObject();
			String searchCriteria = (String) serverInputStream.readObject();
			System.out.println("Searchtype: " + searchType + " Criteria: " + searchCriteria);

			store.setSearchCriteria(searchCriteria);
			store.setSearchType(searchType);

			// serverOutputStream.writeObject();

			serverInputStream.close();
			serverOutputStream.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PersonStoreServerSocket objectserver = new PersonStoreServerSocket();
		objectserver.start();
	}
}
