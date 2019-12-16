package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListFeesResponse {

    @JsonCreator
    public V1ListFeesResponse(
            @JsonProperty("items") List<V1Fee> items) {
        this.items = items;
    }

    private final List<V1Fee> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListFeesResponse)) {
            return false;
        }
        V1ListFeesResponse v1ListFeesResponse = (V1ListFeesResponse) o;
        return Objects.equals(items, v1ListFeesResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Fee> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Fee> items;

        public Builder() { }

        public Builder items(List<V1Fee> value) {
            items = value;
            return this;
        }

        public V1ListFeesResponse build() {
            return new V1ListFeesResponse(items);
        }
    }
}
