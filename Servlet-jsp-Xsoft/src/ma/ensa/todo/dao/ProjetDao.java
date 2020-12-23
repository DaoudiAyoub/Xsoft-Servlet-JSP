package ma.ensa.todo.dao;

import java.util.List;

import ma.ensa.todo.beans.Projet;

public interface ProjetDao {
	public  List<Projet> listProjets();
	public Projet projetByCode(int code);
	public void createProjet(String intitule,String description,String statut,int chargeHoraire);
	public void deleteProjet(int code);
	public void updateProjet(int code,String intitule,String description,String statut,int chargeHoraire);
}
