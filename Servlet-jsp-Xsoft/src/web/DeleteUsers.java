package web;

import java.io.IOException;

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
 * Servlet implementation class DeleteUsers
 */
@WebServlet("/deleteusers")
public class DeleteUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtilisateurDao userDao=new UtilisateurDaoImp();
		UtilisateurBusiness userBusiness=new UtilisateurBusinessImp(userDao);
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("idd"));
		Utilisateur u=userBusiness.utilisateurById(id);
		Utilisateur admin=(Utilisateur) session.getAttribute("utilisateur");
		if(u.getEmail().equals(admin.getEmail())){
			response.sendRedirect("administrateurIndex.jsp");


		}
		else {
			userBusiness.supprimerUtilisateur(u.getId());
			response.sendRedirect("administrateurIndex.jsp");

		}
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
