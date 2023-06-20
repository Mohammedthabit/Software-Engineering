package de.tum.in.ase.eist;

import java.util.List;

public class BinarySearch implements SearchStrategy {

    public int performSearch(List<Chapter> list, String string) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Chapter chapter = list.get(mid);
            int comparison = chapter.getName().compareTo(string);

            if (comparison == 0) {
                return chapter.getPageNumber();
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
