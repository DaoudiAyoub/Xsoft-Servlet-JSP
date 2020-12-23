package ma.ensa.todo.business.imp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import ma.ensa.todo.beans.Tache;
import ma.ensa.todo.beans.Utilisateur;
import ma.ensa.todo.business.TacheBusiness;
import ma.ensa.todo.dao.TacheDao;

public class TacheBusinessImp implements TacheBusiness {
	private TacheDao dao;
	public TacheBusinessImp(TacheDao dao) {
		this.dao=dao;
	}
	Scanner sc=new Scanner(System.in);
	
	public List<Tache> afficherTaches(Utilisateur user) {
        List<Tache> taches=dao.findByUtilisateur(user);
       return taches;
	}

	@Override
	public void AjouterTache(String description,int duree,String statut,Date dateDebut,Date dateFin,int id,int code) {
		Tache tache=null;
		tache=dao.createTache(description, duree,statut,dateDebut, dateFin,id,code );
	}

	@Override
	public void supprimerTache(int code) {
	dao.deleteTache(code);

	}

	@Override
	public void modifierTache(Utilisateur user) {
		System.out.println("============ Modification d'une tache ================");
		System.out.println("numero de la tache:");
		int codeTache=Integer.parseInt(sc.nextLine());
		System.out.println("Description tache:");
		String descriptionTache=sc.nextLine();
		System.out.println("duree Tache:");
		int dureeTache=Integer.parseInt(sc.nextLine());
		System.out.println("statut tache:");
		String statutTache=sc.nextLine();
		System.out.println(" Date debut de la tache(yyyy-mm-dd)");
		Date dateDebutTache=Date.valueOf(sc.nextLine());
		System.out.println(" Date fin de la tache(yyyy-mm-dd)");
		Date dateFinTache=Date.valueOf(sc.nextLine());
		dao.updateTache(codeTache, descriptionTache, dureeTache,statutTache, dateDebutTache, dateFinTache, user.getId());
		
	}

	@Override
	public Tache tacheByCode(int code) {
      Tache t=dao.findByCode(code);
	  return t;
	}

}
