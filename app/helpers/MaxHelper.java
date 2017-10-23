package helpers;

import javax.persistence.Query;

import play.db.jpa.JPA;

public class MaxHelper {
	
	public int getMaxPlusOneId(String klasa){
		String queryText = "";
		
		if(klasa.equals("analitika")){
			queryText = "select max(a.id) from Analitikamagacinskekartice a";
		} else if(klasa.equals("prometniDokument")){
			queryText = "select max(p.id) from Prometnidokument p";
		}
		
		Query query = JPA.em().createQuery(queryText);
	    Long idLong = (Long) query.getSingleResult();
		
	    if(idLong == null){
	    	idLong = Long.valueOf(0);
	    }
	    
	    int id = idLong.intValue();
	    
		return id + 1;
	}
	
}
