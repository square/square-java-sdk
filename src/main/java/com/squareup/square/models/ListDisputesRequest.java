
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListDisputesRequest type.
 */
public class ListDisputesRequest {
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<List<String>> states;
    private final OptionalNullable<String> locationId;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  states  List of String value for states.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public ListDisputesRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("states") List<String> states,
            @JsonProperty("location_id") String locationId) {
        this.cursor = OptionalNullable.of(cursor);
        this.states = OptionalNullable.of(states);
        this.locationId = OptionalNullable.of(locationId);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListDisputesRequest(OptionalNullable<String> cursor,
            OptionalNullable<List<String>> states, OptionalNullable<String> locationId) {
        this.cursor = cursor;
        this.states = states;
        this.locationId = locationId;
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
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
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for States.
     * The dispute states used to filter the result. If not specified, the endpoint returns all
     * disputes. See [DisputeState](#type-disputestate) for possible values
     * @return Returns the Internal List of String
     */
    @JsonGetter("states")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetStates() {
        return this.states;
    }

    /**
     * Getter for States.
     * The dispute states used to filter the result. If not specified, the endpoint returns all
     * disputes. See [DisputeState](#type-disputestate) for possible values
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getStates() {
        return OptionalNullable.getFrom(states);
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the location for which to return a list of disputes. If not specified, the endpoint
     * returns disputes associated with all locations.
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
     * The ID of the location for which to return a list of disputes. If not specified, the endpoint
     * returns disputes associated with all locations.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, states, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListDisputesRequest)) {
            return false;
        }
        ListDisputesRequest other = (ListDisputesRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(states, other.states)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this ListDisputesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDisputesRequest [" + "cursor=" + cursor + ", states=" + states + ", locationId="
                + locationId + "]";
    }

    /**
     * Builds a new {@link ListDisputesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDisputesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.cursor = internalGetCursor();
        builder.states = internalGetStates();
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link ListDisputesRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> cursor;
        private OptionalNullable<List<String>> states;
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
         * Setter for states.
         * @param  states  List of String value for states.
         * @return Builder
         */
        public Builder states(List<String> states) {
            this.states = OptionalNullable.of(states);
            return this;
        }

        /**
         * UnSetter for states.
         * @return Builder
         */
        public Builder unsetStates() {
            states = null;
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
         * Builds a new {@link ListDisputesRequest} object using the set fields.
         * @return {@link ListDisputesRequest}
         */
        public ListDisputesRequest build() {
            return new ListDisputesRequest(cursor, states, locationId);
        }
    }
}
