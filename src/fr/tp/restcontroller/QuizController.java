package fr.tp.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tp.dao.IDAO;
import fr.tp.models.Quiz;

//@RestController
@RequestMapping("/api/quiz")
public class QuizController extends BaseApiController<Quiz>{
	public QuizController(IDAO<Quiz> dao) {
		super(Quiz.class, dao);
	}
}
