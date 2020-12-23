package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.ensa.todo.business.TacheBusiness;
import ma.ensa.todo.business.imp.TacheBusinessImp;
import ma.ensa.todo.dao.TacheDao;
import ma.ensa.todo.dao.imp.TacheDaoImp;
import ma.ensa.todo.beans.Tache;
import ma.ensa.todo.beans.Utilisateur;
/**
 * Servlet implementation class DeleteTache
 */
@WebServlet("/deletetache")
public class DeleteTache extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTache() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int numero = Integer.parseInt(request.getParameter("num"));
		TacheDao tacheDao = new TacheDaoImp();
		TacheBusiness tacheBusiness=new TacheBusinessImp(tacheDao);
		Tache t=tacheBusiness.tacheByCode(numero);
	    tacheBusiness.supprimerTache(numero);	
		response.sendRedirect("employeIndex.jsp");
;	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
