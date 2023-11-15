
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
 * This is a model class for ListGiftCardsRequest type.
 */
public class ListGiftCardsRequest {
    private final OptionalNullable<String> type;
    private final OptionalNullable<String> state;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<String> customerId;

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
        this.type = OptionalNullable.of(type);
        this.state = OptionalNullable.of(state);
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
        this.customerId = OptionalNullable.of(customerId);
    }

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  state  String value for state.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     * @param  customerId  String value for customerId.
     */

    protected ListGiftCardsRequest(OptionalNullable<String> type, OptionalNullable<String> state,
            OptionalNullable<Integer> limit, OptionalNullable<String> cursor,
            OptionalNullable<String> customerId) {
        this.type = type;
        this.state = state;
        this.limit = limit;
        this.cursor = cursor;
        this.customerId = customerId;
    }

    /**
     * Internal Getter for Type.
     * If a [type](entity:GiftCardType) is provided, the endpoint returns gift cards of the
     * specified type. Otherwise, the endpoint returns gift cards of all types.
     * @return Returns the Internal String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetType() {
        return this.type;
    }

    /**
     * Getter for Type.
     * If a [type](entity:GiftCardType) is provided, the endpoint returns gift cards of the
     * specified type. Otherwise, the endpoint returns gift cards of all types.
     * @return Returns the String
     */
    @JsonIgnore
    public String getType() {
        return OptionalNullable.getFrom(type);
    }

    /**
     * Internal Getter for State.
     * If a [state](entity:GiftCardStatus) is provided, the endpoint returns the gift cards in the
     * specified state. Otherwise, the endpoint returns the gift cards of all states.
     * @return Returns the Internal String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetState() {
        return this.state;
    }

    /**
     * Getter for State.
     * If a [state](entity:GiftCardStatus) is provided, the endpoint returns the gift cards in the
     * specified state. Otherwise, the endpoint returns the gift cards of all states.
     * @return Returns the String
     */
    @JsonIgnore
    public String getState() {
        return OptionalNullable.getFrom(state);
    }

    /**
     * Internal Getter for Limit.
     * If a limit is provided, the endpoint returns only the specified number of results per page.
     * The maximum value is 200. The default value is 30. For more information, see
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
     * If a limit is provided, the endpoint returns only the specified number of results per page.
     * The maximum value is 200. The default value is 30. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. If a cursor is not provided, the
     * endpoint returns the first page of the results. For more information, see
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
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. If a cursor is not provided, the
     * endpoint returns the first page of the results. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for CustomerId.
     * If a customer ID is provided, the endpoint returns only the gift cards linked to the
     * specified customer.
     * @return Returns the Internal String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for CustomerId.
     * If a customer ID is provided, the endpoint returns only the gift cards linked to the
     * specified customer.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
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
        Builder builder = new Builder();
        builder.type = internalGetType();
        builder.state = internalGetState();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        builder.customerId = internalGetCustomerId();
        return builder;
    }

    /**
     * Class to build instances of {@link ListGiftCardsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> type;
        private OptionalNullable<String> state;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;
        private OptionalNullable<String> customerId;



        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = OptionalNullable.of(type);
            return this;
        }

        /**
         * UnSetter for type.
         * @return Builder
         */
        public Builder unsetType() {
            type = null;
            return this;
        }

        /**
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = OptionalNullable.of(state);
            return this;
        }

        /**
         * UnSetter for state.
         * @return Builder
         */
        public Builder unsetState() {
            state = null;
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
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = OptionalNullable.of(customerId);
            return this;
        }

        /**
         * UnSetter for customerId.
         * @return Builder
         */
        public Builder unsetCustomerId() {
            customerId = null;
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
