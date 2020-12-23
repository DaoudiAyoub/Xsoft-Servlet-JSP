package ma.ensa.todo.dao;

import java.util.List;

import ma.ensa.todo.beans.Utilisateur;

public interface UtilisateurDao {
public Utilisateur findByLogin(String email ,String password);
public void createUtilisateur(String nom,String prenom,String password,String email,String role);
public void modifierUtilisateur(int id ,String nom,String prenom,String password,String email,String role);
public void deleteUtilisateur(int id);
public Utilisateur searchUtilisateur(int id);
public List<Utilisateur> getAllUtilisateur();
}
