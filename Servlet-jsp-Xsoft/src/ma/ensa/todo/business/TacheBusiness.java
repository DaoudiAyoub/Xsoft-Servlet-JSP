package ma.ensa.todo.business;
import ma.ensa.todo.beans.Tache;

import java.sql.Date;
import java.util.List;

import ma.ensa.todo.beans.Utilisateur;

public interface TacheBusiness {
	public List<Tache> afficherTaches(Utilisateur user);
	public void AjouterTache(String description,int duree,String statut,Date dateDebut,Date dateFin,int id,int code);
	public void supprimerTache(int code);
	public void modifierTache(Utilisateur user);
	public Tache tacheByCode(int code);

}
