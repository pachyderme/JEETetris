package fr.tp.dao;

import java.util.List;

import fr.tp.models.Response;

public interface IResponseDAO extends IDAO<Response> {
	public List<Response> getByQuestionId(int id);
	
	public Response save(final Response o);

    public void delete(final Response object);

	public Response get(final Class<Response> type, final int id);

	public List<Response> getAll(final Class<Response> type);
}
