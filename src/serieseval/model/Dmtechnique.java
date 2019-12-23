/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serieseval.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "dmtechnique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dmtechnique.findAll", query = "SELECT d FROM Dmtechnique d"),
    @NamedQuery(name = "Dmtechnique.findByIddmtechnique", query = "SELECT d FROM Dmtechnique d WHERE d.iddmtechnique = :iddmtechnique"),
    @NamedQuery(name = "Dmtechnique.findByName", query = "SELECT d FROM Dmtechnique d WHERE d.name = :name")})
public class Dmtechnique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddmtechnique")
    private Integer iddmtechnique;
    @Column(name = "name")
    private String name;

    public Dmtechnique() {
    }

    public Dmtechnique(Integer iddmtechnique) {
        this.iddmtechnique = iddmtechnique;
    }

    public Integer getIddmtechnique() {
        return iddmtechnique;
    }

    public void setIddmtechnique(Integer iddmtechnique) {
        this.iddmtechnique = iddmtechnique;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddmtechnique != null ? iddmtechnique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dmtechnique)) {
            return false;
        }
        Dmtechnique other = (Dmtechnique) object;
        if ((this.iddmtechnique == null && other.iddmtechnique != null) || (this.iddmtechnique != null && !this.iddmtechnique.equals(other.iddmtechnique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serieseval.model.Dmtechnique[ iddmtechnique=" + iddmtechnique + " ]";
    }
    
}
