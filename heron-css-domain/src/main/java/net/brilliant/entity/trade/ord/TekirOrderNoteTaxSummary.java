/*
 * Copyleft 2007-2011 Ozgur Yazilim A.S.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 * http://www.gnu.org/licenses/lgpl.html
 *
 * www.tekir.com.tr
 * www.ozguryazilim.com.tr
 *
 */

package net.brilliant.entity.trade.ord;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.entity.trade.TenderTaxSummaryBase;

/**
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="TRD_ORDER_NOTE_TAX_SUMMARY")
public class TekirOrderNoteTaxSummary extends TenderTaxSummaryBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private TekirOrderNote owner;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TekirOrderNoteTaxSummary)) {
            return false;
        }
        TekirOrderNoteTaxSummary other = (TekirOrderNoteTaxSummary)object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) return false;
        return true;
    }

    @Override
    public String toString() {
        return "com.ut.tekir.entities.TekirOrderNoteTaxSummary[id=" + getId() + "]";
    }

	public TekirOrderNote getOwner() {
		return owner;
	}

	public void setOwner(TekirOrderNote owner) {
		this.owner = owner;
	}
    
}
