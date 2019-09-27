package fr.cesi.bibliotheque.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.LivresDao;
import fr.cesi.bibliotheque.dao.UserDao;
import fr.cesi.bibliotheque.entity.Livres;
import fr.cesi.bibliotheque.entity.User;

/**
 * Servlet implementation class InitialisationDate
 */
@WebServlet(urlPatterns = "")
public class InitialisationDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/accueil";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitialisationDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Lancement de l'init");
		Livres Livres1 = new Livres((long)1,"Livre1", "Auteur1", "Edition1");
		Livres Livres2 = new Livres((long)2,"Livre2", "Auteur2", "Edition2");
		Livres Livres3 = new Livres((long)3,"Livre3", "Auteur3", "Edition3");
		Livres Livres4 = new Livres((long)4,"Livre4", "Auteur4", "Edition4");
		LivresDao.addLivre(Livres1);
		LivresDao.addLivre(Livres2);
		LivresDao.addLivre(Livres3);
		LivresDao.addLivre(Livres4);
		
		User user1 = new User((long)1, "romain", "romain");
		User user2 = new User((long)2, "invite", "invite");
		UserDao.addUser(user1);
		UserDao.addUser(user2);
		
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);	
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

}
