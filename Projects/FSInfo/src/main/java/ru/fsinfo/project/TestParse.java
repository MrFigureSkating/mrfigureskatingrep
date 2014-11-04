package ru.fsinfo.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by ArsenyPC on 02.11.2014.
 */
public class TestParse
{
//    public static void main(String[] args) throws IOException
//    {
//        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
//        Element content = doc.getElementById("content");
//        Elements links = content.getElementsByTag("a");
//        for (Element link : links) {
//            String linkHref = link.attr("href");
//            String linkText = link.text();
//            System.out.println(linkHref);
//            System.out.println(linkText);
//        }
//
//    }
public static void main(String[] args) {
    String html = "http://www.isuresults.com/results/wc2014/CAT003RS.HTM";
    try {
        Document doc = Jsoup.connect(html).get();
        Elements tableElements = doc.select("table");

//        Elements tableHeaderEles = tableElements.select("thead tr th");
//        System.out.println("headers");
//        for (int i = 0; i < tableHeaderEles.size(); i++) {
//            System.out.println(tableHeaderEles.get(i).text());
//        }
        System.out.println();

//        Elements tableRowElements = tableElements.select(":not(thead) tr");
        Elements tableRowElements = tableElements.select("tr");
        Element row=tableRowElements.get(9);
        for (int i = 11; i < tableRowElements.size() && !row.attr("class").equals("EmptyLine22"); i+=2) {
//            System.out.println(i);
//            row = tableRowElements.get(i);
//            if (row.attr("class").equals("EmptyLine22"))
//                System.out.println("STOP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            System.out.println(row);
//            System.out.println("!!!!!!!!!!!!!!!"+row.toString());
//            if (row.toString().isEmpty())
//                System.out.println("EMPTY!!!!!!!!!!!!!!!!!");
//            System.out.println("row");
            Elements rowItems = row.select("td");
            for (int j = 0; j < rowItems.size(); j++) {
                System.out.print(rowItems.get(j).text()+" ");
            }
            row = tableRowElements.get(i);
            System.out.println();
        }
//        for (int i = 0; i < tableRowElements.size(); i++) {
//            System.out.println(i);
//            Element row = tableRowElements.get(i);
//            System.out.println("row" + i);
//            Elements rowItems = row.select("td");
//            for (int j = 0; j < rowItems.size(); j++) {
//                System.out.println(rowItems.get(j).text());
//            }
//            System.out.println();
//        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
