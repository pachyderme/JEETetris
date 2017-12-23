package fr.jeetetris.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.models.Test;

//@RestController
@RequestMapping("/api/test")
public class TestController extends BaseApiController<Test>{
	public TestController(IDAO<Test> dao) {
		super(Test.class, dao);
	}
}
