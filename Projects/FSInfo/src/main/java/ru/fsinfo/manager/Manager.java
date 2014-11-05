package ru.fsinfo.manager;

import ru.fsinfo.entity.Pair;
import ru.fsinfo.entity.Person;
import ru.fsinfo.entity.Result;
import ru.fsinfo.entity.Skater;
import ru.fsinfo.utilities.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by ArsenyPC on 02.11.2014.
 */
public class Manager
{
    public static Person checkPersonByName(String name)
    {
        Session session=null;
        Person person=null;
//        boolean result=false;
        try
        {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql="FROM Person P WHERE P.name = :name";
            Query query=session.createQuery(hql);
            query.setParameter("name",name);
            List list=query.list();
            if (list.size()!=0) {
                person = (Person) list.get(0);
            }
//                result=true;
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()))
                session.close();
        }
        return person;
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
    public static void savep(Pair person)
    {
        Session session=null;
        try
        {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()))
                session.close();
        }
    }

    public static void saveList(List<Result> objects)
    {
        Session session=null;
        try
        {
            for (Object obj:objects) {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(obj);
                session.getTransaction().commit();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen()))
                session.close();
        }
    }
    public static void setSkaterOrPairToResult(Result result,String kind,String name)
    {
        Skater skater=null;
        if (kind.equals("Men") || kind.equals("Ladies"))
        {
            skater=(Skater) checkPersonByName(name);
            if (skater==null)
            {
                skater = new Skater();
                skater.setIdPerson(UUID.randomUUID().toString().substring(0,28));
                skater.setName(name);
                skater.setSex(getSex(kind));
                Manager.save(skater);
            }
            result.setSkaterByIdSingle(skater);
        }
        else
            if (kind.equals("Pairs")||kind.equals("Ice Dance"))
            {
                Pair pair=null;
                Skater man=null;
                Skater lady=null;
                String[] pairNames=name.split("/");
                String ladyName=pairNames[0];
                String manName=pairNames[1];
                boolean isManOrLadyNew=false;
                //проверяем партнершу на наличие в БД
                lady=(Skater) checkPersonByName(ladyName);
                if (lady==null)
                {
                    lady = new Skater();
                    lady.setIdPerson(UUID.randomUUID().toString().substring(0,28));
                    lady.setName(ladyName);
                    lady.setSex("f");
                    Manager.save(lady);
                    isManOrLadyNew=true;
                }
                man=(Skater) checkPersonByName(manName);
                if (man==null)
                {
                    man = new Skater();
                    man.setIdPerson(UUID.randomUUID().toString().substring(0,28));
                    man.setName(manName);
                    man.setSex("m");
                    Manager.save(man);
                    isManOrLadyNew=true;
                }
                if (isManOrLadyNew)
                {
                    pair=new Pair();
                    pair.setIdPair(UUID.randomUUID().toString().substring(0,28));
                    pair.setSkaterByIdLady(lady);
                    pair.setSkaterByIdMan(man);
                    pair.setDiscipline(getRussianWord(kind));
                    Manager.savep(pair);
                }
                else
                {
                    boolean areTheyPartners=false;
                    List<Pair> pairs=man.getPairsByIdLady();
                    for(Pair p:pairs)
                    {
                        if (p.getSkaterByIdLady().getIdPerson().equals(lady.getIdPerson()))
                        {
                            pair=p;
                            areTheyPartners=true;
                            break;
                        }
                    }
                    if (!areTheyPartners)
                    {
                        pair=new Pair();
                        pair.setIdPair(UUID.randomUUID().toString().substring(0,28));
                        pair.setSkaterByIdLady(lady);
                        pair.setSkaterByIdMan(man);
                        pair.setDiscipline(getRussianWord(kind));
                        Manager.savep(pair);
                    }
                }
            result.setPairByIdPair(pair);
            }
    }

    private static String getSex(String kind)
    {
        if (kind.equals("Men"))
            return "m";
        if (kind.equals("Ladies"))
            return "f";
        return "";
    }
    private static String getRussianWord(String enWord)
    {
        if (enWord.equals("Men"))
            return "мужское одиночное катание";
        if (enWord.equals("Ladies"))
            return "женское одиночное катание";
        if (enWord.equals("Pairs"))
            return "парное катание";
        if (enWord.equals("Ice Dance"))
            return "танцы на льду";
        return "";
    }
}
