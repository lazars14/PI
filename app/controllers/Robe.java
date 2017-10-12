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
		List<Gruparoba> grupeRoba = Gruparoba.findAll();
		List<Jedinicamere> jediniceMere = Jedinicamere.findAll();
		
		render(robe, grupeRoba, jediniceMere);
	}
	
	public static void create(String naziv, Integer pakovanje, Long grupaRobe, Long jedinicaMere) {
		Gruparoba roba = Gruparoba.findById(grupaRobe);
		Jedinicamere mera = Jedinicamere.findById(jedinicaMere);
		Roba r = new Roba(naziv, pakovanje, roba, mera);
		r.save();
		
		read();
	}
	
	public static void update(Long id, String naziv, Integer pakovanje, Long grupaRobe, Long jedinicaMere) {
		
		Roba r = Roba.findById(id);
		r.naziv = naziv;
		r.pakovanje = pakovanje;
		r.grupaRobe = Gruparoba.findById(grupaRobe);
		r.jedinicaMere = Jedinicamere.findById(jedinicaMere);
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
