package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Scanner;

public class Parser {
    public static String Parse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!\nEnter first currency");
        String first = scanner.nextLine();
        System.out.println("Enter second currency");
        String second = scanner.nextLine();
        Document doc = Jsoup.parse("https://www.google.com/search?q=" + first + "+to+"+ second);
        Element price = doc.getElementsByTag("DFlfde SwHCTb").first();
        return price.toString();
    }
}
