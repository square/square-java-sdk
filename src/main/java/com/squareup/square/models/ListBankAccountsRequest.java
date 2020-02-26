package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListBankAccountsRequest type.
 */
public class ListBankAccountsRequest {

    /**
     * Initialization constructor.
     * @param cursor
     * @param limit
     * @param locationId
     */
    @JsonCreator
    public ListBankAccountsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("location_id") String locationId) {
        this.cursor = cursor;
        this.limit = limit;
        this.locationId = locationId;
    }

    private final String cursor;
    private final Integer limit;
    private final String locationId;
    /**
     * Getter for Cursor.
     * The pagination cursor returned by a previous call to this endpoint.
     * Use it in the next `ListBankAccounts` request to retrieve the next set 
     * of results.
     * See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Limit.
     * Upper limit on the number of bank accounts to return in the response. 
     * Currently, 1000 is the largest supported limit. You can specify a limit 
     * of up to 1000 bank accounts. This is also the default limit.
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for LocationId.
     * Location ID. You can specify this optional filter 
     * to retrieve only the linked bank accounts belonging to a specific location.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor, limit, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListBankAccountsRequest)) {
            return false;
        }
        ListBankAccountsRequest listBankAccountsRequest = (ListBankAccountsRequest) obj;
        return Objects.equals(cursor, listBankAccountsRequest.cursor) &&
            Objects.equals(limit, listBankAccountsRequest.limit) &&
            Objects.equals(locationId, listBankAccountsRequest.locationId);
    }

    /**
     * Builds a new {@link ListBankAccountsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBankAccountsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .limit(getLimit())
            .locationId(getLocationId());
            return builder;
    }

    /**
     * Class to build instances of {@link ListBankAccountsRequest}
     */
    public static class Builder {
        private String cursor;
        private Integer limit;
        private String locationId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }
        /**
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link ListBankAccountsRequest} object using the set fields.
         * @return {@link ListBankAccountsRequest}
         */
        public ListBankAccountsRequest build() {
            return new ListBankAccountsRequest(cursor,
                limit,
                locationId);
        }
    }
}
