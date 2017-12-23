package fr.jeetetris.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.models.User;

//@RestController
@RequestMapping("/api/user")
public class UserController extends BaseApiController<User>{
	public UserController(IDAO<User> dao) {
		super(User.class, dao);
	}
}
