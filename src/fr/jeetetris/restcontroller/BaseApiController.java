package fr.jeetetris.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.jeetetris.dao.IDAO;

public abstract class BaseApiController <T> {
	@Autowired
	private IDAO<T> dao;
	
	private Class<T> type;
	
	public BaseApiController(Class<T> type, IDAO<T> dao) {
		this.type = type;
		this.dao = dao;
	}
	
	@PostMapping(value="/save")
    public T save(@RequestBody T o) {
        return dao.save(o);
    }
	
	@PostMapping(value="/delete")
    public void delete(@RequestBody int id) {
        dao.delete(dao.get(type, id));
    }
	
	@GetMapping(value="/get/{id}")
    public T get( @PathVariable int id) {
        return dao.get(type, id);
    }
	
	@GetMapping("/getAll")
	public List<T> getAll(){
		return dao.getAll(type);
	}
}
