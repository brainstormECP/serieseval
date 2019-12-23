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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "datasource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datasource.findAll", query = "SELECT d FROM Datasource d"),
    @NamedQuery(name = "Datasource.findByIddatasource", query = "SELECT d FROM Datasource d WHERE d.iddatasource = :iddatasource"),
    @NamedQuery(name = "Datasource.findByName", query = "SELECT d FROM Datasource d WHERE d.name = :name")})
public class Datasource implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddatasource")
    private Integer iddatasource;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "idexperimentgroup", referencedColumnName = "idexperimentgroup")
    @ManyToOne(optional = false)
    private Experimentgroup idexperimentgroup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datasource")
    private Collection<Dmresult> dmresultCollection;

    public Datasource() {
    }

    public Datasource(Integer iddatasource) {
        this.iddatasource = iddatasource;
    }

    public Datasource(Integer iddatasource, String name) {
        this.iddatasource = iddatasource;
        this.name = name;
    }

    public Integer getIddatasource() {
        return iddatasource;
    }

    public void setIddatasource(Integer iddatasource) {
        this.iddatasource = iddatasource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Experimentgroup getIdexperimentgroup() {
        return idexperimentgroup;
    }

    public void setIdexperimentgroup(Experimentgroup idexperimentgroup) {
        this.idexperimentgroup = idexperimentgroup;
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
        hash += (iddatasource != null ? iddatasource.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datasource)) {
            return false;
        }
        Datasource other = (Datasource) object;
        if ((this.iddatasource == null && other.iddatasource != null) || (this.iddatasource != null && !this.iddatasource.equals(other.iddatasource))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getName();
    }    
    
}
