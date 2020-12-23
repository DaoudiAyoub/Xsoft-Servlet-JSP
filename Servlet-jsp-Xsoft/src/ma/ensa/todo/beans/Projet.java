package ma.ensa.todo.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Projet")
public class Projet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	@Column(name="intitule",length=50)
	private String intitule;
	@Column(name="description",length=50)
	private String description;
	@Column(name="statut",length=50)
	private String statut;
	@Column(name="charge_horaire",length=50)
	private int chargeHoraire;
	@OneToMany(mappedBy="projet")
	List<Tache> listTaches;
	public int getCode() {
		return code;
	}
	public List<Tache> getListTaches() {
		return listTaches;
	}
	public void setListTaches(List<Tache> listTaches) {
		this.listTaches = listTaches;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public int getChargeHoraire() {
		return chargeHoraire;
	}
	public void setChargeHoraire(int chargeHoraire) {
		this.chargeHoraire = chargeHoraire;
	}
    public void ajouterTache(Tache t) {
    	this.listTaches.add(t);
    }
    public void removeTache(Tache t) {
    	this.listTaches.remove(t);
    }
}
