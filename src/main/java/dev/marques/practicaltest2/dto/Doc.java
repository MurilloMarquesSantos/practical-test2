package dev.marques.practicaltest2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Doc {

    private String title;

    @JsonProperty("author_name")
    private List<String> authorName;

    @JsonProperty("first_publish_year")
    private Integer firstPublishYear;

    private String key;

    public String getTitle() {
        return title;
    }

    public Doc setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<String> getAuthorName() {
        return authorName;
    }

    public Doc setAuthorName(List<String> authorName) {
        this.authorName = authorName;
        return this;
    }

    public Integer getFirstPublishYear() {
        return firstPublishYear;
    }

    public Doc setFirstPublishYear(Integer firstPublishYear) {
        this.firstPublishYear = firstPublishYear;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Doc setKey(String key) {
        this.key = key;
        return this;
    }
}
