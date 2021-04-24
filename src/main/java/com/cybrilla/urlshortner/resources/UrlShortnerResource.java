package com.cybrilla.urlshortner.resources;

import com.cybrilla.urlshortner.model.UriData;
import com.cybrilla.urlshortner.model.UriRequest;
import com.cybrilla.urlshortner.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
public class UrlShortnerResource {


    private UrlShortnerService urlShortnerService;

    @Autowired
    public UrlShortnerResource(UrlShortnerService urlShortnerService) {
        this.urlShortnerService = urlShortnerService;
    }

    @GetMapping("/{alias}")
    public ResponseEntity<?> getUrl(@PathVariable String alias) throws URISyntaxException {
        UriData uriData = urlShortnerService.getUrl(alias);
        URI uri = new URI(uriData.getUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/")
    public ResponseEntity<Optional<UriData>> createUrl(@Valid @RequestBody UriRequest uriRequest) {
        Optional<UriData> response =  urlShortnerService.createUrl(uriRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
