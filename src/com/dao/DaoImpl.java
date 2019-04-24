package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.metier.Formation;
import com.metier.Promo;
import com.metier.Stagiaire;

public class DaoImpl implements Idao {

	private Connection connect;
	private PreparedStatement st; // classe qui va permettre de faire les requetes 
	private ResultSet rs;
	@Override
	public int ajouterStagiaire(Stagiaire s) {
		// TODO Auto-generated method stub
		
		try {
			//1- se connecter a la base de données
			connect = GestionConnexion.getInstance();
		
			//2- Préparer et effectuer la requête
			st = connect.prepareStatement("INSERT INTO Stagiaire(nomStagiaire, prenomStagiaire, age)"// SQL dans le java
			+ " VALUES(?,?,?)");
		
			st.setString(1,  s.getNom());// je passe le premier éléments c'est-à-dire le nom
			st.setString(2,  s.getPrenom());
			st.setInt(3,  s.getAge());
			System.out.println("ligne23");
			st.executeUpdate();
			System.out.println("ligne 24");
			//3- récupérer le résultat en cas de besoin , quand pas de select la 3eme n'a pas d'utilité 
			
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//ou sysout ("erreur")
	}
		return s.getId();
		
	}

	@Override
	public int supprimerStagiaire(int idStagiaire) {
		// TODO Auto-generated method stub
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			//2- préparer effectuer la requête
			st = connect.prepareStatement("DELETE FROM Stagiaire where idStagiaire=?");
			st.setInt(1, idStagiaire);
			st.executeUpdate();
			//3- récupérer le résultat en cas de besoin			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	

	@Override
	public Stagiaire getStagiaire(int idStagiaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stagiaire> findAll() {
		// TODO Auto-generated method stub
			List<Stagiaire> list = new ArrayList<Stagiaire>();
	
		
		try {
			//1- se connecter a la base de données
			connect = GestionConnexion.getInstance();
		
			//2- Préparer et effectuer la requête
			st = connect.prepareStatement("SELECT * FROM Stagiaire") ;
					
					
			 rs= st.executeQuery();
			
			//3- récupérer le résultat en cas de besoin , quand pas de select la 3eme n'a pas d'utilité 
			//rs est une sorte de pointeur vers la bdd, il est avant/devant le premier enregistrement
			while(rs.next()) {// on regarde devant 
				Stagiaire s = new Stagiaire();
				s.setId(rs.getInt("idStagiaire"));// méthode du rs
				s.setNom(rs.getString("nomStagiaire"));
				s.setPrenom(rs.getString("prenomStagiaire"));
				s.setAge(rs.getInt("age"));
				
				list.add(s); // rajout dans la liste
		} 
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//ou sysout ("erreur")
	}
		return list;
	}

	@Override
	public int ajouterPromo(Promo p) {
		// TODO Auto-generated method stub
		try {
			//1- se connecter a la base de données
			connect = GestionConnexion.getInstance();
		
			//2- Préparer et effectuer la requête
			st = connect.prepareStatement("INSERT INTO Promo(nomSession, effectif)"// SQL dans le java
			+ " VALUES(?,?)");
		
			st.setString(1,  p.getNomSession());// je passe le premier éléments c'est-à-dire le nom
			st.setInt(2,  p.getEffectifPromo());
	
			st.executeUpdate();
		
			//3- récupérer le résultat en cas de besoin , quand pas de select la 3eme n'a pas d'utilité 
			
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//ou sysout ("erreur")
	}
		return p.getIdPromo();
		
	}
	

	@Override
	public int supprimerPromo(int idPromo) {
		// TODO Auto-generated method stub
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			//2- préparer effectuer la requête
			st = connect.prepareStatement("DELETE FROM Promo where idPromo=?");
			st.setInt(1, idPromo);
			st.executeUpdate();
			//3- récupérer le résultat en cas de besoin			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Promo getPromo(int idPromo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promo> findAllPromo() {
		// TODO Auto-generated method stub
List<Promo> list = new ArrayList<Promo>();
	
		
		try {
			//1- se connecter a la base de données
			connect = GestionConnexion.getInstance();
		
			//2- Préparer et effectuer la requête
			st = connect.prepareStatement("SELECT * FROM Promo") ;
					
					
			 rs= st.executeQuery();
			
			//3- récupérer le résultat en cas de besoin , quand pas de select la 3eme n'a pas d'utilité 
			//rs est une sorte de pointeur vers la bdd, il est avant/devant le premier enregistrement
			while(rs.next()) {// on regarde devant 
				Promo p = new Promo();
				p.setIdPromo(rs.getInt("idPromo"));// méthode du rs
				p.setNomSession(rs.getString("nomSession"));
				p.setEffectifPromo(rs.getInt("effectif"));
				
				list.add(p); // rajout dans la liste
		} 
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//ou sysout ("erreur")
	}
		return list;
	}

	@Override
	public int ajouterFormation(Formation f) {
		// TODO Auto-generated method stub
		try {
			//1- se connecter a la base de données
			connect = GestionConnexion.getInstance();
		
			//2- Préparer et effectuer la requête
			st = connect.prepareStatement("INSERT INTO Formation(nomFormation)"// SQL dans le java
			+ " VALUES(?)");
		
			st.setString(1,  f.getNomFormation());// je passe le premier éléments c'est-à-dire le nom
			
			st.executeUpdate();
			
			//3- récupérer le résultat en cas de besoin , quand pas de select la 3eme n'a pas d'utilité 
			
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//ou sysout ("erreur")
	}
		return f.getIdFormation();
	}

	@Override
	public int supprimerFormation(int idFormation) {
		// TODO Auto-generated method stub
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			//2- préparer effectuer la requête
			st = connect.prepareStatement("DELETE FROM Formation where idFormation=?");
			st.setInt(1, idFormation);
			st.executeUpdate();
			//3- récupérer le résultat en cas de besoin			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Formation getFormation(int idFormation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	
	
	public List<Formation> findAllFormation() {
		// TODO Auto-generated method stub
		List<Formation> list = new ArrayList<Formation>();
	
		
		try {
			//1- se connecter a la base de données
			connect = GestionConnexion.getInstance();
		
			//2- Préparer et effectuer la requête
			st = connect.prepareStatement("SELECT * FROM Formation") ;
					
					
			 rs= st.executeQuery();
			
			//3- récupérer le résultat en cas de besoin , quand pas de select la 3eme n'a pas d'utilité 
			//rs est une sorte de pointeur vers la bdd, il est avant/devant le premier enregistrement
			while(rs.next()) {// on regarde devant 
				Formation f = new Formation();
				f.setIdFormation(rs.getInt("idFormation"));// méthode du rs
				f.setNomFormation(rs.getString("nomFormation"));
				
				
				list.add(f); // rajout dans la liste
		} 
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();//ou sysout ("erreur")
	}
		return list;
	}

	@Override
	public void attribuerPromoFormation(Promo p, Formation f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attribuerStagiairePromo(Stagiaire s, Promo p) {
		// TODO Auto-generated method stub
		
	}

}
