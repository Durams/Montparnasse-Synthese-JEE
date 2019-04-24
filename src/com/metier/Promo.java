package com.metier;

public class Promo {
 private int idPromo;
 private String nomSession;
 private int effectifPromo;

 public int getIdPromo() {
	return idPromo;
}
public void setIdPromo(int idPromo) {
	this.idPromo = idPromo;
}
public String getNomSession() {
	return nomSession;
}
public void setNomSession(String nomSession) {
	this.nomSession = nomSession;
}
public int getEffectifPromo() {
	return effectifPromo;
}
public void setEffectifPromo(int effectifPromo) {
	this.effectifPromo = effectifPromo;
}
@Override
public String toString() {
	return "Promo [idPromo=" + idPromo + ", nomSession=" + nomSession + ", effectifPromo=" + effectifPromo + "]";
}
 
 
}
