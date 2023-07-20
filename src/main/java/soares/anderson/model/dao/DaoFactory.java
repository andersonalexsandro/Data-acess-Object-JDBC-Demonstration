package soares.anderson.model.dao;

import soares.anderson.dataBase.DataBase;
import soares.anderson.model.dao.impl.DepartmentDao;
import soares.anderson.model.dao.impl.SellerDao;

public class DaoFactory {

    public static Dao creatSellerDao(){
        return new SellerDao(DataBase.getConnection());
    }

    public static Dao creatDeparmentDao(){
        return new DepartmentDao();
    }
}
