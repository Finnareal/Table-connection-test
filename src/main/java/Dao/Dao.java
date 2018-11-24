package Dao;

import java.util.List;

public interface Dao {

    void create(Object object);
    Object read(Class cl, Long id);
    Object update(Object object);
    List readAll(String query);
    void delete(Object object, Long id);

}
