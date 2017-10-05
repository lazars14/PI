package controllers;

import java.util.List;

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
	
	public static void create(Integer id, String naziv) {
		
		Roba r = new Roba(Integer.parseInt(id.toString()), naziv);
		r.save();
		
		read();
	}
	
	public static void update(Integer id, String naziv) {
		
		Roba r = Roba.findById(id);
		r.id = Integer.parseInt(id.toString());
		r.naziv = naziv;
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
