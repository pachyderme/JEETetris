package fr.jeetetris.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.models.Formation;

//@RestController
@RequestMapping("/api/formation")
public class FormationController extends BaseApiController<Formation> {
	public FormationController(IDAO<Formation> dao) {
		super(Formation.class, dao);
	}
}
