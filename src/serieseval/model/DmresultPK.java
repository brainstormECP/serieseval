/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serieseval.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Laura
 */
@Embeddable
public class DmresultPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "iddatasource")
    private int iddatasource;
    @Basic(optional = false)
    @Column(name = "idalgorithm")
    private int idalgorithm;
    @Basic(optional = false)
    @Column(name = "iduser")
    private int iduser;
    @Basic(optional = false)
    @Column(name = "idtestoption")
    private int idtestoption;

    public DmresultPK() {
    }

    public DmresultPK(int iddatasource, int idalgorithm, int iduser, int idtestoption) {
        this.iddatasource = iddatasource;
        this.idalgorithm = idalgorithm;
        this.iduser = iduser;
        this.idtestoption = idtestoption;
    }

    public int getIddatasource() {
        return iddatasource;
    }

    public void setIddatasource(int iddatasource) {
        this.iddatasource = iddatasource;
    }

    public int getIdalgorithm() {
        return idalgorithm;
    }

    public void setIdalgorithm(int idalgorithm) {
        this.idalgorithm = idalgorithm;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdtestoption() {
        return idtestoption;
    }

    public void setIdtestoption(int idtestoption) {
        this.idtestoption = idtestoption;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iddatasource;
        hash += (int) idalgorithm;
        hash += (int) iduser;
        hash += (int) idtestoption;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DmresultPK)) {
            return false;
        }
        DmresultPK other = (DmresultPK) object;
        if (this.iddatasource != other.iddatasource) {
            return false;
        }
        if (this.idalgorithm != other.idalgorithm) {
            return false;
        }
        if (this.iduser != other.iduser) {
            return false;
        }
        if (this.idtestoption != other.idtestoption) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serieseval.model.DmresultPK[ iddatasource=" + iddatasource + ", idalgorithm=" + idalgorithm + ", iduser=" + iduser + ", idtestoption=" + idtestoption + " ]";
    }
    
}
