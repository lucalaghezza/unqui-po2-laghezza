package ar.edu.unq.po2.tp7.templatemethod.wikipedia;

import java.util.*;

public class MismaLetraInicial extends Filtro {
    @Override
    public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
        char inicial = page.getTitle().toLowerCase().charAt(0);
        List<WikipediaPage> result = new ArrayList<>();

        for (WikipediaPage p : wikipedia) {
            if (p.getTitle().toLowerCase().charAt(0) == inicial) {
                result.add(p);
            }
        }
        return result;
    }
}