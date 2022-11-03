/*
* In the file we create an Interface for generic types
* */
package com.simploncloneweb.simplon_clone_web.DAO;

import java.util.List;
import java.util.Map;

public interface IGenericDOA<T> {
    public T get(Class<T> tClass,Integer id);
    public boolean save(T object);
    public boolean update(T object);
    public boolean deleteId(Class<T> tClass, int id);

    public List<T> getAll(Class<T> tClass);
    public List<T> query(Class<T> tClass, String hsql, Map<String,Object> params);
}
