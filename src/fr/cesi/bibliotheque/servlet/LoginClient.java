package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.UserDao;
import fr.cesi.bibliotheque.entity.User;

/**
 * Servlet implementation class LoginClient
 */
@WebServlet(urlPatterns="/LoginClient")
public class LoginClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String VUE;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = UserDao.getAllUser();
		int i = 0;
		for (User user : users) {
			if ( request.getParameter("login").equals(user.getLogin()) &&  request.getParameter("password").equals(user.getMdp())) { 
				request.getSession().setAttribute("login", user.getLogin());
				request.getSession().setAttribute("role", "client");
				request.getSession().setAttribute("id", user.getId());
				request.setAttribute("login", request.getSession().getAttribute(("login")));
				request.setAttribute("id", request.getSession().getAttribute(("id")));
				request.setAttribute("role", request.getSession().getAttribute(("role")));
				i++;
			}
		}
		if(i == 0)
		{
			VUE = "/loginClient.jsp";
		}
		else {
			VUE = "accueil";
		}
		request.getRequestDispatcher(VUE).forward(request, response) ;
	}

}
