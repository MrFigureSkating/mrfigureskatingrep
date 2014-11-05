package ru.fsinfo.project;

import ru.fsinfo.entity.Competition;
import ru.fsinfo.entity.Result;
import ru.fsinfo.manager.Manager;
import ru.fsinfo.parse.Parse;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ArsenyPC on 04.11.2014.
 */
public class Test2
{
    public static void main(String[] args) throws IOException {
        Map<String,String> map=Parse.getLinks("http://www.isuresults.com/results/gpjpn2013/");
//        System.out.println(map);
        Competition comp=new Competition();
        comp.setIdCompetition(UUID.randomUUID().toString().substring(0,30));
        comp.setNameCompetition("NHK Trophy");
        comp.setLocation("Japan");
        Manager.save(comp);
        List<Result> resultsLadies=Parse.getResults(comp,"Ladies",map);
        List<Result> resultsMen=Parse.getResults(comp,"Men",map);
        Manager.saveList(resultsLadies);
        Manager.saveList(resultsMen);
//        for (Result res: results)
//        {
//            System.out.println(res.toString());
//        }
    }
}
