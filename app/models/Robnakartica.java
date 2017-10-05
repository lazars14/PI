package models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import play.db.jpa.Model;

@Entity
public class Robnakartica extends Model{
	
    @Column(nullable = false)
    public BigDecimal cena;
    @Column(nullable = false)
    public int pocStanjeKol;
    @Column(nullable = false)
    public BigDecimal pocStanjeVrednosti;
    @Column(nullable = false)
    public int prometUlazaKol;
    @Column(nullable = false)
    public BigDecimal prometUlazaVr;
    @Column(nullable = false)
    public int prometIzlazaKol;
    @Column(nullable = false)
    public BigDecimal prometIzlazaVr;
    @Column(nullable = false)
    public int ukKol;
    @Column(nullable = false)
    public BigDecimal ukVrednost;
    @OneToMany(mappedBy = "robnaKartica")
    public List<Analitikamagacinskekartice> analitikamagacinskekarticeCollection;
    @ManyToOne(optional = false)
    public Poslovnagodina poslovnaGodina;
    @ManyToOne(optional = false)
    public Magacin magacin;
    @ManyToOne(optional = false)
    public Roba roba;

    public Robnakartica(BigDecimal cena, int pocStanjeKol, BigDecimal pocStanjeVrednosti, int prometUlazaKol, BigDecimal prometUlazaVr, int prometIzlazaKol,
    					BigDecimal prometIzlazaVr, int ukKol, BigDecimal ukVrednost, Poslovnagodina poslovnagodina, Magacin magacin, Roba roba) {
        this.cena = cena;
        this.pocStanjeKol = pocStanjeKol;
        this.pocStanjeVrednosti = pocStanjeVrednosti;
        this.prometUlazaKol = prometUlazaKol;
        this.prometUlazaVr = prometUlazaVr;
        this.prometIzlazaKol = prometIzlazaKol;
        this.prometIzlazaVr = prometIzlazaVr;
        this.ukKol = ukKol;
        this.ukVrednost = ukVrednost;
        this.poslovnaGodina = poslovnagodina;
        this.magacin = magacin;
        this.roba = roba;
    }

	public Robnakartica() {
		// TODO Auto-generated constructor stub
	}

}
