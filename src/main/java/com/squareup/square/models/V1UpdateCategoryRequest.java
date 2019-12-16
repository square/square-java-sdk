package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdateCategoryRequest {

    @JsonCreator
    public V1UpdateCategoryRequest(
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
        if (!(o instanceof V1UpdateCategoryRequest)) {
            return false;
        }
        V1UpdateCategoryRequest v1UpdateCategoryRequest = (V1UpdateCategoryRequest) o;
        return Objects.equals(body, v1UpdateCategoryRequest.body);
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
        Builder builder = new Builder(body);
            return builder;
    }

    public static class Builder {
        private V1Category body;

        public Builder(V1Category body) {
            this.body = body;
        }

        public Builder body(V1Category value) {
            body = value;
            return this;
        }

        public V1UpdateCategoryRequest build() {
            return new V1UpdateCategoryRequest(body);
        }
    }
}
