package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListTimecardsResponse {

    @JsonCreator
    public V1ListTimecardsResponse(
            @JsonProperty("items") List<V1Timecard> items) {
        this.items = items;
    }

    private final List<V1Timecard> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListTimecardsResponse)) {
            return false;
        }
        V1ListTimecardsResponse v1ListTimecardsResponse = (V1ListTimecardsResponse) o;
        return Objects.equals(items, v1ListTimecardsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Timecard> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Timecard> items;

        public Builder() { }

        public Builder items(List<V1Timecard> value) {
            items = value;
            return this;
        }

        public V1ListTimecardsResponse build() {
            return new V1ListTimecardsResponse(items);
        }
    }
}
