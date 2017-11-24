package fr.jeetetris.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/test")
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
		if(request.getParameter("name") != null && request.getParameter("color") != null) {
			Tetrimino t = new Tetrimino(request.getParameter("color").toString(), request.getParameter("name").toString());
			tetriminoDAO.save(t);
		}

		// Delete tétrimino
		if(request.getParameter("tetriminoId") != null) {
			Tetrimino t = tetriminoDAO.find(Integer.parseInt(request.getParameter("tetriminoId")));
			tetriminoDAO.delete(t);
		}
		
		response.sendRedirect("home");
	}

}
