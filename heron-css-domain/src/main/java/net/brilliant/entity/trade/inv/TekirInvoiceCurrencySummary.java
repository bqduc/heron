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

package net.brilliant.entity.trade.inv;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.brilliant.entity.general.MoneySet;
import net.brilliant.entity.trade.TenderCurrencySummaryBase;


/**
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="TRD_INVOICE_CURRENCY_SUMMARY")
public class TekirInvoiceCurrencySummary extends TenderCurrencySummaryBase {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private TekirInvoice owner;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TekirInvoiceCurrencySummary)) {
            return false;
        }
        TekirInvoiceCurrencySummary other = (TekirInvoiceCurrencySummary)object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) return false;
        return true;
    }

    @Override
    public String toString() {
        return "TekirInvoiceCurrencySummary[id=" + getId() + "]";
    }

    public TekirInvoiceCurrencySummary clone() {
    	TekirInvoiceCurrencySummary clonedcs = new TekirInvoiceCurrencySummary();
    	clonedcs.setAmount(new MoneySet(getAmount()));
    	return clonedcs;
    }
    
	public TekirInvoice getOwner() {
		return owner;
	}

	public void setOwner(TekirInvoice owner) {
		this.owner = owner;
	}

}
