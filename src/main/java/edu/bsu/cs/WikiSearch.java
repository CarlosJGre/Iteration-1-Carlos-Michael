package edu.bsu.cs;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;


public class WikiSearch {
    public static void main(String[] args) {
        WikiSearch wikisearch = new WikiSearch();

        //user giving wikipedia article title
        Scanner scan = new Scanner(System.in);
        System.out.println("Give Wikipedia Article Title: ");
        String title = scan.nextLine();

        try {
            String timestamp = wikisearch.getLatestRevisionOf(title);
            System.out.println(timestamp);
        } catch (IOException ioException) {
            System.err.println("Network connection problem: " + ioException.getMessage());
        }
    }

    private String getLatestRevisionOf(String articleTitle) throws IOException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Soup&rvprop=timestamp&rvlimit=1");
        String encodedUrlString = URLEncoder.encode(urlString, Charset.defaultCharset());
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Revision Reporter/0.1 (carlos.gregorio@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            WikipediaRevisionParser parser = new WikipediaRevisionParser();
            String timestamp = parser.parseTime(inputStream);
            return timestamp;

        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }
}
