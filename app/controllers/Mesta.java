package controllers;

import java.util.List;

import models.Mesto;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Mesta extends Controller {
	
	public static void read(){
		List<Mesto> mesta = Mesto.findAll();
		
		render(mesta);
	}
	
	public static void create(String naziv, String pttOznaka){
		Mesto mesto = new Mesto(naziv, pttOznaka);
		mesto.save();
		
		read();
	}

	public static void update(Long id, String naziv, String pttOznaka){
		Mesto mesto = Mesto.findById(id);
		mesto.naziv = naziv;
		mesto.pttOznaka = pttOznaka;
		mesto.save();
		
		read();
	}

	public static void delete(Long id){
		Mesto mesto = Mesto.findById(id);
		mesto.delete();
		
		read();
	}

	public static void filter(){
		
	}
	
}
