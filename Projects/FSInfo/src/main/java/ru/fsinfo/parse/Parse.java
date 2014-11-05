package ru.fsinfo.parse;

import ru.fsinfo.entity.Competition;
import ru.fsinfo.entity.Result;
import ru.fsinfo.entity.Skater;
import ru.fsinfo.manager.Manager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * Created by ArsenyPC on 02.11.2014.
 */
public class Parse {
    public static List<Result> parse(String html) throws IOException {
        Result result = null;
        List<Result> resultList = new ArrayList<Result>();
        Document doc = Jsoup.connect(html).get();
        Elements tableElements = doc.select("table");
        System.out.println();
        Elements tableRowElements = tableElements.select("tr");
        Element row = tableRowElements.get(9);
        for (int i = 11; i < tableRowElements.size() && !row.attr("class").equals("EmptyLine22"); i += 2) {
            result = new Result();
            Elements rowItems = row.select("td");
            result.setIdResult("" + i * 10);
            try {
                result.setTotalPlace(rowItems.get(0).text());
            } catch (NumberFormatException e) {
            }
            try {
                result.setSpPlace(rowItems.get(7).text());
            } catch (NumberFormatException e) {
            }
            try {
                result.setFsPlace(rowItems.get(8).text());
            } catch (NumberFormatException e) {
            }
            try {
                result.setTotalScore(rowItems.get(6).text());
            } catch (NumberFormatException e) {
            }
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
            String name = rowItems.get(1).text();
            Skater skater= (Skater) Manager.checkPersonByName(name);
            if (skater!=null) {
                skater = new Skater();
                skater.setIdPerson("" + i * (-1));
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

    public static Map<String, String> getLinks(String page) throws IOException {
        Document doc = Jsoup.connect(page).get();
        Elements tableElements = doc.select("table");
        Element mainTable = null;
//            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#606060">

        for (Element e : tableElements) {
            if (e.attr("width").equals("80%") && e.attr("border").equals("0") && e.attr("align").equals("center")
                    && e.attr("cellspacing").equals("1") && e.attr("bgcolor").equals("#606060")) {
                mainTable = e;
                break;
            }
        }
//            System.out.println(mainTable);
        Map<String, String> map = new HashMap<>();
        Elements tableRowElements = mainTable.select("td");
        int i = 0;
        while (i < tableRowElements.size()) {
            i = HandleKind(page,"Men", tableRowElements, map, i);
            i = HandleKind(page,"Ladies", tableRowElements, map, i);
            i = HandleKind(page,"Pairs", tableRowElements, map, i);
            i = HandleKind(page,"Ice Dance", tableRowElements, map, i);

//            System.out.println(row);
            i++;
            System.out.println();
        }

        return map;
    }

    private static int HandleKind(String page,String kind, Elements tableRowElements, Map<String, String> map, int i) {
        Element row = tableRowElements.get(i);
        String str = row.text();
        if (str.equals(kind)) {
            String link = "";
            while (!link.equals("Result")) {
                link = tableRowElements.get(++i).text();
            }
            Element a = tableRowElements.get(i).select("a").first();
            String href = a.attr("href");
            map.put(kind + "-"+link, page+href);
            link = "";
            while (!link.equals("Starting Order / Detailed Classification")) {
                link = tableRowElements.get(++i).text();
            }
            a = tableRowElements.get(i).select("a").first();
            href = a.attr("href");
            map.put(kind + "-Sp", page+href);
            link = "";
            while (!link.equals("Starting Order / Detailed Classification")) {
                link = tableRowElements.get(++i).text();
            }
            a = tableRowElements.get(i).select("a").first();
            href = a.attr("href");
            map.put(kind + "-Fs", page+href);
//                    System.out.println("HREF"+href+"--->"+link);

        }
        return i;
    }
    public static List<Result> getResults(Competition competition,String kind,Map<String,String> links) throws IOException {
//        Document doc = Jsoup.connect(html).get();
//        Elements tableElements = doc.select("table");
//        System.out.println();
        Result result;
        List<Result> resultList=new ArrayList<>();
        String page= links.get(kind+"-Result");
        Document doc=Jsoup.connect(page).get();
        Elements tableElements = doc.select("table");
        Elements tableRowElements = tableElements.select("tr");
        Element row = tableRowElements.get(9);
        for (int i = 11; i < tableRowElements.size() && !row.attr("class").equals("EmptyLine22"); i += 2)
        {
            result = new Result();
            Elements rowItems = row.select("td");
            result.setIdResult(UUID.randomUUID().toString().substring(0,30));
            result.setTotalPlace(rowItems.get(0).text());
            result.setSpPlace(rowItems.get(7).text());
            result.setFsPlace(rowItems.get(8).text());
            result.setTotalScore(rowItems.get(6).text());
            result.setCountry(rowItems.get(5).text());
            String name = rowItems.get(1).text();
            if (kind.equals("Men") || kind.equals("Ladies"))
            {
//                Manager.
            }
            Skater skater = (Skater) Manager.checkPersonByName(name);
            if (skater==null)
            {
                skater = new Skater();
                skater.setIdPerson(UUID.randomUUID().toString().substring(0,30));
                skater.setName(name);
                skater.setSex(getSex(kind));
                Manager.save(skater);
            }
            result.setSkaterByIdSingle(skater);
            result.setDiscipline(getRussianWord(kind));
//                Competition c=new Competition();
//                c.setIdCompetition(""+i*10);
                result.setCompetitionByIdCompetition(competition);
//            Manager.save(result);

            resultList.add(result);
            row = tableRowElements.get(i);
        }
        String sp=links.get(kind+"-Sp");
        Map<String,String> spResults=getShortOrFreeProgramResult(sp);
        for (int i=0;i< resultList.size();i++)
        {
            Result currentResult=resultList.get(i);
            currentResult.setSpScore(spResults.get(currentResult.getSpPlace()));
        }
        String fs=links.get(kind+"-Fs");
        Map<String,String> fsResults=getShortOrFreeProgramResult(fs);
        for (int i=0;i< resultList.size();i++)
        {
            Result currentResult=resultList.get(i);
            currentResult.setFsScore(fsResults.get(currentResult.getFsPlace()));
        }
        return resultList;
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
    private static String getSex(String kind)
    {
        if (kind.equals("Men"))
            return "m";
        if (kind.equals("Ladies"))
            return "f";
        return "";
    }
    private static Map<String,String> getShortOrFreeProgramResult(String html) throws IOException {
//        String html = "http://www.isuresults.com/results/gpcan2014/SEG001.HTM";
        Map<String,String> map=new HashMap<>();
        Document doc = Jsoup.connect(html).get();
        Elements tableElements = doc.select("table");
        Element mainTable=null;
        //<table width="100%" align="center" border="0" cellspacing="1">
        for (Element e : tableElements) {
            if (e.attr("width").equals("100%") && e.attr("border").equals("0") && e.attr("align").equals("center")
                    && e.attr("cellspacing").equals("1")) {
                mainTable = e;
                break;
            }
        }
        Elements checkQ=mainTable.select("th");
        //если в таблице есть столбец Qual., это значит, что результат нужно брать из столбца 4, иначе - из столбца 3
        int jump=3;
        for (Element e:checkQ)
        {
            if (e.text().equals("Qual."))
            {
                jump++;
                break;
            }
        }
        Elements tableRowElements = mainTable.select("tr");
        for (int i =1; i < tableRowElements.size(); i ++)
        {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");
            map.put(rowItems.get(0).text(),rowItems.get(jump).text());
        }

    return map;
    }
}