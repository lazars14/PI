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
		List<Poslovnagodina> poslovnagodina = Poslovnagodina.findAll();
	
		render(poslovnagodina);
	}
	
	public static void create(Date godina, boolean zakljucena, Preduzece preduzece){
		Poslovnagodina pg = new Poslovnagodina(godina, zakljucena, preduzece);
		pg.save();
		
		read();
	}

	
	public static void update(Long id, Date godina, boolean zakljucena, Preduzece preduzece){
			Poslovnagodina pg = Poslovnagodina.findById(id);
			pg.godina = godina;
			pg.zakljucena = zakljucena;
			pg.save();
			pg.preduzece = preduzece;
			
			read();
	}
	
	public static void delete (Long id){
		Poslovnagodina pg = Poslovnagodina.findById(id);
		pg.delete();
		
		read();
	}
	
	public static void filter(){
		
	}

}
