package controllers;

import java.util.List;

import models.Preduzece;
import models.Radnik;

import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Radnici extends Controller{
	
	public static void read() {
		List<Radnik> radnici = Radnik.findAll();
		
		render(radnici);
	}
	
	public static void create(Integer id, String ime, String prezime, String jmbg, String adresa, String radnoMesto) {
		
		Radnik r = new Radnik(Integer.parseInt(id.toString()), ime, prezime, jmbg, adresa, radnoMesto);
		r.save();
		
		read();
	}
	
	public static void update(Integer id, String ime, String prezime, String jmbg, String adresa, String radnoMesto) {
		
		Radnik r = Radnik.findById(id);
		r.id = Integer.parseInt(id.toString());
		r.ime = ime;
		r.prezime = prezime;
		r.jmbg = jmbg;
		r.adresa = adresa;
		r.radnoMesto = radnoMesto;
		r.save();
		
		read();
	}
	
	public static void delete(Long id){
		Radnik radnik = Radnik.findById(id);
    	radnik.delete();
    	
    	read();
	}

	public static void filter(){
	
	}

}
