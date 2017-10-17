package controllers;

import java.util.Date;
import java.util.List;

import models.Magacin;
import models.Poslovnipartner;
import models.Prometnidokument;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Prometnadokumenta extends Controller{
	
	public static void read(){
		List<Prometnidokument> dokumenti = Prometnidokument.findAll();
		List<Magacin> magacini = Magacin.findAll();
		List<Poslovnipartner> partneri = Poslovnipartner.findAll();
	
		render(dokumenti, magacini, partneri);
	}
	
	public static void create(String vrstaDokumenta, int redniBrojDokumenta, Date datumFormiranja, Date datumKnjizenja,
			Character statusDokumenta, Long magacin, Long poslovniPartner){
		
		Magacin m = Magacin.findById(magacin);
		Poslovnipartner pp = Poslovnipartner.findById(poslovniPartner);
		Prometnidokument pd = new Prometnidokument(vrstaDokumenta, redniBrojDokumenta, datumFormiranja,
				datumKnjizenja, statusDokumenta.charValue(), m, pp);
		pd.save();
		
		read();
	}

	
	public static void update(Long id, String vrstaDokumenta, Integer redniBrojDokumenta, Date datumFormiranja, 
			Date datumKnjizenja, Character statusDokumenta, Long magacin, Long poslovniPartner){
		
			Prometnidokument pd = Prometnidokument.findById(id);
			pd.vrstaDokumenta = vrstaDokumenta;
			pd.redniBrojDokumenta = Integer.parseInt(redniBrojDokumenta.toString());
			pd.datumFormiranja = datumFormiranja;
			pd.datumKnjizenja = datumKnjizenja;
			pd.statusDokumenta = statusDokumenta.charValue();
			pd.magacin = Magacin.findById(magacin);
			pd.poslovniPartner = Poslovnipartner.findById(poslovniPartner);
			
			pd.save();
			
			read();
	}
	
	public static void delete (Long id){
		Prometnidokument pr = Prometnidokument.findById(id);
		pr.delete();
		
		read();
	}
	
	public static void filter(){
		
	}

}
