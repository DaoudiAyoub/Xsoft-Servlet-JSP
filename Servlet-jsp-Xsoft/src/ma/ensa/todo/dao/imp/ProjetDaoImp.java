package ma.ensa.todo.dao.imp;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ma.ensa.todo.beans.Projet;
import ma.ensa.todo.beans.Tache;
import ma.ensa.todo.dao.ProjetDao;

public class ProjetDaoImp implements ProjetDao{

	public ProjetDaoImp() {}

	@Override
	public List<Projet> listProjets() {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Projet> projets=session.createQuery("from Projet").list();
		return projets;
	}

	@Override
	public Projet projetByCode(int code) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Projet where code=?");
		query.setParameter(0, code);
		Projet pr=(Projet) query.uniqueResult();
		return pr;
	}

	@Override
	public void createProjet(String intitule, String description, String statut, int chargeHoraire) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Projet projet=new Projet();
		projet.setDescription(description);
		projet.setIntitule(intitule);
		projet.setChargeHoraire(chargeHoraire);
		projet.setStatut(statut);
		session.save(projet);
		session.getTransaction().commit();
	}

	@Override
	public void deleteProjet(int code) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Projet projet =(Projet) session.get(Projet.class,code);
		session.delete(projet);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateProjet(int code,String intitule, String description, String statut, int chargeHoraire) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Projet where code=?");
		query.setParameter(0, code);
		Projet pr=(Projet) query.uniqueResult();
		pr.setChargeHoraire(chargeHoraire);
		pr.setIntitule(intitule);
		pr.setDescription(description);
		pr.setStatut(statut);
		session.save(pr);
		session.getTransaction().commit();
		
	}
}
