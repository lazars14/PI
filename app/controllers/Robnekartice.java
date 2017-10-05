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

	public static void create(Integer id, BigDecimal cena, int pocStanjeKol, BigDecimal pocStanjeVrednosti, int prometUlazaKol, BigDecimal prometUlazaVr, int prometIzlazaKol, BigDecimal prometIzlazaVr, int ukKol, BigDecimal ukVrednost) {
		
		Robnakartica robnakartica = new Robnakartica();
		robnakartica.id = Integer.parseInt(id.toString());
		robnakartica.cena = cena;
		robnakartica.pocStanjeKol = pocStanjeKol;
		robnakartica.pocStanjeVrednosti = pocStanjeVrednosti;
		robnakartica.prometUlazaKol = prometUlazaKol;
		robnakartica.prometUlazaVr = prometUlazaVr;
		robnakartica.prometIzlazaKol = prometIzlazaKol;
		robnakartica.prometIzlazaVr = prometIzlazaVr;
		robnakartica.ukKol = ukKol;
		robnakartica.ukVrednost = ukVrednost;
		robnakartica.save();
	}
	
	public static void update(Integer id, BigDecimal cena, int pocStanjeKol, BigDecimal pocStanjeVrednosti, int prometUlazaKol, BigDecimal prometUlazaVr, int prometIzlazaKol, BigDecimal prometIzlazaVr, int ukKol, BigDecimal ukVrednost) {
		
		Robnakartica r = Robnakartica.findById(id);
		r.id = Integer.parseInt(id.toString());
		r.cena = cena;
		r.pocStanjeKol = pocStanjeKol;
		r.pocStanjeVrednosti = pocStanjeVrednosti;
		r.prometUlazaKol = prometUlazaKol;
		r.prometUlazaVr = prometUlazaVr;
		r.prometIzlazaKol = prometIzlazaKol;
		r.prometIzlazaVr = prometIzlazaVr;
		r.ukKol = ukKol;
		r.ukVrednost = ukVrednost;
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
