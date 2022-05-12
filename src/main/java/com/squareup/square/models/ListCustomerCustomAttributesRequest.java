
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListCustomerCustomAttributesRequest type.
 */
public class ListCustomerCustomAttributesRequest {
    private final Integer limit;
    private final String cursor;
    private final Boolean withDefinitions;

    /**
     * Initialization constructor.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     * @param  withDefinitions  Boolean value for withDefinitions.
     */
    @JsonCreator
    public ListCustomerCustomAttributesRequest(
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("with_definitions") Boolean withDefinitions) {
        this.limit = limit;
        this.cursor = cursor;
        this.withDefinitions = withDefinitions;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to return in a single paged response. This limit is advisory.
     * The response might contain more or fewer results. The minimum value is 1 and the maximum
     * value is 100. The default value is 20. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * The cursor returned in the paged response from the previous call to this endpoint. Provide
     * this cursor to retrieve the next page of results for your original request. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for WithDefinitions.
     * Indicates whether to return the [custom attribute definition]($m/CustomAttributeDefinition)
     * in the `definition` field of each custom attribute. Set this parameter to `true` to get the
     * name and description of each custom attribute, information about the data type, or other
     * definition details. The default value is `false`.
     * @return Returns the Boolean
     */
    @JsonGetter("with_definitions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getWithDefinitions() {
        return withDefinitions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, cursor, withDefinitions);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomerCustomAttributesRequest)) {
            return false;
        }
        ListCustomerCustomAttributesRequest other = (ListCustomerCustomAttributesRequest) obj;
        return Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(withDefinitions, other.withDefinitions);
    }

    /**
     * Converts this ListCustomerCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomerCustomAttributesRequest [" + "limit=" + limit + ", cursor=" + cursor
                + ", withDefinitions=" + withDefinitions + "]";
    }

    /**
     * Builds a new {@link ListCustomerCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .limit(getLimit())
                .cursor(getCursor())
                .withDefinitions(getWithDefinitions());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerCustomAttributesRequest}.
     */
    public static class Builder {
        private Integer limit;
        private String cursor;
        private Boolean withDefinitions;



        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for withDefinitions.
         * @param  withDefinitions  Boolean value for withDefinitions.
         * @return Builder
         */
        public Builder withDefinitions(Boolean withDefinitions) {
            this.withDefinitions = withDefinitions;
            return this;
        }

        /**
         * Builds a new {@link ListCustomerCustomAttributesRequest} object using the set fields.
         * @return {@link ListCustomerCustomAttributesRequest}
         */
        public ListCustomerCustomAttributesRequest build() {
            return new ListCustomerCustomAttributesRequest(limit, cursor, withDefinitions);
        }
    }
}
