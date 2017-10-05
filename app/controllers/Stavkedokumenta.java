package controllers;


import java.math.BigDecimal;
import java.util.List;

import models.Robnakartica;
import models.Stavkadokumenta;
import play.mvc.Controller;
import play.mvc.With;

//@With(Security.class)
public class Stavkedokumenta extends Controller{
	
	public static void read() {
		
		List<Stavkadokumenta> stavkeDok = Stavkadokumenta.findAll();
		
		render(stavkeDok);
		//comment
	}
	
	public static void crete(Integer id, int kolicina, BigDecimal cena, BigDecimal vrednost) {
		
		Stavkadokumenta stavkadokumenta = new Stavkadokumenta();
		stavkadokumenta.id = Integer.parseInt(id.toString());
		stavkadokumenta.kolicina  = kolicina;
		stavkadokumenta.cena = cena;
		stavkadokumenta.vrednost = vrednost;
		stavkadokumenta.save();
	}
	
	public static void update(Integer id, int kolicina, BigDecimal cena, BigDecimal vrednost) {
		
		Stavkadokumenta s = Stavkadokumenta.findById(id);
		s.id = Integer.parseInt(id.toString());
		s.kolicina = kolicina;
		s.cena = cena;
		s.vrednost  = vrednost;
		
		s.save();
		
		read();
		
	}
	
	public static void delete(Long id){
		Stavkadokumenta stavkadok = Stavkadokumenta.findById(id);
    	stavkadok.delete();
    	
    	read();
	}

	public static void filter(){
	
	}

}
