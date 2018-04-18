package db;


public interface IFind {
    public String prepareList();
    public String prepareEdit();
    public String prepareView();
    public void prepareDestroy();
    public void setCurrentself(Object o);
    
}
