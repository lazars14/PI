package controllers;

import java.util.List;

import models.Magacin;
import models.Preduzece;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Magacini extends Controller {
	
	public static void read(){
		List<Magacin> magacini = Magacin.findAll();
		// List<Preduzece> preduzeca = Preduzece.findAll();
		
		render(magacini);
	}
	
	public static void create(String naziv){
		Preduzece preduzece = Preduzece.findById(1);
		Magacin magacin = new Magacin(naziv, preduzece);
		magacin.save();
		
		read();
	}

	public static void update(Long id, String naziv){
		Preduzece preduzece = Preduzece.findById(1);
		Magacin magacin = Magacin.findById(id);
		magacin.naziv = naziv;
		magacin.preduzece = preduzece;
		magacin.save();
		
		read();
	}

	public static void delete(Long id){
		Magacin magacin = Magacin.findById(id);
		magacin.delete();
		
		read();
	}

	public static void filter(){
	
	}
	
}
