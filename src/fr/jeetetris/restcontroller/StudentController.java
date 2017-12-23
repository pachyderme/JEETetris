package fr.jeetetris.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jeetetris.dao.IDAO;
//import fr.jeetetris.models.Student;
import fr.jeetetris.models.User;

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
