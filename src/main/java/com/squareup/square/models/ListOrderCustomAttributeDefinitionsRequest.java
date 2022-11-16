
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListOrderCustomAttributeDefinitionsRequest type.
 */
public class ListOrderCustomAttributeDefinitionsRequest {
    private final String visibilityFilter;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Integer> limit;

    /**
     * Initialization constructor.
     * @param  visibilityFilter  String value for visibilityFilter.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListOrderCustomAttributeDefinitionsRequest(
            @JsonProperty("visibility_filter") String visibilityFilter,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.visibilityFilter = visibilityFilter;
        this.cursor = OptionalNullable.of(cursor);
        this.limit = OptionalNullable.of(limit);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListOrderCustomAttributeDefinitionsRequest(String visibilityFilter,
            OptionalNullable<String> cursor, OptionalNullable<Integer> limit) {
        this.visibilityFilter = visibilityFilter;
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Getter for VisibilityFilter.
     * Enumeration of visibility-filter values used to set the ability to view custom attributes or
     * custom attribute definitions.
     * @return Returns the String
     */
    @JsonGetter("visibility_filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getVisibilityFilter() {
        return visibilityFilter;
    }

    /**
     * Internal Getter for Cursor.
     * The cursor returned in the paged response from the previous call to this endpoint. Provide
     * this cursor to retrieve the next page of results for your original request. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * The cursor returned in the paged response from the previous call to this endpoint. Provide
     * this cursor to retrieve the next page of results for your original request. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of results to return in a single paged response. This limit is advisory.
     * The response might contain more or fewer results. The minimum value is 1 and the maximum
     * value is 100. The default value is 20. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the Internal Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetLimit() {
        return this.limit;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to return in a single paged response. This limit is advisory.
     * The response might contain more or fewer results. The minimum value is 1 and the maximum
     * value is 100. The default value is 20. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visibilityFilter, cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListOrderCustomAttributeDefinitionsRequest)) {
            return false;
        }
        ListOrderCustomAttributeDefinitionsRequest other =
                (ListOrderCustomAttributeDefinitionsRequest) obj;
        return Objects.equals(visibilityFilter, other.visibilityFilter)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListOrderCustomAttributeDefinitionsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListOrderCustomAttributeDefinitionsRequest [" + "visibilityFilter="
                + visibilityFilter + ", cursor=" + cursor + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListOrderCustomAttributeDefinitionsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListOrderCustomAttributeDefinitionsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .visibilityFilter(getVisibilityFilter());
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        return builder;
    }

    /**
     * Class to build instances of {@link ListOrderCustomAttributeDefinitionsRequest}.
     */
    public static class Builder {
        private String visibilityFilter;
        private OptionalNullable<String> cursor;
        private OptionalNullable<Integer> limit;



        /**
         * Setter for visibilityFilter.
         * @param  visibilityFilter  String value for visibilityFilter.
         * @return Builder
         */
        public Builder visibilityFilter(String visibilityFilter) {
            this.visibilityFilter = visibilityFilter;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = OptionalNullable.of(limit);
            return this;
        }

        /**
         * UnSetter for limit.
         * @return Builder
         */
        public Builder unsetLimit() {
            limit = null;
            return this;
        }

        /**
         * Builds a new {@link ListOrderCustomAttributeDefinitionsRequest} object using the set
         * fields.
         * @return {@link ListOrderCustomAttributeDefinitionsRequest}
         */
        public ListOrderCustomAttributeDefinitionsRequest build() {
            return new ListOrderCustomAttributeDefinitionsRequest(visibilityFilter, cursor, limit);
        }
    }
}
