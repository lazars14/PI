package models;

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
import javax.validation.constraints.Size;


import play.db.jpa.Model;

@Entity
public class Roba extends Model{
	
    @Column(nullable = false)
    public String naziv;
    @Column(nullable = false)
    public Integer pakovanje;
    @ManyToOne(optional = false)
    public Gruparoba grupaRobe;
    @ManyToOne(optional = false)
    public Jedinicamere jedinicaMere;
    @OneToMany(mappedBy = "roba")
    public List<Robnakartica> robnakarticaCollection;
    @OneToMany(mappedBy = "roba")
    public List<Stavkadokumenta> stavkadokumentaCollection;


    public Roba(String naziv, Integer pakovanje, Gruparoba gruparoba, Jedinicamere jedinicamere) {
        this.naziv = naziv;
        this.pakovanje = pakovanje;
        this.grupaRobe = gruparoba;
        this.jedinicaMere = jedinicamere;
    }
}
