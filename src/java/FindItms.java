
import db.Book;
import java.util.List;

public class FindItms {

    public  FindItms(){}
    
    private String table;
    private String site;
    private String info;
    private Object obj;

    public String getTable() {
        return table;
    }

    public String getSite() {
        return site;
    }

    public String getInfo() {
        return info;
    }

    public Object getObj() {
        return obj;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
    
    public  FindItms( String table,String site,String info,Object obj){
        this.info = info;
        this.obj =obj;
        this.site =site;
        this.table =table;
    }
    
    @Override
    public String toString(){
     
        return this.info;
    }
    
}
