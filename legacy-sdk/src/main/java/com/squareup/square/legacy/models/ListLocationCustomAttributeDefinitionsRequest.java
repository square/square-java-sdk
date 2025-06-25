package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListLocationCustomAttributeDefinitionsRequest type.
 */
public class ListLocationCustomAttributeDefinitionsRequest {
    private final String visibilityFilter;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  visibilityFilter  String value for visibilityFilter.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListLocationCustomAttributeDefinitionsRequest(
            @JsonProperty("visibility_filter") String visibilityFilter,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.visibilityFilter = visibilityFilter;
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Initialization constructor.
     * @param  visibilityFilter  String value for visibilityFilter.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    protected ListLocationCustomAttributeDefinitionsRequest(
            String visibilityFilter, OptionalNullable<Integer> limit, OptionalNullable<String> cursor) {
        this.visibilityFilter = visibilityFilter;
        this.limit = limit;
        this.cursor = cursor;
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
     * Internal Getter for Limit.
     * The maximum number of results to return in a single paged response. This limit is advisory.
     * The response might contain more or fewer results. The minimum value is 1 and the maximum
     * value is 100. The default value is 20. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
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
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for Cursor.
     * The cursor returned in the paged response from the previous call to this endpoint. Provide
     * this cursor to retrieve the next page of results for your original request. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
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
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visibilityFilter, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListLocationCustomAttributeDefinitionsRequest)) {
            return false;
        }
        ListLocationCustomAttributeDefinitionsRequest other = (ListLocationCustomAttributeDefinitionsRequest) obj;
        return Objects.equals(visibilityFilter, other.visibilityFilter)
                && Objects.equals(limit, other.limit)
                && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListLocationCustomAttributeDefinitionsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListLocationCustomAttributeDefinitionsRequest [" + "visibilityFilter=" + visibilityFilter + ", limit="
                + limit + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListLocationCustomAttributeDefinitionsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListLocationCustomAttributeDefinitionsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().visibilityFilter(getVisibilityFilter());
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListLocationCustomAttributeDefinitionsRequest}.
     */
    public static class Builder {
        private String visibilityFilter;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;

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
         * Builds a new {@link ListLocationCustomAttributeDefinitionsRequest} object using the set
         * fields.
         * @return {@link ListLocationCustomAttributeDefinitionsRequest}
         */
        public ListLocationCustomAttributeDefinitionsRequest build() {
            return new ListLocationCustomAttributeDefinitionsRequest(visibilityFilter, limit, cursor);
        }
    }
}
