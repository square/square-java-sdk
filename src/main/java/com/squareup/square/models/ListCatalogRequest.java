
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for ListCatalogRequest type.
 */
public class ListCatalogRequest {
    private final String cursor;
    private final String types;

    /**
     * Initialization constructor.
     * @param cursor String value for cursor.
     * @param types String value for types.
     */
    @JsonCreator
    public ListCatalogRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("types") String types) {
        this.cursor = cursor;
        this.types = types;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor returned in the previous response. Leave unset for an initial request.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Types.
     * An optional case-insensitive, comma-separated list of object types to retrieve, for example
     * `ITEM,ITEM_VARIATION,CATEGORY,IMAGE`. The legal values are taken from the CatalogObjectType
     * enum: `ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`, `MODIFIER`, `MODIFIER_LIST`,
     * or `IMAGE`.
     * @return Returns the String
     */
    @JsonGetter("types")
    public String getTypes() {
        return this.types;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor, types);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCatalogRequest)) {
            return false;
        }
        ListCatalogRequest other = (ListCatalogRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(types, other.types);
    }

    /**
     * Builds a new {@link ListCatalogRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCatalogRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .types(getTypes());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCatalogRequest}.
     */
    public static class Builder {
        private String cursor;
        private String types;



        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for types.
         * @param types String value for types.
         * @return Builder
         */
        public Builder types(String types) {
            this.types = types;
            return this;
        }

        /**
         * Builds a new {@link ListCatalogRequest} object using the set fields.
         * @return {@link ListCatalogRequest}
         */
        public ListCatalogRequest build() {
            return new ListCatalogRequest(cursor,
                types);
        }
    }
}
