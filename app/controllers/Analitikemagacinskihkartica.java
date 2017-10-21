package controllers;

import java.math.BigDecimal;
import java.util.List;

import models.Analitikamagacinskekartice;
import models.Robnakartica;
import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Analitikemagacinskihkartica extends Controller {
	
	public static void read(){
		List<Analitikamagacinskekartice> analitike = Analitikamagacinskekartice.findAll();
        List<Robnakartica> robneKartice = Robnakartica.findAll();
        
        render(analitike,robneKartice);
	}
	
	public static void create(Long redniBroj, String vrstaPrometa, String smer, Long kolicina,
			Long cena, Long vrednost, Long robnaKartica){
		
		Robnakartica rk = Robnakartica.findById(robnaKartica);
		Analitikamagacinskekartice a = new Analitikamagacinskekartice(Integer.parseInt(redniBroj.toString()), vrstaPrometa,
				smer.charAt(0), Integer.parseInt(kolicina.toString()), Double.valueOf(cena), Double.valueOf(vrednost), rk);
		a.save();
		
		read();
	}

	public static void update(Long id, Long redniBroj, String vrstaPrometa, String smer, Long kolicina,
			Long cena, Long vrednost, Long robnaKartica){
		
		Robnakartica rk = Robnakartica.findById(robnaKartica);
		Analitikamagacinskekartice a = Analitikamagacinskekartice.findById(id);
		a.redniBroj = Integer.parseInt(redniBroj.toString());
		a.vrstaPrometa = vrstaPrometa;
		a.smer = smer.charAt(0);
		a.kolicina = Integer.parseInt(kolicina.toString());
		a.cena = Double.valueOf(cena);
		a.vrednost = Double.valueOf(vrednost);
		a.robnaKartica = rk;
		a.save();
		
		read();
	}

	public static void delete(Long id){
		Analitikamagacinskekartice analitikaMagKartice = Analitikamagacinskekartice.findById(id);
    	analitikaMagKartice.delete();
    	
    	read();
	}

	public static void filter(){
	
	}
}
