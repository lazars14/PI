/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import play.db.jpa.Model;

@Entity
public class Radnik extends Model {

    @Column(nullable = false)
    public String ime;
    @Column(nullable = false)
    public String prezime;
    @Column(nullable = false, unique=true)
    public String jmbg;
    @Column(nullable = false)
    public String adresa;
    @Column(nullable = false)
    public String radnoMesto;
    @Column(nullable = false, unique=true)
    public String korisnickoIme;
    @Column(nullable = false)
    public String lozinka;
    @ManyToOne(optional = false)
    public Preduzece preduzece;
    
    public Radnik(String ime, String prezime, String jmbg, String adresa, String radnoMesto, String korisnickoIme, String lozinka, Preduzece preduzece) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.radnoMesto = radnoMesto;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.preduzece = preduzece;
    }
}
