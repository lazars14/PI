
package models;

import java.io.Serializable;
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
public class Preduzece extends Model {
    
    @Column(nullable = false)
    public String naziv;
    
    @Column(nullable = false)
    public String pib;
    
    @Column(nullable = false)
    public String adresa;
    
    @ManyToOne(optional = false)
    public Mesto mesto;
    @OneToMany(mappedBy = "preduzece")
    public List<Poslovnagodina> poslovnagodinaList;
    @OneToMany(mappedBy = "preduzece")
    public List<Gruparoba> gruparobaList;
    @OneToMany(mappedBy = "preduzece")
    public List<Poslovnipartner> poslovnipartnerList;
    @OneToMany(mappedBy = "preduzece")
    public List<Radnik> radnikList;
    @OneToMany(mappedBy = "preduzece")
    public List<Magacin> magacinList;
    
    public Preduzece(String naziv, String pib, String adresa, Mesto mesto) {
        this.naziv = naziv;
        this.pib = pib;
        this.adresa = adresa;
        this.mesto = mesto;
    }

    
}
