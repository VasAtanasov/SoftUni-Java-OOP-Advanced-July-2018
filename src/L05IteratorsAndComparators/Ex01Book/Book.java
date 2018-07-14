package L05IteratorsAndComparators.Ex01Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... values) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(values);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... values) {
        this.authors = new ArrayList<>();
        Collections.addAll(authors, values);
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Year: ").append(this.getYear())
                .append(System.lineSeparator())
                .append("Authors: ").append(String.join(", ", this.getAuthors()));
        return sb.toString();
    }
}
