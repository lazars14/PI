package models;

import java.io.Serializable;
import java.util.Collection;
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
    public Integer id;
    @Column(nullable = false)
    public String tipPartnera;
    @Column(nullable = false)
    public String nazivPartnera;
    @Column(nullable = false)
    public String pib;
    @Column(nullable = false)
    public String adresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poslovniPartner")
    public Collection<Prometnidokument> prometnidokumentCollection;
    @JoinColumn(name = "preduzece", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public Preduzece preduzece;
    @JoinColumn(name = "mesto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public Mesto mesto;
    public Poslovnipartner(Integer id, String tipPartnera, String nazivPartnera, String pib, String adresa) {
        this.id = id;
        this.tipPartnera = tipPartnera;
        this.nazivPartnera = nazivPartnera;
        this.pib = pib;
        this.adresa = adresa;
    }   
}
