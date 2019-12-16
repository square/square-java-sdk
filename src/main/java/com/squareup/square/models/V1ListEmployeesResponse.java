package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListEmployeesResponse {

    @JsonCreator
    public V1ListEmployeesResponse(
            @JsonProperty("items") List<V1Employee> items) {
        this.items = items;
    }

    private final List<V1Employee> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListEmployeesResponse)) {
            return false;
        }
        V1ListEmployeesResponse v1ListEmployeesResponse = (V1ListEmployeesResponse) o;
        return Objects.equals(items, v1ListEmployeesResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Employee> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Employee> items;

        public Builder() { }

        public Builder items(List<V1Employee> value) {
            items = value;
            return this;
        }

        public V1ListEmployeesResponse build() {
            return new V1ListEmployeesResponse(items);
        }
    }
}
