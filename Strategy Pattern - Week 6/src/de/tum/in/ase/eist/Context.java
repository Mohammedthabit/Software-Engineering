package de.tum.in.ase.eist;

import java.util.List;

public class Context {

    private List<Chapter> book;

    private SearchStrategy searchAlgorithm;

    public boolean isChaptersSortedByName() {
        for (int i = 0; i < book.size() - 1; i++) {
            if (book.get(i).getName().compareTo(book.get(i + 1).getName()) > 0) {
                return false;
            }
        }
        return true;
    }

    public int search(String name) {
        return searchAlgorithm.performSearch(book, name);
    }

    public List<Chapter> getBook() {
        return book;
    }

    public void setBook(List<Chapter> book) {
        this.book = book;
    }

    public SearchStrategy getSearchAlgorithm() {
        return searchAlgorithm;
    }

    public void setSearchAlgorithm(SearchStrategy searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }
}
