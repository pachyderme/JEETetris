package fr.tp.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tp.dao.IDAO;
import fr.tp.models.Question;

//@RestController
@RequestMapping("/api/question")
public class QuestionController extends BaseApiController<Question>{
	public QuestionController(IDAO<Question> dao) {
		super(Question.class, dao);
	}
}
