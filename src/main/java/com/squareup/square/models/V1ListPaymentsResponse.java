package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListPaymentsResponse {

    @JsonCreator
    public V1ListPaymentsResponse(
            @JsonProperty("items") List<V1Payment> items) {
        this.items = items;
    }

    private final List<V1Payment> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListPaymentsResponse)) {
            return false;
        }
        V1ListPaymentsResponse v1ListPaymentsResponse = (V1ListPaymentsResponse) o;
        return Objects.equals(items, v1ListPaymentsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Payment> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Payment> items;

        public Builder() { }

        public Builder items(List<V1Payment> value) {
            items = value;
            return this;
        }

        public V1ListPaymentsResponse build() {
            return new V1ListPaymentsResponse(items);
        }
    }
}
