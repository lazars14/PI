package controllers;

import java.math.BigDecimal;
import java.util.List;

import models.Magacin;
import models.Poslovnagodina;
import models.Roba;
import models.Robnakartica;
import play.mvc.With;
import play.mvc.*;

//@With(Secure.class)
public class Robnekartice extends Controller{

	public static void read() {
    	List<Robnakartica> robneKartice = Robnakartica.findAll();
    	//List<Roba> robe = Roba.findAll();
    	//List<Magacin> magacini = Magacin.findAll();
    	//List<Poslovnagodina> poslovneGodine = Poslovnagodina.findAll();
    	//comment
    	
    	render(robneKartice);
	}

	public static void create(BigDecimal cena, int pocStanjeKol, BigDecimal pocStanjeVrednosti, int prometUlazaKol, BigDecimal prometUlazaVr, int prometIzlazaKol,
								BigDecimal prometIzlazaVr, int ukKol, BigDecimal ukVrednost, Poslovnagodina poslovnagodina, Magacin magacin, Roba roba) {
		
		Robnakartica robnakartica = new Robnakartica(cena, pocStanjeKol, pocStanjeVrednosti, prometUlazaKol, prometUlazaVr, prometIzlazaKol, prometIzlazaVr, ukKol, ukVrednost, poslovnagodina, magacin, roba);
		robnakartica.save();
	}
	
	public static void update(Long id, BigDecimal cena, int pocStanjeKol, BigDecimal pocStanjeVrednosti, int prometUlazaKol, BigDecimal prometUlazaVr, int prometIzlazaKol,
			BigDecimal prometIzlazaVr, int ukKol, BigDecimal ukVrednost, Poslovnagodina poslovnagodina, Magacin magacin, Roba roba) {
		
		Robnakartica r = Robnakartica.findById(id);
		r.cena = cena;
		r.pocStanjeKol = pocStanjeKol;
		r.pocStanjeVrednosti = pocStanjeVrednosti;
		r.prometUlazaKol = prometUlazaKol;
		r.prometUlazaVr = prometUlazaVr;
		r.prometIzlazaKol = prometIzlazaKol;
		r.prometIzlazaVr = prometIzlazaVr;
		r.ukKol = ukKol;
		r.ukVrednost = ukVrednost;
		r.poslovnaGodina = poslovnagodina;
		r.magacin = magacin;
		r.roba = roba;
		r.save();
		
		read();
	}
	
	public static void delete(Long id){
		Robnakartica robkart = Robnakartica.findById(id);
    	robkart.delete();
    	
    	read();
	}

	public static void filter(){
	
	}
}
