package dev.marques.practicaltest2.client;

import dev.marques.practicaltest2.dto.SearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OpenLibraryClient {

    private final RestTemplate restTemplate;

    private final String baseUrl;

    public OpenLibraryClient(@Value("${open-library.base-url}") String baseUrl, RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
        this.baseUrl = baseUrl;
    }

    public SearchResponse search(String q, Integer page, Integer limit, String sort) {
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/search.json")
                .queryParam("q", q);
        if (page != null) uri.queryParam("page", page);
        if (limit != null) uri.queryParam("limit", limit);
        if (sort != null) uri.queryParam("sort", sort);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<SearchResponse> resp =
                restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entity, SearchResponse.class);
        return resp.getBody();
    }

}
