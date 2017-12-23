package fr.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DAO<T> implements IDAO<T>{
	
	@PersistenceContext
	protected EntityManager em;

	public T save(final T o){
      return (T) em.merge(o);
    }
	
    public void delete(final T object){
      em.remove(em.merge(object));
    }

	public T get(final Class<T> type, final int id){
      return (T) em.find(type, id);
    }

	public List<T> getAll(final Class<T> type) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(type);
        Root<T> root = cq.from(type);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

}
