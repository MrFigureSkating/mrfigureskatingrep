package main.java.project;

import main.java.entity.Result;
import main.java.parse.Parse;

import java.io.IOException;
import java.util.List;

/**
 * Created by ArsenyPC on 02.11.2014.
 */
public class ParseTest
{
    public static void main(String[] args) throws IOException {
        List<Result> results=Parse.parse("http://www.isuresults.com/results/gpcan2014/CAT002RS.HTM");
        System.out.println("finish");
    }
}
