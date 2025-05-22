package ar.edu.unq.po2.tp7.templatemethod.wikipedia;

import java.util.List;
import java.util.Map;

public interface WikipediaPage {
    String getTitle();
    List<WikipediaPage> getLinks();
    Map<String, WikipediaPage> getInfobox();
}
