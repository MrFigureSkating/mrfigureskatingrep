/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.java.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author Арсений
 */
public class HibernateUtil
{
    private static SessionFactory sessionFactoty;
    static
    {
        try
        {
        sessionFactoty=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }catch(Throwable e)
        {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory()
    {
        return sessionFactoty;
    }
}
