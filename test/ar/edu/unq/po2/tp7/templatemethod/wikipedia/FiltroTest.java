package ar.edu.unq.po2.tp7.templatemethod.wikipedia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class FiltroTest {

    @Test
    public void testMismaLetraInicial() {
        WikipediaPage bernal = new DummyWikipediaPage("Bernal");
        WikipediaPage buenosAires = new DummyWikipediaPage("Buenos Aires");
        WikipediaPage quilmes = new DummyWikipediaPage("Quilmes");

        List<WikipediaPage> allPages = List.of(bernal, buenosAires, quilmes);
        Filtro filtro = new MismaLetraInicial();

        List<WikipediaPage> similares = filtro.getSimilarPages(bernal, allPages);
        assertTrue(similares.contains(bernal));
        assertTrue(similares.contains(buenosAires));
        assertFalse(similares.contains(quilmes));
    }

    @Test
    public void testLinkEnComun() {
        WikipediaPage laPlata = new DummyWikipediaPage("La Plata");
        WikipediaPage gimnasia = new DummyWikipediaPage("Gimnasia", List.of(laPlata));
        WikipediaPage buenosAires = new DummyWikipediaPage("Buenos Aires", List.of(laPlata));

        Filtro filtro = new LinkEnComun();
        List<WikipediaPage> similares = filtro.getSimilarPages(gimnasia, List.of(buenosAires));
        assertTrue(similares.contains(buenosAires));
    }

    @Test
    public void testPropiedadEnComun() {
        Map<String, WikipediaPage> infobox1 = new HashMap<>();
        infobox1.put("birth_place", new DummyWikipediaPage("La Plata"));

        Map<String, WikipediaPage> infobox2 = new HashMap<>();
        infobox2.put("birth_place", new DummyWikipediaPage("Buenos Aires"));

        WikipediaPage persona1 = new DummyWikipediaPage("Persona1", List.of(), infobox1);
        WikipediaPage persona2 = new DummyWikipediaPage("Persona2", List.of(), infobox2);

        Filtro filtro = new PropiedadEnComun();
        List<WikipediaPage> similares = filtro.getSimilarPages(persona1, List.of(persona2));
        assertTrue(similares.contains(persona2));
    }
}