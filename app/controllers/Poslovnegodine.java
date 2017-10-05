package controllers;

import java.util.Date;
import java.util.List;

import models.Poslovnagodina;

import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Poslovnegodine extends Controller {
	
	

	public static void read(){
		List<Poslovnagodina> poslovnagodina = Poslovnagodina.findAll();
	
		render(poslovnagodina);
	}
	
	public static void create(Integer id, Date godina, boolean zakljucena){
		Poslovnagodina pg = new Poslovnagodina(Integer.parseInt(id.toString()), godina, zakljucena);
		pg.save();
		
		read();
	}

	
	public static void update(Integer id, Date godina, boolean zakljucena){
			Poslovnagodina pg = Poslovnagodina.findById(id);
			pg.id = Integer.parseInt(id.toString());
			pg.godina = godina;
			pg.zakljucena = zakljucena;
			pg.save();
			
			read();
	}
	
	public static void delete (Integer id){
		Poslovnagodina pg = Poslovnagodina.findById(id);
		pg.delete();
		
		read();
	}
	
	public static void filter(){
		
	}

}
