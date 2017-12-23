package fr.tp.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tp.dao.IDAO;
import fr.tp.models.Test;

//@RestController
@RequestMapping("/api/test")
public class TestController extends BaseApiController<Test>{
	public TestController(IDAO<Test> dao) {
		super(Test.class, dao);
	}
}
