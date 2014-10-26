package main.java.project;

import main.java.entity.*;
import main.java.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by ArsenyPC on 26.10.2014.
 */
public class Main
{
    public static void main(String[] args)
    {
//        EntityManagerFactory factory= Persistence.createEntityManagerFactory("manager");
//        EntityManager manager=factory.createEntityManager();
////        Person person1=new Person(3, "Аделина Сотникова", 'f', new GregorianCalendar(1996, 6, 1), "Олимпийская чемпионка", 1, 0, 0);
////        Skater skater=new Skater(3, "Аделина Сотникова", 'f', new GregorianCalendar(1996, 6, 1), "Олимпийская чемпионка", 1, 0, 0);
////        List<Country> countries=Arrays.asList(new Country("rus", "Россия"),new Country("ita", "Италия"));
//        manager.getTransaction().begin();
////        List<Country> countries=new ArrayList<Country>();
////        countries.add(manager.find(Country.class, "rus"));
////        countries.add(manager.find(Country.class, "ita"));
////        Person person=manager.find(Person.class, 3);
//        Person person =manager.find(Person.class,3);
//        System.out.println(person.getName());
////        person.setCountries(countries);
////        manager.merge(person);
////        manager.flush();
//        manager.getTransaction().commit();
//        manager.close();
//        factory.close();
        Session session=null;
        try
        {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
//            Person person= (Person) session.get(Person.class,3);
//            System.out.println(person.getName());
//            Skater skater=new Skater(4,"Елизавета","f",new GregorianCalendar(1996, 1, 1),"призер ЧЕ",(short)1,(short)0,(short)0);
//            session.save(skater);
//        List<Country> countries=new ArrayList<Country>();
//        countries.add((Country) session.get(Country.class, "rus"));
//        countries.add((Country) session.get(Country.class, "ita"));
//        Person person= (Person) session.get(Person.class, 3);
//        person.setCountries(countries);

            //skater-disciplines
//            List<Discipline> disciplines=new ArrayList<Discipline>();
//            disciplines.add((Discipline) session.get(Discipline.class,1));
//            Skater sotnikova= (Skater) session.get(Skater.class,3);
//            SkaterDiscipline sd=new SkaterDiscipline();
//            sd.setDiscipline(disciplines.get(0));
//            sd.setSkater(sotnikova);
//            sd.setIdEvent(100);
//            sd.setStartSeason(2000);
//            session.save(sd);
//            session.merge(person);

            //skater-coaches
//            List<Coach> coaches=new ArrayList<Coach>();
//            coaches.add((Coach) session.get(Coach.class,1));
//            Skater sotnikova=(Skater) session.get(Skater.class,3);
//            SkaterCoach skaterCoach=new SkaterCoach();
//            skaterCoach.setSkater(sotnikova);
//            skaterCoach.setCoach(coaches.get(0));
//            skaterCoach.setIdEvent(1);
//            skaterCoach.setStartSeason(2006);
//            session.save(skaterCoach);
            Skater adelinaSotnikova= (Skater) session.get(Skater.class,3);

            session.getTransaction().commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally
        {
            if ((session!=null) && (session.isOpen()))
                session.close();
        }
    }
}
