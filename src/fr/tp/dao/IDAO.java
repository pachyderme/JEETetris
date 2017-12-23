package fr.tp.dao;

import java.util.List;

public interface IDAO<T> {
	public T save(final T o);

    public void delete(final T object);

	public T get(final Class<T> type, final int id);

	public List<T> getAll(final Class<T> type);
}
