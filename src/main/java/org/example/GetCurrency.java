package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class GetCurrency {
    public static void Parse() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello!\nEnter first currency");
        String first = scanner.nextLine();
        System.out.println("Enter second currency");
        String second = scanner.nextLine();

        Document doc = Jsoup.connect("https://www.google.com/search?q=" + first + "+to+"+ second).get();
        Element ElemPrice = doc.selectFirst("span.DFlfde.SwHCTb");

        Document doc2 = Jsoup.connect("https://www.google.com/search?q=" + second + "+to+"+ first).get();
        Element ElemPrice2 = doc2.selectFirst("span.DFlfde.SwHCTb");



        assert ElemPrice != null;
        assert ElemPrice2 != null;
        double price = Double.parseDouble(ElemPrice.text().replace(",","."));
        double price2 = Double.parseDouble(ElemPrice2.text().replace(",","."));

        System.out.println("1 "+first+" equals "+price+" "+second+"\nor\n1 "+second+" equals "+price2+" "+first);

    }
}
