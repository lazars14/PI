/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import play.db.jpa.Model;


@Entity
public class Analitikamagacinskekartice extends Model {

	@Column(nullable = false)
    public int redniBroj;
	@Column(nullable = false)
    public String vrstaPrometa;
	@Column(nullable = false)
    public Character smer;
	@Column(nullable = false)
    public int kolicina;
	@Column(nullable = false)
    public Double cena;
	@Column(nullable = false)
    public Double vrednost;
    
    @ManyToOne(optional = false)
    public Robnakartica robnaKartica;
    
    @OneToMany(mappedBy = "analitikaMagacinskeKartice")
    public List<Stavkadokumenta> stavkadokumentaCollection;
    
    public Analitikamagacinskekartice(int redniBroj, String vrstaPrometa, Character smer, int kolicina, Double cena, Double vrednost, Robnakartica robnaKartica) {
        this.redniBroj = redniBroj;
        this.vrstaPrometa = vrstaPrometa;
        this.smer = smer;
        this.kolicina = kolicina;
        this.cena = cena;
        this.vrednost = vrednost;
        this.robnaKartica = robnaKartica;
    }
    
}
