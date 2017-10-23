
package models;

import java.io.Serializable;
import java.util.List;
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
public class Prometnidokument extends Model{

    @Column(nullable = false)
    public String vrstaDokumenta;
    
    @Column(nullable = false)
    public int redniBrojDokumenta;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    public Date datumFormiranja;
    
    @Column(name = "datumKnjizenja")
    @Temporal(TemporalType.DATE)
    public Date datumKnjizenja;
    
    @Column(nullable = false)
    public Character statusDokumenta;
    
    @ManyToOne(optional = false)
    public Magacin magacin;
    @ManyToOne(optional = false)
    public Poslovnipartner poslovniPartner;
    @OneToMany(mappedBy = "prometniDokument")
    public List<Stavkadokumenta> stavkadokumentaList;
 
    public Prometnidokument(String vrstaDokumenta, int redniBrojDokumenta, Date datumFormiranja, Date datumKnjizenja, Character statusDokumenta, Magacin magacin, Poslovnipartner poslovnipartner) {
        this.vrstaDokumenta = vrstaDokumenta;
        this.redniBrojDokumenta = redniBrojDokumenta;
        this.datumFormiranja = datumFormiranja;
        this.datumKnjizenja = datumKnjizenja;
        this.statusDokumenta = statusDokumenta;
        this.magacin = magacin;
        this.poslovniPartner = poslovnipartner;
    }
}
