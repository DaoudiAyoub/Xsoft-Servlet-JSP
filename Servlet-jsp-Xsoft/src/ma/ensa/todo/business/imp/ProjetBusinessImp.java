package ma.ensa.todo.business.imp;

import java.util.List;
import java.util.Scanner;

import ma.ensa.todo.beans.Projet;
import ma.ensa.todo.beans.Tache;
import ma.ensa.todo.business.ProjetBusiness;
import ma.ensa.todo.dao.ProjetDao;

public class ProjetBusinessImp implements ProjetBusiness {
	
	ProjetDao prDao;
	public ProjetBusinessImp(ProjetDao prDao) {
		this.prDao=prDao;
	}

   
	public List<Projet> afficherProjets() {
		List<Projet> projets=prDao.listProjets();
		return projets;
	}

	@Override
	public void ajouterProjet(String intitule,String description,String statut,int chargeHoraire) {
		
        prDao.createProjet(intitule, description, statut, chargeHoraire);		

	}

	@Override
	public void supprimerProjet(int code) {
		prDao.deleteProjet(code);
	}

	@Override
	public void modifierProjet(int code,String intitule,String description,String statut,int chargeHoraire) {
		prDao.updateProjet(code,intitule, description, statut, chargeHoraire);
	}


	@Override
	public Projet afficherProjetByCode(int code) {
		Projet p=prDao.projetByCode(code);
		return p;
	}



	
}
