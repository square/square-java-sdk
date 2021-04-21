
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListDeviceCodesRequest type.
 */
public class ListDeviceCodesRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String productType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> status;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  locationId  String value for locationId.
     * @param  productType  String value for productType.
     * @param  status  List of String value for status.
     */
    @JsonCreator
    public ListDeviceCodesRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("product_type") String productType,
            @JsonProperty("status") List<String> status) {
        this.cursor = cursor;
        this.locationId = locationId;
        this.productType = productType;
        this.status = status;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See [Paginating
     * results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for LocationId.
     * If specified, only returns DeviceCodes of the specified location. Returns DeviceCodes of all
     * locations if empty.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for ProductType.
     * @return Returns the String
     */
    @JsonGetter("product_type")
    public String getProductType() {
        return productType;
    }

    /**
     * Getter for Status.
     * If specified, returns DeviceCodes with the specified statuses. Returns DeviceCodes of status
     * `PAIRED` and `UNPAIRED` if empty. See [DeviceCodeStatus](#type-devicecodestatus) for possible
     * values
     * @return Returns the List of String
     */
    @JsonGetter("status")
    public List<String> getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, locationId, productType, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListDeviceCodesRequest)) {
            return false;
        }
        ListDeviceCodesRequest other = (ListDeviceCodesRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(productType, other.productType)
            && Objects.equals(status, other.status);
    }

    /**
     * Converts this ListDeviceCodesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDeviceCodesRequest [" + "cursor=" + cursor + ", locationId=" + locationId
                + ", productType=" + productType + ", status=" + status + "]";
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
                .productType(getProductType())
                .status(getStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link ListDeviceCodesRequest}.
     */
    public static class Builder {
        private String cursor;
        private String locationId;
        private String productType;
        private List<String> status;



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
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for productType.
         * @param  productType  String value for productType.
         * @return Builder
         */
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  List of String value for status.
         * @return Builder
         */
        public Builder status(List<String> status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link ListDeviceCodesRequest} object using the set fields.
         * @return {@link ListDeviceCodesRequest}
         */
        public ListDeviceCodesRequest build() {
            return new ListDeviceCodesRequest(cursor, locationId, productType, status);
        }
    }
}
