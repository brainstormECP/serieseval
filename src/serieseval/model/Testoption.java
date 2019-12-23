/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serieseval.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "testoption")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testoption.findAll", query = "SELECT t FROM Testoption t"),
    @NamedQuery(name = "Testoption.findByIdtestoption", query = "SELECT t FROM Testoption t WHERE t.idtestoption = :idtestoption"),
    @NamedQuery(name = "Testoption.findByName", query = "SELECT t FROM Testoption t WHERE t.name = :name")})
public class Testoption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtestoption")
    private Integer idtestoption;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testoption")
    private Collection<Dmresult> dmresultCollection;

    public Testoption() {
    }

    public Testoption(Integer idtestoption) {
        this.idtestoption = idtestoption;
    }

    public Testoption(Integer idtestoption, String name) {
        this.idtestoption = idtestoption;
        this.name = name;
    }

    public Integer getIdtestoption() {
        return idtestoption;
    }

    public void setIdtestoption(Integer idtestoption) {
        this.idtestoption = idtestoption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Dmresult> getDmresultCollection() {
        return dmresultCollection;
    }

    public void setDmresultCollection(Collection<Dmresult> dmresultCollection) {
        this.dmresultCollection = dmresultCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtestoption != null ? idtestoption.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testoption)) {
            return false;
        }
        Testoption other = (Testoption) object;
        if ((this.idtestoption == null && other.idtestoption != null) || (this.idtestoption != null && !this.idtestoption.equals(other.idtestoption))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
}
