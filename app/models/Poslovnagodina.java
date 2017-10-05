/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import play.db.jpa.Model;

@Entity
public class Poslovnagodina extends Model {

    @Column(nullable = false)
    public Date godina;
    @Column(name = "zakljucena")
    public boolean zakljucena;
    
    @ManyToOne(optional = false)
    public Preduzece preduzece;
    
    @OneToMany(mappedBy = "poslovnaGodina")
    public List<Robnakartica> robnakarticaCollection;    

    public Poslovnagodina(Date godina, boolean zakljucena, Preduzece preduzece) {
        this.godina = godina;
        this.zakljucena = zakljucena;
        this.preduzece = preduzece;
    }  
}
