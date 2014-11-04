package ru.fsinfo.parse;

import ru.fsinfo.entity.Result;
import ru.fsinfo.entity.Skater;
import ru.fsinfo.manager.Manager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ArsenyPC on 02.11.2014.
 */
public class Parse
{
    public static List<Result> parse(String html) throws IOException
    {
        Result result=null;
        List<Result> resultList=new ArrayList<Result>();
        Document doc = Jsoup.connect(html).get();
            Elements tableElements = doc.select("table");
            System.out.println();
            Elements tableRowElements = tableElements.select("tr");
            Element row = tableRowElements.get(9);
            for (int i = 11; i < tableRowElements.size() && !row.attr("class").equals("EmptyLine22"); i += 2)
            {
                result=new Result();
                Elements rowItems = row.select("td");
                result.setIdResult(""+i*10);
                try {
                    result.setTotalPlace(rowItems.get(0).text());
                }
                catch (NumberFormatException e)  {}
                try {
                    result.setSpPlace(rowItems.get(7).text());
                }
                catch (NumberFormatException e)  {}
                try {
                    result.setFsPlace(rowItems.get(8).text());
                }
                catch (NumberFormatException e)  {}
                try {
                    result.setTotalScore(rowItems.get(6).text());
                }
                catch (NumberFormatException e)  {}
                result.setCountry(rowItems.get(5).text());

//                result.setSpPlace(Integer.valueOf(rowItems.get(7).text()));
//                if (!rowItems.get(8).text().equals(""))
//                    result.setFsPlace(Integer.valueOf(rowItems.get(8).text()));
//                if (!rowItems.get(6).text().equals("FNR"))
//                result.setTotalScore(Double.valueOf(rowItems.get(6).text()));
//                for (int j = 0; j < rowItems.size(); j++)
//                {
//                    System.out.print(rowItems.get(j).text() + " ");
//                }
                String name=rowItems.get(1).text();
                Skater skater=null;
                if(!Manager.checkPersonByName(name))
                {
                    skater=new Skater();
                    skater.setIdPerson(""+i*(-1));
                    skater.setName(name);
                    Manager.save(skater);
                }
                result.setSkaterByIdSingle(skater);
                result.setDiscipline("женское");
//                Competition c=new Competition();
//                c.setIdCompetition(""+i*10);
//                result.setCompetitionByIdCompetition(c);
                Manager.save(result);

                resultList.add(result);
                row = tableRowElements.get(i);
                System.out.println();
            }
        return resultList;
    }
}