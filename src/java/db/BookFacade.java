/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author павел
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> {

    @PersistenceContext(unitName = "libraryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }
    
    public List<Book> FindBook(String findStr){
        
         Query sel = em.createQuery("FROM Book b WHERE b.namebook LIKE :findStr ");
         sel.setParameter("findStr", "%"+findStr+"%");
         System.out.println(sel.getResultList());
         //System.out.println(findStr);
         
     return sel.getResultList();
     }
    
}
