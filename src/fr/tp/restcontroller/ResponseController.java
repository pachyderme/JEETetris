package fr.tp.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tp.dao.IDAO;
import fr.tp.models.Response;

//@RestController
@RequestMapping("/api/response")
public class ResponseController extends BaseApiController<Response>{
	public ResponseController(IDAO<Response> dao) {
		super(Response.class, dao);
	}
}
