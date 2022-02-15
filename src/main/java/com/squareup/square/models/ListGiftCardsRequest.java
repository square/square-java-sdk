
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListGiftCardsRequest type.
 */
public class ListGiftCardsRequest {
    private final String type;
    private final String state;
    private final Integer limit;
    private final String cursor;
    private final String customerId;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  state  String value for state.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     * @param  customerId  String value for customerId.
     */
    @JsonCreator
    public ListGiftCardsRequest(
            @JsonProperty("type") String type,
            @JsonProperty("state") String state,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("customer_id") String customerId) {
        this.type = type;
        this.state = state;
        this.limit = limit;
        this.cursor = cursor;
        this.customerId = customerId;
    }

    /**
     * Getter for Type.
     * If a [type]($m/GiftCardType) is provided, the endpoint returns gift cards of the specified
     * type. Otherwise, the endpoint returns gift cards of all types.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Getter for State.
     * If a [state]($m/GiftCardStatus) is provided, the endpoint returns the gift cards in the
     * specified state. Otherwise, the endpoint returns the gift cards of all states.
     * @return Returns the String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getState() {
        return state;
    }

    /**
     * Getter for Limit.
     * If a limit is provided, the endpoint returns only the specified number of results per page.
     * The maximum value is 50. The default value is 30. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. If a cursor is not provided, the
     * endpoint returns the first page of the results. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for CustomerId.
     * If a customer ID is provided, the endpoint returns only the gift cards linked to the
     * specified customer.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, state, limit, cursor, customerId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListGiftCardsRequest)) {
            return false;
        }
        ListGiftCardsRequest other = (ListGiftCardsRequest) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(state, other.state)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(customerId, other.customerId);
    }

    /**
     * Converts this ListGiftCardsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListGiftCardsRequest [" + "type=" + type + ", state=" + state + ", limit=" + limit
                + ", cursor=" + cursor + ", customerId=" + customerId + "]";
    }

    /**
     * Builds a new {@link ListGiftCardsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListGiftCardsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .state(getState())
                .limit(getLimit())
                .cursor(getCursor())
                .customerId(getCustomerId());
        return builder;
    }

    /**
     * Class to build instances of {@link ListGiftCardsRequest}.
     */
    public static class Builder {
        private String type;
        private String state;
        private Integer limit;
        private String cursor;
        private String customerId;



        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

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
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Builds a new {@link ListGiftCardsRequest} object using the set fields.
         * @return {@link ListGiftCardsRequest}
         */
        public ListGiftCardsRequest build() {
            return new ListGiftCardsRequest(type, state, limit, cursor, customerId);
        }
    }
}
