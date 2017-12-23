package fr.tp.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tp.dao.IDAO;
import fr.tp.models.Subject;

//@RestController
@RequestMapping("/api/subject")
public class SubjectController extends BaseApiController<Subject>{
	public SubjectController(IDAO<Subject> dao) {
		super(Subject.class, dao);
	}
}
