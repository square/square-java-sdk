package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdateItemRequest {

    @JsonCreator
    public V1UpdateItemRequest(
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
        if (!(o instanceof V1UpdateItemRequest)) {
            return false;
        }
        V1UpdateItemRequest v1UpdateItemRequest = (V1UpdateItemRequest) o;
        return Objects.equals(body, v1UpdateItemRequest.body);
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
        Builder builder = new Builder(body);
            return builder;
    }

    public static class Builder {
        private V1Item body;

        public Builder(V1Item body) {
            this.body = body;
        }

        public Builder body(V1Item value) {
            body = value;
            return this;
        }

        public V1UpdateItemRequest build() {
            return new V1UpdateItemRequest(body);
        }
    }
}
