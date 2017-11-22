package fr.jeetetris.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jeetetris.models.Tetrimino;
import fr.jeetetris.models.Tetrimino.TetriminoForm;
import fr.jeetetris.models.Tetris;
import fr.jeetetris.models.User;

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
//      On récupère la session dans la requète
		HttpSession session = request.getSession();
//		Si l'utilisateur n'est pas connecté alors on le redirige vers la page d'accueil : HOME
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
		if(request.getServletContext().getAttribute("tetris") != null) {
			Tetris tetris = (Tetris) request.getServletContext().getAttribute("tetris");
			if(request.getParameter("name") != null && request.getParameter("color") != null) {
				tetris.getTetriminos().add(new Tetrimino(TetriminoForm.SQUARE, request.getParameter("color").toString(), request.getParameter("name").toString()));
			}
		}
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
		doGet(request, response);
	}

}
