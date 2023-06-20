package de.tum.in.ase.eist;

import java.util.List;

public class LinearSearch implements SearchStrategy {

    public int performSearch(List<Chapter> list, String string) {
        for (Chapter chapter : list) {
            if (chapter.getName().equals(string)) {
                return chapter.getPageNumber();
            }
        }
        return -1;
    }

}
