package fr.jeetetris.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String HOME     = "/WEB-INF/home.jsp";
    public static final String ADMIN_HOME  = "/WEB-INF/admin_home.jsp";
    public static final String USER = "user";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      On récupère la session dans la requète
		HttpSession session = request.getSession();
//		Si l'utilisateur n'est pas connecté alors on le redirige vers la page d'accueil : HOME
        if ( session.getAttribute( USER ) == null ) {
            response.sendRedirect( request.getContextPath() + HOME );
        } else {
//        	Sinon, on le redirige vers la destination
            this.getServletContext().getRequestDispatcher( ADMIN_HOME ).forward( request, response );
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
