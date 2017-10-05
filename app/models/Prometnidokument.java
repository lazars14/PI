
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
public class Prometnidokument extends Model{

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    public Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "vrstaDokumenta")
    public String vrstaDokumenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "redniBrojDokumenta")
    public int redniBrojDokumenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumFormiranja")
    @Temporal(TemporalType.DATE)
    public Date datumFormiranja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumKnjizenja")
    @Temporal(TemporalType.DATE)
    public Date datumKnjizenja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statusDokumenta")
    public Character statusDokumenta;
    @JoinColumn(name = "magacin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public Magacin magacin;
    @JoinColumn(name = "poslovniPartner", referencedColumnName = "id")
    @ManyToOne(optional = false)
    public Poslovnipartner poslovniPartner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prometniDokument")
    public Collection<Stavkadokumenta> stavkadokumentaCollection;
    public Prometnidokument(Integer id, String vrstaDokumenta, int redniBrojDokumenta, Date datumFormiranja, Date datumKnjizenja, Character statusDokumenta) {
        this.id = id;
        this.vrstaDokumenta = vrstaDokumenta;
        this.redniBrojDokumenta = redniBrojDokumenta;
        this.datumFormiranja = datumFormiranja;
        this.datumKnjizenja = datumKnjizenja;
        this.statusDokumenta = statusDokumenta;
    }
}
