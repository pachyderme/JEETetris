package fr.tp.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.tp.dao.IDAO;
import fr.tp.models.User;

//@RestController
@RequestMapping("/api/user")
public class UserController extends BaseApiController<User>{
	public UserController(IDAO<User> dao) {
		super(User.class, dao);
	}
}
