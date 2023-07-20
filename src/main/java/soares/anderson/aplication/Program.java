package soares.anderson.aplication;

import soares.anderson.model.dao.Dao;
import soares.anderson.model.dao.DaoFactory;
import soares.anderson.model.dao.impl.SellerDao;
import soares.anderson.model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Dao sellerDao = DaoFactory.creatSellerDao();
        Seller seller = sellerDao.findById(7);
        System.out.println(seller);
    }
}
