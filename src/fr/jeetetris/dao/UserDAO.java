package fr.jeetetris.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.jeetetris.models.User;

@Repository
@Transactional
public class UserDAO implements IDAO<User> {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User find(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User save(User object) {
		return em.merge(object);
	}

	@Override
	public boolean delete(User object) {
		try {
			em.remove(em.merge(object));
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<User> findAll() {
		return null;
	}

}
