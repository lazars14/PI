package controllers;


import java.math.BigDecimal;
import java.util.List;

import models.Analitikamagacinskekartice;
import models.Prometnidokument;
import models.Roba;
import models.Robnakartica;
import models.Stavkadokumenta;
import play.mvc.Controller;
import play.mvc.With;

//@With(Security.class)
public class Stavkedokumenta extends Controller{
	
	public static void read(){
		List<Stavkadokumenta> stavke = Stavkadokumenta.findAll();
		List<Roba> robe = Roba.findAll();
		List<Prometnidokument> dokumenti = Prometnidokument.findAll();
		List<Analitikamagacinskekartice> analitike = Analitikamagacinskekartice.findAll();
		
		render(stavke, robe, dokumenti, analitike);
	}
	
	public static void create(int kolicina, String cena, String vrednost, Long analitika, Long roba, Long prometniDokument) {
		
		Analitikamagacinskekartice a = Analitikamagacinskekartice.findById(analitika);
		Roba r = Roba.findById(roba);
		Prometnidokument p = Prometnidokument.findById(prometniDokument);
		Stavkadokumenta stavka = new Stavkadokumenta(kolicina, Double.valueOf(cena), Double.valueOf(vrednost), a, r, p);
		stavka.save();
		
		read();
	}
	
	public static void update(Long id, int kolicina, String cena, String vrednost, Long analitika, Long roba, Long prometniDokument) {
		
		Stavkadokumenta s = Stavkadokumenta.findById(id);
		s.kolicina = kolicina;
		s.cena = Double.valueOf(cena);
		s.vrednost  = Double.valueOf(vrednost);
		s.analitikaMagacinskeKartice = Analitikamagacinskekartice.findById(analitika);
		s.roba = Roba.findById(roba);
		s.prometniDokument = Prometnidokument.findById(prometniDokument);
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
