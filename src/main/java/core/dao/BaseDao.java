package core.dao;

import java.util.List;

public interface BaseDao<T> {

    List<T> getAll();

    T getById(int id);

    void add(T entityObj);

    void delete(T entityObj);

    void addOrUpdate(T entityObj);

    void update(T entityObj);
}