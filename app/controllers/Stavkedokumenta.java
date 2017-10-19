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
	
	public static void create(int kolicina, String cena, String vrednost, Long analitikaMagacinskeKartice, Long roba, Long prometniDokument) {
		
		Analitikamagacinskekartice a = Analitikamagacinskekartice.findById(analitikaMagacinskeKartice);
		Roba r = Roba.findById(roba);
		Prometnidokument p = Prometnidokument.findById(prometniDokument);
		Stavkadokumenta stavkadokumenta = new Stavkadokumenta(kolicina, Double.valueOf(cena), Double.valueOf(vrednost), a, r, p);
		stavkadokumenta.save();
		
		Prometnadokumenta.readAll(stavkadokumenta.prometniDokument.id);
	}
	
	public static void update(Long id, int kolicina, String cena, String vrednost, Long analitikaMagacinskeKartice, Long roba, Long prometniDokument) {
		
		Stavkadokumenta s = Stavkadokumenta.findById(id);
		s.kolicina = kolicina;
		s.cena = Double.valueOf(cena);
		s.vrednost  = Double.valueOf(vrednost);
		s.analitikaMagacinskeKartice = Analitikamagacinskekartice.findById(analitikaMagacinskeKartice);
		s.roba = Roba.findById(roba);
		s.prometniDokument = Prometnidokument.findById(prometniDokument);
		s.save();
		
		Prometnadokumenta.readAll(s.prometniDokument.id);
	}
	
	public static void delete(Long id){
		Stavkadokumenta stavkadok = Stavkadokumenta.findById(id);
    	stavkadok.delete();
    	
    	Prometnadokumenta.readAll(stavkadok.prometniDokument.id);
	}

	public static void filter(){
	
	}

}
