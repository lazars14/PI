package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	public static void create(String vrstaDokumenta, int redniBrojDokumenta, String datumFormiranja,
			Character statusDokumenta, Long magacin, Long poslovniPartner){
		
		SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
		Magacin m = Magacin.findById(magacin);
		Poslovnipartner pp = Poslovnipartner.findById(poslovniPartner);
		Date datumFormiranjaDate = new Date();
		
		try {
			datumFormiranjaDate = parser.parse(datumFormiranja);
		} catch (ParseException e) {
			e.printStackTrace();
			read();
		}
		
		Prometnidokument pd = new Prometnidokument(vrstaDokumenta, redniBrojDokumenta, datumFormiranjaDate,
				null, statusDokumenta.charValue(), m, pp);
		pd.save();
		
		read();
	}

	
	public static void update(Long id, String vrstaDokumenta, Integer redniBrojDokumenta, String datumFormiranja, 
			String datumKnjizenja, Character statusDokumenta, Long magacin, Long poslovniPartner){
			
			if(vrstaDokumenta.equals("Pr")){
				
			} else if(vrstaDokumenta.equals("Ot")){
				
			} else if(vrstaDokumenta.equals("Mm")){
				
			}
		
			SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
			Date datumFormiranjaDate = new Date();
			Date datumKnjizenjaDate = new Date();
			
			try {
				datumFormiranjaDate = parser.parse(datumFormiranja);
		        datumKnjizenjaDate = parser.parse(datumKnjizenja);
			} catch (ParseException e) {
				e.printStackTrace();
				read();
			}
		
			Prometnidokument pd = Prometnidokument.findById(id);
			pd.vrstaDokumenta = vrstaDokumenta;
			pd.redniBrojDokumenta = Integer.parseInt(redniBrojDokumenta.toString());
			pd.datumFormiranja = datumFormiranjaDate;
			pd.datumKnjizenja = datumKnjizenjaDate;
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
	
	public static void readAll(Long docId) {
		List<Prometnidokument> dokumenti = Prometnidokument.findAll();
		List<Magacin> magacini = Magacin.findAll();
		List<Poslovnipartner> partneri = Poslovnipartner.findAll();
		List<Stavkadokumenta> stavke = Stavkadokumenta.find("byPrometniDokument", docId).fetch();
		List<Roba> robe = Roba.findAll();
		List<Analitikamagacinskekartice> analitike = Analitikamagacinskekartice.findAll();
		
		render(dokumenti, magacini, partneri, stavke, robe, analitike);
	}
	
}
