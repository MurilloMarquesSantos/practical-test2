package dev.marques.practicaltest2.service;

import dev.marques.practicaltest2.client.OpenLibraryClient;
import dev.marques.practicaltest2.dto.BookDto;
import dev.marques.practicaltest2.dto.PagedResponse;
import dev.marques.practicaltest2.dto.SearchResponse;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final OpenLibraryClient client;

    public BookService(OpenLibraryClient client) {
        this.client = client;
    }

    public PagedResponse<BookDto> searchBySubject(String subject, int page, int size, boolean sortAsc) {

        int olPage = Math.max(1, page);
        SearchResponse resp = client.search("subject:" + subject, olPage, size, null);

        List<BookDto> list = Optional.ofNullable(resp.getDocs()).orElse(List.of())
                .stream()
                .map(d -> new BookDto(d.getTitle(), d.getAuthorName(), d.getFirstPublishYear(), d.getKey()))
                .collect(Collectors.toList());

        Comparator<BookDto> cmp = Comparator.comparing(b -> Optional.ofNullable(b.getTitle()).orElse(""));
        if (!sortAsc) cmp = cmp.reversed();
        list.sort(cmp);

        return new PagedResponse<>(
                list,
                page,
                size,
                resp.getNumFound()
        );
    }

    public PagedResponse<BookDto> searchByTitle(String title, int page, int size, boolean sortAsc) {
        int olPage = Math.max(1, page);

        String query = URLEncoder.encode(title, StandardCharsets.UTF_8);

        SearchResponse resp = client.search(query, olPage, size, null);


        List<BookDto> list = Optional.ofNullable(resp.getDocs()).orElse(List.of())
                .stream()
                .map(d -> new BookDto(
                        d.getTitle(),
                        d.getAuthorName(),
                        d.getFirstPublishYear(),
                        d.getKey()
                ))
                .collect(Collectors.toList());

        Comparator<BookDto> cmp = Comparator.comparing(
                b -> Optional.ofNullable(b.getTitle()).orElse(""),
                String.CASE_INSENSITIVE_ORDER
        );
        if (!sortAsc) {
            cmp = cmp.reversed();
        }
        list.sort(cmp);

        return new PagedResponse<>(
                list,
                page,
                size,
                resp.getNumFound()
        );
    }
}
