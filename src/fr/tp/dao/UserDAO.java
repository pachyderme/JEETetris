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

import fr.tp.models.Admin;

@Repository
@Transactional
public class UserDAO implements IUserDAO{

	@PersistenceContext
	protected EntityManager em;
	
	public Admin getByIdentifier(String identifier, String password) {
		try {
			Admin u = (Admin) em.createQuery("FROM User WHERE identifier = :identifier AND password = :password").setParameter("identifier",identifier).setParameter("password",password).getSingleResult();
			return u;
		}catch(PersistenceException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Admin save(final Admin o){
      return (Admin) em.merge(o);
    }
	
	@Override
    public void delete(final Admin object){
      em.remove(em.merge(object));
    }

	@Override
	public Admin get(final Class<Admin> type, final int id){
      return (Admin) em.find(type, id);
    }

	@Override
	public List<Admin> getAll(final Class<Admin> type) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Admin> cq = builder.createQuery(type);
        Root<Admin> root = cq.from(type);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }
}
