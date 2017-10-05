package controllers;

import java.util.List;

import models.Poslovnipartner;
import models.Preduzece;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Poslovnipartneri extends Controller {

	public static void read(){
		List<Poslovnipartner> poslovnipartneri = Poslovnipartner.findAll();
	
		render(poslovnipartneri);
	}
	
	public static void create(String tipPartnera, String nazivPartnera, String pib, String adresa, Preduzece preduzece){
		Poslovnipartner pp = new Poslovnipartner(tipPartnera, nazivPartnera, pib, adresa, preduzece);
		pp.save();
		
		read();
	}

	
	public static void update(Long id, String tipPartnera , String nazivPartnera, String pib, String adresa, Preduzece preduzece){
			Poslovnipartner pp = Poslovnipartner.findById(id);
			pp.tipPartnera = tipPartnera;
			pp.nazivPartnera = nazivPartnera;
			pp.pib = pib;
			pp.adresa = adresa;
			pp.preduzece = preduzece;
			pp.save();
			
			read();
	}
	
	public static void delete (Long id){
		Poslovnipartner pp = Poslovnipartner.findById(id);
		pp.delete();
		
		read();
	}
	
	public static void filter(){
		
	}
}
