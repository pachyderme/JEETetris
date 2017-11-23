package fr.jeetetris.dao;

import java.util.List;

public interface IDAO<T> {
	public T find(int id);
	public List<T> findAll();
	public T save(T object);
	public boolean delete(T object);
}
