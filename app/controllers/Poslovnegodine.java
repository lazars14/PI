package controllers;

import java.util.Date;
import java.util.List;

import models.Poslovnagodina;
import models.Preduzece;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Poslovnegodine extends Controller {
	
	

	public static void read(){
		List<Poslovnagodina> poslovneGodine = Poslovnagodina.findAll();
		List<Preduzece> preduzeca = Preduzece.findAll();
	
		render(poslovneGodine, preduzeca);
	}
	
	public static void create(int godina, Long preduzece){
		Preduzece p = Preduzece.findById(preduzece);
		Poslovnagodina pg = new Poslovnagodina(godina, false, p);
		pg.save();
		
		read();
	}

	public static void update(Long id, int godina, boolean zakljucena, Long preduzece){
			Preduzece p = Preduzece.findById(preduzece);
			Poslovnagodina pg = Poslovnagodina.findById(id);
			pg.godina = godina;
			pg.zakljucena = zakljucena;
			pg.preduzece = p;
			pg.save();
			
			read();
	}
	
	public static void delete (Long id){
		Poslovnagodina pg = Poslovnagodina.findById(id);
		pg.delete();
		
		read();
	}
	
	public static void filter(){
		
	}
	
	public static void zakljucivanje(Long id){
		Poslovnagodina pg = Poslovnagodina.findById(id);
		
		
	}
}
