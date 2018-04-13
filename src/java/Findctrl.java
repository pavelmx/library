import db.Book;
import db.BookFacade;
import db.Client;
import db.ClientFacade;

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

/**
 *
 * @author павел
 */
@Named(value = "FindCtrl")
@SessionScoped


public class Findctrl implements Serializable {

    @EJB private db.BookFacade BookFacade;
    @EJB private db.ClientFacade ClientFacade;
    private String findStr;
    private DataModel findResult = null;
    private FindItms current;
    private int selectedItemIndex;
    private PaginationHelper pagination;

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
        
        for(Book b: blst){
        lst.add(new FindItms("Book", "book", b.getNamebook(), b));
        System.out.println(lst.toString());
        }
        for(Client c: clst){
        lst.add(new FindItms("Client", "client", c.getFio(), c));
        System.out.println(lst.toString());
        }
        
        findResult = new ListDataModel(lst);
        
      return "/find/findList";  
    }
    

     
}
