package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import helpers.MaxHelper;
import helpers.PrometniDokumentiHelper;
import models.Analitikamagacinskekartice;
import models.Magacin;
import models.Poslovnipartner;
import models.Prometnidokument;
import models.Roba;
import models.Stavkadokumenta;
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
	
	public static void create(String vrstaDokumenta, Long magacin, Long poslovniPartner){
		MaxHelper maxHelper = new MaxHelper();
		SimpleDateFormat parser = new SimpleDateFormat("YYYY-MM-DD");
		Magacin m = Magacin.findById(magacin);
		Poslovnipartner pp = Poslovnipartner.findById(poslovniPartner);
		Date datumKnjizenjaDate = new Date();
		String statusDokumenta = "F";
		
		try {
			datumKnjizenjaDate = parser.parse("1970-01-01");
		} catch (ParseException e) {
			e.printStackTrace();
			read();
		}
		
		Prometnidokument pd = new Prometnidokument(vrstaDokumenta, maxHelper.getMaxPlusOneId("prometniDokument"), new Date(),
				datumKnjizenjaDate, statusDokumenta.charAt(0), m, pp);
		pd.save();
		
		read();
	}

	
	public static void update(Long id, Integer redniBrojDokumenta, String datumFormiranja, 
			String datumKnjizenja, Character statusDokumenta, Long magacin, Long poslovniPartner){
			
			Prometnidokument pd = Prometnidokument.findById(id);
		
			SimpleDateFormat parser = new SimpleDateFormat("YYYY-MM-DD");
			Date datumFormiranjaDate = new Date();
			Date datumKnjizenjaDate = new Date();
			
			try {
				datumFormiranjaDate = parser.parse(datumFormiranja);
		        datumKnjizenjaDate = parser.parse(datumKnjizenja);
			} catch (ParseException e) {
				e.printStackTrace();
				read();
			}
		
			pd.datumFormiranja = datumFormiranjaDate;
			pd.datumKnjizenja = datumKnjizenjaDate;
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
	
	public static void proknjizi(Long id){
		
	}
	
	public static void storniraj(){
		
	}
	
}
