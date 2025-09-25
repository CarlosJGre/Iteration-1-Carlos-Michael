package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {


    //}

    //gives Array of the time of edits from a wiki article
    public String parseFull (InputStream testDataStream) throws IOException {
        JSONArray time = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
        JSONArray users = (JSONArray) JsonPath.read(testDataStream, "$..user");

        System.out.println(time.get(0).toString() + "  " + users.get(0).toString());

        return "Done";
    }

    public String parseTime(InputStream testDataStream) throws IOException {

        JSONArray time = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");

        System.out.println(time.get(0).toString());
        System.out.println(time.get(1).toString());
        System.out.println(time.get(2).toString());
        System.out.println(time.get(3).toString());
        return time.get(0).toString();
    }

    //gives Array of Users who have edited the wiki aritcle
    public String parseUser(InputStream testDataStream) throws IOException{

        JSONArray user = (JSONArray) JsonPath.read(testDataStream, "$..user");

        System.out.println(user.get(0).toString());
        System.out.println(user.get(1).toString());
        System.out.println(user.get(2).toString());
        System.out.println(user.get(3).toString());
        return user.get(0).toString();

    }
}
