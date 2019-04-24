package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Iservice;
import com.service.ServiceImpl;

/**
 * Servlet implementation class ServletSupprimerStag
 */
@WebServlet("/ServletSupprimerStag")
public class ServletSupprimerStag extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Iservice service = new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprimerStag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int id = Integer.parseInt(request.getParameter("idStagiaire"));
		service.supprimerStagiaire(id);
		
		//3 - préparation à l'envoi        
		request.setAttribute("Stagiaires", service.findAll());                
		
		//4- appel de la jsp        
		request.getRequestDispatcher("Stagiaire.jsp").forward(request,  response);      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
