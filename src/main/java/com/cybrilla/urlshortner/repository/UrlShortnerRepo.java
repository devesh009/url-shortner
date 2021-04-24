package com.cybrilla.urlshortner.repository;

import com.cybrilla.urlshortner.model.UriData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlShortnerRepo extends JpaRepository<UriData , Long> {
    Optional<UriData> findByAlias(String alias);
    Boolean existsByAlias(String alias);

}
