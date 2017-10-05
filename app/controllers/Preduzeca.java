package controllers;

import java.util.List;

import models.Preduzece;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Preduzeca extends Controller {
	
	public static void read(){
		List<Preduzece> preduzeca = Preduzece.findAll();
	
		render(preduzeca);
	}
	
	public static void create(Integer id, String naziv, String pib, String adresa){
		Preduzece pr = new Preduzece(Integer.parseInt(id.toString()), naziv, pib, adresa);
		pr.save();
		
		read();
	}

	
	public static void update(Integer id, String naziv, String pib, String adresa){
			Preduzece pr = Preduzece.findById(id);
			pr.id = Integer.parseInt(id.toString());
			pr.naziv = naziv;
			pr.pib = pib;
			pr.adresa = adresa;
			pr.save();
			
			read();
	}
	
	public static void delete (Integer id){
		Preduzece pr = Preduzece.findById(id);
		pr.delete();
		
		read();
	}
	
	public static void filter(){
		
	}

}
