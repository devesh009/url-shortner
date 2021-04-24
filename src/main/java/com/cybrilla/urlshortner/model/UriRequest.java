package com.cybrilla.urlshortner.model;

import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

public class UriRequest {
    @NotNull
    private String alias;

    @NotNull
    private String uri;

    public UriRequest(String alias, String uri) {
        this.alias = alias;
        this.uri = uri;
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
        return new StringJoiner(", ", UriRequest.class.getSimpleName() + "[", "]")
                .add("alias='" + alias + "'")
                .add("uri='" + uri + "'")
                .toString();
    }
}
