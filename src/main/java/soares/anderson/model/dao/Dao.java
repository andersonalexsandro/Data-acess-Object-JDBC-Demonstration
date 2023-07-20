package soares.anderson.model.dao;

import soares.anderson.model.entities.Department;

import java.util.List;

public interface Dao <T>{
     void insert(T obj);
     void update(T obj);
     void deleteById(int id);
     T findById(Integer id);
     List<T> findAll();
}
