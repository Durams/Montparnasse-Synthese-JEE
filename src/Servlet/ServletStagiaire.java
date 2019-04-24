package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Stagiaire;
import com.service.Iservice;
import com.service.ServiceImpl;

/**
 * Servlet implementation class ServletStagiaire
 */
@WebServlet("/ServletStagiaire")
public class ServletStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Iservice service = new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStagiaire() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1 récupération des données
				/*String nom = request.getParameter("lastname");// info récupérer , le client parle 
				String prenom = request.getParameter("firstname"); 
				int age = Integer.parseInt(request.getParameter("age"));
				
				//2 envoyer à la couche service
				Personne p = new Personne();
				p.setAge(age);
				p.setNom(nom);
				p.setPrenom(prenom);
				
				service.ajouterPersonne(p);
				
				//3 faire appel à la JSP, preparation à l'envoi
				request.setAttribute("personnes",  service.findAll());
				/*request.setAttribute("lenom", nom );
				request.setAttribute("leprenom", prenom );
				request.setAttribute("lage", age );*/
				
				//1- récupération des données        
				String nom;        
				String prenom;        
				int age;        
				if(request.getParameter("lastname")!=null) {            
					age = Integer.parseInt(request.getParameter("age"));            
					nom = request.getParameter("lastname");            
					prenom = request.getParameter("firstname");        
					
					//2- envoyer à la couche service        
					Stagiaire s = new Stagiaire();        
					s.setAge(age);        
					s.setNom(nom);        
					s.setPrenom(prenom);                
					service.ajouterStagiaire(s);        }        
				
				//3 - préparation à l'envoi        
				request.setAttribute("Stagiaires", service.findAll());                
				
				//4- appel de la jsp        
				request.getRequestDispatcher("Stagiaire.jsp").forward(request, response);
				}
	

          
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
