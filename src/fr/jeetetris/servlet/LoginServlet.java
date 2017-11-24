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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.jeetetris.dao.IDAO;
import fr.jeetetris.dao.IUserDAO;
import fr.jeetetris.models.Tetrimino;
import fr.jeetetris.models.User;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/testl")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Autowired
    private IUserDAO userDAO;
	private String msg = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		if(request.getSession().getAttribute("user") != null) {
			response.sendRedirect("home");
		}else {
			this.getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		if(request.getParameter("identifier") != null && request.getParameter("password") != null) {
			User u = userDAO.findByIdentifier(request.getParameter("identifier"),request.getParameter("password"));
			if(u != null) {
					request.getSession().setAttribute("user", u);
				}
				else
				{
					msg = "Echec de la connexion";
					request.setAttribute("msg", msg);
				}
			
		}
		doGet(request, response);
	}

}
