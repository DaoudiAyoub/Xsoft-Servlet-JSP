package ma.ensa.todo.business.imp;

import java.util.List;
import java.util.Scanner;

import ma.ensa.todo.beans.Tache;
import ma.ensa.todo.beans.Utilisateur;
import ma.ensa.todo.business.UtilisateurBusiness;
import ma.ensa.todo.dao.UtilisateurDao;

public class UtilisateurBusinessImp implements UtilisateurBusiness {
     private UtilisateurDao dao;
     public UtilisateurBusinessImp(UtilisateurDao dao) {
    	 this.dao=dao;
    	 
     }
     Scanner sc=new Scanner(System.in);
	@Override
	public void ajouterUtilisateur(String nom,String prenom,String password,String email,String role) {
		
		dao.createUtilisateur(nom,prenom, password, email,role);
		
	}

	@Override
	public Utilisateur connecterUtilisateur(String email ,String password) {
		
		Utilisateur user=dao.findByLogin(email, password);
		
		return user;
	}

	@Override
	public List<Utilisateur> allUtilisateur() {
      List<Utilisateur> users=dao.getAllUtilisateur();
      return users;
	}

	@Override
	public Utilisateur utilisateurById(int id) {
			
		Utilisateur user=dao.searchUtilisateur(id);
		return user;

	}

	@Override
	public void updateUtilisateur(int id ,String nom,String prenom,String password,String email,String role) {
		// TODO Auto-generated method stub
		
		dao.modifierUtilisateur(id, nom, prenom, password, email, role);
	}

	@Override
	public void supprimerUtilisateur(int id) {
		
		dao.deleteUtilisateur(id);
	}

}
