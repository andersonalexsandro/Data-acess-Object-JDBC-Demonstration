package soares.anderson.Db.model;

public class DataBaseIntegrityException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DataBaseIntegrityException(String msg){
        super(msg);
    }
}
