
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListOrderCustomAttributesRequest type.
 */
public class ListOrderCustomAttributesRequest {
    private final String visibilityFilter;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<Boolean> withDefinitions;

    /**
     * Initialization constructor.
     * @param  visibilityFilter  String value for visibilityFilter.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     * @param  withDefinitions  Boolean value for withDefinitions.
     */
    @JsonCreator
    public ListOrderCustomAttributesRequest(
            @JsonProperty("visibility_filter") String visibilityFilter,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("with_definitions") Boolean withDefinitions) {
        this.visibilityFilter = visibilityFilter;
        this.cursor = OptionalNullable.of(cursor);
        this.limit = OptionalNullable.of(limit);
        this.withDefinitions = OptionalNullable.of(withDefinitions);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListOrderCustomAttributesRequest(String visibilityFilter,
            OptionalNullable<String> cursor, OptionalNullable<Integer> limit,
            OptionalNullable<Boolean> withDefinitions) {
        this.visibilityFilter = visibilityFilter;
        this.cursor = cursor;
        this.limit = limit;
        this.withDefinitions = withDefinitions;
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

    /**
     * Internal Getter for WithDefinitions.
     * Indicates whether to return the [custom attribute
     * definition](entity:CustomAttributeDefinition) in the `definition` field of each custom
     * attribute. Set this parameter to `true` to get the name and description of each custom
     * attribute, information about the data type, or other definition details. The default value is
     * `false`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("with_definitions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetWithDefinitions() {
        return this.withDefinitions;
    }

    /**
     * Getter for WithDefinitions.
     * Indicates whether to return the [custom attribute
     * definition](entity:CustomAttributeDefinition) in the `definition` field of each custom
     * attribute. Set this parameter to `true` to get the name and description of each custom
     * attribute, information about the data type, or other definition details. The default value is
     * `false`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getWithDefinitions() {
        return OptionalNullable.getFrom(withDefinitions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visibilityFilter, cursor, limit, withDefinitions);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListOrderCustomAttributesRequest)) {
            return false;
        }
        ListOrderCustomAttributesRequest other = (ListOrderCustomAttributesRequest) obj;
        return Objects.equals(visibilityFilter, other.visibilityFilter)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit)
            && Objects.equals(withDefinitions, other.withDefinitions);
    }

    /**
     * Converts this ListOrderCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListOrderCustomAttributesRequest [" + "visibilityFilter=" + visibilityFilter
                + ", cursor=" + cursor + ", limit=" + limit + ", withDefinitions=" + withDefinitions
                + "]";
    }

    /**
     * Builds a new {@link ListOrderCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListOrderCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .visibilityFilter(getVisibilityFilter());
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        builder.withDefinitions = internalGetWithDefinitions();
        return builder;
    }

    /**
     * Class to build instances of {@link ListOrderCustomAttributesRequest}.
     */
    public static class Builder {
        private String visibilityFilter;
        private OptionalNullable<String> cursor;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<Boolean> withDefinitions;



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
         * Setter for withDefinitions.
         * @param  withDefinitions  Boolean value for withDefinitions.
         * @return Builder
         */
        public Builder withDefinitions(Boolean withDefinitions) {
            this.withDefinitions = OptionalNullable.of(withDefinitions);
            return this;
        }

        /**
         * UnSetter for withDefinitions.
         * @return Builder
         */
        public Builder unsetWithDefinitions() {
            withDefinitions = null;
            return this;
        }

        /**
         * Builds a new {@link ListOrderCustomAttributesRequest} object using the set fields.
         * @return {@link ListOrderCustomAttributesRequest}
         */
        public ListOrderCustomAttributesRequest build() {
            return new ListOrderCustomAttributesRequest(visibilityFilter, cursor, limit,
                    withDefinitions);
        }
    }
}
