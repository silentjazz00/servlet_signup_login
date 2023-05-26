package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Student;

public class StudentDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transcation = manager.getTransaction();

	public void save(Student student) {
		transcation.begin();
		manager.persist(student);
		transcation.commit();
	}

	public Student fetch(String email) {

		List<Student> list = manager.createQuery("select x from Student x where email=?1").setParameter(1, email)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Student fetch(long mobile) {

		List<Student> list = manager.createQuery("select x from Student x where phone=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
}