package ma.ensa.todo.dao.imp;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory factory=null;
	public static SessionFactory getSessionFactory(){
		if(factory==null){
			StandardServiceRegistry registre=new StandardServiceRegistryBuilder().configure().build();
			factory=new MetadataSources(registre).buildMetadata().buildSessionFactory();
		}
		return factory;
	}
}

