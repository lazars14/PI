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
    	List<Roba> robe = Roba.findAll();
    	List<Magacin> magacini = Magacin.findAll();
    	List<Poslovnagodina> poslovneGodine = Poslovnagodina.findAll();
    	
    	render(robneKartice, robe, magacini, poslovneGodine);
	}

	public static void create(String cena, int pocStanjeKol, String pocStanjeVr, int prometUlazaKol, String prometUlazaVr,
			int prometIzlazaKol, String prometIzlazaVr, int ukKol, String ukVr, Long poslovnaGodina, Long magacin,
			Long roba) {
		
		Poslovnagodina pGod = Poslovnagodina.findById(poslovnaGodina);
		Magacin m = Magacin.findById(magacin);
		Roba r = Roba.findById(roba);
		Robnakartica robnakartica = new Robnakartica(Double.valueOf(cena), pocStanjeKol, Double.valueOf(pocStanjeVr),
				prometUlazaKol, Double.valueOf(prometUlazaVr), prometIzlazaKol, Double.valueOf(prometIzlazaVr), ukKol,
				Double.valueOf(ukVr), pGod, m, r);
		robnakartica.save();
		
		read();
	}
	
	public static void update(Long id, String cena, int pocStanjeKol, String pocStanjeVr, int prometUlazaKol,
			String prometUlazaVr, int prometIzlazaKol, String prometIzlazaVr, int ukKol, String ukVr,
			Long poslovnaGodina, Long magacin, Long roba) {
	
		Robnakartica r = Robnakartica.findById(id);
		r.cena = Double.valueOf(cena);
		r.pocStanjeKol = pocStanjeKol;
		r.pocStanjeVrednosti = Double.valueOf(pocStanjeVr);
		r.prometUlazaKol = prometUlazaKol;
		r.prometUlazaVr = Double.valueOf(prometUlazaVr);
		r.prometIzlazaKol = prometIzlazaKol;
		r.prometIzlazaVr = Double.valueOf(prometIzlazaVr);
		r.ukKol = ukKol;
		r.ukVrednost = Double.valueOf(ukVr);
		r.poslovnaGodina = Poslovnagodina.findById(poslovnaGodina);
		r.magacin = Magacin.findById(magacin);
		r.roba = Roba.findById(roba);
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
