package co.edu.sena.examplejpa.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author victus
 */
@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByDocument", query = "SELECT e FROM Employee e WHERE e.document = :document"),
    @NamedQuery(name = "Employee.findByFullname", query = "SELECT e FROM Employee e WHERE e.fullname = :fullname"),
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    @NamedQuery(name = "Employee.findByPhone", query = "SELECT e FROM Employee e WHERE e.phone = :phone")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "document")
    private Long document;
    @Basic(optional = false)
    @Column(name = "fullname")
    private String fullname;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<Record> recordCollection;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne
    private EmployeeType typeId;

    public Employee() {
    }

    public Employee(Long document) {
        this.document = document;
    }

    public Employee(Long document, String fullname, String address, String phone) {
        this.document = document;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Record> getRecordCollection() {
        return recordCollection;
    }

    public void setRecordCollection(Collection<Record> recordCollection) {
        this.recordCollection = recordCollection;
    }

    public EmployeeType getTypeId() {
        return typeId;
    }

    public void setTypeId(EmployeeType typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (document != null ? document.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fullname;
    }
    
}
