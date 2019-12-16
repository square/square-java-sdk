package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListPagesResponse {

    @JsonCreator
    public V1ListPagesResponse(
            @JsonProperty("items") List<V1Page> items) {
        this.items = items;
    }

    private final List<V1Page> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListPagesResponse)) {
            return false;
        }
        V1ListPagesResponse v1ListPagesResponse = (V1ListPagesResponse) o;
        return Objects.equals(items, v1ListPagesResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Page> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Page> items;

        public Builder() { }

        public Builder items(List<V1Page> value) {
            items = value;
            return this;
        }

        public V1ListPagesResponse build() {
            return new V1ListPagesResponse(items);
        }
    }
}
