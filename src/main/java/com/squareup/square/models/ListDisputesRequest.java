package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListDisputesRequest type.
 */
public class ListDisputesRequest {

    /**
     * Initialization constructor.
     * @param cursor
     * @param states
     * @param locationId
     */
    @JsonCreator
    public ListDisputesRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("states") List<String> states,
            @JsonProperty("location_id") String locationId) {
        this.cursor = cursor;
        this.states = states;
        this.locationId = locationId;
    }

    private final String cursor;
    private final List<String> states;
    private final String locationId;
    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for the original query.
     * For more information, see [Paginating](https://developer.squareup.com/docs/basics/api101/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for States.
     * The dispute states to filter the result.
     * If not specified, the endpoint
     * returns all open disputes (dispute status is not
     * `INQUIRY_CLOSED`, `WON`, or `LOST`).
     * See [DisputeState](#type-disputestate) for possible values
     */
    @JsonGetter("states")
    public List<String> getStates() {
        return this.states;
    }

    /**
     * Getter for LocationId.
     * The ID of the location for which to return 
     * a list of disputes. If not specified,
     * the endpoint returns all open disputes
     * (dispute status is not `INQUIRY_CLOSED`, `WON`, or 
     * `LOST`) associated with all locations.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor, states, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListDisputesRequest)) {
            return false;
        }
        ListDisputesRequest listDisputesRequest = (ListDisputesRequest) obj;
        return Objects.equals(cursor, listDisputesRequest.cursor) &&
            Objects.equals(states, listDisputesRequest.states) &&
            Objects.equals(locationId, listDisputesRequest.locationId);
    }

    /**
     * Builds a new {@link ListDisputesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDisputesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .states(getStates())
            .locationId(getLocationId());
            return builder;
    }

    /**
     * Class to build instances of {@link ListDisputesRequest}
     */
    public static class Builder {
        private String cursor;
        private List<String> states;
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
         * Setter for states
         * @param states
         * @return Builder
         */
        public Builder states(List<String> states) {
            this.states = states;
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
         * Builds a new {@link ListDisputesRequest} object using the set fields.
         * @return {@link ListDisputesRequest}
         */
        public ListDisputesRequest build() {
            return new ListDisputesRequest(cursor,
                states,
                locationId);
        }
    }
}
