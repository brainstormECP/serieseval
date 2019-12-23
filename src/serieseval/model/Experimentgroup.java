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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "experimentgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experimentgroup.findAll", query = "SELECT e FROM Experimentgroup e"),
    @NamedQuery(name = "Experimentgroup.findByIdexperimentgroup", query = "SELECT e FROM Experimentgroup e WHERE e.idexperimentgroup = :idexperimentgroup"),
    @NamedQuery(name = "Experimentgroup.findByDescription", query = "SELECT e FROM Experimentgroup e WHERE e.description = :description"),
    @NamedQuery(name = "Experimentgroup.findByFecha", query = "SELECT e FROM Experimentgroup e WHERE e.fecha = :fecha")})
public class Experimentgroup implements Serializable {
    @JoinColumn(name = "resultseleccionado", referencedColumnName = "id")
    @ManyToOne
    private Dmresult resultseleccionado;
        
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexperimentgroup")
    private Integer idexperimentgroup;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexperimentgroup")
    private Collection<Datasource> datasourceCollection;

    public Experimentgroup() {
    }

    public Experimentgroup(Integer idexperimentgroup) {
        this.idexperimentgroup = idexperimentgroup;
    }

    public Experimentgroup(Integer idexperimentgroup, String description, Date fecha) {
        this.idexperimentgroup = idexperimentgroup;
        this.description = description;
        this.fecha = fecha;
    }

    public Integer getIdexperimentgroup() {
        return idexperimentgroup;
    }

    public void setIdexperimentgroup(Integer idexperimentgroup) {
        Integer oldIdexperimentgroup = this.idexperimentgroup;
        this.idexperimentgroup = idexperimentgroup;
        changeSupport.firePropertyChange("idexperimentgroup", oldIdexperimentgroup, idexperimentgroup);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    @XmlTransient
    public Collection<Datasource> getDatasourceCollection() {
        return datasourceCollection;
    }

    public void setDatasourceCollection(Collection<Datasource> datasourceCollection) {
        this.datasourceCollection = datasourceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexperimentgroup != null ? idexperimentgroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experimentgroup)) {
            return false;
        }
        Experimentgroup other = (Experimentgroup) object;
        if ((this.idexperimentgroup == null && other.idexperimentgroup != null) || (this.idexperimentgroup != null && !this.idexperimentgroup.equals(other.idexperimentgroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serieseval.model.Experimentgroup[ idexperimentgroup=" + idexperimentgroup + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    public Dmresult getResultseleccionado() {
        return resultseleccionado;
    }

    public void setResultseleccionado(Dmresult resultseleccionado) {
        this.resultseleccionado = resultseleccionado;
    }
    
}
