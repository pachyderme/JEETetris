package fr.jeetetris.dao;

import fr.jeetetris.models.User;

public interface IUserDAO extends IDAO<User> {

	public User findByIdentifier(String identifier, String password);
}
