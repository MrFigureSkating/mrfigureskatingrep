package ru.fsinfo.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by ArsenyPC on 03.11.2014.
 */
public class Test1
{
    public static void main(String[] args) {
        String html = "http://www.isuresults.com/results/wc2014";
        try {
            Document doc = Jsoup.connect(html).get();
            Elements tableElements = doc.select("table");
            Element mainTable=null;
//            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#606060">

            for (Element e:tableElements)
            {
                if (e.attr("width").equals("80%") && e.attr("border").equals("0") && e.attr("align").equals("center")
                        && e.attr("cellspacing").equals("1") && e.attr("bgcolor").equals("#606060"))
                {
                    System.out.println("Hurray!!!!");
                    mainTable=e;
                    break;
                }
            }
            Elements tableRowElements = mainTable.select("tr");
            for (int i = 0; i < tableRowElements.size(); i++) {
                Element row = tableRowElements.get(i);
                System.out.println("row");
                Elements rowItems = row.select("td");
                for (int j = 0; j < rowItems.size(); j++) {
                    System.out.println(rowItems.get(j).text());
                    Elements link = rowItems.select("a");
                    for (Element e:link)
                    {
                        String absHref = e.attr("abs:href"); // "http://jsoup.org/"
                        System.out.println("REFERENCE "+absHref);
                    }
//                    System.out.println(rowItems.get(j).text());
                }
                System.out.println();
            }








//
//            Elements tableHeaderEles = tableElements.select("thead tr th");
//            System.out.println("headers");
//            for (int i = 0; i < tableHeaderEles.size(); i++) {
//                System.out.println(tableHeaderEles.get(i).text());
//            }
//            System.out.println();
//
//            Elements tableRowElements = tableElements.select("tr");
//
//            for (int i = 0; i < tableRowElements.size(); i++) {
//                Element row = tableRowElements.get(i);
//                System.out.println("row");
//                Elements rowItems = row.select("td");
//                for (int j = 0; j < rowItems.size(); j++) {
//                    System.out.println(rowItems.get(j).text());
//                    Elements link = rowItems.select("a");
//                    for (Element e:link)
//                    {
//                        String absHref = e.attr("abs:href"); // "http://jsoup.org/"
//                        System.out.println("REFERENCE "+absHref);
//                    }
////                    System.out.println(rowItems.get(j).text());
//                }
//                System.out.println();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
