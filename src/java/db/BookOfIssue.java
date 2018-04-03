/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author павел
 */
@Entity
@Table(name = "book_of_issue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookOfIssue.findAll", query = "SELECT b FROM BookOfIssue b")
    , @NamedQuery(name = "BookOfIssue.findById", query = "SELECT b FROM BookOfIssue b WHERE b.id = :id")
    , @NamedQuery(name = "BookOfIssue.findByBook", query = "SELECT b FROM BookOfIssue b WHERE b.book = :book")
    , @NamedQuery(name = "BookOfIssue.findByDateofissue", query = "SELECT b FROM BookOfIssue b WHERE b.dateofissue = :dateofissue")
    , @NamedQuery(name = "BookOfIssue.findByReturndate", query = "SELECT b FROM BookOfIssue b WHERE b.returndate = :returndate")})
public class BookOfIssue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "Book")
    private Integer book;
    @Column(name = "Date_of_issue")
    @Temporal(TemporalType.DATE)
    private Date dateofissue;
    @Column(name = "Return_date")
    @Temporal(TemporalType.DATE)
    private Date returndate;
    @JoinColumn(name = "Client", referencedColumnName = "id")
    @ManyToOne
    private Client client;
    @JoinColumn(name = "Librarian", referencedColumnName = "id")
    @ManyToOne
    private Librarian librarian;

    public BookOfIssue() {
    }

    public BookOfIssue(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Date getDateofissue() {
        return dateofissue;
    }

    public void setDateofissue(Date dateofissue) {
        this.dateofissue = dateofissue;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
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
        if (!(object instanceof BookOfIssue)) {
            return false;
        }
        BookOfIssue other = (BookOfIssue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.BookOfIssue[ id=" + id + " ]";
    }
    
}
