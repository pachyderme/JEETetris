package fr.jeetetris.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.models.Subject;

//@RestController
@RequestMapping("/api/subject")
public class SubjectController extends BaseApiController<Subject>{
	public SubjectController(IDAO<Subject> dao) {
		super(Subject.class, dao);
	}
}
