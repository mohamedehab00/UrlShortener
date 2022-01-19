package com.TinyUrl;

public class Main {

    public static void main(String[] args) {
        // The URL must be encoded and decoded with the same UrlShortener object
	    UrlShortener urlShort = new UrlShortener();

        String OriginalURL = "https://leetcode.com/problems/encode-and-decode-tinyurl/";

        String shortURL = urlShort.encode(OriginalURL);
        System.out.println(shortURL);

        String returnedURL = urlShort.decode(shortURL);
        System.out.println(returnedURL);

        OriginalURL = "https://www.youtube.com/watch?v=uPWPqDxbRmo";

        shortURL = urlShort.encode(OriginalURL);
        System.out.println(shortURL);

        returnedURL = urlShort.decode(shortURL);
        System.out.println(returnedURL);
    }
}
