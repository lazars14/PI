
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

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    public Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naziv")
    public String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "pib")
    public String pib;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "adresa")
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
