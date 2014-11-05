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
        Map<String,String> map=Parse.getLinks("http://www.isuresults.com/results/gpcan2013/");
//        System.out.println(map);
        Competition comp=new Competition();
        comp.setIdCompetition(UUID.randomUUID().toString().substring(0,30));
        comp.setNameCompetition("Skate Canada");
        comp.setLocation("Canada");
        Manager.save(comp);
        List<Result> resultsLadies=Parse.getResults(comp,"Ladies",map);
        List<Result> resultsMen=Parse.getResults(comp,"Men",map);
        List<Result> resultsPairs=Parse.getResults(comp,"Pairs",map);
        List<Result> resultsIceDance=Parse.getResults(comp,"Ice Dance",map);
        Manager.saveList(resultsLadies);
        Manager.saveList(resultsMen);
        Manager.saveList(resultsPairs);
        Manager.saveList(resultsIceDance);
//        for (Result res: results)
//        {
//            System.out.println(res.toString());
//        }
    }
}
