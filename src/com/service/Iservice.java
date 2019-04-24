package com.service;

import java.util.List;

import com.metier.Formation;
import com.metier.Promo;
import com.metier.Stagiaire;

public interface Iservice {
	
	public int ajouterStagiaire (Stagiaire s);
	public int supprimerStagiaire (int idStagiaire);
	public Stagiaire getStagiaire (int idStagiaire);
	public List<Stagiaire> findAll();
	
	public int ajouterPromo (Promo p);
	public int supprimerPromo (int idPromo);
	public Promo getPromo (int idPromo);
	public List<Promo> findAllPromo();
	
	public int ajouterFormation (Formation f);
	public int supprimerFormation (int idFormation);
	public Formation getFormation (int idFormation);
	public List<Formation> findAllFormation();
}
