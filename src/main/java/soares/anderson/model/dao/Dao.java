package soares.anderson.model.dao;

import soares.anderson.model.entities.Seller;

import java.util.List;

public interface Dao <T>{
     void insert(T obj);
     void update(T obj);
     void deleteById(int id);
     Seller findById(int id);
     List<T> findAll();
}
