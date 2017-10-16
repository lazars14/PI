package models;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import play.db.jpa.Model;

@Entity
public class Stavkadokumenta extends Model{


    @Column(nullable = false)
    public int kolicina;
    @Column(nullable = false)
    public Double cena;
    @Column(nullable = false)
    public Double vrednost;
    @ManyToOne(optional = false)
    public Analitikamagacinskekartice analitikaMagacinskeKartice;
    @ManyToOne(optional = false)
    public Roba roba;
    @ManyToOne(optional = false)
    public Prometnidokument prometniDokument;


    public Stavkadokumenta(int kolicina, Double cena, Double vrednost, Analitikamagacinskekartice analitikamagacinskekartice, Roba roba, Prometnidokument prometnidokument) {
        this.kolicina = kolicina;
        this.cena = cena;
        this.vrednost = vrednost;
        this.analitikaMagacinskeKartice = analitikamagacinskekartice;
        this.roba = roba;
        this.prometniDokument = prometnidokument;
    }
}
