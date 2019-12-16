package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListCatalogRequest {

    @JsonCreator
    public ListCatalogRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("types") String types) {
        this.cursor = cursor;
        this.types = types;
    }

    private final String cursor;
    private final String types;

    @Override
    public int hashCode() {
        return Objects.hash(cursor, types);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListCatalogRequest)) {
            return false;
        }
        ListCatalogRequest listCatalogRequest = (ListCatalogRequest) o;
        return Objects.equals(cursor, listCatalogRequest.cursor) &&
            Objects.equals(types, listCatalogRequest.types);
    }

    /**
     * Getter for Cursor.
     * The pagination cursor returned in the previous response. Leave unset for an initial request.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

    /**
     * Getter for Types.
     * An optional case-insensitive, comma-separated list of object types to retrieve, for example
     * `ITEM,ITEM_VARIATION,CATEGORY,IMAGE`.
     * The legal values are taken from the CatalogObjectType enum:
     * `ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`,
     * `MODIFIER`, `MODIFIER_LIST`, or `IMAGE`.
     */
    @JsonGetter("types")
    public String getTypes() { 
        return this.types;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .types(getTypes());
            return builder;
    }

    public static class Builder {
        private String cursor;
        private String types;

        public Builder() { }

        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder types(String value) {
            types = value;
            return this;
        }

        public ListCatalogRequest build() {
            return new ListCatalogRequest(cursor,
                types);
        }
    }
}
