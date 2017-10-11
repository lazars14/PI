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
		List<Preduzece> preduzeca = Preduzece.findAll();
		
		render(radnici, preduzeca);
	}
	
	public static void create(String ime, String prezime, String jmbg, String adresa, String radnoMesto, String korisnickoIme, String lozinka, Long preduzece) {
		Preduzece p = Preduzece.findById(preduzece);
		Radnik r = new Radnik(ime, prezime, jmbg, adresa, radnoMesto, korisnickoIme, lozinka, p);
		r.save();
		
		read();
	}
	
	public static void update(Long id, String ime, String prezime, String jmbg, String adresa, String radnoMesto, String korisnickoIme, String lozinka, Long preduzece) {
		
		Radnik r = Radnik.findById(id);
		r.ime = ime;
		r.prezime = prezime;
		r.jmbg = jmbg;
		r.adresa = adresa;
		r.radnoMesto = radnoMesto;
		r.korisnickoIme = korisnickoIme;
		r.lozinka = lozinka;
		r.preduzece = Preduzece.findById(preduzece);
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
