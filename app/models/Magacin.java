/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
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
public class Magacin extends Model {

	@Column(nullable = false)
    public String naziv;
	
	@ManyToOne(optional = false)
    public Preduzece preduzece;

    @OneToMany(mappedBy = "magacin")
    public List<Prometnidokument> prometnidokumentCollection;
    @OneToMany(mappedBy = "magacin")
    public List<Robnakartica> robnakarticaCollection;    
    
    public Magacin(String naziv, Preduzece preduzece) {
        this.naziv = naziv;
        this.preduzece = preduzece;
    }
}
