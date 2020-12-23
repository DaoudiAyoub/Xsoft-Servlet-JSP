package test;

import java.util.Date;

import ma.ensa.todo.business.ProjetBusiness;
import ma.ensa.todo.business.TacheBusiness;
import ma.ensa.todo.business.UtilisateurBusiness;
import ma.ensa.todo.business.imp.ProjetBusinessImp;
import ma.ensa.todo.business.imp.TacheBusinessImp;
import ma.ensa.todo.business.imp.UtilisateurBusinessImp;
import ma.ensa.todo.dao.UtilisateurDao;
import ma.ensa.todo.dao.imp.UtilisateurDaoImp;
import ma.ensa.todo.dao.ProjetDao;
import ma.ensa.todo.dao.imp.ProjetDaoImp;
import ma.ensa.todo.dao.TacheDao;
import ma.ensa.todo.dao.imp.TacheDaoImp;




public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtilisateurDao userDao=new UtilisateurDaoImp();
		UtilisateurBusiness userBusiness=new UtilisateurBusinessImp(userDao);
		ProjetDao prDao=new ProjetDaoImp();
		ProjetBusiness prBusiness=new ProjetBusinessImp(prDao);
		TacheDao tacheDao=new TacheDaoImp();
		TacheBusiness tacheBusiness=new TacheBusinessImp(tacheDao);

		
	}

}
