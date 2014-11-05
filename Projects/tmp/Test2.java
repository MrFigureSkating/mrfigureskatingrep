package main.java.project;

import main.java.parse.Parse;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ArsenyPC on 04.11.2014.
 */
public class Test2
{
    public static void main(String[] args) throws IOException {
        Map<String,String> map=Parse.getLinks("http://www.isuresults.com/results/gpcan2014/");
        System.out.println(map);
    }
}
