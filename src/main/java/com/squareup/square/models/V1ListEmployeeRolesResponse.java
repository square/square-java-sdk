package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListEmployeeRolesResponse {

    @JsonCreator
    public V1ListEmployeeRolesResponse(
            @JsonProperty("items") List<V1EmployeeRole> items) {
        this.items = items;
    }

    private final List<V1EmployeeRole> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListEmployeeRolesResponse)) {
            return false;
        }
        V1ListEmployeeRolesResponse v1ListEmployeeRolesResponse = (V1ListEmployeeRolesResponse) o;
        return Objects.equals(items, v1ListEmployeeRolesResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1EmployeeRole> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1EmployeeRole> items;

        public Builder() { }

        public Builder items(List<V1EmployeeRole> value) {
            items = value;
            return this;
        }

        public V1ListEmployeeRolesResponse build() {
            return new V1ListEmployeeRolesResponse(items);
        }
    }
}
