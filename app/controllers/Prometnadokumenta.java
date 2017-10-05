package controllers;

import java.util.Date;
import java.util.List;

import models.Prometnidokument;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Prometnadokumenta extends Controller{
	
	public static void read(){
		List<Prometnidokument> dokumenti = Prometnidokument.findAll();
	
		render(dokumenti);
	}
	
	public static void create(Integer id, String vrstaDokumenta, Integer redniBrojDokumenta, Date datumFormiranja, Date datumKnjizenja, Character statusDokumenta){
		Prometnidokument pd = new Prometnidokument(Integer.parseInt(id.toString()), vrstaDokumenta, redniBrojDokumenta, datumFormiranja, datumKnjizenja, statusDokumenta);
		pd.save();
		
		read();
	}

	
	public static void update(Integer id, String vrstaDokumenta, Integer redniBrojDokumenta, Date datumFormiranja, Date datumKnjizenja, Character statusDokumenta){
			Prometnidokument pd = Prometnidokument.findById(id);
			pd.id = Integer.parseInt(id.toString());
			pd.vrstaDokumenta = vrstaDokumenta;
			pd.redniBrojDokumenta = Integer.parseInt(redniBrojDokumenta.toString());
			pd.datumFormiranja = datumFormiranja;
			pd.datumKnjizenja = datumKnjizenja;
			pd.statusDokumenta = statusDokumenta;
			pd.save();
			
			read();
	}
	
	public static void delete (Integer id){
		Prometnidokument pr = Prometnidokument.findById(id);
		pr.delete();
		
		read();
	}
	
	public static void filter(){
		
	}

}
