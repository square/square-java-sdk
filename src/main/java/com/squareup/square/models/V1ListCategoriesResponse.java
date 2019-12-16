package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListCategoriesResponse {

    @JsonCreator
    public V1ListCategoriesResponse(
            @JsonProperty("items") List<V1Category> items) {
        this.items = items;
    }

    private final List<V1Category> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListCategoriesResponse)) {
            return false;
        }
        V1ListCategoriesResponse v1ListCategoriesResponse = (V1ListCategoriesResponse) o;
        return Objects.equals(items, v1ListCategoriesResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Category> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Category> items;

        public Builder() { }

        public Builder items(List<V1Category> value) {
            items = value;
            return this;
        }

        public V1ListCategoriesResponse build() {
            return new V1ListCategoriesResponse(items);
        }
    }
}
