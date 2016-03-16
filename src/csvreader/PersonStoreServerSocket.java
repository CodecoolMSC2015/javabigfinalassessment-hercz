package csvreader;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PersonStoreServerSocket {

	public void start() {

		try {

			System.out.println("---SERVER---");
			ServerSocket serverSocket = new ServerSocket(1555);
			System.out.println("\nserver is waiting...");

			Socket pipe = serverSocket.accept();

			System.out.println("Client Connected!");

			ObjectInputStream serverInputStream = new ObjectInputStream(pipe.getInputStream());
			ObjectOutputStream serverOutputStream = new ObjectOutputStream(pipe.getOutputStream());

			String searchCriteria = (String) serverInputStream.readObject();
			String searchType = (String) serverInputStream.readObject();
			System.out.println(searchCriteria + searchType);

			serverInputStream.close();
			serverOutputStream.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	DataReader dataReader = new DataReader() {
	};

	public static void main(String[] args) {
		PersonStoreServerSocket p = new PersonStoreServerSocket();
		p.start();
	}
}
