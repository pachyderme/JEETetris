package fr.jeetetris.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.jeetetris.models.Question;

@Repository
@Transactional
public class QuestionDAO implements IQuestionDAO{

	@PersistenceContext
	protected EntityManager em;
	
	public List<Question> getByQuizId(int id) {
		try {
			@SuppressWarnings("unchecked")
			List<Question> q = (List<Question>) em.createQuery("FROM Question WHERE quiz_id = :id").setParameter("id",id).getResultList();
			return q;
		}catch(PersistenceException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Question save(final Question o){
      return (Question) em.merge(o);
    }
	
	@Override
    public void delete(final Question object){
      em.remove(em.merge(object));
    }

	@Override
	public Question get(final Class<Question> type, final int id){
      return (Question) em.find(type, id);
    }

	@Override
	public List<Question> getAll(final Class<Question> type) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Question> cq = builder.createQuery(type);
        Root<Question> root = cq.from(type);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }
}
