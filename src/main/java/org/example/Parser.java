package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;

public class Parser {
    public static String Parse() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!\nEnter first currency");
        String first = scanner.nextLine();
        System.out.println("Enter second currency");
        String second = scanner.nextLine();
        Document doc = Jsoup.connect("https://www.google.com/search?q=" + first + "+to+"+ second).get();
        Element price = doc.selectFirst("span.DFlfde.SwHCTb");
        System.out.println(price.text());
        return price.toString();
    }
}
