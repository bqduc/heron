
package net.brilliant.entity.emx;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.brilliant.ccs.GlobalSharedConstants;
import net.brilliant.framework.validation.StrictlyPositiveNumber;

/**
 * 
 * @author MOHAMMED BOUNAGA
 * 
 * github.com/medbounaga
 */

@Entity
@Table(name = "sale_order_line")
@NamedQueries({            
    @NamedQuery(name = "SaleOrderLine.findByProduct", query = "SELECT s FROM SaleOrderLine s WHERE s.product.id = :productId"),  
    @NamedQuery(name = "SaleOrderLine.countByProduct", query = "SELECT SUM(s.quantity) FROM SaleOrderLine s WHERE s.product.id = :productId "),
    @NamedQuery(name = "SaleOrderLine.findAll", query = "SELECT s FROM SaleOrderLine s"),
    @NamedQuery(name = "SaleOrderLine.findById", query = "SELECT s FROM SaleOrderLine s WHERE s.id = :id"),
    @NamedQuery(name = "SaleOrderLine.findByDate", query = "SELECT s FROM SaleOrderLine s WHERE s.date = :date"),
    @NamedQuery(name = "SaleOrderLine.findByQuantity", query = "SELECT s FROM SaleOrderLine s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "SaleOrderLine.findByPrice", query = "SELECT s FROM SaleOrderLine s WHERE s.price = :price"),
    @NamedQuery(name = "SaleOrderLine.findBySubTotal", query = "SELECT s FROM SaleOrderLine s WHERE s.subTotal = :subTotal"),
    @NamedQuery(name = "SaleOrderLine.findByDiscount", query = "SELECT s FROM SaleOrderLine s WHERE s.discount = :discount"),
    @NamedQuery(name = "SaleOrderLine.findByName", query = "SELECT s FROM SaleOrderLine s WHERE s.name = :name"),
    @NamedQuery(name = "SaleOrderLine.findByActive", query = "SELECT s FROM SaleOrderLine s WHERE s.active = :active"),
    @NamedQuery(name = "SaleOrderLine.findByUom", query = "SELECT s FROM SaleOrderLine s WHERE s.uom = :uom")})
public class SaleOrderLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @StrictlyPositiveNumber(message = "{PositiveQuantity}")
    @Column(name = "quantity")
    private Double quantity = 1d;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Size(max = 40, message = "{LongString}")
    @Column(name = "uom")
    private String uom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private double subTotal;
    @Basic(optional = false)
    @Max(value=100,message="{MaxDiscount}") 
    @Min(value=0,  message = "{PositiveDiscount}") 
    @NotNull
    @Column(name = "discount")
    private double discount = 0d;
    @Size(max = 128, message = "{LongString}")
    @Column(name = GlobalSharedConstants.PROP_NAME)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private Boolean active;
    @NotNull
    @Column(name = "invoiced")
    private Boolean invoiced;
    @Transient
    private String productName;
    @Transient
    private String taxName;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SaleOrder saleOrder;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EnterpriseProduct product;
    @JoinColumn(name = "tax_id", referencedColumnName = "id")
    @ManyToOne
    private EnterpriseTax tax;


    public SaleOrderLine() {
    }

    public SaleOrderLine(Integer id) {
        this.id = id;
    }

    public SaleOrderLine(Integer id, Double quantity, double price, double subTotal, Boolean active) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    public Boolean getInvoiced() {
        return invoiced;
    }

    public void setInvoiced(Boolean invoiced) {
        this.invoiced = invoiced;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public EnterpriseProduct getProduct() {
        return product;
    }

    public void setProduct(EnterpriseProduct product) {
        this.product = product;
    }

    public EnterpriseTax getTax() {
        return tax;
    }

    public void setTax(EnterpriseTax tax) {
        this.tax = tax;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
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
        if (!(object instanceof SaleOrderLine)) {
            return false;
        }
        SaleOrderLine other = (SaleOrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SaleOrderLine[ id=" + id + " ]";
    }
    
}
