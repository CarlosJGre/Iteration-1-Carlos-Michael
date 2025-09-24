package edu.bsu.cs;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import  java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParserTest {

    @Test
    public void testParseTime() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamp = parser.parseTime(testDataStream);
        Assertions.assertEquals("2025-09-20T20:50:28Z", timestamp);
    }

    @Test
    public void testParseUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String user = parser.parseUser(testDataStream);
        Assertions.assertEquals("Notreallydavid", user);
    }
}
