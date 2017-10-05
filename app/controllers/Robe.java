package controllers;

import java.util.List;

import models.Gruparoba;
import models.Jedinicamere;
import models.Radnik;
import models.Roba;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Robe extends Controller{
	
	public static void read() {
		List<Roba> robe = Roba.findAll();
		
		render(robe);
	}
	
	public static void create(String naziv, Integer pakovanje, Gruparoba gruparoba, Jedinicamere jedinicamere) {
		
		Roba r = new Roba(naziv, pakovanje, gruparoba, jedinicamere);
		r.save();
		// comment
		
		read();
	}
	
	public static void update(Long id, String naziv, Integer pakovanje, Gruparoba gruparoba, Jedinicamere jedinicamere) {
		
		Roba r = Roba.findById(id);
		r.naziv = naziv;
		r.pakovanje = pakovanje;
		r.grupaRobe = gruparoba;
		r.jedinicaMere = jedinicamere;
		r.save();
		
		read();
	}
	
	public static void delete(Long id){
		Roba roba = Roba.findById(id);
    	roba.delete();
    	
    	read();
	}

	public static void filter(){
	
	}

}
