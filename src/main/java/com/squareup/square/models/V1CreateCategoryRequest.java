package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CreateCategoryRequest {

    @JsonCreator
    public V1CreateCategoryRequest(
            @JsonProperty("body") V1Category body) {
        this.body = body;
    }

    private final V1Category body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1CreateCategoryRequest)) {
            return false;
        }
        V1CreateCategoryRequest v1CreateCategoryRequest = (V1CreateCategoryRequest) o;
        return Objects.equals(body, v1CreateCategoryRequest.body);
    }

    /**
     * Getter for Body.
     * V1Category
     */
    @JsonGetter("body")
    public V1Category getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .body(getBody());
            return builder;
    }

    public static class Builder {
        private V1Category body;

        public Builder() { }

        public Builder body(V1Category value) {
            body = value;
            return this;
        }

        public V1CreateCategoryRequest build() {
            return new V1CreateCategoryRequest(body);
        }
    }
}
