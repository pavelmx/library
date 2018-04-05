/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author павел
 */
@Stateless
public class BookOfIssueFacade extends AbstractFacade<BookOfIssue> {

    @PersistenceContext(unitName = "libraryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookOfIssueFacade() {
        super(BookOfIssue.class);
    }
    
    public Collection checkr() {
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
Calendar cal = Calendar.getInstance();
//System.out.println(dateFormat.format(cal.getTime()));
        Date d = new Date();
       Query query =  em.createQuery("SELECT b FROM BookOfIssue b");
       
     Collection<BookOfIssue> bk = query.getResultList();
     
    
       return bk;
    }
    
}
