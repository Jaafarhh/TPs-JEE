package dao;

import java.util.List;

public interface IDao<T> {
    boolean create(T obj);

    boolean update(T obj);

    boolean delete(T obj);

    T findById(int id);

    List<T> findAll();
}
