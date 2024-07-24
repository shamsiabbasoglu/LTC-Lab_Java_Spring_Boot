package mentor.bookstore.service;

import lombok.RequiredArgsConstructor;
import mentor.bookstore.config.client.GoodReadsAPI;
import mentor.bookstore.dto.responsedto.goodreadsdto.Root;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodReadsService {
    private final GoodReadsAPI goodReadsAPI;
    @Value("${host}")
    private String host;
    @Value("${key}")
    private String key;

    public List<Root> getAuthorBooks(String input) {
        List<Root> authorBooks = goodReadsAPI.getAuthorBooks(host, key, input);
        return authorBooks.subList(0, Math.min(authorBooks.size(), 10));
    }
}