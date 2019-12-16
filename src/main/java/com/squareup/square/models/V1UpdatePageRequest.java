package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdatePageRequest {

    @JsonCreator
    public V1UpdatePageRequest(
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
        if (!(o instanceof V1UpdatePageRequest)) {
            return false;
        }
        V1UpdatePageRequest v1UpdatePageRequest = (V1UpdatePageRequest) o;
        return Objects.equals(body, v1UpdatePageRequest.body);
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
        Builder builder = new Builder(body);
            return builder;
    }

    public static class Builder {
        private V1Page body;

        public Builder(V1Page body) {
            this.body = body;
        }

        public Builder body(V1Page value) {
            body = value;
            return this;
        }

        public V1UpdatePageRequest build() {
            return new V1UpdatePageRequest(body);
        }
    }
}
