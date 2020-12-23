package ma.ensa.todo.business;
import java.util.List;

import ma.ensa.todo.beans.Utilisateur;

public interface UtilisateurBusiness {
	public void ajouterUtilisateur(String nom,String prenom,String password,String email,String role);
	public Utilisateur connecterUtilisateur(String email ,String password);
	public List<Utilisateur> allUtilisateur();
	public Utilisateur utilisateurById(int id);
	public void updateUtilisateur(int id ,String nom,String prenom,String password,String email,String role);
	public void supprimerUtilisateur(int id);
}
