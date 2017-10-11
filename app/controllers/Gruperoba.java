package controllers;

import java.util.List;

import models.Gruparoba;
import models.Preduzece;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Gruperoba extends Controller {
	
	public static void read(){
		List<Gruparoba> grupeRoba = Gruparoba.findAll();
		List<Preduzece> preduzeca = Preduzece.findAll();
		
		render(grupeRoba, preduzeca);
	}
	
	public static void create(String naziv, Long preduzece){
		Preduzece p = Preduzece.findById(preduzece);
		Gruparoba grupa = new Gruparoba(naziv, p);
		grupa.save();
		
		read();
	}

	public static void update(Long id, String naziv, Long preduzece){
		Preduzece p = Preduzece.findById(preduzece);
		Gruparoba grupa = Gruparoba.findById(id);
		grupa.naziv = naziv;
		grupa.preduzece = p;
		grupa.save();
		
		read();
	}

	public static void delete(Long id){
		Gruparoba grupa = Gruparoba.findById(id);
		grupa.delete();
		
		read();
	}

	public static void filter(){
	
	}
	
}
