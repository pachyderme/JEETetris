package fr.jeetetris.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.jeetetris.models.Tetrimino;
import fr.jeetetris.models.Tetris;
import fr.jpatest.model.Product;

@Repository
@Transactional
public class TetrisDAO implements IDAO<Tetris> {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Tetris find(int id) {
		return em.find(Tetris.class, id);
	}

	@Override
	public Tetris save(Tetris object) {
		return em.merge(object);
	}

	@Override
	public boolean delete(Tetris object) {
		try {
			em.remove(em.merge(object));
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Tetris> findAll() {
		return null;
	}

}