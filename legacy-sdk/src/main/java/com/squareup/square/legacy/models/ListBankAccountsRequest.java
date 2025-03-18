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
 * This is a model class for ListBankAccountsRequest type.
 */
public class ListBankAccountsRequest {
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> locationId;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public ListBankAccountsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("location_id") String locationId) {
        this.cursor = OptionalNullable.of(cursor);
        this.limit = OptionalNullable.of(limit);
        this.locationId = OptionalNullable.of(locationId);
    }

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     * @param  locationId  String value for locationId.
     */
    protected ListBankAccountsRequest(
            OptionalNullable<String> cursor, OptionalNullable<Integer> limit, OptionalNullable<String> locationId) {
        this.cursor = cursor;
        this.limit = limit;
        this.locationId = locationId;
    }

    /**
     * Internal Getter for Cursor.
     * The pagination cursor returned by a previous call to this endpoint. Use it in the next
     * `ListBankAccounts` request to retrieve the next set of results. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
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
     * The pagination cursor returned by a previous call to this endpoint. Use it in the next
     * `ListBankAccounts` request to retrieve the next set of results. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for Limit.
     * Upper limit on the number of bank accounts to return in the response. Currently, 1000 is the
     * largest supported limit. You can specify a limit of up to 1000 bank accounts. This is also
     * the default limit.
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
     * Upper limit on the number of bank accounts to return in the response. Currently, 1000 is the
     * largest supported limit. You can specify a limit of up to 1000 bank accounts. This is also
     * the default limit.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for LocationId.
     * Location ID. You can specify this optional filter to retrieve only the linked bank accounts
     * belonging to a specific location.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * Location ID. You can specify this optional filter to retrieve only the linked bank accounts
     * belonging to a specific location.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListBankAccountsRequest)) {
            return false;
        }
        ListBankAccountsRequest other = (ListBankAccountsRequest) obj;
        return Objects.equals(cursor, other.cursor)
                && Objects.equals(limit, other.limit)
                && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this ListBankAccountsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListBankAccountsRequest [" + "cursor=" + cursor + ", limit=" + limit + ", locationId=" + locationId
                + "]";
    }

    /**
     * Builds a new {@link ListBankAccountsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBankAccountsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link ListBankAccountsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> locationId;

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
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Builds a new {@link ListBankAccountsRequest} object using the set fields.
         * @return {@link ListBankAccountsRequest}
         */
        public ListBankAccountsRequest build() {
            return new ListBankAccountsRequest(cursor, limit, locationId);
        }
    }
}
