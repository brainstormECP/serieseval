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
@Table(name = "dmgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dmgroup.findAll", query = "SELECT d FROM Dmgroup d"),
    @NamedQuery(name = "Dmgroup.findByIdgroup", query = "SELECT d FROM Dmgroup d WHERE d.idgroup = :idgroup"),
    @NamedQuery(name = "Dmgroup.findByName", query = "SELECT d FROM Dmgroup d WHERE d.name = :name")})
public class Dmgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgroup")
    private Integer idgroup;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgroup")
    private Collection<Algorithm> algorithmCollection;

    public Dmgroup() {
    }

    public Dmgroup(Integer idgroup) {
        this.idgroup = idgroup;
    }

    public Dmgroup(Integer idgroup, String name) {
        this.idgroup = idgroup;
        this.name = name;
    }

    public Integer getIdgroup() {
        return idgroup;
    }

    public void setIdgroup(Integer idgroup) {
        this.idgroup = idgroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Algorithm> getAlgorithmCollection() {
        return algorithmCollection;
    }

    public void setAlgorithmCollection(Collection<Algorithm> algorithmCollection) {
        this.algorithmCollection = algorithmCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgroup != null ? idgroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dmgroup)) {
            return false;
        }
        Dmgroup other = (Dmgroup) object;
        if ((this.idgroup == null && other.idgroup != null) || (this.idgroup != null && !this.idgroup.equals(other.idgroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
