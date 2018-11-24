package Dao;

import Resources.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.lang.reflect.Field;
import java.util.List;

public class GoodColorDao implements Dao {

    private static Session session;

    public GoodColorDao(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void create(Object object) {
        Transaction transaction = session.beginTransaction();
        System.out.println(object);
        session.persist(object);
        try {
            Field field = object.getClass().getDeclaredField("Id");
            field.setAccessible(true);
            System.out.println("New record added with ID = " + field.get(object));
        } catch (NoSuchFieldException | IllegalAccessException | HibernateException e) {
            e.printStackTrace();
        }
        transaction.commit();
        //session.close();
    }

    @Override
    public Object read(Class cl, Long id) {
        Object object = session.get(cl, id);
        if (object != null){
            System.out.println(object.toString());
        }else {
            System.out.println("Record with id " + id + " not found");
        }
        return object;
    }

    @Override
    public Object update(Object object) {
        return session.merge(object);
    }

    @Override
    public List readAll(String query) {
        Query readFrom = session.createQuery(query);
        List result = readFrom.list();
        System.out.println(result);
        return result;
    }

    @Override
    public void delete(Object object, Long id) {
        object = session.get(object.getClass(), id);
        if (object != null){
            Transaction transaction = session.beginTransaction();
            System.out.println(object.toString());
            session.delete(object);
            transaction.commit();
            //session.close();
        }else {
            System.out.println("Record with id " + id + " not found");
        }
    }

    public void sessionClose(){
        session.close();
    }
}
