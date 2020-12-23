package ma.ensa.todo.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tache")
public class Tache {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int numero;
@Column(name="description",length=50)
private String description;
@Column(name="duree",length=6)
private int duree;
@Column(name="statut",length=50)
private String statut;
@Column(name="dateDebut",length=50)
private Date dateDebut;
@Column(name="dateFin",length=50)
private Date dateFin;	
@ManyToOne()
@JoinColumn(name="id")
private Utilisateur utilisateur;
@ManyToOne()
@JoinColumn(name="code")
private Projet projet;
public String getStatut() {
	return statut;
}
public void setStatut(String statut) {
	this.statut = statut;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public Utilisateur getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}

public Tache() {
	super();
}
public int getNumero() {
	return numero;
}
public String getDescription() {
	return description;
}
public int getDuree() {
	return duree;
}
public Date getDateFin() {
	return dateFin;
}
public Utilisateur getUser() {
	return utilisateur;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public void setDescription(String description) {
	this.description = description;
}
public void setDuree(int duree) {
	this.duree = duree;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}
public void setUser(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
public Projet getProjet() {
	return projet;
}
public void setProjet(Projet projet) {
	this.projet = projet;
}

}
