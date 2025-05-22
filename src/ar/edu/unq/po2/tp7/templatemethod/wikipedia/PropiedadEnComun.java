package ar.edu.unq.po2.tp7.templatemethod.wikipedia;
import java.util.*;

public class PropiedadEnComun extends Filtro {
    @Override
    public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
        Set<String> propiedades = page.getInfobox().keySet();
        List<WikipediaPage> result = new ArrayList<>();

        for (WikipediaPage p : wikipedia) {
            Set<String> otrasPropiedades = p.getInfobox().keySet();
            for (String prop : propiedades) {
                if (otrasPropiedades.contains(prop)) {
                    result.add(p);
                    break;
                }
            }
        }
        return result;
    }
}