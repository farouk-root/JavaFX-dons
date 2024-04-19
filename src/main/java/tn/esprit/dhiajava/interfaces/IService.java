package tn.esprit.dhiajava.interfaces;

import java.util.List;

public interface IService<T> {
    public void add(T t);
    public void update(T t , int id);
    public void delete(int id);
    public List<T> getAll();
    public T getById(int id);
}
