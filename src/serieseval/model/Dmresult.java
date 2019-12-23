/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serieseval.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "dmresult")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dmresult.findAll", query = "SELECT d FROM Dmresult d"),
    @NamedQuery(name = "Dmresult.findByIddatasource", query = "SELECT d FROM Dmresult d WHERE d.dmresultPK.iddatasource = :iddatasource"),
    @NamedQuery(name = "Dmresult.findByIdalgorithm", query = "SELECT d FROM Dmresult d WHERE d.dmresultPK.idalgorithm = :idalgorithm"),
    @NamedQuery(name = "Dmresult.findByIduser", query = "SELECT d FROM Dmresult d WHERE d.dmresultPK.iduser = :iduser"),
    @NamedQuery(name = "Dmresult.findByIdtestoption", query = "SELECT d FROM Dmresult d WHERE d.dmresultPK.idtestoption = :idtestoption"),
    @NamedQuery(name = "Dmresult.findByCorrelationCoefficient", query = "SELECT d FROM Dmresult d WHERE d.correlationCoefficient = :correlationCoefficient"),
    @NamedQuery(name = "Dmresult.findByMeanAbsoluteError", query = "SELECT d FROM Dmresult d WHERE d.meanAbsoluteError = :meanAbsoluteError"),
    @NamedQuery(name = "Dmresult.findByRootMeanSquaredError", query = "SELECT d FROM Dmresult d WHERE d.rootMeanSquaredError = :rootMeanSquaredError"),
    @NamedQuery(name = "Dmresult.findByRelativeAbsoluteError", query = "SELECT d FROM Dmresult d WHERE d.relativeAbsoluteError = :relativeAbsoluteError"),
    @NamedQuery(name = "Dmresult.findByRootRelativeSquareError", query = "SELECT d FROM Dmresult d WHERE d.rootRelativeSquareError = :rootRelativeSquareError"),
    @NamedQuery(name = "Dmresult.findByTestoptionparam", query = "SELECT d FROM Dmresult d WHERE d.testoptionparam = :testoptionparam")})
public class Dmresult implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "correlationCoefficient")
    private double correlationCoefficient;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "meanAbsoluteError")
    private double meanAbsoluteError;
    @Basic(optional = false)
    @Column(name = "rootMeanSquaredError")
    private double rootMeanSquaredError;
    @Basic(optional = false)
    @Column(name = "relativeAbsoluteError")
    private double relativeAbsoluteError;
    @Basic(optional = false)
    @Column(name = "rootRelativeSquareError")
    private double rootRelativeSquareError;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "resultseleccionado")
    private Collection<Experimentgroup> experimentgroupCollection;
    private static final long serialVersionUID = 1L;
    
    protected DmresultPK dmresultPK;
    @Column(name = "testoptionparam")
    private Integer testoptionparam;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "idtestoption", referencedColumnName = "idtestoption", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Testoption testoption;
    @JoinColumn(name = "idalgorithm", referencedColumnName = "idalgorithm", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Algorithm algorithm;
    @JoinColumn(name = "iddatasource", referencedColumnName = "iddatasource", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Datasource datasource;

    public Dmresult() {
    }

    public Dmresult(DmresultPK dmresultPK) {
        this.dmresultPK = dmresultPK;
    }

    public Dmresult(DmresultPK dmresultPK, double correlationCoefficient, double meanAbsoluteError, double rootMeanSquaredError, double relativeAbsoluteError, double rootRelativeSquareError) {
        this.dmresultPK = dmresultPK;
        this.correlationCoefficient = correlationCoefficient;
        this.meanAbsoluteError = meanAbsoluteError;
        this.rootMeanSquaredError = rootMeanSquaredError;
        this.relativeAbsoluteError = relativeAbsoluteError;
        this.rootRelativeSquareError = rootRelativeSquareError;
    }

    public Dmresult(int iddatasource, int idalgorithm, int iduser, int idtestoption) {
        this.dmresultPK = new DmresultPK(iddatasource, idalgorithm, iduser, idtestoption);
    }

    public DmresultPK getDmresultPK() {
        return dmresultPK;
    }

    public void setDmresultPK(DmresultPK dmresultPK) {
        this.dmresultPK = dmresultPK;
    }


    public Integer getTestoptionparam() {
        return testoptionparam;
    }

    public void setTestoptionparam(Integer testoptionparam) {
        this.testoptionparam = testoptionparam;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Testoption getTestoption() {
        return testoption;
    }

    public void setTestoption(Testoption testoption) {
        this.testoption = testoption;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Datasource getDatasource() {
        return datasource;
    }

    public void setDatasource(Datasource datasource) {
        this.datasource = datasource;
    }    

    public Dmresult(Integer id) {
        this.id = id;
    }

    public Dmresult(Integer id, double correlationCoefficient, double meanAbsoluteError, double rootMeanSquaredError, double relativeAbsoluteError, double rootRelativeSquareError) {
        this.id = id;
        this.correlationCoefficient = correlationCoefficient;
        this.meanAbsoluteError = meanAbsoluteError;
        this.rootMeanSquaredError = rootMeanSquaredError;
        this.relativeAbsoluteError = relativeAbsoluteError;
        this.rootRelativeSquareError = rootRelativeSquareError;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    public Collection<Experimentgroup> getExperimentgroupCollection() {
        return experimentgroupCollection;
    }

    public void setExperimentgroupCollection(Collection<Experimentgroup> experimentgroupCollection) {
        this.experimentgroupCollection = experimentgroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dmresult)) {
            return false;
        }
        Dmresult other = (Dmresult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serieseval.model.Dmresult[ id=" + id + " ]";
    }

    public double getCorrelationCoefficient() {
        return correlationCoefficient;
    }

    public void setCorrelationCoefficient(double correlationCoefficient) {
        this.correlationCoefficient = correlationCoefficient;
    }

    public double getMeanAbsoluteError() {
        return meanAbsoluteError;
    }

    public void setMeanAbsoluteError(double meanAbsoluteError) {
        this.meanAbsoluteError = meanAbsoluteError;
    }

    public double getRootMeanSquaredError() {
        return rootMeanSquaredError;
    }

    public void setRootMeanSquaredError(double rootMeanSquaredError) {
        this.rootMeanSquaredError = rootMeanSquaredError;
    }

    public double getRelativeAbsoluteError() {
        return relativeAbsoluteError;
    }

    public void setRelativeAbsoluteError(double relativeAbsoluteError) {
        this.relativeAbsoluteError = relativeAbsoluteError;
    }

    public double getRootRelativeSquareError() {
        return rootRelativeSquareError;
    }

    public void setRootRelativeSquareError(double rootRelativeSquareError) {
        this.rootRelativeSquareError = rootRelativeSquareError;
    }
    
}
