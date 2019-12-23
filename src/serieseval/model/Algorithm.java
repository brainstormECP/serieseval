/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serieseval.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "algorithm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Algorithm.findAll", query = "SELECT a FROM Algorithm a"),
    @NamedQuery(name = "Algorithm.findByIdalgorithm", query = "SELECT a FROM Algorithm a WHERE a.idalgorithm = :idalgorithm"),
    @NamedQuery(name = "Algorithm.findByName", query = "SELECT a FROM Algorithm a WHERE a.name = :name")})
public class Algorithm implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalgorithm")
    private Integer idalgorithm;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "algorithm")
    private Collection<Dmresult> dmresultCollection;
    @JoinColumn(name = "idgroup", referencedColumnName = "idgroup")
    @ManyToOne(optional = false)
    private Dmgroup idgroup;

    public Algorithm() {
    }

    public Algorithm(Integer idalgorithm) {
        this.idalgorithm = idalgorithm;
    }

    public Algorithm(Integer idalgorithm, String name) {
        this.idalgorithm = idalgorithm;
        this.name = name;
    }

    public Integer getIdalgorithm() {
        return idalgorithm;
    }

    public void setIdalgorithm(Integer idalgorithm) {
        Integer oldIdalgorithm = this.idalgorithm;
        this.idalgorithm = idalgorithm;
        changeSupport.firePropertyChange("idalgorithm", oldIdalgorithm, idalgorithm);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    @XmlTransient
    public Collection<Dmresult> getDmresultCollection() {
        return dmresultCollection;
    }

    public void setDmresultCollection(Collection<Dmresult> dmresultCollection) {
        this.dmresultCollection = dmresultCollection;
    }

    public Dmgroup getIdgroup() {
        return idgroup;
    }

    public void setIdgroup(Dmgroup idgroup) {
        Dmgroup oldIdgroup = this.idgroup;
        this.idgroup = idgroup;
        changeSupport.firePropertyChange("idgroup", oldIdgroup, idgroup);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalgorithm != null ? idalgorithm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Algorithm)) {
            return false;
        }
        Algorithm other = (Algorithm) object;
        if ((this.idalgorithm == null && other.idalgorithm != null) || (this.idalgorithm != null && !this.idalgorithm.equals(other.idalgorithm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getName() + " (" + getIdgroup().getName() + ")";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
