package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.ensa.todo.business.ProjetBusiness;
import ma.ensa.todo.business.imp.ProjetBusinessImp;
import ma.ensa.todo.dao.ProjetDao;
import ma.ensa.todo.dao.imp.ProjetDaoImp;

/**
 * Servlet implementation class DeleteProjet
 */
@WebServlet("/deleteprojet")
public class DeleteProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProjet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProjetDao prDao=new ProjetDaoImp();
		ProjetBusiness prBusiness=new ProjetBusinessImp(prDao);	
		HttpSession session = request.getSession();
		int cod = Integer.parseInt(request.getParameter("codd"));
		System.out.println("vous vouler supprimer"+cod);
		prBusiness.supprimerProjet(cod);
		System.out.println("good work" );

		response.sendRedirect("chefProjetIndex.jsp");

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
