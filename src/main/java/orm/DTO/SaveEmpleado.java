package orm.DTO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveEmpleado {
public static void main(String[] args) {
	
	
	SessionFactory  fact = new Configuration().
		configure("hibernate.cfg.xml").addAnnotatedClass(empleados.class).buildSessionFactory();
	
	Session sess = fact.openSession();
	
	try {
		empleados empl = new empleados("Juan Carlos","Orea", 's');
		sess.beginTransaction();
		
		sess.persist(empl);
		
		sess.getTransaction().commit();
		
		System.out.println("Registro Funcional");
		
		sess.close();
		
	} finally {
		fact.close();
	}
}
}
