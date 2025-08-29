package dev.marques.practicaltest2.dto;

import java.util.List;

public class BookDto {

    private String title;

    private List<String> authors;

    private Integer year;

    private String openLibraryKey;

    public BookDto(String title, List<String> authors, Integer year, String openLibraryKey) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.openLibraryKey = openLibraryKey;
    }

    public String getTitle() {
        return title;
    }

    public BookDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public BookDto setAuthors(List<String> authors) {
        this.authors = authors;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public BookDto setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getOpenLibraryKey() {
        return openLibraryKey;
    }

    public BookDto setOpenLibraryKey(String openLibraryKey) {
        this.openLibraryKey = openLibraryKey;
        return this;
    }
}
