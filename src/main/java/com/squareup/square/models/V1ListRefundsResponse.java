package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListRefundsResponse {

    @JsonCreator
    public V1ListRefundsResponse(
            @JsonProperty("items") List<V1Refund> items) {
        this.items = items;
    }

    private final List<V1Refund> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListRefundsResponse)) {
            return false;
        }
        V1ListRefundsResponse v1ListRefundsResponse = (V1ListRefundsResponse) o;
        return Objects.equals(items, v1ListRefundsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Refund> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Refund> items;

        public Builder() { }

        public Builder items(List<V1Refund> value) {
            items = value;
            return this;
        }

        public V1ListRefundsResponse build() {
            return new V1ListRefundsResponse(items);
        }
    }
}
