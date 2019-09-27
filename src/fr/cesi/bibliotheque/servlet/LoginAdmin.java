package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet(urlPatterns="/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String VUE;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAdmin() {
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
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("login").equals("admin") &&  request.getParameter("password").equals("admin")) { 
			request.getSession().setAttribute("login",  request.getParameter("login"));
			request.getSession().setAttribute("role", "admin");
			request.setAttribute("login", request.getSession().getAttribute(("login")));
			request.setAttribute("role", request.getSession().getAttribute(("role")));
			VUE = "/accueil";
		}
		else {
			VUE = "/loginAdmin.jsp";
			}
		request.getRequestDispatcher(VUE).forward(request, response);

		
	}

}
