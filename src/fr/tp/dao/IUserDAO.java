package fr.tp.dao;

import java.util.List;

import fr.tp.models.Admin;

public interface IUserDAO extends IDAO<Admin> {
	public Admin getByIdentifier(String identifier, String password);
	
	public Admin save(final Admin o);

    public void delete(final Admin object);

	public Admin get(final Class<Admin> type, final int id);

	public List<Admin> getAll(final Class<Admin> type);
}
