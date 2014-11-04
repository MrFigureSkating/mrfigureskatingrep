package ru.fsinfo.project;

import ru.fsinfo.entity.Skater;
import ru.fsinfo.utilities.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

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
//            Skater adelinaSotnikova= (Skater) session.get(Skater.class,3);
//            Skater vlszhr=new Skater(5,"Татьяна Волосожар","f",new GregorianCalendar(1986, 4, 22),"The Best!",(short)1,(short)0,(short)0);
//            Skater trnkv=new Skater(6,"Максим Траньков","m",new GregorianCalendar(1983,8,7),"The Best!",(short)1,(short)0,(short)0);
//            List<Discipline> disciplines=new ArrayList<Discipline>();
//            disciplines.add((Discipline) session.get(Discipline.class,4));
//            SkaterDiscipline sd=new SkaterDiscipline();
//            sd.setDiscipline(disciplines.get(0));
//            sd.setSkater(vlszhr);
//            sd.setIdEvent(101);
//            sd.setStartSeason(2000);
//            session.save(vlszhr);
//            session.save(sd);
//
//            sd=new SkaterDiscipline();
//            sd.setDiscipline(disciplines.get(0));
//            sd.setSkater(trnkv);
//            sd.setIdEvent(102);
//            sd.setStartSeason(1997);
//            session.save(trnkv);
//            session.save(sd);
//            List<Pair> pairs=new ArrayList<Pair>();
//            pairs.add((Pair) session.get(Pair.class,1));
//            Pair vt= (Pair) session.get(Pair.class,1);
//            List<Program> programs=new ArrayList<Program>();
//            Program p=new Program();
//            p.setIdProgram(9);
//            p.setNameProgram("Вальс Маскарад");
//            session.save(p);
//            Skater sotnikova= (Skater) session.get(Skater.class,3);
//            List<Program> programs=new ArrayList<Program>();
//
//            Program valz= (Program) session.get(Program.class,9);
//            programs.add((Program) session.get(Program.class,9));
//            SkaterPrograms sp=new SkaterPrograms();
//            sp.setProgram(programs.get(0));
//            sp.setIdProgramSingleOrPairChor(3);
//            sp.setSeason(2013);
//            sp.setType("sp");
//            sp.setSkater(sotnikova);
//            sp.setDiscipline("женское");
//            session.save(sp);
//            Skater skater=new Skater();
//            skater.setIdPerson("2");skater.setSex("f");skater.setName("Юлия Липницкая");skater.setInfo("няшечка");skater.setIsReigningSkater(true);skater.setIsReigningCoach(false);skater.setIsReigningChoreographer(false);
//            session.save(skater);
//            Country russia=new Country();
//            russia.setName("Russia");russia.setShortName("rus");
//            session.save(russia);
//            Person lip= (Person) session.get(Person.class,"2");
//            List<Country> countries=new ArrayList<Country>();
//            countries.add((Country) session.get(Country.class,"rus"));
//            lip.setCountries(countries);
//            session.merge(lip);
//
//            Coach mozer=new Coach();
//            mozer.setIdPerson("3");mozer.setName("Нина Мозер"); mozer.setInfo("Тренер Тани и Макса");mozer.setSex("f");mozer.setIsReigningSkater(false);mozer.setIsReigningCoach(true);mozer.setIsReigningChoreographer(false);
//            session.save(mozer);
//            Skater vlszhr=new Skater();
//            vlszhr.setIdPerson("4");vlszhr.setName("Татьяна Волосожар");vlszhr.setInfo("Олимпийская Чемпионака Сщчи-2014");vlszhr.setSex("f");vlszhr.setIsReigningSkater(true);vlszhr.setIsReigningCoach(false);vlszhr.setIsReigningChoreographer(false);
//            Skater trnkv=new Skater();
//            trnkv.setIdPerson("5");trnkv.setName("Максим Траньков");trnkv.setInfo("ОЧ");trnkv.setSex("m");trnkv.setIsReigningSkater(true);trnkv.setIsReigningCoach(false);trnkv.setIsReigningChoreographer(false);
//            session.save(vlszhr);
//            session.save(trnkv);
//            Pair vt=new Pair();
//            vt.setIdPair("1");
//            vt.setDiscipline("парное");
//            vt.setSkaterByIdLady(vlszhr);
//            vt.setSkaterByIdMan(trnkv);
//            session.save(vt);
//            Pair vt= (Pair) session.get(Pair.class,"1");
//            List<SkaterCoach> skaterCoach=vt.getSkaterCoachesByIdPair();
//             System.out.println(skaterCoach.get(0).getCoachByIdCoach().getName());
//            Coach mozer= (Coach) session.get(Coach.class,"3");
//            SkaterCoach sc=new SkaterCoach();
//            sc.setIdEvent("1");sc.setStartSeason(2010);sc.setPairByIdPair(vt);sc.setCoachByIdCoach(mozer);
//            SkaterCoach sc= (SkaterCoach) session.get(SkaterCoach.class,"1");
//            vt.setSkaterCoachesByIdPair(new ArrayList<SkaterCoach>(Arrays.asList(sc)));
//            List<SkaterCoach> skaterCoaches=new ArrayList<SkaterCoach>();
//            skaterCoaches.add(sc);
//            vt.setSkaterCoachesByIdPair(skaterCoaches);
//            session.merge(vt);


//            String hql="FROM Person P WHERE P.name = :name";
//             Query query=session.createQuery(hql);
//            query.setParameter("name","Юлия Липницкая");
//            List results=query.list();
            Skater sotnikova=new Skater();
            sotnikova.setIdPerson("1");
            sotnikova.setName("Cjnybrjdf");
            session.save(sotnikova);
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
