package com.cybrilla.urlshortner.service;

import com.cybrilla.urlshortner.exception.BadRequestException;
import com.cybrilla.urlshortner.exception.NotFoundException;
import com.cybrilla.urlshortner.model.UriData;
import com.cybrilla.urlshortner.model.UriRequest;
import com.cybrilla.urlshortner.repository.UrlShortnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlShortnerService {

    private UrlShortnerRepo urlShortnerRepo;

    @Autowired
    public UrlShortnerService(UrlShortnerRepo urlShortnerRepo) {
        this.urlShortnerRepo = urlShortnerRepo;
    }

    public Optional<UriData> createUrl(UriRequest uriRequest){

        if(urlShortnerRepo.existsByAlias(uriRequest.getAlias())){
            throw new BadRequestException("Alias already exists");
        }

        UriData uriData = new UriData(uriRequest.getAlias(),uriRequest.getUri());
        UriData response = urlShortnerRepo.save(uriData);
        return Optional.ofNullable(response);
    }
    public UriData getUrl(String alias){
        return  urlShortnerRepo.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Try Again"));

    }
}
