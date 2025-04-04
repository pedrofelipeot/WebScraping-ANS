package org.example.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class AnexoFinder {
    private static final String BASE_URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

    public static String findAnexoUrl(String keyword) throws IOException {
        Document doc = Jsoup.connect(BASE_URL).get();
        for (Element link : doc.select("a[href$=.pdf]")) {
            String fileUrl = link.absUrl("href");
            if (fileUrl.toLowerCase().contains(keyword)) {
                return fileUrl;
            }
        }
        return null;
    }
}
