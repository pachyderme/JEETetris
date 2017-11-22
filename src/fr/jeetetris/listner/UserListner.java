package fr.jeetetris.listner;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.jeetetris.models.Tetris;
import fr.jeetetris.models.User;

/**
 * Application Lifecycle Listener implementation class UserListner
 *
 */
@WebListener
public class UserListner implements ServletContextListener {
	public List<User> users;
	public Tetris tetris;
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
         
         tetris = new Tetris();
         
         sce.getServletContext().setAttribute("tetris", tetris);
    }
	
}
