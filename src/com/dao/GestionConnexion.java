package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GestionConnexion {

	

	private String url="jdbc:postgresql://localhost:5432/SyntheseJEE";
	private String user="postgres";
	private String passwd="1988remi";
	
	// objet connexion 
	
	private static Connection connect;// static commun à tous les package
// constructeur privé : permet de créer une connexion 
	private GestionConnexion() {// je change public en private, c'est un constructeur, 
		
		try {
			System.out.println("AVant");
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection(url, user, passwd);
			System.out.println("Apres");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erreur de connexion");
		}
	}
	
	// méthode d'attribution de connexion
	
	public static Connection getInstance() { 
		if(connect == null) {  // pour créer une instance de connexion
			new GestionConnexion();
		} 
		return connect; // sinon j'utilise celle qui existe 
	}
	
	
	
}
