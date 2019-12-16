package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CreateItemRequest {

    @JsonCreator
    public V1CreateItemRequest(
            @JsonProperty("body") V1Item body) {
        this.body = body;
    }

    private final V1Item body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1CreateItemRequest)) {
            return false;
        }
        V1CreateItemRequest v1CreateItemRequest = (V1CreateItemRequest) o;
        return Objects.equals(body, v1CreateItemRequest.body);
    }

    /**
     * Getter for Body.
     * V1Item
     */
    @JsonGetter("body")
    public V1Item getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .body(getBody());
            return builder;
    }

    public static class Builder {
        private V1Item body;

        public Builder() { }

        public Builder body(V1Item value) {
            body = value;
            return this;
        }

        public V1CreateItemRequest build() {
            return new V1CreateItemRequest(body);
        }
    }
}
