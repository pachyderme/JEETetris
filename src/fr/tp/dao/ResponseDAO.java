package fr.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.tp.models.Response;

@Repository
@Transactional
public class ResponseDAO implements IResponseDAO{

	@PersistenceContext
	protected EntityManager em;
	
	public List<Response> getByQuestionId(int id) {
		try {
			@SuppressWarnings("unchecked")
			List<Response> q = (List<Response>) em.createQuery("FROM Response WHERE question_id = :id").setParameter("id",id).getResultList();
			return q;
		}catch(PersistenceException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Response save(final Response o){
      return (Response) em.merge(o);
    }
	
	@Override
    public void delete(final Response object){
      em.remove(em.merge(object));
    }

	@Override
	public Response get(final Class<Response> type, final int id){
      return (Response) em.find(type, id);
    }

	@Override
	public List<Response> getAll(final Class<Response> type) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Response> cq = builder.createQuery(type);
        Root<Response> root = cq.from(type);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }
}
