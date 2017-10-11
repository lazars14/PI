package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Poslovnipartner extends Model {
	
	
    @Column(nullable = false)
    public String tipPartnera;
    @Column(nullable = false)
    public String nazivPartnera;
    @Column(nullable = false)
    public String pib;
    @Column(nullable = false)
    public String adresa;
    @OneToMany(mappedBy = "poslovniPartner")
    public List<Prometnidokument> prometnidokumentCollection;
    @ManyToOne(optional = false)
    public Preduzece preduzece;
 
    @ManyToOne(optional = false)
    public Mesto mesto;
    
    public Poslovnipartner(String tipPartnera, String nazivPartnera, String pib, String adresa, Preduzece preduzece) {
        this.tipPartnera = tipPartnera;
        this.nazivPartnera = nazivPartnera;
        this.pib = pib;
        this.adresa = adresa;
        this.preduzece = preduzece;
        this.mesto = preduzece.mesto;
    }   
}
