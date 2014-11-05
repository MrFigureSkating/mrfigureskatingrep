package ru.fsinfo.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ArsenyPC on 04.11.2014.
 */
public class TestParse2 {
    public static void main(String[] args) throws IOException {


        String html = "http://www.isuresults.com/results/gpcan2014/SEG001.HTM";
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
//            for (int j = 0; j < rowItems.size(); j++)
//            {
//                System.out.print(rowItems.get(j).text() + " ");
//            }
//            System.out.println();
        }
        System.out.println(map);
    }
}
