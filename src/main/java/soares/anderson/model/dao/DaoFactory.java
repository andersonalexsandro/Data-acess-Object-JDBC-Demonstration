package soares.anderson.model.dao;


import soares.anderson.dataBase.DB;
import soares.anderson.model.dao.impl.DepartmentDaoJDBC;
import soares.anderson.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
