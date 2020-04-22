package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListDeviceCodesRequest type.
 */
public class ListDeviceCodesRequest {

    /**
     * Initialization constructor.
     * @param cursor
     * @param locationId
     * @param productType
     */
    @JsonCreator
    public ListDeviceCodesRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("product_type") String productType) {
        this.cursor = cursor;
        this.locationId = locationId;
        this.productType = productType;
    }

    private final String cursor;
    private final String locationId;
    private final String productType;
    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for your original query.
     * See [Paginating results](#paginatingresults) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for LocationId.
     * If specified, only returns DeviceCodes of the specified location.
     * Returns DeviceCodes of all locations if empty.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for ProductType.
     */
    @JsonGetter("product_type")
    public String getProductType() {
        return this.productType;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor, locationId, productType);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListDeviceCodesRequest)) {
            return false;
        }
        ListDeviceCodesRequest listDeviceCodesRequest = (ListDeviceCodesRequest) obj;
        return Objects.equals(cursor, listDeviceCodesRequest.cursor) &&
            Objects.equals(locationId, listDeviceCodesRequest.locationId) &&
            Objects.equals(productType, listDeviceCodesRequest.productType);
    }

    /**
     * Builds a new {@link ListDeviceCodesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDeviceCodesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .locationId(getLocationId())
            .productType(getProductType());
            return builder;
    }

    /**
     * Class to build instances of {@link ListDeviceCodesRequest}
     */
    public static class Builder {
        private String cursor;
        private String locationId;
        private String productType;

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
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        /**
         * Setter for productType
         * @param productType
         * @return Builder
         */
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        /**
         * Builds a new {@link ListDeviceCodesRequest} object using the set fields.
         * @return {@link ListDeviceCodesRequest}
         */
        public ListDeviceCodesRequest build() {
            return new ListDeviceCodesRequest(cursor,
                locationId,
                productType);
        }
    }
}
