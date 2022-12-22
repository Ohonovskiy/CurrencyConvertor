package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.Scanner;

public class GetCurrency {
    public static void Parse() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String first, second;

        System.out.println("Hello!\nEnter first currency");
        first = scanner.nextLine();

        System.out.println("Enter second currency");
        second = scanner.nextLine();

        Document doc = Jsoup.connect("https://www.google.com/search?q=" + first + "+to+"+ second).get();
        Element ElemPrice = doc.selectFirst("span.DFlfde.SwHCTb");

        Document doc2 = Jsoup.connect("https://www.google.com/search?q=" + second + "+to+"+ first).get();
        Element ElemPrice2 = doc2.selectFirst("span.DFlfde.SwHCTb");

        if(ElemPrice == null){
            ElemPrice = doc.selectFirst("span.pclqee");
            if (ElemPrice == null) {
                System.out.println("Cannot find " + first);
                System.exit(0);
            }
        }
        if(ElemPrice2 == null){
            ElemPrice2 = doc2.selectFirst("span.pclqee");
            if(ElemPrice2 == null){
                System.out.println("Cannot find " + second);
                System.exit(0);
            }

        }

        double price, price2, amount;
        price = Double.parseDouble(ElemPrice.text().replace(",",".").replace(" ", ""));
        price2 = Double.parseDouble(ElemPrice2.text().replace(",",".").replace(" ", ""));

        System.out.println("1 "+first+" equals "+price+" "+second+"\nor\n1 "+second+" equals "+price2+" "+first+"\n");

        System.out.println("Enter amount of currencies");
        amount = scanner.nextDouble();

        System.out.println("\n"+amount+" "+first+" equals "+price*amount+" "+second+"\nor\n"+amount+" "+second+" equals "+price2*amount+" "+first);
    }
}
