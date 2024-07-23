package mentor.bookstore.config.client;

import mentor.bookstore.dto.responsedto.goodreadsdto.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "MyAPI", url = "https://goodreads12.p.rapidapi.com")
public interface GoodReadsAPI {

    @GetMapping("/getAuthorBooks")
    List<Root> getAuthorBooks(
            @RequestHeader(name = "x-rapidapi-host") String host,
            @RequestHeader(name = "x-rap idapi-key") String key,
            @RequestParam(name = "authorID") String authorID
    );
}
