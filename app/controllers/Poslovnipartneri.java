package controllers;

import java.util.List;

import models.Poslovnipartner;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Poslovnipartneri extends Controller {

	public static void read(){
		List<Poslovnipartner> poslovnipartneri = Poslovnipartner.findAll();
	
		render(poslovnipartneri);
	}
	
	public static void create(Integer id, String tipPartnera , String nazivPartnera, String pib, String adresa){
		Poslovnipartner pp = new Poslovnipartner(Integer.parseInt(id.toString()), tipPartnera, nazivPartnera, pib, adresa);
		pp.save();
		
		read();
	}

	
	public static void update(Integer id, String tipPartnera , String nazivPartnera, String pib, String adresa){
			Poslovnipartner pp = Poslovnipartner.findById(id);
			pp.id = Integer.parseInt(id.toString());
			pp.tipPartnera = tipPartnera;
			pp.nazivPartnera = nazivPartnera;
			pp.pib = pib;
			pp.adresa = adresa;
			pp.save();
			
			read();
	}
	
	public static void delete (Integer id){
		Poslovnipartner pp = Poslovnipartner.findById(id);
		pp.delete();
		
		read();
	}
	
	public static void filter(){
		
	}
}
