package dev.marques.practicaltest2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchResponse {

    private int start;

    @JsonProperty("num_found")
    private int numFound;

    private List<Doc> docs;

    public int getStart() {
        return start;
    }

    public SearchResponse setStart(int start) {
        this.start = start;
        return this;
    }

    public int getNumFound() {
        return numFound;
    }

    public SearchResponse setNumFound(int numFound) {
        this.numFound = numFound;
        return this;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public SearchResponse setDocs(List<Doc> docs) {
        this.docs = docs;
        return this;
    }
}
