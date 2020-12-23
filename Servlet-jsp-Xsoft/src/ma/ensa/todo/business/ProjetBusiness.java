package ma.ensa.todo.business;
import ma.ensa.todo.beans.Projet;

import java.util.List;

public interface ProjetBusiness {
	public List<Projet> afficherProjets();
	public Projet afficherProjetByCode(int code);
	public void ajouterProjet(String intitule,String description,String statut,int chargeHoraire);
	public void supprimerProjet(int code);
	public void modifierProjet(int code,String intitule,String description,String statut,int chargeHoraire);
}
