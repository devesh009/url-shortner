package com.cybrilla.urlshortner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

@Entity
public class UriData {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @NaturalId
    @Column(unique = true, nullable = false)
    @NotNull
    private String alias;

    @Column(nullable = false)
    @NotNull
    private String uri;

    public UriData() {
    }

    public UriData(String alias, String uri) {
        this.alias = alias;
        this.uri = uri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UriData.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("alias='" + alias + "'")
                .add("uri='" + uri + "'")
                .toString();
    }
}
