import db.Book;
import db.BookController;
import db.BookFacade;
import db.Client;
import db.ClientController;
import db.ClientFacade;
import db.IFind;
import db.Librarian;
import db.LibrarianController;
import db.LibrarianFacade;

import db.util.JsfUtil;
import db.util.PaginationHelper;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author павел
 */
@Named(value = "FindCtrl")
@SessionScoped


public class Findctrl implements Serializable {

    
    @EJB private db.BookFacade BookFacade;
    @EJB private db.ClientFacade ClientFacade;
    @EJB private db.LibrarianFacade LibrarianFacade;
    @Inject private BookController bookCtrl;
    @Inject private ClientController clientCtrl;
    @Inject private LibrarianController librarianCtrl;

    private String findStr;
    private DataModel findResult = null;
 
    
     public LibrarianFacade getLibrarianFacade() {
        return LibrarianFacade;
    }
     
    public Findctrl() {
    }
    
    public void setFindStr(String findStr) {
        this.findStr = findStr;
    }

    public void setFindResult(DataModel findResult) {
        this.findResult = findResult;
    }

    public String getFindStr() {
        return findStr;
    }

    public DataModel getFindResult() {
        return findResult;
    }
            
    private BookFacade getBookFacade() {
       return BookFacade;
    }
    
    public ClientFacade getClientFacade() {
        return ClientFacade;
    }
    
    public String goFind(){
    
        List<FindItms> lst = new LinkedList();
        List<Book> blst = getBookFacade().FindBook(findStr);
        List<Client> clst = getClientFacade().FindClient(findStr);
        List<Librarian> llst = getLibrarianFacade().FindLibrarian(findStr);
        
        for(Book b: blst){
        lst.add(new FindItms("Book", "book", b.getNamebook(), b, bookCtrl));
        System.out.println(lst.toString());
        }
        for(Librarian l: llst){
        lst.add(new FindItms("Librarian", "librarian", l.getName(), l, librarianCtrl));
        System.out.println(lst.toString());
        }
        for(Client c: clst){
        lst.add(new FindItms("Client", "client", c.getFio(), c, clientCtrl));
        System.out.println(lst.toString());
        }
        
        findResult = new ListDataModel(lst);
        
      return "/findList";  
    }
     
    public String goToList(){
        
        FindItms f = (FindItms) getFindResult().getRowData();
        String d = (f.getSite() + "/" + f.getCtrl().prepareList());
        System.out.println(d);
        return d;
    }
    
    public String deleteItm(){
        
        FindItms f = (FindItms) getFindResult().getRowData();
        System.out.println("delete "+f.getTable());
        //clientCtrl.setCurrentself(f.getObj());
      f.getCtrl().setCurrentself(f.getObj());
       f.getCtrl().prepareDestroy();
        return goFind();
    }
    
    public String editItm(){
        
        FindItms f = (FindItms) getFindResult().getRowData();
       f.getCtrl().setCurrentself(f.getObj());
        System.out.println(f.getSite());
        return f.getSite() + "/Edit";
    }
}
