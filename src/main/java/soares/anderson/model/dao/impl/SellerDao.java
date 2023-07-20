package soares.anderson.model.dao.impl;

import soares.anderson.dataBase.DataBase;
import soares.anderson.dataBase.DataBaseException;
import soares.anderson.model.dao.Dao;
import soares.anderson.model.entities.Department;
import soares.anderson.model.entities.Seller;

import java.sql.*;
import java.util.List;

public class SellerDao implements Dao<Seller> {
    private Connection connection;

    public SellerDao(Connection connection) {
        this.connection = DataBase.getConnection();
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Seller findById(int id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement("" +
                    "SELECT seller.*,department.Name as DepName\n" +
                    "FROM seller INNER JOIN department\n" +
                    "ON seller.DepartmentId = department.Id\n" +
                    "WHERE seller.Id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Department department = instantieteDepartmente(resultSet);
                return instantieteSeller(resultSet, department);
            }
            return null;
        }
        catch (SQLException e){
            throw new DataBaseException(e.getMessage());
        }
        finally {
            DataBase.closeStatement(preparedStatement);
        }
    }

    public Department instantieteDepartmente(ResultSet resultset) throws SQLException{
        int departmentId = resultset.getInt("DepartmentId");
        Department department = new Department(departmentId);
        department.setName(resultset.getString("DepName"));
        return department;
    }

    public Seller instantieteSeller(ResultSet resultSet, Department department) throws SQLException {
        int sellerId = resultSet.getInt("Id");
        Seller seller = new Seller(sellerId);
        String sellerName = resultSet.getString("Name");
        String sellerEmail = resultSet.getString("Email");
        double sellerBaseSalary = resultSet.getDouble("BaseSalary");

        seller.setName(sellerName);
        seller.setEmail(sellerEmail);
        seller.setBaseSalary(sellerBaseSalary);
        seller.setBirthDate(resultSet.getDate("BirthDate"));
        seller.setDepartment(department);
        return seller;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
