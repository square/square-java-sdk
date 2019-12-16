package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListSettlementsResponse {

    @JsonCreator
    public V1ListSettlementsResponse(
            @JsonProperty("items") List<V1Settlement> items) {
        this.items = items;
    }

    private final List<V1Settlement> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListSettlementsResponse)) {
            return false;
        }
        V1ListSettlementsResponse v1ListSettlementsResponse = (V1ListSettlementsResponse) o;
        return Objects.equals(items, v1ListSettlementsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Settlement> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Settlement> items;

        public Builder() { }

        public Builder items(List<V1Settlement> value) {
            items = value;
            return this;
        }

        public V1ListSettlementsResponse build() {
            return new V1ListSettlementsResponse(items);
        }
    }
}
