package fr.tp.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tp.dao.IDAO;
import fr.tp.models.Formation;

//@RestController
@RequestMapping("/api/formation")
public class FormationController extends BaseApiController<Formation> {
	public FormationController(IDAO<Formation> dao) {
		super(Formation.class, dao);
	}
}
