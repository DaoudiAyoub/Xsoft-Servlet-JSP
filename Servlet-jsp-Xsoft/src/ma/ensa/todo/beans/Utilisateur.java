package ma.ensa.todo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="utilisateur")
public class Utilisateur {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(name="nom",length=50)
private String nom;
@Column(name="prenom",length=50)
private String prenom;
@Column(name="email",length=50)
private String email;
@Column(name="password",length=50)
private String password;
@Column(name="role",length=50)
private String role;
@OneToMany(mappedBy="utilisateur")
List<Tache> listTaches;
public Utilisateur() {
	listTaches=new ArrayList<Tache>();
}
public int getId() {
	return id;
}
public String getNom() {
	return nom;
}
public String getPassword() {
	return password;
}
public String getEmail() {
	return email;
}
public List<Tache> getListTaches() {
	return listTaches;
}
public void setId(int id) {
	this.id = id;
}
public void setNom(String nom) {
	this.nom = nom;
}
public void setPassword(String password) {
	this.password = password;
}
public void setEmail(String email) {
	this.email = email;
}
public void setListTaches(List<Tache> listTaches) {
	this.listTaches = listTaches;
}
public void ajouterTache(Tache T) {
	listTaches.add(T);
}
public void supprimerTache(Tache T) {
	listTaches.remove(T);
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}




}
