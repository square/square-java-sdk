
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListCustomerCustomAttributeDefinitionsRequest type.
 */
public class ListCustomerCustomAttributeDefinitionsRequest {
    private final Integer limit;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListCustomerCustomAttributeDefinitionsRequest(
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.limit = limit;
        this.cursor = cursor;
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

    @Override
    public int hashCode() {
        return Objects.hash(limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomerCustomAttributeDefinitionsRequest)) {
            return false;
        }
        ListCustomerCustomAttributeDefinitionsRequest other =
                (ListCustomerCustomAttributeDefinitionsRequest) obj;
        return Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListCustomerCustomAttributeDefinitionsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomerCustomAttributeDefinitionsRequest [" + "limit=" + limit + ", cursor="
                + cursor + "]";
    }

    /**
     * Builds a new {@link ListCustomerCustomAttributeDefinitionsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerCustomAttributeDefinitionsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .limit(getLimit())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerCustomAttributeDefinitionsRequest}.
     */
    public static class Builder {
        private Integer limit;
        private String cursor;



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
         * Builds a new {@link ListCustomerCustomAttributeDefinitionsRequest} object using the set
         * fields.
         * @return {@link ListCustomerCustomAttributeDefinitionsRequest}
         */
        public ListCustomerCustomAttributeDefinitionsRequest build() {
            return new ListCustomerCustomAttributeDefinitionsRequest(limit, cursor);
        }
    }
}
