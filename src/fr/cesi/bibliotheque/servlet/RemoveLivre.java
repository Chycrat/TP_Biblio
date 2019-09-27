package fr.cesi.bibliotheque.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.LivresDao;

/**
 * Servlet implementation class RemoveLivre
 */
@WebServlet(urlPatterns = "/RemoveLivre")
public class RemoveLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/accueil";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveLivre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		LivresDao.removeLivre(id);
		request.getRequestDispatcher(VUE).forward(request, response);
	}

}
