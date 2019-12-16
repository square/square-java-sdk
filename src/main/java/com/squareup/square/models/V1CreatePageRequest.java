package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CreatePageRequest {

    @JsonCreator
    public V1CreatePageRequest(
            @JsonProperty("body") V1Page body) {
        this.body = body;
    }

    private final V1Page body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1CreatePageRequest)) {
            return false;
        }
        V1CreatePageRequest v1CreatePageRequest = (V1CreatePageRequest) o;
        return Objects.equals(body, v1CreatePageRequest.body);
    }

    /**
     * Getter for Body.
     * V1Page
     */
    @JsonGetter("body")
    public V1Page getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .body(getBody());
            return builder;
    }

    public static class Builder {
        private V1Page body;

        public Builder() { }

        public Builder body(V1Page value) {
            body = value;
            return this;
        }

        public V1CreatePageRequest build() {
            return new V1CreatePageRequest(body);
        }
    }
}
