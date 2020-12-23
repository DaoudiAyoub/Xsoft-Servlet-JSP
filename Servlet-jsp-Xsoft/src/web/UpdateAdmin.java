package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensa.todo.business.UtilisateurBusiness;
import ma.ensa.todo.business.imp.UtilisateurBusinessImp;
import ma.ensa.todo.dao.UtilisateurDao;
import ma.ensa.todo.dao.imp.UtilisateurDaoImp;

/**
 * Servlet implementation class UpdateAdmin
 */
@WebServlet("/updateadmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtilisateurDao userDao=new UtilisateurDaoImp();
		UtilisateurBusiness userBusiness=new UtilisateurBusinessImp(userDao);
		int id_empl=Integer.parseInt(request.getParameter("id"));
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String role=request.getParameter("role");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		userBusiness.updateUtilisateur(id_empl, nom, prenom, password, email, role);
		response.sendRedirect("administrateurIndex.jsp");

	}

}
