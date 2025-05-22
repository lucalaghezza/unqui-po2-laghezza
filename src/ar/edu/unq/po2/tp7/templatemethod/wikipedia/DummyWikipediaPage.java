package ar.edu.unq.po2.tp7.templatemethod.wikipedia;

import java.util.*;

public class DummyWikipediaPage implements WikipediaPage {
    private String title;
    private List<WikipediaPage> links;
    private Map<String, WikipediaPage> infobox;

    public DummyWikipediaPage(String title) {
        this(title, new ArrayList<>(), new HashMap<>());
    }

    public DummyWikipediaPage(String title, List<WikipediaPage> links) {
        this(title, links, new HashMap<>());
    }

    public DummyWikipediaPage(String title, List<WikipediaPage> links, Map<String, WikipediaPage> infobox) {
        this.title = title;
        this.links = links;
        this.infobox = infobox;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<WikipediaPage> getLinks() {
        return links;
    }

    @Override
    public Map<String, WikipediaPage> getInfobox() {
        return infobox;
    }

    @Override
    public String toString() {
        return title;
    }
}