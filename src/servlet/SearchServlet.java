package servlet;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csvreader.SearchType;

//@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void sendToServer(String skill, SearchType type) {
		try {
			Socket clientSocket = new Socket("localhost", 1555);

			ObjectOutputStream clientOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

			clientOutputStream.writeObject(type);
			clientOutputStream.writeObject(skill);
			clientSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String skills, searchTypeString;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		skills = request.getParameter("skills");
		searchTypeString = request.getParameter("searchType");

		SearchType searchType = SearchType.valueOf(searchTypeString);
		sendToServer(skills, searchType);

		request.getRequestDispatcher("index.html").include(request, response);
		out.print("Criteria: " + skills + "Searchtype: " + searchType);
		out.close();
	}

}
