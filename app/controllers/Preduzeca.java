package controllers;

import java.util.List;

import models.Mesto;
import models.Preduzece;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Preduzeca extends Controller {
	
	public static void read(){
		List<Preduzece> preduzeca = Preduzece.findAll();
		List<Mesto> mesta = Mesto.findAll();
		
		render(preduzeca, mesta);
	}
	
	public static void create(String naziv, String pib, String adresa, Long mesto){
		Mesto m = Mesto.findById(mesto);
		Preduzece pr = new Preduzece(naziv, pib, adresa, m);
		pr.save();
		
		read();
	}

	
	public static void update(Long id, String naziv, String pib, String adresa, Long mesto){
			Mesto m = Mesto.findById(mesto);
			Preduzece pr = Preduzece.findById(id);
			pr.naziv = naziv;
			pr.pib = pib;
			pr.adresa = adresa;
			pr.mesto = m;
			pr.save();
			
			read();
	}
	
	public static void delete (Long id){
		Preduzece pr = Preduzece.findById(id);
		pr.delete();
		
		read();
	}
	
	public static void filter(){
		
	}

}
