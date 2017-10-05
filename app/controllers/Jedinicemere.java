package controllers;

import java.util.List;

import models.Jedinicamere;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Jedinicemere extends Controller {

	public static void read(){
		List<Jedinicamere> jedinice = Jedinicamere.findAll();
		
		render(jedinice);
	}
	
	public static void create(String naziv){
		Jedinicamere mera = new Jedinicamere(naziv);
		mera.save();
		
		read();
	}

	public static void update(Long id, String naziv){
		Jedinicamere mera = Jedinicamere.findById(id);
		mera.naziv = naziv;
		mera.save();
		
		read();
	}

	public static void delete(Long id){
		Jedinicamere mera = Jedinicamere.findById(id);
		mera.delete();
		
		read();
	}

	public static void filter(){
	
	}
	
}
