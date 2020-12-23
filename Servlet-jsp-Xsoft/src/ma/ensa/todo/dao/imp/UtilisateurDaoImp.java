package ma.ensa.todo.dao.imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.todo.beans.Tache;
import ma.ensa.todo.beans.Utilisateur;
import ma.ensa.todo.dao.UtilisateurDao;

public class UtilisateurDaoImp implements UtilisateurDao {
 
	public UtilisateurDaoImp() {}
	public Utilisateur findByLogin(String email ,String password) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("FROM Utilisateur WHERE email=? AND password=?");
		query.setParameter(0, email);
		query.setParameter(1, password);
		Utilisateur user=(Utilisateur) query.uniqueResult();
		session.getTransaction().commit();
		return user;
	}
	
	public void createUtilisateur(String nom,String prenom,String password,String email,String role) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Utilisateur user=new Utilisateur();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setPassword(password);
		user.setEmail(email);
		user.setRole(role);
		session.save(user);
		session.getTransaction().commit();
		System.out.println("Utilisateur ajouté");
		
	}
	public Utilisateur searchUtilisateur(int id) {
		// TODO Auto-generated method stub
				SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				@SuppressWarnings("rawtypes")
				Query query=session.createQuery("FROM Utilisateur WHERE id=? ");
				query.setParameter(0, id);
				Utilisateur user=(Utilisateur) query.uniqueResult();
				session.getTransaction().commit();
				return user;
	}
	public List<Utilisateur> getAllUtilisateur() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("FROM Utilisateur ");
		List<Utilisateur> user=session. createQuery("from Utilisateur" ).list(); 
		session.getTransaction().commit();
		return user;
		
	}
	@Override
	public void modifierUtilisateur(int id, String nom, String prenom, String password, String email, String role) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Utilisateur user=session.load(Utilisateur.class, id);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setPassword(password);
		user.setEmail(email);
		user.setRole(role);
		session.update(user);
		session.getTransaction().commit();
		System.out.println("Utilisateur Modifié");
		
		
	}
	@Override
	public void deleteUtilisateur(int id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Utilisateur user=session.load(Utilisateur.class, id);
		session.delete(user);
		session.getTransaction().commit();
		System.out.println("Utilisateur Supprimé");
		
	}


}
