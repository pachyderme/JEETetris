package fr.jeetetris.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.models.Question;

//@RestController
@RequestMapping("/api/question")
public class QuestionController extends BaseApiController<Question>{
	public QuestionController(IDAO<Question> dao) {
		super(Question.class, dao);
	}
}
