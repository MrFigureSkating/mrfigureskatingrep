package main.java.manager;

import main.java.entity.Person;
import main.java.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ArsenyPC on 02.11.2014.
 */
public class Manager
{
    public static boolean checkPersonByName(String name)
    {
        Session session=null;
        Person person=null;
        boolean result=false;
        try
        {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql="FROM Person P WHERE P.name = :name";
            Query query=session.createQuery(hql);
            query.setParameter("name",name);
            List list=query.list();
            if (list.size()!=0)
                result=true;
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()))
                session.close();
        }
        return result;
    }

    public static void save(Object person)
    {
        Session session=null;
        try
        {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(person);
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()))
                session.close();
        }
    }
}
