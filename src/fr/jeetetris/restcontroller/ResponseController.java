package fr.jeetetris.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.models.Response;

//@RestController
@RequestMapping("/api/response")
public class ResponseController extends BaseApiController<Response>{
	public ResponseController(IDAO<Response> dao) {
		super(Response.class, dao);
	}
}
