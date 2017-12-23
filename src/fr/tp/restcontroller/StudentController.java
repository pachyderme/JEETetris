package fr.tp.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tp.dao.IDAO;
import fr.tp.models.User;

//@Controller
//@RequestMapping("/api/student")
//public class StudentController extends BaseApiController<Student>{
//	public StudentController(DAO<Student> dao) {
//		super(Student.class, dao);
//	}
//}

//@RestController
@RequestMapping("/api/student")
public class StudentController extends BaseApiController<User>{
	public StudentController(IDAO<User> dao) {
		super(User.class, dao);
	}
}
