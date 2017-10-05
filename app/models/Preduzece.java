
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
public class Preduzece extends Model {

	
    @Column(nullable = false)
    public Integer id;
    
    @Column(nullable = false)
    public String naziv;
    
    @Column(nullable = false)
    public String pib;
    
    @Column(nullable = false)
    public String adresa;
    @JoinColumn(name = "mesto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public Mesto mesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preduzece")
    public Collection<Poslovnagodina> poslovnagodinaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preduzece")
    public Collection<Gruparoba> gruparobaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preduzece")
    public Collection<Poslovnipartner> poslovnipartnerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preduzece")
    public Collection<Radnik> radnikCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preduzece")
    public Collection<Magacin> magacinCollection;
    public Preduzece(Integer id, String naziv, String pib, String adresa) {
        this.id = id;
        this.naziv = naziv;
        this.pib = pib;
        this.adresa = adresa;
    }

    
}
