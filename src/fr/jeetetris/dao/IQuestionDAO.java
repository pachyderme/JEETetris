package fr.jeetetris.dao;

import java.util.List;

import fr.jeetetris.models.Question;

public interface IQuestionDAO extends IDAO<Question> {
	public List<Question> getByQuizId(int id);
	
	public Question save(final Question o);

    public void delete(final Question object);

	public Question get(final Class<Question> type, final int id);

	public List<Question> getAll(final Class<Question> type);
}
