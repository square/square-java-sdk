
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for ListBreakTypesRequest type.
 */
public class ListBreakTypesRequest {
    private final String locationId;
    private final Integer limit;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param locationId String value for locationId.
     * @param limit Integer value for limit.
     * @param cursor String value for cursor.
     */
    @JsonCreator
    public ListBreakTypesRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.locationId = locationId;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Getter for LocationId.
     * Filter Break Types returned to only those that are associated with the specified location.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Limit.
     * Maximum number of Break Types to return per page. Can range between 1 and 200. The default is
     * the maximum at 200.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * Pointer to the next page of Break Type results to fetch.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationId, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListBreakTypesRequest)) {
            return false;
        }
        ListBreakTypesRequest other = (ListBreakTypesRequest) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Builds a new {@link ListBreakTypesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBreakTypesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationId(getLocationId())
            .limit(getLimit())
            .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListBreakTypesRequest}.
     */
    public static class Builder {
        private String locationId;
        private Integer limit;
        private String cursor;



        /**
         * Setter for locationId.
         * @param locationId String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for limit.
         * @param limit Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListBreakTypesRequest} object using the set fields.
         * @return {@link ListBreakTypesRequest}
         */
        public ListBreakTypesRequest build() {
            return new ListBreakTypesRequest(locationId,
                limit,
                cursor);
        }
    }
}
