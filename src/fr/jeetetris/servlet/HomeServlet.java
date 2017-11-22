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
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String LOGIN     = "login";
    public static final String HOME  = "/home";
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
//      On r�cup�re la session dans la requ�te
		HttpSession session = request.getSession();
//		Si l'utilisateur n'est pas connect� alors on le redirige vers la page d'accueil : HOME
        if ( session.getAttribute( USER ) == null ) {
        	response.sendRedirect(LOGIN);
        } else {
//        	Sinon, on le redirige vers la destination
            this.getServletContext().getRequestDispatcher( "/WEB-INF/"+HOME+".jsp" ).forward( request, response );
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("deconnexion") != null) {
			request.getSession().setAttribute(USER, null);
		}
		doGet(request, response);
	}

}
