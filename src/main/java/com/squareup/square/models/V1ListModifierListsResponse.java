package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListModifierListsResponse {

    @JsonCreator
    public V1ListModifierListsResponse(
            @JsonProperty("items") List<V1ModifierList> items) {
        this.items = items;
    }

    private final List<V1ModifierList> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListModifierListsResponse)) {
            return false;
        }
        V1ListModifierListsResponse v1ListModifierListsResponse = (V1ListModifierListsResponse) o;
        return Objects.equals(items, v1ListModifierListsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1ModifierList> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1ModifierList> items;

        public Builder() { }

        public Builder items(List<V1ModifierList> value) {
            items = value;
            return this;
        }

        public V1ListModifierListsResponse build() {
            return new V1ListModifierListsResponse(items);
        }
    }
}
