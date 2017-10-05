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
	
		render(dokumenti);
	}
	
	public static void create(String vrstaDokumenta, int redniBrojDokumenta, Date datumFormiranja, Date datumKnjizenja, Character statusDokumenta, Magacin magacin, Poslovnipartner poslovnipartner){
		Prometnidokument pd = new Prometnidokument(vrstaDokumenta, redniBrojDokumenta, datumFormiranja, datumKnjizenja, statusDokumenta, magacin, poslovnipartner);
		pd.save();
		
		read();
	}

	
	public static void update(Long id, String vrstaDokumenta, Integer redniBrojDokumenta, Date datumFormiranja, Date datumKnjizenja, Character statusDokumenta, Magacin magacin, Poslovnipartner poslovnipartner){
			Prometnidokument pd = Prometnidokument.findById(id);
			pd.vrstaDokumenta = vrstaDokumenta;
			pd.redniBrojDokumenta = Integer.parseInt(redniBrojDokumenta.toString());
			pd.datumFormiranja = datumFormiranja;
			pd.datumKnjizenja = datumKnjizenja;
			pd.statusDokumenta = statusDokumenta;
			pd.magacin = magacin;
			pd.poslovniPartner = poslovnipartner;
			
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
