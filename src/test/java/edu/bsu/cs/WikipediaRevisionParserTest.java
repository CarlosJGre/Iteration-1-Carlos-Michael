package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import  java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParserTest {

    @Test
    public void testParse() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamp = parser.parse(testDataStream);
        Assertions.assertEquals("2025-09-20T20:36:03Z", timestamp);
    }
}
