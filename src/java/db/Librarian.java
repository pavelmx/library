/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author павел
 */
@Entity
@Table(name = "librarian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarian.findAll", query = "SELECT l FROM Librarian l")
    , @NamedQuery(name = "Librarian.findById", query = "SELECT l FROM Librarian l WHERE l.id = :id")
    , @NamedQuery(name = "Librarian.findByName", query = "SELECT l FROM Librarian l WHERE l.name = :name")})
public class Librarian implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @OneToMany(mappedBy = "librarian")
    private Collection<BookOfIssue> bookOfIssueCollection;

    public Librarian() {
    }

    public Librarian(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<BookOfIssue> getBookOfIssueCollection() {
        return bookOfIssueCollection;
    }

    public void setBookOfIssueCollection(Collection<BookOfIssue> bookOfIssueCollection) {
        this.bookOfIssueCollection = bookOfIssueCollection;
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
        if (!(object instanceof Librarian)) {
            return false;
        }
        Librarian other = (Librarian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Librarian[ id=" + id + " ]";
    }
    
}
