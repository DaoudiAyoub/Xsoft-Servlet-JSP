package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ma.ensa.todo.beans.Utilisateur;
import ma.ensa.todo.business.UtilisateurBusiness;
import ma.ensa.todo.business.imp.UtilisateurBusinessImp;
import ma.ensa.todo.dao.UtilisateurDao;
import ma.ensa.todo.dao.imp.UtilisateurDaoImp;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/Connection")
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDao userDao=new UtilisateurDaoImp();
		UtilisateurBusiness userBusiness=new UtilisateurBusinessImp(userDao);
		System.out.println("Connection do get servlet");
		Utilisateur user=null;
		// TODO Auto-generated method stub
//		response.setContentType("text/html");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		user=userBusiness.connecterUtilisateur(email, pass);
		if(user!=null) {
			String role=user.getRole();
			HttpSession session = request.getSession();

			session.setAttribute("utilisateur", user);
			if (role.equals("Employé")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Employe");
				dispatcher.forward(request,response);			} 
			else if (role.equals("Administrateur")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Administrateur");
				dispatcher.forward(request,response);
			} else if (role.equals("Chef de projet")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ChefProjet");
				dispatcher.forward(request,response);			}
		}
		else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<h3><b>email ou password est non valide</b></h3>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("err","false");
			dispatcher.include(request,response);
			out.print("<h3><b>email ou password est non valide</b></h3>");
		}
		
//		response.sendRedirect("ChefDeProjetIndex.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

	}

}
