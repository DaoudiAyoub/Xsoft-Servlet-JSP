package ma.ensa.todo.dao.imp;
import ma.ensa.todo.beans.Projet;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ma.ensa.todo.beans.Tache;
import ma.ensa.todo.beans.Utilisateur;
import ma.ensa.todo.dao.TacheDao;

public class TacheDaoImp implements TacheDao {
	public TacheDaoImp() {}
	public List<Tache> findByUtilisateur(Utilisateur user){
		List<Tache> taches=user.getListTaches();
		return taches;
	}
	public Tache createTache(String description,int duree,String statut,Date dateDebut,Date dateFin,int id,int code){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Tache tache=new Tache();
		tache.setDateFin(dateFin);
		tache.setDescription(description);
		tache.setDuree(duree);
		tache.setDateDebut(dateDebut);
		tache.setStatut(statut);
		@SuppressWarnings("rawtypes")
		Query queryy=session.createQuery("FROM Projet WHERE code=?");
		queryy.setParameter(0, code);
		Projet projet=(Projet) queryy.uniqueResult();
		tache.setProjet(projet);
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("FROM Utilisateur WHERE id=?");
		query.setParameter(0, id);
		Utilisateur user=(Utilisateur) query.uniqueResult();
		tache.setUser(user);
		session.save(tache);
		session.getTransaction().commit();
		return tache;
	}
	public void deleteTache(int numero) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Tache tache =(Tache) session.get(Tache.class, numero);
		session.delete(tache);
		session.getTransaction().commit();
		session.close();

	}
	public void updateTache(int numero,String description,int duree,String statut,Date dateDebut,Date dateFin,int id) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from Tache where numero=? and id=?");
		query.setParameter(0, numero);
		query.setParameter(1, id);
		Tache tache=(Tache) query.uniqueResult();
		tache.setDescription(description);
		tache.setDuree(duree);
		tache.setStatut(statut);
		tache.setDateDebut(dateDebut);
		tache.setDateFin(dateFin);
		session.save(tache);
		session.getTransaction().commit();
		System.out.println("Tache modifié");

	}
	@Override
	public Tache findByCode(int code) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from Tache where numero=?");
		query.setParameter(0, code);
        Tache t =(Tache) query.uniqueResult();
		session.getTransaction().commit();
	    return t;
	}
}
