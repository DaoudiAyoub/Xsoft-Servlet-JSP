package ma.ensa.todo.dao;

import java.util.List;
import java.sql.Date;

import ma.ensa.todo.beans.Tache;
import ma.ensa.todo.beans.Utilisateur;

public interface TacheDao {
public List<Tache> findByUtilisateur(Utilisateur user);
public Tache createTache(String description,int duree,String statut,Date dateDebut,Date dateFin,int id,int code);
public void deleteTache(int numero);
public void updateTache(int numero,String description,int duree,String statut,Date dateDebut,Date dateFin,int id);
public Tache findByCode(int code);

}
