package ar.edu.unq.po2.tp7.templatemethod.wikipedia;
import java.util.*;

public class LinkEnComun extends Filtro {
    @Override
    public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
        Set<WikipediaPage> links = new HashSet<>(page.getLinks());
        List<WikipediaPage> result = new ArrayList<>();

        for (WikipediaPage p : wikipedia) {
            if (!Collections.disjoint(p.getLinks(), links)) {
                result.add(p);
            }
        }
        return result;
    }
}