package fr.jeetetris.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.jeetetris.models.Tetrimino;

@Repository
@Transactional
public class TetriminoDAO implements IDAO<Tetrimino> {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Tetrimino find(int id) {
		return em.find(Tetrimino.class, id);
	}

	@Override
	public Tetrimino save(Tetrimino object) {
		return em.merge(object);
	}

	@Override
	public boolean delete(Tetrimino object) {
		try {
			em.remove(em.merge(object));
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tetrimino> findAll() {
		Query myQuery = em.createQuery("from Tetrimino");
		return (List<Tetrimino>)myQuery.getResultList();
	}

}
