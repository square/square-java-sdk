
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
 * This is a model class for ListLoyaltyPromotionsRequest type.
 */
public class ListLoyaltyPromotionsRequest {
    private final String status;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Integer> limit;

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListLoyaltyPromotionsRequest(
            @JsonProperty("status") String status,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.status = status;
        this.cursor = OptionalNullable.of(cursor);
        this.limit = OptionalNullable.of(limit);
    }

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */

    protected ListLoyaltyPromotionsRequest(String status, OptionalNullable<String> cursor,
            OptionalNullable<Integer> limit) {
        this.status = status;
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Getter for Status.
     * Indicates the status of a [loyalty promotion]($m/LoyaltyPromotion).
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
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

    /**
     * Internal Getter for Limit.
     * The maximum number of results to return in a single paged response. The minimum value is 1
     * and the maximum value is 30. The default value is 30. For more information, see
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
     * The maximum number of results to return in a single paged response. The minimum value is 1
     * and the maximum value is 30. The default value is 30. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListLoyaltyPromotionsRequest)) {
            return false;
        }
        ListLoyaltyPromotionsRequest other = (ListLoyaltyPromotionsRequest) obj;
        return Objects.equals(status, other.status)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListLoyaltyPromotionsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListLoyaltyPromotionsRequest [" + "status=" + status + ", cursor=" + cursor
                + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListLoyaltyPromotionsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListLoyaltyPromotionsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .status(getStatus());
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        return builder;
    }

    /**
     * Class to build instances of {@link ListLoyaltyPromotionsRequest}.
     */
    public static class Builder {
        private String status;
        private OptionalNullable<String> cursor;
        private OptionalNullable<Integer> limit;



        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
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
         * Builds a new {@link ListLoyaltyPromotionsRequest} object using the set fields.
         * @return {@link ListLoyaltyPromotionsRequest}
         */
        public ListLoyaltyPromotionsRequest build() {
            return new ListLoyaltyPromotionsRequest(status, cursor, limit);
        }
    }
}
