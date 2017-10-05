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

import play.db.jpa.Model;

@Entity
public class Poslovnagodina extends Model {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    public Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "godina")
    @Temporal(TemporalType.DATE)
    public Date godina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zakljucena")
    public boolean zakljucena;
    @JoinColumn(name = "preduzece", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public Preduzece preduzece;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poslovnaGodina")
    public Collection<Robnakartica> robnakarticaCollection;    

    public Poslovnagodina(Integer id, Date godina, boolean zakljucena) {
        this.id = id;
        this.godina = godina;
        this.zakljucena = zakljucena;
    }  
}
