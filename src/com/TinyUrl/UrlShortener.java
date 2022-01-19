package com.TinyUrl;

// essential imports
import java.util.HashMap;

public class UrlShortener {
    private HashMap<String,String> mappingTable;
    private static String tinyPage = "http://tinyurl.com/";

    public UrlShortener() {
        mappingTable = new HashMap<>();
    }

    private int getSlashIDX(String URL){
        // checks the first occurrence of slash
        for (int i = 0; i < URL.length(); i++) {
            if(URL.charAt(i)=='/'){
                // first slash index
                return i;
            }
        }
        // if not found
        return -1;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encoded = "";

        String[] LongURL = new String[2]; // stores the divided url

        int idx = getSlashIDX(longUrl);// index of first slash

        // url parts
        LongURL[0] = longUrl.substring(0,idx);
        LongURL[1] = longUrl.substring(idx);

        // mapping the first url part to tiny WebPage
        mappingTable.put(tinyPage,LongURL[0]);

        encoded += tinyPage;

        // max size of the hashed size
        int HashedSize = 5;
        String HashedPart = "";

        // Hashed part is a mix of numbers and alphabets
        for (int i = 0; i < HashedSize; i++) {
            int rand = (int)(Math.random() * 20);
            if(i % 2 == 0){
                HashedPart += ((char)((int)'a' + rand));
            }
            else if(rand < 10){
                HashedPart += ((Integer)rand).toString();
            }
        }

        // mapping the second url part to HashedPart
        mappingTable.put(HashedPart,LongURL[1]);

        encoded += HashedPart;

        return encoded; // the encoded url
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String decoded = "";

        String[] TinyURL = shortUrl.split(".com/"); // stores the divided url

        TinyURL[0] = TinyURL[0]+".com/"; // complete the url after splitting on (.com) part

        // restore the url parts from the Hash Table
        decoded += mappingTable.getOrDefault(TinyURL[0],TinyURL[0]);
        decoded += mappingTable.getOrDefault(TinyURL[1],TinyURL[1]);

        return decoded; // the decoded url
    }
}
