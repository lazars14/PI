/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
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
public class Gruparoba extends Model {

	@Column(nullable = false)
    public String naziv;
    
	@OneToMany(mappedBy = "grupaRobe")
    public Collection<Roba> robaCollection;
	
    @ManyToOne(optional = false)
    public Preduzece preduzece;
    
    public Gruparoba(String naziv, Preduzece preduzece) {
        this.naziv = naziv;
        this.preduzece = preduzece;
    }
}
