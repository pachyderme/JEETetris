package fr.jeetetris.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.models.Tetrimino;
import fr.jeetetris.models.Tetris;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String LOGIN     = "login";
    public static final String HOME  = "home";
    public static final String USER = "user";
    
    @Autowired
    private IDAO<Tetrimino> tetriminoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/WEB-INF/"+HOME+".jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Deconnexion
		if(request.getParameter("deconnexion") != null) {
			request.getSession().setAttribute(USER, null);
		}
		
		// Ajout tétrimino
		if(request.getServletContext().getAttribute("tetris") != null) {
			//Tetris tetris = (Tetris) request.getServletContext().getAttribute("tetris");
			if(request.getParameter("name") != null && request.getParameter("color") != null) {
				Tetrimino t = new Tetrimino(request.getParameter("color").toString(), request.getParameter("name").toString());
				tetriminoDAO.save(t);
				//tetris.getTetriminos().add(new Tetrimino(TetriminoForm.SQUARE, request.getParameter("color").toString(), request.getParameter("name").toString()));
			}
		}
		
		// Delete tétrimino
		if(request.getParameter("delete") != null) {
			Tetris t = (Tetris) request.getServletContext().getAttribute("tetris");
			List<Tetrimino> tetriminos = t.getTetriminos();
			Tetrimino te2 = null;
			if(tetriminos != null) {
				for(Tetrimino te: tetriminos) {
					if(request.getParameter("delete").equals(te.getName())) {
						te2 = te;
					}
				}
				if(!te2.equals(null)) {
					tetriminos.remove(te2);
				}
			}
		}
		response.sendRedirect("home");
	}

}
