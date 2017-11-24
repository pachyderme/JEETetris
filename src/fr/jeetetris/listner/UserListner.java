package fr.jeetetris.listner;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.models.Tetrimino;
import fr.jeetetris.models.User;

/**
 * Application Lifecycle Listener implementation class UserListner
 *
 */
@WebListener
public class UserListner implements ServletContextListener {
	public List<User> users;
	
    /**
     * Default constructor. 
     */
    public UserListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         users = new ArrayList<User>();
         users.add(new User("titome", "mdp", "Thomas", "Thomas"));
         users.add(new User("pbouv", "mdp", "Pierre", "Pierre"));
         
         sce.getServletContext().setAttribute("users", users);
                  
         ApplicationContext myContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
         @SuppressWarnings("unchecked")
		IDAO<Tetrimino> tetriminoDAO = (IDAO<Tetrimino>)myContext.getBean("tetriminoDAO");
         sce.getServletContext().setAttribute("tetriminos", tetriminoDAO.findAll());
    }
	
}
